package pl.dragondice.dragondicefinal.domain.user_character_structure;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "feats")
public class CharacterFeats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;
    @NotBlank
    private String name;
    @NotBlank
    @Size(max = 500)
    private String description;
    @OneToOne
    private CharacterScoreIncrease scoreIncrease;
}

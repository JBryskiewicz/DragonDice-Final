package pl.dragondice.dragondicefinal.domain.user_character_structure;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "race")
public class CharacterRace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;
    @NotBlank
    private String name;
    @NotBlank
    @Size(max = 500)
    private String description;
    @Min(0)
    @NotNull
    private int walkingSpeed;
    @OneToOne
    private CharacterScoreIncrease scoreIncrease;
}

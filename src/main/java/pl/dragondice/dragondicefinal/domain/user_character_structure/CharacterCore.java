package pl.dragondice.dragondicefinal.domain.user_character_structure;

import lombok.*;
import pl.dragondice.dragondicefinal.domain.user.User;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "character_core")
public class CharacterCore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;
    @NotBlank
    private String name;
    @Min(1)
    @NotNull
    private int age;
    private String alignment;
    @Size(max = 2000)
    private String backstory;

    @OneToOne
    @JoinColumn(name = "stats_id", nullable = false)
    private CharacterStatistics stats;
    @ManyToOne
    private CharacterRace race;
    @ManyToOne
    private CharacterBackground background;
    @ManyToMany
    private List<CharacterFeats> feats;
    @OneToMany(fetch = FetchType.EAGER)
    private List<CharacterScoreIncrease> increases;

    //TODO Character class implementation
    //TODO Inventory implementation

    @ManyToOne
    private User user;

}

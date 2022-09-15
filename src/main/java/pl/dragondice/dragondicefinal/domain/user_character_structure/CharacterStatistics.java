package pl.dragondice.dragondicefinal.domain.user_character_structure;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "character_stats")
public class CharacterStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;
    private int level;
    private int proficiency;
    private int strAbility;
    private int dexAbility;
    private int conAbility;
    private int intAbility;
    private int wisAbility;
    private int chaAbility;

    public CharacterStatistics(int level, int proficiency, int strAbility, int dexAbility, int conAbility,
                               int intAbility, int wisAbility, int chaAbility){
        this.level = level;
        this.proficiency = proficiency;
        this.strAbility = strAbility;
        this.dexAbility = dexAbility;
        this.conAbility = conAbility;
        this.intAbility = intAbility;
        this.wisAbility = wisAbility;
        this.chaAbility = chaAbility;
    }
}

package pl.dragondice.dragondicefinal.domain.user_character_structure;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "score_increase")
public class CharacterScoreIncrease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;
    private int strIncrease;
    private int dexIncrease;
    private int conIncrease;
    private int intIncrease;
    private int wisIncrease;
    private int chaIncrease;

    public CharacterScoreIncrease(int strIncrease, int dexIncrease, int conIncrease,
                               int intIncrease, int wisIncrease, int chaIncrease){
        this.strIncrease = strIncrease;
        this.dexIncrease = dexIncrease;
        this.conIncrease = conIncrease;
        this.intIncrease = intIncrease;
        this.wisIncrease = wisIncrease;
        this.chaIncrease = chaIncrease;
    }
}

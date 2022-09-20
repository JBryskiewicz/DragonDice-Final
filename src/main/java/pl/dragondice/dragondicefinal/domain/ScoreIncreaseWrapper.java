package pl.dragondice.dragondicefinal.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dragondice.dragondicefinal.domain.user_character_structure.CharacterScoreIncrease;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ScoreIncreaseWrapper {

    private List<CharacterScoreIncrease> increaseList;

}


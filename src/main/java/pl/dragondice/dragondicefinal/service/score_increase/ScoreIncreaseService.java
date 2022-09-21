package pl.dragondice.dragondicefinal.service.score_increase;

import pl.dragondice.dragondicefinal.domain.user_character_structure.CharacterScoreIncrease;

import java.util.List;
import java.util.Optional;

public interface ScoreIncreaseService {
    CharacterScoreIncrease save(CharacterScoreIncrease scoreIncrease);
    void saveAll(List<CharacterScoreIncrease> increases);
    void editScoreIncrease(CharacterScoreIncrease increase);
    Optional<CharacterScoreIncrease> findById(long id);
    void deleteCharacterIncreases(List<CharacterScoreIncrease> increaseList);
}

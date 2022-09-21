package pl.dragondice.dragondicefinal.service.character_core;

import pl.dragondice.dragondicefinal.domain.user.User;
import pl.dragondice.dragondicefinal.domain.user_character_structure.CharacterCore;
import pl.dragondice.dragondicefinal.domain.user_character_structure.CharacterScoreIncrease;

import java.util.List;
import java.util.Optional;

public interface CharacterCoreService {
    List<CharacterCore> findAllByUser(User user);
    void save(CharacterCore characterCore);
    Optional<CharacterCore> findById(long id);
    void editCharacter(CharacterCore characterCore);
    void editCharacterIncrease(CharacterScoreIncrease increase);
    List<CharacterScoreIncrease> findIncreasesByCoreIdAccordingToLevel(long id, int leveLimit);
    void delete(CharacterCore characterCore);
}

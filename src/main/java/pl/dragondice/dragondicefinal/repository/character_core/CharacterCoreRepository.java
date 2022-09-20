package pl.dragondice.dragondicefinal.repository.character_core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.dragondice.dragondicefinal.domain.user.User;
import pl.dragondice.dragondicefinal.domain.user_character_structure.CharacterCore;
import pl.dragondice.dragondicefinal.domain.user_character_structure.CharacterScoreIncrease;

import java.util.List;

@Repository
public interface CharacterCoreRepository extends JpaRepository<CharacterCore, Long> {
    List<CharacterCore> findAllByUser(User user);
//    @Query(value = "select c.increases from CharacterCore c where c.id = ?1")
//    List<CharacterScoreIncrease> findIncreasesByCoreIdAccordingToLevel(long id, int levelLimit);
}

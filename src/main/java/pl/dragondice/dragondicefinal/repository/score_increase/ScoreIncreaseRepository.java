package pl.dragondice.dragondicefinal.repository.score_increase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.dragondice.dragondicefinal.domain.user_character_structure.CharacterScoreIncrease;

@Repository
public interface ScoreIncreaseRepository extends JpaRepository<CharacterScoreIncrease, Long> {

}

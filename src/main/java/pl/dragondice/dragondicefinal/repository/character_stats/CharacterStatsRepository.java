package pl.dragondice.dragondicefinal.repository.character_stats;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dragondice.dragondicefinal.domain.user_character_structure.CharacterStatistics;

@Repository
public interface CharacterStatsRepository extends JpaRepository<CharacterStatistics, Long> {

}

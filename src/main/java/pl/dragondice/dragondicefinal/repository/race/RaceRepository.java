package pl.dragondice.dragondicefinal.repository.race;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dragondice.dragondicefinal.domain.user_character_structure.CharacterRace;

@Repository
public interface RaceRepository extends JpaRepository<CharacterRace, Long> {

}

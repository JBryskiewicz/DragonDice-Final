package pl.dragondice.dragondicefinal.repository.feats;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dragondice.dragondicefinal.domain.user_character_structure.CharacterFeats;

@Repository
public interface FeatRepository extends JpaRepository<CharacterFeats, Long> {

}

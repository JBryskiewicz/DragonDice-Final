package pl.dragondice.dragondicefinal.repository.background;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dragondice.dragondicefinal.domain.user_character_structure.CharacterBackground;

@Repository
public interface BackgroundRepository extends JpaRepository<CharacterBackground, Long> {

}

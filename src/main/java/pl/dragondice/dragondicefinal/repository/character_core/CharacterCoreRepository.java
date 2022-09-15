package pl.dragondice.dragondicefinal.repository.character_core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.dragondice.dragondicefinal.domain.user.User;
import pl.dragondice.dragondicefinal.domain.user_character_structure.CharacterCore;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterCoreRepository extends JpaRepository<CharacterCore, Long> {
    List<CharacterCore> findAllByUser(User user);
}

package pl.dragondice.dragondicefinal.service.character_core;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dragondice.dragondicefinal.domain.user.User;
import pl.dragondice.dragondicefinal.domain.user_character_structure.CharacterCore;
import pl.dragondice.dragondicefinal.repository.character_core.CharacterCoreRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class CharacterCoreServiceImpl implements CharacterCoreService{
    private final CharacterCoreRepository characterRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CharacterCore> findAllByUser(User user) {
        return characterRepository.findAllByUser(user);
    }

    @Override
    public void save(CharacterCore characterCore) {
        this.characterRepository.save(characterCore);
    }

    @Override
    public Optional<CharacterCore> findById(long id) {
        return characterRepository.findById(id);
    }

    @Override
    public void editCharacter(CharacterCore characterCore) {
        entityManager.merge(characterCore);
    }
}

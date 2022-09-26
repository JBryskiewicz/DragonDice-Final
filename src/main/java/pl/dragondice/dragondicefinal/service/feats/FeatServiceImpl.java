package pl.dragondice.dragondicefinal.service.feats;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dragondice.dragondicefinal.domain.user_character_structure.CharacterFeats;
import pl.dragondice.dragondicefinal.repository.feats.FeatRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class FeatServiceImpl implements FeatService{
    private final FeatRepository featRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CharacterFeats> findAll() {
        return featRepository.findAll();
    }

    @Override
    public Optional<CharacterFeats> findById(long id) {
        return featRepository.findById(id);
    }
}

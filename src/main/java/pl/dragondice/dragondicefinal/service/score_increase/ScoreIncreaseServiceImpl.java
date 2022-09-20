package pl.dragondice.dragondicefinal.service.score_increase;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dragondice.dragondicefinal.domain.user_character_structure.CharacterScoreIncrease;
import pl.dragondice.dragondicefinal.repository.score_increase.ScoreIncreaseRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ScoreIncreaseServiceImpl implements ScoreIncreaseService{
    private final ScoreIncreaseRepository increaseRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public CharacterScoreIncrease save(CharacterScoreIncrease scoreIncrease) {
        return this.increaseRepository.save(scoreIncrease);
    }

    @Override
    public void saveAll(List<CharacterScoreIncrease> increases) {
        this.increaseRepository.saveAll(increases);
    }

    @Override
    public void editScoreIncrease(CharacterScoreIncrease increase) {
        this.entityManager.merge(increase);
    }

    @Override
    public Optional<CharacterScoreIncrease> findById(long id) {
        return this.increaseRepository.findById(id);
    }
}

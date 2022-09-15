package pl.dragondice.dragondicefinal.service.score_increase;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dragondice.dragondicefinal.repository.score_increase.ScoreIncreaseRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
@AllArgsConstructor
public class ScoreIncreaseServiceImpl implements ScoreIncreaseService{
    private final ScoreIncreaseRepository increaseRepository;
    @PersistenceContext
    private EntityManager entityManager;

}

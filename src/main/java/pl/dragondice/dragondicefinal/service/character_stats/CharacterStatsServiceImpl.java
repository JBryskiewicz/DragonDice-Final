package pl.dragondice.dragondicefinal.service.character_stats;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dragondice.dragondicefinal.domain.user_character_structure.CharacterStatistics;
import pl.dragondice.dragondicefinal.repository.character_stats.CharacterStatsRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
@AllArgsConstructor
public class CharacterStatsServiceImpl implements CharacterStatsService{

    private final CharacterStatsRepository statsRepository;
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public CharacterStatistics save(CharacterStatistics statistics) {
        return this.statsRepository.save(statistics);
    }

    @Override
    public void delete(CharacterStatistics statistics) {
        this.statsRepository.delete(statistics);
    }

    @Override
    public void edit(CharacterStatistics statistics) {
        this.entityManager.merge(statistics);
    }
}

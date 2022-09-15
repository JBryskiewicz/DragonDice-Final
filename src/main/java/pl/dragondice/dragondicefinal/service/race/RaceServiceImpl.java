package pl.dragondice.dragondicefinal.service.race;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dragondice.dragondicefinal.domain.user_character_structure.CharacterRace;
import pl.dragondice.dragondicefinal.repository.race.RaceRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class RaceServiceImpl implements RaceService{
    private final RaceRepository raceRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CharacterRace> findAll() {
        return raceRepository.findAll();
    }
}

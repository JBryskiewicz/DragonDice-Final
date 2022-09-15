package pl.dragondice.dragondicefinal.service.background;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dragondice.dragondicefinal.domain.user_character_structure.CharacterBackground;
import pl.dragondice.dragondicefinal.repository.background.BackgroundRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class BackgroundServiceImpl implements BackgroundService{
    private final BackgroundRepository backgroundRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CharacterBackground> findAll() {
        return backgroundRepository.findAll();
    }
}

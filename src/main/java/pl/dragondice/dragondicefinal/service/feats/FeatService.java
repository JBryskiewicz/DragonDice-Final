package pl.dragondice.dragondicefinal.service.feats;

import pl.dragondice.dragondicefinal.domain.user_character_structure.CharacterFeats;

import java.util.List;
import java.util.Optional;

public interface FeatService {
List<CharacterFeats> findAll();
Optional<CharacterFeats> findById(long id);
}

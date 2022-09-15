package pl.dragondice.dragondicefinal.service.feats;

import pl.dragondice.dragondicefinal.domain.user_character_structure.CharacterFeats;

import java.util.List;

public interface FeatService {
List<CharacterFeats> findAll();
}

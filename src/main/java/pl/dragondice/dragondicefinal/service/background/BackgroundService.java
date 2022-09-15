package pl.dragondice.dragondicefinal.service.background;

import pl.dragondice.dragondicefinal.domain.user_character_structure.CharacterBackground;

import java.util.List;

public interface BackgroundService {
List<CharacterBackground> findAll();
}

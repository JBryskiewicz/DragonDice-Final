package pl.dragondice.dragondicefinal.service.character_stats;

import pl.dragondice.dragondicefinal.domain.user_character_structure.CharacterStatistics;

public interface CharacterStatsService {
    CharacterStatistics save(CharacterStatistics statistics);
    void delete(CharacterStatistics statistics);
}

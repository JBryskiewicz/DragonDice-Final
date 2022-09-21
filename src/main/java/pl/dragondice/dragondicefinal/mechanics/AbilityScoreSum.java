package pl.dragondice.dragondicefinal.mechanics;

import lombok.AllArgsConstructor;
import pl.dragondice.dragondicefinal.domain.user_character_structure.CharacterCore;
import pl.dragondice.dragondicefinal.domain.user_character_structure.CharacterScoreIncrease;
import pl.dragondice.dragondicefinal.service.character_core.CharacterCoreService;

//This class returns summarized Ability Score of character with all increases from leveling up and race.
//Feats are not finished yet and increase from items will be added once item.class is implemented.

@AllArgsConstructor
public class AbilityScoreSum {

    private final CharacterCoreService characterService;
    private CharacterCore character(long id){
        return characterService.findById(id).get();
    }

    public int strAbilityScore(long id){

        int characterStatistics = character(id).getStats().getStrAbility();
        int scoreIncreaseSum = character(id).getIncreases()
                .stream()
                .map(CharacterScoreIncrease::getStrIncrease)
                .mapToInt(Integer::intValue)
                .sum();
        int raceScoreIncrease = character(id).getRace().getScoreIncrease().getStrIncrease();

        return characterStatistics + scoreIncreaseSum + raceScoreIncrease;
    }

    public int dexAbilityScore(long id){

        int characterStatistics = character(id).getStats().getDexAbility();
        int scoreIncreaseSum = character(id).getIncreases()
                .stream()
                .map(CharacterScoreIncrease::getDexIncrease)
                .mapToInt(Integer::intValue)
                .sum();
        int raceScoreIncrease = character(id).getRace().getScoreIncrease().getDexIncrease();

        return characterStatistics + scoreIncreaseSum + raceScoreIncrease;
    }

    public int conAbilityScore(long id){

        int characterStatistics = character(id).getStats().getConAbility();
        int scoreIncreaseSum = character(id).getIncreases()
                .stream()
                .map(CharacterScoreIncrease::getConIncrease)
                .mapToInt(Integer::intValue)
                .sum();
        int raceScoreIncrease = character(id).getRace().getScoreIncrease().getConIncrease();

        return characterStatistics + scoreIncreaseSum + raceScoreIncrease;
    }

    public int intAbilityScore(long id){

        int characterStatistics = character(id).getStats().getIntAbility();
        int scoreIncreaseSum = character(id).getIncreases()
                .stream()
                .map(CharacterScoreIncrease::getIntIncrease)
                .mapToInt(Integer::intValue)
                .sum();
        int raceScoreIncrease = character(id).getRace().getScoreIncrease().getIntIncrease();

        return characterStatistics + scoreIncreaseSum + raceScoreIncrease;
    }

    public int wisAbilityScore(long id){

        int characterStatistics = character(id).getStats().getWisAbility();
        int scoreIncreaseSum = character(id).getIncreases()
                .stream()
                .map(CharacterScoreIncrease::getWisIncrease)
                .mapToInt(Integer::intValue)
                .sum();
        int raceScoreIncrease = character(id).getRace().getScoreIncrease().getWisIncrease();

        return characterStatistics + scoreIncreaseSum + raceScoreIncrease;
    }

    public int chaAbilityScore(long id){

        int characterStatistics = character(id).getStats().getChaAbility();
        int scoreIncreaseSum = character(id).getIncreases()
                .stream()
                .map(CharacterScoreIncrease::getChaIncrease)
                .mapToInt(Integer::intValue)
                .sum();
        int raceScoreIncrease = character(id).getRace().getScoreIncrease().getChaIncrease();

        return characterStatistics + scoreIncreaseSum + raceScoreIncrease;
    }

}

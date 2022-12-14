package pl.dragondice.dragondicefinal.web.app;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.dragondice.dragondicefinal.domain.user.CurrentUser;
import pl.dragondice.dragondicefinal.domain.user_character_structure.*;
import pl.dragondice.dragondicefinal.mechanics.ModifiersDefiner;
import pl.dragondice.dragondicefinal.service.background.BackgroundService;
import pl.dragondice.dragondicefinal.service.character_core.CharacterCoreService;
import pl.dragondice.dragondicefinal.service.character_stats.CharacterStatsService;
import pl.dragondice.dragondicefinal.service.feats.FeatService;
import pl.dragondice.dragondicefinal.service.race.RaceService;
import pl.dragondice.dragondicefinal.service.score_increase.ScoreIncreaseService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/app")
@AllArgsConstructor
public class CharacterCreatorController {

    private static final long DEFAULT_SELECTION = 1L;
    private static final int DEFAULT_LEVEL = 1;
    private static final int DEFAULT_PROFICIENCY = 2;
    private static final int DEFAULT_ABILITY_SCORE = 8;
    private static final int DEFAULT_SCORE_INCREASE = 0;

    private final CharacterCoreService characterService;
    private final CharacterStatsService statsService;
    private final ScoreIncreaseService increaseService;
    private final FeatService featService;
    private final RaceService raceService;
    private final BackgroundService backgroundService;

    private List<CharacterFeats> featsList;
    private List<CharacterScoreIncrease> scoreIncreaseList;
    private List<CharacterBackground> backgroundList;
    private List<CharacterRace> raceList;

    @GetMapping("/character-creator-step-1")
    public String CharacterCreatorStepOne(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        CurrentUserInfo.passModelAttributes(model, currentUser);
        creatorStepOneModelAttributes(model);
        return "character_creator/creator_1";
    }

    @PostMapping("/character-creator-step-1-result")
    public String CharacterCreatorStepOneResult(@AuthenticationPrincipal CurrentUser currentUser, Model model,
                                                @Valid @ModelAttribute("character") CharacterCore character,
                                                BindingResult result) {
        if (result.hasErrors()) {
            CurrentUserInfo.passModelAttributes(model, currentUser);
            creatorStepOneModelAttributes(model);
            return "character_creator/creator_1";
        }
        character.setStats(defaultStats());
        character.setIncreases(defaultScoreIncreases());
        character.setFeats(defaultFeats());
        character.setUser(currentUser.getUser());
        characterService.save(character);
        return "redirect:/app/character-creator-step-2/" + character.getId();
    }

    @GetMapping("/character-creator-step-2/{id}")
    public String CharacterCreatorStepTwo(@AuthenticationPrincipal CurrentUser currentUser, Model model,
                                          @PathVariable long id) {
        CurrentUserInfo.passModelAttributes(model, currentUser);
        creatorStepTwoModelAttributes(model, id);
        return "character_creator/creator_2";
    }

    @PostMapping("/character-creator-step-2-result")
    public String CharacterCreatorStepTwoResult(@AuthenticationPrincipal CurrentUser currentUser, Model model,
                                                @Valid CharacterStatistics statistics, BindingResult result,
                                                @RequestParam long id) {
        if (result.hasErrors()) {
            CurrentUserInfo.passModelAttributes(model, currentUser);
            creatorStepTwoModelAttributes(model, id);
            return "character_creator/creator_2";
        }
        CharacterCore core = characterService.findById(id).get();
        statistics.setProficiency(ModifiersDefiner.proficiency(statistics.getLevel()));
        statsService.save(statistics);
        core.setStats(statistics);
        characterService.editCharacter(core);
        return "redirect:/app/character-creator-step-4/" + id;
    }

    //TODO implement character-creator-step-3 when CharacterClass entity is created

    @GetMapping("/character-creator-step-4/{id}")
    public String CharacterCreatorStepFour(@AuthenticationPrincipal CurrentUser currentUser, Model model,
                                           @PathVariable long id) {
        CurrentUserInfo.passModelAttributes(model, currentUser);
        creatorStepFourModelAttributes(model, id);
        return "character_creator/creator_4";
    }

    @GetMapping("/score-increase-add/{increaseId}/{charId}")
    public String addScoreIncrease(@AuthenticationPrincipal CurrentUser currentUser, Model model,
                                   @PathVariable long increaseId, @PathVariable long charId) {
        CurrentUserInfo.passModelAttributes(model, currentUser);
        chooseScoreIncreaseModelAttributes(model, increaseId, charId);
        return "character_creator/creator_score_increase";
    }

    @PostMapping("/score-increase-add-result")
    public String addScoreIncreaseResult(@RequestParam long charId, @Valid CharacterScoreIncrease increase) {
        characterService.editCharacterIncrease(increase);
        return "redirect:/app/character-editor-step-4/"+charId;
    }

    @PostMapping("/feat-selection-creator-result")
    public String featSelectionResult(@ModelAttribute("featList") FeatWrapper featList, @RequestParam long id) {
        CharacterCore core = characterService.findById(id).get();
        core.setFeats(featList.getFeats());
        core.setStats(core.getStats());
        core.setIncreases(core.getIncreases());
        core.setUser(core.getUser());
        characterService.editCharacter(core);

        return "redirect:/app/character-creator-step-4/"+id;
    }

    //TODO Implement creator-step-5 when items.class is created

    /* !SUPPORT METHOD SECTION STARTS HERE! */

    public void creatorStepOneModelAttributes(Model model) {
        raceList = raceService.findAll();

        List<CharacterRace> raceSelection = raceList.stream()
                .skip(DEFAULT_SELECTION)
                .collect(Collectors.toList());
        model.addAttribute("race", raceSelection);

        CharacterRace defaultRace = raceList.stream().findFirst().get();
        model.addAttribute("defaultRace", defaultRace);

        backgroundList = backgroundService.findAll();

        List<CharacterBackground> backgroundSelection = backgroundList.stream()
                .skip(DEFAULT_SELECTION)
                .collect(Collectors.toList());
        model.addAttribute("background", backgroundSelection);

        CharacterBackground defaultBackground = backgroundList.stream().findFirst().get();
        model.addAttribute("defaultBackground", defaultBackground);

        model.addAttribute("character", new CharacterCore());
    }

    public CharacterStatistics defaultStats() {
        return statsService.save(
                new CharacterStatistics(
                        DEFAULT_LEVEL,
                        DEFAULT_PROFICIENCY,
                        DEFAULT_ABILITY_SCORE,  //Strength
                        DEFAULT_ABILITY_SCORE,  //Dexterity
                        DEFAULT_ABILITY_SCORE,  //Constitution
                        DEFAULT_ABILITY_SCORE,  //Intelligence
                        DEFAULT_ABILITY_SCORE,  //Wisdom
                        DEFAULT_ABILITY_SCORE   //Charisma
                ));
    }

    public List<CharacterScoreIncrease> defaultScoreIncreases() {
        List<CharacterScoreIncrease> increases = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            increases.add(
                    increaseService.save(
                            new CharacterScoreIncrease(
                                    DEFAULT_SCORE_INCREASE, //Strength
                                    DEFAULT_SCORE_INCREASE, //Dexterity
                                    DEFAULT_SCORE_INCREASE, //Constitution
                                    DEFAULT_SCORE_INCREASE, //Intelligence
                                    DEFAULT_SCORE_INCREASE, //Wisdom
                                    DEFAULT_SCORE_INCREASE  //Charisma
                            )));
        }
        return increases;
    }

    public List<CharacterFeats> defaultFeats() {
        featsList = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            featsList.add(featService.findById(DEFAULT_SELECTION).get());
        }
        return featsList;
    }

    public void creatorStepTwoModelAttributes(Model model, long id) {
        model.addAttribute("stats", new CharacterStatistics());
        model.addAttribute("charId", id);
    }

    public void creatorStepFourModelAttributes(Model model, long id) {
        int levelCheck = ModifiersDefiner.checkLevel(characterService.findById(id).get()
                .getStats()
                .getLevel());

        scoreIncreaseList = characterService.findIncreasesByCoreIdAccordingToLevel(id, levelCheck);
        model.addAttribute("increases", scoreIncreaseList);

        FeatWrapper wrapper = new FeatWrapper();
        featsList = characterService.findFeatsByCoreIdAccordingToLevel(id, levelCheck);
        wrapper.setFeats(featsList);
        model.addAttribute("featList", wrapper);

        List<CharacterFeats> selectionFeatList = featService.findAll().stream()
                .skip(DEFAULT_SELECTION)
                .collect(Collectors.toList());
        model.addAttribute("featSelection", selectionFeatList);

        model.addAttribute("charId", id);
    }

    public void chooseScoreIncreaseModelAttributes(Model model, long increaseId, long charId) {
        model.addAttribute("increase", increaseService.findById(increaseId).get());
        model.addAttribute("charId", charId);
    }

}

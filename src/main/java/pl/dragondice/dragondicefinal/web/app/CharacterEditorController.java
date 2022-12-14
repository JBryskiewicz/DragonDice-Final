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
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/app")
@AllArgsConstructor
public class CharacterEditorController {

    private static final long DEFAULT_SELECTION = 1L;

    private final CharacterCoreService characterService;
    private final RaceService raceService;
    private final BackgroundService backgroundService;
    private final CharacterStatsService statsService;
    private final ScoreIncreaseService increaseService;
    private final FeatService featService;

    private List<CharacterBackground> backgroundList;
    private List<CharacterRace> raceList;
    private List<CharacterScoreIncrease> scoreIncreaseList;
    private List<CharacterFeats> featsList;

    @GetMapping("/character-editor-step-1/{id}")
    public String characterEditorStepOne(@AuthenticationPrincipal CurrentUser currentUser, Model model,
                                         @PathVariable long id){
        CurrentUserInfo.passModelAttributes(model, currentUser);
        editorStepOneModelAttributes(model, id);
        return "character_editor/editor_1";
    }

    @PostMapping("/character-editor-step-1-result")
    public String characterEditorStepOneResult(@AuthenticationPrincipal CurrentUser currentUser, Model model,
                                               @Valid @ModelAttribute("character") CharacterCore character,
                                               BindingResult result,
                                               @RequestParam long id){
        if(result.hasErrors()){
            CurrentUserInfo.passModelAttributes(model, currentUser);
            editorStepOneModelAttributes(model, id);
            return "character_editor/editor_1";
        }
        CharacterCore originalCore = characterService.findById(id).get();
        character.setStats(originalCore.getStats());
        character.setIncreases(originalCore.getIncreases());
        character.setFeats(originalCore.getFeats());
        character.setUser(originalCore.getUser());
        characterService.editCharacter(character);
        return "redirect:/app/character-editor-step-2/" + character.getId();
    }

    @GetMapping("/character-editor-step-2/{id}")
    public String characterEditorStepTwo(@AuthenticationPrincipal CurrentUser currentUser, Model model,
                                         @PathVariable long id){
        CurrentUserInfo.passModelAttributes(model, currentUser);
        editorStepTwoModelAttributes(model, id);
        return "character_editor/editor_2";
    }

    @PostMapping("/character-editor-step-2-result")
    public String characterEditorStepTwoResult(CharacterStatistics statistics, @RequestParam long id){
        statistics.setProficiency(ModifiersDefiner.proficiency(statistics.getLevel()));
        statsService.edit(statistics);
        return "redirect:/app/character-editor-step-4/" + id;
    }

    //TODO implement character-editor-step-3 when CharacterClass entity is created

    @GetMapping("/character-editor-step-4/{id}")
    public String characterEditorStepFour(@AuthenticationPrincipal CurrentUser currentUser, Model model,
                                          @PathVariable long id){
        CurrentUserInfo.passModelAttributes(model, currentUser);
        editorStepFourModelAttributes(model, id);
        return "character_editor/editor_4";
    }

    @GetMapping("/score-increase-edit/{increaseId}/{charId}")
    public String addScoreIncrease(@AuthenticationPrincipal CurrentUser currentUser, Model model,
                                   @PathVariable long increaseId, @PathVariable long charId){
        CurrentUserInfo.passModelAttributes(model, currentUser);
        chooseScoreIncreaseModelAttributes(model, increaseId, charId);
        return "character_editor/editor_score_increase";
    }
    @PostMapping("/score-increase-edit-result")
    public String addScoreIncreaseResult(@RequestParam long charId,@Valid CharacterScoreIncrease increase){
        characterService.editCharacterIncrease(increase);
        return "redirect:/app/character-editor-step-4/"+charId;
    }

    @PostMapping("/feat-selection-editor-result")
    public String featSelectionResult(@ModelAttribute("featList") FeatWrapper featList, @RequestParam long id) {
        CharacterCore core = characterService.findById(id).get();
        core.setFeats(featList.getFeats());
        core.setStats(core.getStats());
        core.setIncreases(core.getIncreases());
        core.setUser(core.getUser());
        characterService.editCharacter(core);

        return "redirect:/app/character-editor-step-4/"+id;
    }

    /* SUPPORT METHOD SECTION STARTS */

    public void editorStepOneModelAttributes(Model model, long id) {
        raceList = raceService.findAll();
        List<CharacterRace> raceSelection = raceList.stream()
                .skip(DEFAULT_SELECTION)
                .collect(Collectors.toList());
        model.addAttribute("race", raceSelection);

        backgroundList = backgroundService.findAll();
        List<CharacterBackground> backgroundSelection = backgroundList.stream()
                .skip(DEFAULT_SELECTION)
                .collect(Collectors.toList());
        model.addAttribute("background", backgroundSelection);

        CharacterCore character = characterService.findById(id).get();
        model.addAttribute("character", character);
    }

    public void editorStepTwoModelAttributes(Model model, long id){
        model.addAttribute("stats", characterService.findById(id).get().getStats());
        model.addAttribute("charId", id);
    }

    public void editorStepFourModelAttributes(Model model, long id){
        CharacterCore core = characterService.findById(id).get();
        int levelCheck = ModifiersDefiner.checkLevel(core.getStats().getLevel());

        scoreIncreaseList = characterService.findIncreasesByCoreIdAccordingToLevel(id, levelCheck);
        model.addAttribute("increases", scoreIncreaseList);

        FeatWrapper wrapper = new FeatWrapper();
        featsList = characterService.findFeatsByCoreIdAccordingToLevel(id, levelCheck);
        wrapper.setFeats(featsList);
        model.addAttribute("featList", wrapper);

        List<CharacterFeats> selectionFeatList = featService.findAll();
        model.addAttribute("featSelection", selectionFeatList);

        model.addAttribute("charId", id);
    }

    public void chooseScoreIncreaseModelAttributes(Model model, long increaseId, long charId){
        model.addAttribute("increase", increaseService.findById(increaseId).get());
        model.addAttribute("charId", charId);
    }
}

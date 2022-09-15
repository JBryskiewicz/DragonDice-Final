package pl.dragondice.dragondicefinal.web.app;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.dragondice.dragondicefinal.domain.user.CurrentUser;
import pl.dragondice.dragondicefinal.domain.user_character_structure.CharacterCore;
import pl.dragondice.dragondicefinal.domain.user_character_structure.CharacterStatistics;
import pl.dragondice.dragondicefinal.mechanics.ModifiersDefiner;
import pl.dragondice.dragondicefinal.service.background.BackgroundService;
import pl.dragondice.dragondicefinal.service.character_core.CharacterCoreService;
import pl.dragondice.dragondicefinal.service.character_stats.CharacterStatsService;
import pl.dragondice.dragondicefinal.service.feats.FeatService;
import pl.dragondice.dragondicefinal.service.race.RaceService;

import javax.validation.Valid;

@Controller
@RequestMapping("/app")
@AllArgsConstructor
public class CharacterCreatorController {
    private final CharacterCoreService characterService;
    private final CharacterStatsService statsService;
    private final RaceService raceService;
    private final BackgroundService backgroundService;
    private final FeatService featService;

    @GetMapping("/character-creator-step-1")
    public String CharacterCreatorStepOne(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        currentUserName(model, currentUser);
        creatorStepOneModelAttributes(model);
        return "/app/character_creator_1";
    }

    @PostMapping("/character-creator-step-1-result")
    public String CharacterCreatorStepOneResult(@AuthenticationPrincipal CurrentUser currentUser, Model model,
                                                @Valid CharacterCore core, BindingResult result) {
        if (result.hasErrors()) {
            currentUserName(model, currentUser);
            creatorStepOneModelAttributes(model);
            return "/app/character_creator_1";
        }
        core.setUser(currentUser.getUser());
        core.setStats(defaultStats());
        characterService.save(core);
        return "redirect:/app/character-creator-step-2/" + core.getId();
    }

    @GetMapping("/character-creator-step-2/{id}")
    public String CharacterCreatorStepTwo(@AuthenticationPrincipal CurrentUser currentUser, Model model,
                                          @PathVariable long id) {
        currentUserName(model, currentUser);
        creatorStepTwoModelAttributes(model, id);
        return "/app/character_creator_2";
    }

    @PostMapping("/character-creator-step-2-result")
    public String CharacterCreatorStepTwoResult(@AuthenticationPrincipal CurrentUser currentUser, Model model,
                                                @Valid CharacterStatistics statistics, BindingResult result,
                                                @RequestParam long id) {
        if (result.hasErrors()) {
            currentUserName(model, currentUser);
            creatorStepTwoModelAttributes(model, id);
            return "/app/character_creator_2";
        }
        CharacterCore core = characterService.findById(id).get();
        statistics.setProficiency(ModifiersDefiner.proficiency(statistics.getLevel()));
        statsService.save(statistics);
        core.setStats(statistics);
        characterService.editCharacter(core);
        return "redirect:/app/character-creator-step-4/"+id;
    }

    //TODO implement character-creator-step-3 when CharacterClass entity is created

    @GetMapping("/character-creator-step-4/{id}")
    public String CharacterCreatorStepFour(@AuthenticationPrincipal CurrentUser currentUser, Model model,
                                           @PathVariable long id){
        currentUserName(model, currentUser);
        creatorStepFourModelAttributes(model, id);
        return "/app/character_creator_4";
    }

    @PostMapping("/character-createor-step-4-result")
    public String CharacterCreatorStepFourResult(@AuthenticationPrincipal CurrentUser currentUser, Model model,
                                                 @RequestParam long id){
        //TODO method must process both score increases and / or feats wrap them into Lists and save to Character class

        //TODO redirect to step-5 instead when inventory/items are implemented
        return "redirect:/app/select";
    }

    /* ! SUPPORT METHOD SECTION - START ! */

    private static final int DEFAULT_LEVEL = 1;
    private static final int STARTING_PROFICIENCY = 2;
    private static final int DEFAULT_STR = 8;
    private static final int DEFAULT_DEX = 8;
    private static final int DEFAULT_CON = 8;
    private static final int DEFAULT_INT = 8;
    private static final int DEFAULT_WIS = 8;
    private static final int DEFAULT_CHA = 8;

    public void currentUserName(Model model, CurrentUser currentUser) {
        String username = currentUser.getUser().getUsername();
        model.addAttribute("user", username);
    }

    public void creatorStepOneModelAttributes(Model model) {
        model.addAttribute("race", raceService.findAll());
        model.addAttribute("background", backgroundService.findAll());
        model.addAttribute("character", new CharacterCore());
    }

    public CharacterStatistics defaultStats(){
        return statsService.save(
                new CharacterStatistics(
                DEFAULT_LEVEL,
                STARTING_PROFICIENCY,
                DEFAULT_STR,
                DEFAULT_DEX,
                DEFAULT_CON,
                DEFAULT_INT,
                DEFAULT_WIS,
                DEFAULT_CHA
                ));
    }

    public void creatorStepTwoModelAttributes(Model model, long id) {
        model.addAttribute("stats", new CharacterStatistics());
        model.addAttribute("charId", id);
    }

    public void creatorStepFourModelAttributes(Model model, long id){
        //TODO when class is implemented pass attribute Fighter class for special increase condition on lvl 6 and 14
        //TODO also Rogue class for special condition at lvl 10
        model.addAttribute("lvl", characterService.findById(id).get().getStats().getLevel());
//        model.addAttribute("increase", scoreIncreaseListAttribute());
        model.addAttribute("feats", featService.findAll());
        model.addAttribute("charId", id);
    }


}

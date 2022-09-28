package pl.dragondice.dragondicefinal.web.app;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dragondice.dragondicefinal.domain.user.CurrentUser;
import pl.dragondice.dragondicefinal.domain.user_character_structure.CharacterCore;
import pl.dragondice.dragondicefinal.mechanics.AbilityScoreSum;
import pl.dragondice.dragondicefinal.mechanics.ModifiersDefiner;
import pl.dragondice.dragondicefinal.service.character_core.CharacterCoreService;

@Controller
@RequestMapping("/app")
@AllArgsConstructor
public class CharacterController {
    private static final int BASE_TEN = 10;
    private final CharacterCoreService characterService;

    @GetMapping("/character-sheet/{id}")
    public String characterSheet(@AuthenticationPrincipal CurrentUser currentUser, Model model, @PathVariable long id){

        CurrentUserInfo.passModelAttributes(model, currentUser);
        characterCore(model, id);
        abilityScoresModelAttributes(model, id);
        abilityScoreModifiersModelAttributes(model, id);
        passiveSkillsAndArmorClass(model, id);

        return "character_sheet/sheet";
    }

    /* SUPPORT METHOD SECTION STARTS */

    public void characterCore(Model model, long id){
        CharacterCore character = characterService.findById(id).get();
        model.addAttribute("character", character);
    }

    public void abilityScoresModelAttributes(Model model, long id){
        AbilityScoreSum scoreSum = new AbilityScoreSum(characterService);
        model.addAttribute("strAbilityScore", scoreSum.strAbilityScore(id));
        model.addAttribute("dexAbilityScore", scoreSum.dexAbilityScore(id));
        model.addAttribute("conAbilityScore", scoreSum.conAbilityScore(id));
        model.addAttribute("intAbilityScore", scoreSum.intAbilityScore(id));
        model.addAttribute("wisAbilityScore", scoreSum.wisAbilityScore(id));
        model.addAttribute("chaAbilityScore", scoreSum.chaAbilityScore(id));
    }

    public void abilityScoreModifiersModelAttributes(Model model, long id){
        AbilityScoreSum scoreSum = new AbilityScoreSum(characterService);
        model.addAttribute("strMod", ModifiersDefiner.abilityModifier(scoreSum.strAbilityScore(id)));
        model.addAttribute("dexMod", ModifiersDefiner.abilityModifier(scoreSum.dexAbilityScore(id)));
        model.addAttribute("conMod", ModifiersDefiner.abilityModifier(scoreSum.conAbilityScore(id)));
        model.addAttribute("intMod", ModifiersDefiner.abilityModifier(scoreSum.intAbilityScore(id)));
        model.addAttribute("wisMod", ModifiersDefiner.abilityModifier(scoreSum.wisAbilityScore(id)));
        model.addAttribute("chaMod", ModifiersDefiner.abilityModifier(scoreSum.chaAbilityScore(id)));
    }

    public void passiveSkillsAndArmorClass(Model model, long id){
        AbilityScoreSum scoreSum = new AbilityScoreSum(characterService);
        model.addAttribute("ArmorClass", BASE_TEN +
                ModifiersDefiner.abilityModifier(scoreSum.dexAbilityScore(id)));
        model.addAttribute("passivePerception", BASE_TEN +
                ModifiersDefiner.abilityModifier(scoreSum.wisAbilityScore(id)));
        model.addAttribute("passiveInvestigation", BASE_TEN +
                ModifiersDefiner.abilityModifier(scoreSum.intAbilityScore(id)));
        model.addAttribute("passiveInsight", BASE_TEN +
                ModifiersDefiner.abilityModifier(scoreSum.wisAbilityScore(id)));
    }
}

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
import pl.dragondice.dragondicefinal.domain.user_character_structure.CharacterScoreIncrease;
import pl.dragondice.dragondicefinal.domain.user_character_structure.CharacterStatistics;
import pl.dragondice.dragondicefinal.service.character_core.CharacterCoreService;
import pl.dragondice.dragondicefinal.service.character_stats.CharacterStatsService;
import pl.dragondice.dragondicefinal.service.score_increase.ScoreIncreaseService;

import java.util.List;

@Controller
@RequestMapping("/app")
@AllArgsConstructor
public class CharacterDeleteController {
    private final CharacterCoreService characterService;
    private final CharacterStatsService statsService;
    private final ScoreIncreaseService increaseService;

    @GetMapping("/character-delete/{id}")
    public String characterDelete(@AuthenticationPrincipal CurrentUser currentUser, Model model, @PathVariable long id){
        CurrentUserInfo.passModelAttributes(model, currentUser);
        model.addAttribute("character", characterService.findById(id).get());
        return "character_delete/confirm_delete";
    }

    @GetMapping("/character-delete-result/{id}")
    public String characterDeleteResult(@PathVariable long id){
        CharacterCore core = characterService.findById(id).get();
        CharacterStatistics stats = core.getStats();
        List<CharacterScoreIncrease> increaseList = core.getIncreases();
        characterService.delete(core);
        statsService.delete(stats);
        increaseService.deleteCharacterIncreases(increaseList);
        return "redirect:/app/select";
    }
}

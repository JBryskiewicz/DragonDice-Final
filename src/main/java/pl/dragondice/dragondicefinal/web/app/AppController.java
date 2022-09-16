package pl.dragondice.dragondicefinal.web.app;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dragondice.dragondicefinal.domain.user.CurrentUser;
import pl.dragondice.dragondicefinal.service.character_core.CharacterCoreService;

import javax.validation.Valid;

@Controller
@RequestMapping("/app")
@AllArgsConstructor
public class AppController {
    private final CharacterCoreService characterService;

    @GetMapping("/select")
    public String charSelect(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        currentUserName(model, currentUser);
        model.addAttribute("characters", characterService.findAllByUser(currentUser.getUser()));
        return "character_select";
    }

    /* ! SUPPORT METHOD SECTION - START ! */

    public void currentUserName(Model model, CurrentUser currentUser) {
        String username = currentUser.getUser().getUsername();
        model.addAttribute("user", username);
    }
}

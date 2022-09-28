package pl.dragondice.dragondicefinal.web.admin_app;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dragondice.dragondicefinal.domain.user.CurrentUser;

@Controller
@RequestMapping("/admin-app")
@AllArgsConstructor
public class AdminAppController {

    @GetMapping("/panel")
    public String adminPanel(@AuthenticationPrincipal CurrentUser currentUser, Model model){
        String username = currentUser.getUser().getUsername();
        model.addAttribute("user", username);
        return "admin_panel";
    }
}

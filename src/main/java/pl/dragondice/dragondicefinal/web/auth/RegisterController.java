package pl.dragondice.dragondicefinal.web.auth;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dragondice.dragondicefinal.domain.user.User;
import pl.dragondice.dragondicefinal.service.user.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/register-section")
@AllArgsConstructor
public class RegisterController {
    private final UserService userService;

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "auth/register";
    }

    @PostMapping("/register-result")
    public String registerResult(@Valid User user, BindingResult result){
        if (result.hasErrors()){
            return "/auth/register";
        }
        userService.saveUser(user);
        return "redirect:/login-section/login";
    }
}

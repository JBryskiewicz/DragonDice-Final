package pl.dragondice.dragondicefinal.web.auth;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
            return "auth/register";
        }
        userService.saveUser(user);
        return "redirect:/login-section/login";
    }

    @GetMapping("/signup-confirm/{token}")
    @ResponseBody
    public String confirm(@PathVariable String token){
        return userService.confirmToken(token);
        //TODO Redirect to login page with model attributed String with activation info.
    }

}

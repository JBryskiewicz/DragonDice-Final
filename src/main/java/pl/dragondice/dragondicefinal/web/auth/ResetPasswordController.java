package pl.dragondice.dragondicefinal.web.auth;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.dragondice.dragondicefinal.domain.user.ResetToken;
import pl.dragondice.dragondicefinal.domain.user.User;
import pl.dragondice.dragondicefinal.service.email.EmailSenderService;
import pl.dragondice.dragondicefinal.service.email.RecoveryEmail;
import pl.dragondice.dragondicefinal.service.user.UserService;
import pl.dragondice.dragondicefinal.service.verification_token.VerificationTokenService;

import java.time.LocalDateTime;
import java.util.UUID;

@Controller
@RequestMapping("/password-recovery")
@AllArgsConstructor
public class ResetPasswordController {

    private static final String LINK = "http://localhost:8081/password-recovery/new-password/";
    private static final String TOKEN_EXPIRED = "This token is expired";

    //TODO Change name of interface to TokenService because now it works for two different tokens
    private final VerificationTokenService tokenService;
    private final UserService userService;
    private final EmailSenderService emailService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final String TOKEN = UUID.randomUUID().toString();

    @GetMapping("/forgot-password")
    public String forgotPassword(){
        return "auth/forgot_password";
    }

    @PostMapping("/recover")
    public String recoverPassword(@RequestParam String email){
        User user = userService.findUserByEmail(email);
        tokenService.saveRecoveryToken(user,TOKEN);

        String link = LINK + TOKEN;
        System.out.println(link);
        RecoveryEmail emailBody = new RecoveryEmail();
        emailService.sendRecoveryEmail(
                email,
                emailBody.buildRecoveryEmail(user.getUsername(), link)
        );
        return "redirect:/login-section/login";
    }

    @GetMapping("/new-password/{token}")
    public String newPasswordForm(Model model, @PathVariable String token){
        ResetToken resetToken = tokenService.findByResetToken(token);
        LocalDateTime now = LocalDateTime.now();
        if(now.isAfter(resetToken.getExpiryDate())){
            model.addAttribute("expired", TOKEN_EXPIRED);
            return "auth/forgot_password";
        }
        User user = resetToken.getUser();
        model.addAttribute("id", user.getId());
        model.addAttribute("token", token);
        return "auth/change_password";
    }

    @PostMapping("/result")
    public String changePassword(@RequestParam String password, @RequestParam String confirmPassword,
                                 @RequestParam long id, @RequestParam String token){
        if(!password.equals(confirmPassword)){
            return "redirect:/password-recovery/new-password/"+token;
        }
        User user = userService.findById(id).get();
        user.setPassword(passwordEncoder.encode(password));
        userService.editUser(user);
        return "redirect:/login-section/login";
    }
}

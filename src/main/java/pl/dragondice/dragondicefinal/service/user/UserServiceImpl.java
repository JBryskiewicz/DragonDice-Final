package pl.dragondice.dragondicefinal.service.user;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dragondice.dragondicefinal.domain.user.Role;
import pl.dragondice.dragondicefinal.domain.user.User;
import pl.dragondice.dragondicefinal.domain.user.VerificationToken;
import pl.dragondice.dragondicefinal.repository.Role.RoleRepository;
import pl.dragondice.dragondicefinal.repository.user.UserRepository;
import pl.dragondice.dragondicefinal.service.email.ConfirmationEmail;
import pl.dragondice.dragondicefinal.service.email.EmailSenderService;
import pl.dragondice.dragondicefinal.service.email.EmailValidator;
import pl.dragondice.dragondicefinal.service.verification_token.VerificationTokenService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private static final String USER_ROLE = "ROLE_USER";
    private static final String LINK = "http://localhost:8081/register-section/signup-confirm/";
    private static final String CONFIRM_ERROR = "Email is not verified, check your email";
    private static final String TOKEN_ERROR = "Incorrect activation token";
    private static final String TOKEN_CONFIRMED = "Account activated via verification";
    private static final String TOKEN_EXPIRED = "This token is expired";
    private static final int DISABLED = 0;
    private static final int ENABLED = 1;
    private final String TOKEN = UUID.randomUUID().toString();


    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final VerificationTokenService tokenService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final EmailValidator emailValidator;
    private final EmailSenderService emailSenderService;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void saveUser(User user) {
        boolean validEmail = emailValidator.test(user.getEmail());
        if(!validEmail){
            throw new IllegalStateException(CONFIRM_ERROR);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(DISABLED);
        Role userRole = roleRepository.findByName(USER_ROLE);
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
        tokenService.save(user, TOKEN);

        String link = LINK + TOKEN;
        ConfirmationEmail emailBody = new ConfirmationEmail();
        emailSenderService.sendConfirmationEmail(
                user.getEmail(),
                emailBody.buildEmail(user.getUsername(), link)
        );
    }

    @Override
    public String confirmToken(String token) {
        try{
            VerificationToken verificationToken = tokenService.findByToken(token);
            LocalDateTime now = LocalDateTime.now();
            if(now.isAfter(verificationToken.getExpiryDate())){
                return TOKEN_EXPIRED;
            }
            if(!token.equals(verificationToken.getToken())){
                return TOKEN_ERROR;
            }
            User user = tokenService.findByToken(token).getUser();
            user.setEnabled(ENABLED);
            entityManager.merge(user);
            return TOKEN_CONFIRMED;
        }catch (NullPointerException e){
            return TOKEN_ERROR;
        }
    }

    @Override
    public void editUser(User user) {
        //TODO Write code to edit user with details like enabled, roles, password reset etc.
    }

    @Override
    public void softEditUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public String findByEmail(String email) {
        String existingEmail = userRepository.findByEmail(email).getEmail();
        if(existingEmail.equals(null)){
            return "DOES_NOT_EXIST";
        }
        return existingEmail;
    }


}

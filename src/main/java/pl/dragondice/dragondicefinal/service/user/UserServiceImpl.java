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
import pl.dragondice.dragondicefinal.service.verification_token.VerificationTokenService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private static final String USER_ROLE = "ROLE_USER";
    private static final String LINK = "http://localhost:8081/register-section/signup-confirm/";
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
    private final EmailSenderService emailSenderService;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(DISABLED);
        Role userRole = roleRepository.findByName(USER_ROLE);
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
        tokenService.saveVerificationToken(user, TOKEN);

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
            VerificationToken verificationToken = tokenService.findByVerificationToken(token);
            LocalDateTime now = LocalDateTime.now();
            if(now.isAfter(verificationToken.getExpiryDate())){
                return TOKEN_EXPIRED;
            }
            if(!token.equals(verificationToken.getToken())){
                return TOKEN_ERROR;
            }
            User user = tokenService.findByVerificationToken(token).getUser();
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
        try{
            return userRepository.findByEmail(email).getEmail();
        }catch (NullPointerException e){
            return "DOES_NOT_EXIST";
        }
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


}

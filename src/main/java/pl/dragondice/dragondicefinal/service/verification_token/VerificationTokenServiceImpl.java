package pl.dragondice.dragondicefinal.service.verification_token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dragondice.dragondicefinal.domain.user.User;
import pl.dragondice.dragondicefinal.domain.user.VerificationToken;
import pl.dragondice.dragondicefinal.repository.verification_token.VerificationTokenRepository;

import java.time.LocalDateTime;

@Service
@Transactional
@AllArgsConstructor
public class VerificationTokenServiceImpl implements VerificationTokenService{

    private static final int EXPIRATION = 24 * 60;
    private final VerificationTokenRepository tokenRepository;

    @Override
    public VerificationToken findByToken(String token) {
        return this.tokenRepository.findByToken(token);
    }

    @Override
    public void save(User user, String token) {
        VerificationToken verificationToken = new VerificationToken(user, token);
        verificationToken.setExpiryDate(calculateExpiryDate(EXPIRATION));
        tokenRepository.save(verificationToken);
    }

    private LocalDateTime calculateExpiryDate(int expiryDateInMinutes){
        LocalDateTime time = LocalDateTime.now().plusMinutes(expiryDateInMinutes);
        return time;
    }
}

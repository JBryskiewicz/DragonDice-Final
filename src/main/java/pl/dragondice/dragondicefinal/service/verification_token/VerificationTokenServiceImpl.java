package pl.dragondice.dragondicefinal.service.verification_token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dragondice.dragondicefinal.domain.user.ResetToken;
import pl.dragondice.dragondicefinal.domain.user.User;
import pl.dragondice.dragondicefinal.domain.user.VerificationToken;
import pl.dragondice.dragondicefinal.repository.reset_token.ResetTokenRepository;
import pl.dragondice.dragondicefinal.repository.verification_token.VerificationTokenRepository;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class VerificationTokenServiceImpl implements VerificationTokenService{

    private static final int VERIFICATION_EXPIRATION = 24 * 60;
    private static final int RECOVERY_EXPIRATION = 60;
    private final VerificationTokenRepository verificationTokenRepository;
    private final ResetTokenRepository resetTokenRepository;


    @Override
    public VerificationToken findByVerificationToken(String token) {
        return this.verificationTokenRepository.findByToken(token);
    }

    @Override
    public ResetToken findByResetToken(String token) {
        return this.resetTokenRepository.findByToken(token);
    }

    @Override
    public void saveVerificationToken(User user, String token) {
        VerificationToken verificationToken = new VerificationToken(user, token);
        verificationToken.setExpiryDate(calculateExpiryDate(VERIFICATION_EXPIRATION));
        verificationTokenRepository.save(verificationToken);
    }

    @Override
    public void saveRecoveryToken(User user, String token) {
        ResetToken resetToken = new ResetToken(user, token);
        resetToken.setExpiryDate(calculateExpiryDate(RECOVERY_EXPIRATION));
        resetTokenRepository.save(resetToken);
    }

    private LocalDateTime calculateExpiryDate(int expiryDateInMinutes){
        LocalDateTime time = LocalDateTime.now().plusMinutes(expiryDateInMinutes);
        return time;
    }
}

package pl.dragondice.dragondicefinal.service.verification_token;

import pl.dragondice.dragondicefinal.domain.user.ResetToken;
import pl.dragondice.dragondicefinal.domain.user.User;
import pl.dragondice.dragondicefinal.domain.user.VerificationToken;

public interface VerificationTokenService {
    VerificationToken findByVerificationToken(String token);
    ResetToken findByResetToken(String token);
    void saveVerificationToken(User user, String token);
    void saveRecoveryToken(User user, String token);
}

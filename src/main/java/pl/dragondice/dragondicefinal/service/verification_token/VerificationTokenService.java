package pl.dragondice.dragondicefinal.service.verification_token;

import pl.dragondice.dragondicefinal.domain.user.User;
import pl.dragondice.dragondicefinal.domain.user.VerificationToken;

public interface VerificationTokenService {
    VerificationToken findByToken(String token);
    void save(User user, String token);
}

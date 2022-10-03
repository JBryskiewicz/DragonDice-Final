package pl.dragondice.dragondicefinal.repository.reset_token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dragondice.dragondicefinal.domain.user.ResetToken;

@Repository
public interface ResetTokenRepository extends JpaRepository<ResetToken, Long> {
    ResetToken findByToken(String Token);
}

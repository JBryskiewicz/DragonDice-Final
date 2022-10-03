package pl.dragondice.dragondicefinal.service.user;

import pl.dragondice.dragondicefinal.domain.user.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findById(long id);
    User findByUsername(String username);
    void saveUser(User user);
    String confirmToken(String token);
    void editUser(User user);
    void softEditUser(User user);
    String findByEmail(String email);
    User findUserByEmail(String email);

}

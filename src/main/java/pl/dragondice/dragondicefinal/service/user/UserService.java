package pl.dragondice.dragondicefinal.service.user;

import pl.dragondice.dragondicefinal.domain.user.User;

public interface UserService {
    User findByUsername(String username);
    void saveUser(User user);
    String confirmToken(String token);
    void editUser(User user);
    void softEditUser(User user);

}

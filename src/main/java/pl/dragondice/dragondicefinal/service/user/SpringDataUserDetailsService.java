package pl.dragondice.dragondicefinal.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.dragondice.dragondicefinal.domain.user.CurrentUser;
import pl.dragondice.dragondicefinal.domain.user.User;

import java.util.HashSet;
import java.util.Set;

public class SpringDataUserDetailsService implements UserDetailsService {

    private static final String DISABLED_ACCOUNT_MASSAGE = "account is inactive";
    private static final String NOT_FOUND_ACCOUNT_MASSAGE = "account does not exits";
    private UserService userService;

    @Autowired
    public void setUserRepository(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userService.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException(username + NOT_FOUND_ACCOUNT_MASSAGE);
        }
        if(user.getEnabled() == 0){
            throw new UsernameNotFoundException(username + DISABLED_ACCOUNT_MASSAGE);
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        user.getRoles().forEach(r ->
                grantedAuthorities.add(new SimpleGrantedAuthority(r.getName())));

        return new CurrentUser(user.getUsername(),user.getPassword(),
                grantedAuthorities, user);

    }
}

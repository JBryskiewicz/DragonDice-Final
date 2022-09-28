package pl.dragondice.dragondicefinal.web.app;

import org.springframework.ui.Model;
import pl.dragondice.dragondicefinal.domain.user.CurrentUser;
import pl.dragondice.dragondicefinal.domain.user.Role;

import java.util.Iterator;
import java.util.Set;

public class CurrentUserInfo {

    private static final int checkAdminAttribute = 1;
    private static final String ADMIN_ROLE = "ROLE_ADMIN";

    public static void passModelAttributes(Model model, CurrentUser currentUser){
        String username = currentUser.getUser().getUsername();
        model.addAttribute("user", username);

        Set<Role> roleList = currentUser.getUser().getRoles();
        Iterator<Role> it = roleList.iterator();
        while (it.hasNext()){
            if (it.next().getName().equals(ADMIN_ROLE)){
                model.addAttribute("CheckAdmin", checkAdminAttribute);
            }
        }
    }
}

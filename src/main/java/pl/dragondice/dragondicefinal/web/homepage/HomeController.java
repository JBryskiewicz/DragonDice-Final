package pl.dragondice.dragondicefinal.web.homepage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/homepage")
    public String homepage(){
        //TODO pass number of registered accounts
        return "homepage";
    }
}

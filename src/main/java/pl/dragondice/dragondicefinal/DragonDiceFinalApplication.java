package pl.dragondice.dragondicefinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("pl.dragondice")
@EntityScan("pl.dragondice.dragondicefinal.domain")
@EnableJpaRepositories("pl.dragondice.dragondicefinal.repository")
public class DragonDiceFinalApplication {

    public static void main(String[] args) {
        SpringApplication.run(DragonDiceFinalApplication.class, args);
    }

    //TODO
    // form validation - Check why step 1 for creators does not want to display errors unlike registration
    // change forgotten password via email
    // fix feat list for saving and editing (incorrect display order)
    // fix registration form. Double click for register button causes error with stacktrace (sends two same entities to DB)
    // change login form into thymeleaf so validation can be applied
    // Create characterClass.class
    // Create characterSubClass.class
    // Create item.class
    // Create spell.class
}
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
    // form validation - display error on incorrect input
    // interface for creator and editor controllers?
    // change forgotten password via email
    // fix feat list for saving and editing (incorrect display order)
    // separate admin control panel from user app
    // Make accounts active or inactive via enabled attribute
}

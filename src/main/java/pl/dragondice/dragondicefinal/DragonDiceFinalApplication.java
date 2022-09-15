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

}

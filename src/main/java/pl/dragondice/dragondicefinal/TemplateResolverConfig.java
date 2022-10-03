package pl.dragondice.dragondicefinal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration
public class TemplateResolverConfig {
    SpringResourceTemplateResolver templateResolver;

    @Bean
    public SpringResourceTemplateResolver appTemplateResolver() {
        templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("classpath:/templates/app/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setOrder(1);
        templateResolver.setCheckExistence(true);

        return templateResolver;
    }

    @Bean
    public SpringResourceTemplateResolver adminAppTemplateResolver() {
        templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("classpath:/templates/admin_app/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setOrder(2);
        templateResolver.setCheckExistence(true);

        return templateResolver;
    }

    @Bean
    public SpringResourceTemplateResolver AuthTemplateResolver() {
        templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("classpath:/templates/auth/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setOrder(3);
        templateResolver.setCheckExistence(true);

        return templateResolver;
    }

}

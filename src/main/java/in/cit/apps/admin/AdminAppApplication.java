package in.cit.apps.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(value = {"in.cit.apps.admin"})
@EnableAutoConfiguration
@Configuration
@EnableJpaRepositories(basePackages = {"in.cit.apps.admin.data"})
public class AdminAppApplication extends SpringBootServletInitializer {


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AdminAppApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(AdminAppApplication.class, args);
    }
}

package in.cit.apps.admin;

import in.cit.apps.admin.data.repo.UserGroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

//@SpringBootApplication
@ComponentScan(value = {"in.cit.apps.admin"})
@EnableAutoConfiguration//(exclude = {DataSourceAutoConfiguration.class})
@Configuration
@EnableJpaRepositories(basePackages = {"in.cit.apps.admin.data"})
public class AdminAppApplication extends SpringBootServletInitializer {

    @Autowired
    DataSource dataSource;

    @Autowired
    UserGroupsRepository userGroupsRepository;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AdminAppApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(AdminAppApplication.class, args);
    }
}

package ua.com.callboard.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

/**
 * Created by Temp on 21.09.2017.
 */
@Configuration
@EnableJpaRepositories(basePackages = {"ua.com.callboard.instance"}, entityManagerFactoryRef = "emf")
@EnableSpringDataWebSupport
public class JPARepositoryConfig {

}

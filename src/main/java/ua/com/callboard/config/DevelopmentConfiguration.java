package ua.com.callboard.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by Temp on 21.09.2017.
 */
@Profile("dev")
@Configuration
public class DevelopmentConfiguration {

    @Bean
    public PropertyPlaceholderConfigurer placeholderConfigurer() {
        PropertyPlaceholderConfigurer placeholderConfigurer = new PropertyPlaceholderConfigurer();

        placeholderConfigurer.setLocations(
                new ClassPathResource("db-config.properties"),
                new ClassPathResource("dev.properties")
        );
        return placeholderConfigurer;
    }
}

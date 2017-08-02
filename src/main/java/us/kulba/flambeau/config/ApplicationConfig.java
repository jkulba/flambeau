package us.kulba.flambeau.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * App config getters and setters map to values set in application.yml.
 *
 * @author James Kulba, jkulba@gmail.com, 2017
 */
@Component
@ConfigurationProperties(prefix = "app")
public class ApplicationConfig {
    final Logger logger = LoggerFactory.getLogger(ApplicationConfig.class);

    private String profile;
    private String driver;

    public String getProfile() { return profile; }

    public void setProfile(String profile) { this.profile = profile; }

    public String getDriver() { return driver; }

    public void setDriver(String driver) { this.driver = driver; }

    @PostConstruct
    public void xxx() {
        logger.info("Initialized [Environment Profile: {}]", profile);

    }

}

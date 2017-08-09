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
    private String driverProp;

    public String getProfile() { return profile; }

    public void setProfile(String profile) { this.profile = profile; }

    public String getDriver() { return driver; }

    public void setDriver(String driver) { this.driver = driver; }

    public String getDriverProp() { return driverProp; }

    public void setDriverProp(String driverProp) { this.driverProp = driverProp; }

    @PostConstruct
    public void xxx() {
        logger.info("Initialized [Environment Profile: {}]", profile);
        logger.info("Initialized [Environment driver: {}]", driver);
        logger.info("Initialized [Environment driverProp: {}]", driverProp);

    }

}

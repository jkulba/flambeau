package us.kulba.flambeau.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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
    private String browser;

    @Autowired
    private ApplicationConfig applicationConfig;

    public String getProfile() { return profile; }

    public void setProfile(String profile) { this.profile = profile; }

    public String getDriver() { return driver; }

    public void setDriver(String driver) { this.driver = driver; }

    public String getBrowser() { return browser; }

    public void setBrowser(String browser) { this.browser = browser; }

    @PostConstruct
    public void xxx() {
        logger.info("Initialized [Environment Profile: {}]", profile);
        logger.info("Initialized [Environment driver: {}]", driver);
        logger.info("Initialized [Environment browser: {}]", browser);

    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}

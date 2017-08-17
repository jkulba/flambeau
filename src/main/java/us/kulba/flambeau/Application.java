package us.kulba.flambeau;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import us.kulba.flambeau.config.ApplicationConfig;

/**
 * Main driver for application
 *
 * @author James Kulba, jkulba@gmail.com, 2017
 */
@SpringBootApplication
public class Application implements CommandLineRunner {
	final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private ApplicationConfig applicationConfig;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
//        app.setBannerMode(Banner.Mode.OFF);  //Banner.mode value is now set in the application.yml
        app.run(args);
	}

	@Override
	public void run(String... strings) throws Exception {
        logger.info("The Flambeau is a river in Wisconsin");

        System.setProperty("webdriver.chrome.driver", "chromedriver");
        System.setProperty("webdriver.gecko.driver", "geckodriver");

	}
}

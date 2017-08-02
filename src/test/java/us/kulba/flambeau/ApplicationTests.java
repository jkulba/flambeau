package us.kulba.flambeau;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import us.kulba.flambeau.config.ApplicationConfig;

/**
 * Generic test file
 *
 * @author James Kulba, jkulba@gmail.com, 2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    final Logger logger = LoggerFactory.getLogger(ApplicationTests.class);

    @Autowired
    private ApplicationConfig applicationConfig;

	private void googleExampleThatSearchesFor(final String searchString) {

        System.setProperty("webdriver.gecko.driver", applicationConfig.getDriver());

		WebDriver driver = new FirefoxDriver();

		driver.get("http://www.google.com");

		WebElement searchField = driver.findElement(By.name("q"));

		searchField.clear();
		searchField.sendKeys(searchString);

		logger.info("Page title is: " + driver.getTitle());

		searchField.submit();

		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driverObject) {
				return driverObject.getTitle().toLowerCase().startsWith(searchString.toLowerCase());}
		});


		logger.info("Page title is: " + driver.getTitle());

		driver.quit();
	}

    @Test
    public void googleCheeseExample() {
        googleExampleThatSearchesFor("Cheese!");
    }

    @Test
    public void googleMilkExample() {
        googleExampleThatSearchesFor("Milk!");
    }

}

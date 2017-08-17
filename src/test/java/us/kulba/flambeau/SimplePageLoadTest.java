package us.kulba.flambeau;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import us.kulba.flambeau.constants.BrowserType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimplePageLoadTest {
    final Logger logger = LoggerFactory.getLogger(SimplePageLoadTest.class);

    /**
     * Test method used to navigate to google and search for the search term 'Cheese'.
     *
     * @param driver
     * @param searchString
     */
    private void googleSearchForTerm(WebDriver driver, final String searchString) {
        logger.info("Start googleSearchForTerm");

        driver.get("http://www.google.com");
        WebElement searchField = driver.findElement(By.name("q"));

        searchField.clear();
        searchField.sendKeys(searchString);

        logger.info("Page title is: " + driver.getTitle());

        searchField.submit();

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driverObject) {
                return driverObject.getTitle().toLowerCase().startsWith(searchString.toLowerCase());
            }
        });
        driver.quit();
    }

    @Test
    public void searchChromeTest() {
        WebDriver driver = BrowserType.fromString("CHROME").startDriver();
        googleSearchForTerm(driver, "Cheese");
    }

    @Test
    public void searchGeckoTest() {
        WebDriver driver = BrowserType.fromString("GECKO").startDriver();
        googleSearchForTerm(driver, "Cheese");
    }


}

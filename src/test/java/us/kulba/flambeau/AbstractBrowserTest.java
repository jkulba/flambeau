package us.kulba.flambeau;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * Abstract class used to define the browser type used for any implemented tests.
 *
 * @author James Kulba, jkulba@gmail.com, 2017
 *
 */
public abstract class AbstractBrowserTest {

    public enum Browsers {
        CHROME, FIREFOX, SAFARI, IE32, IE64;
    }

    public static WebDriver startDriver (Browsers browserType) {

        switch (browserType) {
            case FIREFOX:
                return new FirefoxDriver();
            case CHROME:
                return new ChromeDriver();
            case SAFARI:
                return new SafariDriver();
            case IE32:
                return new InternetExplorerDriver();
            case IE64:
                return new InternetExplorerDriver();
            default:
                throw new IllegalArgumentException("Unknown browser type");
        }
    }


}

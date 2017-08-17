package us.kulba.flambeau.constants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;


public enum BrowserType {

    CHROME("CHROME") {

        @Override
        public WebDriver startDriver() { return new ChromeDriver(); }
        @Override
        public String driverProp() { return "webdriver.chrome.driver"; }

    },
    FIREFOX("GECKO") {

        @Override
        public WebDriver startDriver() { return new FirefoxDriver(); }
        @Override
        public String driverProp() { return "webdriver.gecko.driver"; }

    },
    SAFARI("SAFARI") {

        @Override
        public WebDriver startDriver() { return new SafariDriver(); }

        @Override
        public String driverProp() { return "webdriver.chrome.driver"; }

    },
    IE32("IE32") {

        @Override
        public WebDriver startDriver() { return new InternetExplorerDriver(); }

        @Override
        public String driverProp() { return "webdriver.chrome.driver"; }

    },
    IE64("IE64") {

        @Override
        public WebDriver startDriver() { return new InternetExplorerDriver(); }

        @Override
        public String driverProp() { return "webdriver.chrome.driver"; }

    };

    private final String strValue;

    BrowserType(final String strValue) {
        this.strValue = strValue;
    }

    public static BrowserType fromString(String name) {
        for (BrowserType b : BrowserType.values()) {
            if (b.strValue.equalsIgnoreCase(name.toUpperCase())) {
                return b;
            }
        }
        return null;
    }

    public WebDriver startDriver() { return null; }

    public String driverProp() { return ""; }

    @Override
    public String toString() {
        return this.strValue;
    }
}

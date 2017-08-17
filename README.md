# flambeau test tool
Sample Selenium Test Tool to be used as a proto-type for more advanced Selenium tests.

The idea is to write tests that do NOT rely on a GUI browser.  By using WebDriver for each type of browser, we can write tests that will be headless and be driven by a tool like Jenkins.   

##### Requirements for tests
In order for the tests to run, the WebDriver for a given browser is required.   Download the driver of your choice and copy the driver into the root of the project.
* geckdriver - https://github.com/mozilla/geckodriver/releases
* chromedriver - https://sites.google.com/a/chromium.org/chromedriver/downloads

webdriver.ie.driver

webdriver.chrome.driver

webdriver.gecko.driver


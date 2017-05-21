package navigation.webdrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by matias on 21/05/17.
 */
public class WebDriverInitializer {
    private static boolean chromeDriverInitialized = false;
    private static boolean firefoxDriverInitialized = false;

    public static WebDriver getFirefoxDriver(){
        return new FirefoxDriver();
    }

    public static WebDriver getDefaultWebDriver(){
        return getFirefoxDriver();
    }
}

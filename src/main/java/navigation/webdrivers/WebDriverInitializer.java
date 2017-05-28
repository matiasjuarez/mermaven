package navigation.webdrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

/**
 * Created by matias on 21/05/17.
 */
public class WebDriverInitializer {
    private static boolean chromeDriverInitialized = false;
    private static boolean firefoxDriverInitialized = false;

    public static WebDriver getFirefoxDriver(){
        if(!firefoxDriverInitialized){
            File file = new File("/home/matias/Documents/Projects/mermaven/src/main/java/navigation/webdrivers/geckodriver");
            System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
            firefoxDriverInitialized = true;
        }

        return new FirefoxDriver();
    }

    public static WebDriver getDefaultWebDriver(){
        if(!chromeDriverInitialized){
            File file = new File("/home/matias/Documents/Projects/mermaven/src/main/java/navigation/webdrivers/chromedriver");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            chromeDriverInitialized = true;
        }
        return getFirefoxDriver();
    }
}

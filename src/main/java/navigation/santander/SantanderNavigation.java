package navigation.santander;

import navigation.webdrivers.WebDriverInitializer;
import org.openqa.selenium.WebDriver;

/**
 * Created by matias on 21/05/17.
 */
public class SantanderNavigation {
    private WebDriver webDriver;
    private StartingPage startingPage;

    public SantanderNavigation(){
        webDriver = WebDriverInitializer.getDefaultWebDriver();
        startingPage = new StartingPage();
    }

    public void operate(){
        startingPage.operate(webDriver);
    }
}

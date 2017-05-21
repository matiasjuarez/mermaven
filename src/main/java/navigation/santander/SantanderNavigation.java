package navigation.santander;

import navigation.webdrivers.WebDriverInitializer;
import org.openqa.selenium.WebDriver;
import utilidades.NavigationUtils;

import java.util.ArrayList;

/**
 * Created by matias on 21/05/17.
 */
public class SantanderNavigation {
    private WebDriver webDriver;
    private StartingPage startingPage;
    private LoginPage loginPage;
    private ClienteAccountPage clienteAccountPage;
    private ArrayList<String> windowHandlers;

    public SantanderNavigation(){
        webDriver = WebDriverInitializer.getDefaultWebDriver();
        startingPage = new StartingPage();
        loginPage = new LoginPage();
        clienteAccountPage = new ClienteAccountPage();
    }

    public void operate(){
        startingPage.operate(webDriver);

        NavigationUtils.delay(10);
        windowHandlers = NavigationUtils.getWindowsHandlers(webDriver);
        webDriver.switchTo().window(windowHandlers.get(1));

        loginPage.operate(webDriver);

        NavigationUtils.delay(10);

        clienteAccountPage.operate(webDriver);
    }
}

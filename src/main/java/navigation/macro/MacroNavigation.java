package navigation.macro;

import configuracion.Configuration;
import navigation.webdrivers.WebDriverInitializer;
import org.openqa.selenium.WebDriver;
import utilidades.NavigationUtils;

import java.util.ArrayList;

/**
 * Created by matias on 21/05/17.
 */
public class MacroNavigation {
    private WebDriver webDriver;
    private LoginPage loginPage;
    private ClienteAccountPage clienteAccountPage;
    private ArrayList<String> windowHandlers;

    public MacroNavigation(){
        webDriver = WebDriverInitializer.getDefaultWebDriver();
        loginPage = new LoginPage(Configuration.getInstance().getPathToUserDataMac());
        clienteAccountPage = new ClienteAccountPage();
    }

    public void operate(){
        loginPage.operate(webDriver);

        NavigationUtils.delay(10);
        webDriver.switchTo().defaultContent();

        clienteAccountPage.operate(webDriver);
    }
}

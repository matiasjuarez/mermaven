package matias.navigation.santander;

import matias.configuracion.Configuration;
import matias.navigation.santander.pages.ClientAccountPage;
import matias.navigation.santander.pages.StartingPage;
import matias.navigation.webdrivers.WebDriverInitializer;
import org.openqa.selenium.WebDriver;
import matias.navigation.NavigationUtils;

/**
 * Created by matias on 21/05/17.
 */
public class SantanderNavigation {
    private WebDriver webDriver;
    private NavigationStatus status;
    private LoginManager loginManager;
    private ClientAccountPage clientAccountPage;

    public SantanderNavigation(){
        webDriver = WebDriverInitializer.getDefaultWebDriver();
        loginManager = new LoginManager(Configuration.getInstance().getPathToUserDataSan());
        status = new NavigationStatus();
        clientAccountPage = new ClientAccountPage();
    }

    public void goToTenencias(){
        if(status.getCurrent_page() != NavigationStatus.CURRENT_PAGE.CLIENTE_ACCOUNT_PAGE){
            goToClientAccountPage();
        }

        clientAccountPage.goToTenencias(webDriver);
    }

    public void goToCotizaciones(){
        if(status.getCurrent_page() != NavigationStatus.CURRENT_PAGE.CLIENTE_ACCOUNT_PAGE){
            goToClientAccountPage();
        }

        clientAccountPage.goToCotizaciones(webDriver);
    }

    public void goToStartingPage(){
        StartingPage.goToStartingPage(webDriver);

        if(NavigationUtils.waitForPageLoad(webDriver, 15)){
            status.setCurrent_page(NavigationStatus.CURRENT_PAGE.STARTING_PAGE);
        }
    }

    public void goToLoginPage(){
        goToStartingPage();

        if(status.getCurrent_page() != NavigationStatus.CURRENT_PAGE.STARTING_PAGE){
            return;
        }

        StartingPage.goToLoginPage(webDriver);
        NavigationUtils.delay(5);
        NavigationUtils.changeFocusToLastOpenedWindow(webDriver);

        if(NavigationUtils.waitForPageLoad(webDriver, 15)){
            status.setCurrent_page(NavigationStatus.CURRENT_PAGE.LOGIN_PAGE);
        }
    }

    public void goToClientAccountPage(){
        goToLoginPage();

        if(status.getCurrent_page() != NavigationStatus.CURRENT_PAGE.LOGIN_PAGE){
            return;
        }

        loginManager.logIn(webDriver);

        if(NavigationUtils.waitForPageLoad(webDriver, 15)){
            status.setCurrent_page(NavigationStatus.CURRENT_PAGE.CLIENTE_ACCOUNT_PAGE);
            status.setLogged(true);
        }
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}

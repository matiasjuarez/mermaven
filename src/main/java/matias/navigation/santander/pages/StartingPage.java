package matias.navigation.santander.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import matias.navigation.NavigationUtils;

/**
 * Created by matias on 21/05/17.
 */
public class StartingPage {
    private static final String pageURL = "https://www.santanderrio.com.ar/banco/online/personas";
    private static final String LOC_BTN_INGRESAR = "//*[@id=\"banner_area\"]/div/div[2]/div/a";

    public static void goToLoginPage(WebDriver webDriver){
        WebElement btnIngresar = NavigationUtils.waitForElement(webDriver, LOC_BTN_INGRESAR, 10);
        btnIngresar.click();
    }

    public static void goToStartingPage(WebDriver webDriver){
        webDriver.navigate().to(pageURL);
    }
}

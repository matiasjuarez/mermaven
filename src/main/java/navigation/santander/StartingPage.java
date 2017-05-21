package navigation.santander;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilidades.NavigationUtils;

/**
 * Created by matias on 21/05/17.
 */
public class StartingPage {
    private final String startingURL = "https://www.santanderrio.com.ar/banco/online/personas";
    private final String LOC_BTN_INGRESAR = "//*[@id=\"banner_area\"]/div/div[2]/div/a";

    public void operate(WebDriver webDriver){
        webDriver.navigate().to(startingURL);
        WebElement btnIngresar = NavigationUtils.waitForElement(webDriver, LOC_BTN_INGRESAR, 10);
        btnIngresar.click();
    }
}

package navigation.santander;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilidades.NavigationUtils;

/**
 * Created by matias on 21/05/17.
 */
public class StartingPage {
    private final String LOC_BTN_INGRESAR = "//*[@id=\"banner_area\"]/div/div[2]/div/a";

    public void operate(WebDriver webDriver){
        WebElement btnIngresar = NavigationUtils.waitForElement(webDriver, LOC_BTN_INGRESAR, 10);
        btnIngresar.click();
    }
}

package navigation.macro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilidades.NavigationUtils;

/**
 * Created by matias on 21/05/17.
 */
public class ClienteAccountPage {
    private final String LOC_FRM_MENU = "/html/frameset/frameset/frameset/frameset/frame[2]";
    private final String LOC_LNK_MENU_INVERSIONES = "//*[@id=\"mainLayer\"]/table[5]/tbody/tr/td/div/span/table/tbody/tr/td[1]/a";
    private final String LOC_LNK_MENU_SUSCRIPCION_RESCATE = "//*[@id='menu5']/table/tbody/tr/td/div/span/table/tbody/tr/td[1]/a";

    private final String LOC_FRM_MAIN_CONTENT = "/html/frameset/frameset/frameset/frame";
    private final String LOC_LNK_SUSCRIPCION_RESCATE_OPERATE = "/html/body/form/center/table/tbody/tr[2]/td/center/center[7]/table/tbody/tr[1]/td[1]/a";

    private int timeout = 10;

    public void operate(WebDriver webDriver){
        clickInversiones(webDriver);

        NavigationUtils.delay(5);
        webDriver.switchTo().defaultContent();

        clickFondos(webDriver);
    }

    public void clickInversiones(WebDriver webDriver){
        NavigationUtils.changeToFrame(webDriver, LOC_FRM_MENU, timeout);

        WebElement lnkInversiones =
                NavigationUtils.waitForElement(webDriver, LOC_LNK_MENU_INVERSIONES, timeout);
        lnkInversiones.click();

        WebElement lnkSuscripcionRescate =
                NavigationUtils.waitForElement(webDriver, LOC_LNK_MENU_SUSCRIPCION_RESCATE, timeout);
        lnkSuscripcionRescate.click();
    }

    public void clickFondos(WebDriver webDriver){
        NavigationUtils.changeToFrame(webDriver, LOC_FRM_MAIN_CONTENT, timeout);

        WebElement lnkFondos = NavigationUtils.waitForElement(webDriver, LOC_LNK_SUSCRIPCION_RESCATE_OPERATE, timeout);
        lnkFondos.click();
    }
}

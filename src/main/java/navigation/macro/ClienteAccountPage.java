package navigation.macro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilidades.NavigationUtils;

/**
 * Created by matias on 21/05/17.
 */
public class ClienteAccountPage {
    private final String LOC_FRM_INVERSIONES = "//*[@id=\"framePrincipal\"]/frame";
    private final String LOC_LNK_INVERSIONES = "//*[@id=\"inversiones\"]";

    private final String LOC_FRM_EXTERNAL_FONDOS = "//*[@id=\"frame2\"]";
    private final String LOC_FRM_INTERNAL_FONDOS = "/html/frameset/frame[1]";
    private final String LOC_LNK_FONDOS = "//*[@id=\"fondos_2\"]";

    private final String LOC_FRM_INTERNAL_COTIZACIONES_TENENCIAS = "/html/frameset/frame[2]";
    private final String LOC_LNK_COTIZACIONES = "//*[@id=\"cotizaciones_3\"]";
    private final String LOC_LNK_TENENCIAS = "//*[@id=\"tenencia_1\"]";


    private int timeout = 10;

    public void operate(WebDriver webDriver){
        clickInversiones(webDriver);

        webDriver.switchTo().defaultContent();
        NavigationUtils.delay(5);

        clickFondos(webDriver);

        webDriver.switchTo().defaultContent();
        NavigationUtils.delay(5);

        clickCotizaciones(webDriver);

        webDriver.switchTo().defaultContent();
        NavigationUtils.delay(5);

        clickTenencias(webDriver);
    }

    public void clickInversiones(WebDriver webDriver){
        changeFrame(webDriver, LOC_FRM_INVERSIONES);

        WebElement lnkInversiones = NavigationUtils.waitForElement(webDriver, LOC_LNK_INVERSIONES, timeout);
        lnkInversiones.click();
    }

    public void clickFondos(WebDriver webDriver){
        changeFrame(webDriver, LOC_FRM_EXTERNAL_FONDOS);
        changeFrame(webDriver, LOC_FRM_INTERNAL_FONDOS);

        WebElement lnkFondos = NavigationUtils.waitForElement(webDriver, LOC_LNK_FONDOS, timeout);
        lnkFondos.click();
    }

    private void clickCotizaciones(WebDriver webDriver){
        changeFrame(webDriver, LOC_FRM_EXTERNAL_FONDOS);
        changeFrame(webDriver, LOC_FRM_INTERNAL_COTIZACIONES_TENENCIAS);

        WebElement lnkCotizaciones = NavigationUtils.waitForElement(webDriver, LOC_LNK_COTIZACIONES, timeout);
        lnkCotizaciones.click();
    }

    private void clickTenencias(WebDriver webDriver){
        changeFrame(webDriver, LOC_FRM_EXTERNAL_FONDOS);
        changeFrame(webDriver, LOC_FRM_INTERNAL_COTIZACIONES_TENENCIAS);

        WebElement lnkTenencias = NavigationUtils.waitForElement(webDriver, LOC_LNK_TENENCIAS, timeout);
        lnkTenencias.click();
    }

    private void changeFrame(WebDriver webDriver, String frameXpath){
        webDriver.switchTo().frame(
                NavigationUtils.waitForElement(webDriver, frameXpath, timeout)
        );
    }
}

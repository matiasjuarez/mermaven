package navigation.santander;

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
        NavigationUtils.changeFrame(webDriver, LOC_FRM_INVERSIONES, timeout);

        WebElement lnkInversiones = NavigationUtils.waitForElement(webDriver, LOC_LNK_INVERSIONES, timeout);
        lnkInversiones.click();
    }

    public void clickFondos(WebDriver webDriver){
        NavigationUtils.changeFrame(webDriver, LOC_FRM_EXTERNAL_FONDOS, timeout);
        NavigationUtils.changeFrame(webDriver, LOC_FRM_INTERNAL_FONDOS, timeout);

        WebElement lnkFondos = NavigationUtils.waitForElement(webDriver, LOC_LNK_FONDOS, timeout);
        lnkFondos.click();
    }

    private void clickCotizaciones(WebDriver webDriver){
        navigateToFrameInternalCotizacionesTenencias(webDriver);

        WebElement lnkCotizaciones = NavigationUtils.waitForElement(webDriver, LOC_LNK_COTIZACIONES, timeout);
        lnkCotizaciones.click();
    }

    private void clickTenencias(WebDriver webDriver){
        navigateToFrameInternalCotizacionesTenencias(webDriver);

        WebElement lnkTenencias = NavigationUtils.waitForElement(webDriver, LOC_LNK_TENENCIAS, timeout);
        lnkTenencias.click();
    }

    private void navigateToFrameInternalCotizacionesTenencias(WebDriver webDriver){
        NavigationUtils.changeFrame(webDriver, LOC_FRM_EXTERNAL_FONDOS, timeout);
        NavigationUtils.changeFrame(webDriver, LOC_FRM_INTERNAL_COTIZACIONES_TENENCIAS, timeout);
    }
}

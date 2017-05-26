package navigation.santander.pages;

import IO.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilidades.NavigationUtils;

/**
 * Created by matias on 25/05/17.
 */
public class ClientAccountPage {
    private static final String LOC_FRM_INVERSIONES = "//*[@id=\"framePrincipal\"]/frame";
    private static final String LOC_LNK_INVERSIONES = "//*[@id=\"inversiones\"]";

    private static final String LOC_FRM_EXTERNAL_FONDOS = "//*[@id=\"frame2\"]";
    private static final String LOC_FRM_INTERNAL_FONDOS = "/html/frameset/frame[1]";
    private static final String LOC_LNK_FONDOS = "//*[@id=\"fondos_2\"]";

    private static final String LOC_FRM_INTERNAL_COTIZACIONES_TENENCIAS = "/html/frameset/frame[2]";
    private static final String LOC_LNK_COTIZACIONES = "//*[@id=\"cotizaciones_3\"]";
    private static final String LOC_LNK_TENENCIAS = "//*[@id=\"tenencia_1\"]";

    private static final String LOC_DIV_ERROR_MESSAGE = "//*[@id=\"indiMsjErrorPage\"]";
    private static final String LOC_P_ERROR_MESSAGE_CONTENT_RELATIVE = "/div/p";

    private static int timeout = 10;

    public static void goToTenencias(WebDriver webDriver){
        clickInversiones(webDriver);
        clickFondos(webDriver);
        clickTenencias(webDriver);
    }

    public static void goToCotizaciones(WebDriver webDriver){
        clickInversiones(webDriver);
        clickFondos(webDriver);
        clickCotizaciones(webDriver);

        if(isErrorMessagePresent(webDriver)){
            Logger.getInstance().log(getErrorMessage(webDriver));
        }
    }

    public static boolean isErrorMessagePresent(WebDriver webDriver){
        try{
            getErrorMessageElement(webDriver);
            return true;
        }
        catch(TimeoutException te){
            return false;
        }
    }

    private static WebElement getErrorMessageElement(WebDriver webDriver){
        return NavigationUtils.waitForElement(webDriver, LOC_DIV_ERROR_MESSAGE, 5);
    }

    private static String getErrorMessage(WebDriver webDriver){
        WebElement divElement = getErrorMessageElement(webDriver);
        WebElement pElement = divElement.findElement(By.xpath(LOC_P_ERROR_MESSAGE_CONTENT_RELATIVE));

        return pElement.getText();
    }

    private static void clickInversiones(WebDriver webDriver){
        NavigationUtils.changeFrame(webDriver, LOC_FRM_INVERSIONES, timeout);

        WebElement lnkInversiones = NavigationUtils.waitForElement(webDriver, LOC_LNK_INVERSIONES, timeout);
        lnkInversiones.click();
    }

    private static void clickFondos(WebDriver webDriver){
        webDriver.switchTo().defaultContent();

        NavigationUtils.changeFrame(webDriver, LOC_FRM_EXTERNAL_FONDOS, timeout);
        NavigationUtils.changeFrame(webDriver, LOC_FRM_INTERNAL_FONDOS, timeout);

        WebElement lnkFondos = NavigationUtils.waitForElement(webDriver, LOC_LNK_FONDOS, timeout);
        lnkFondos.click();
    }

    private static void clickCotizaciones(WebDriver webDriver){
        navigateToFrameInternalCotizacionesTenencias(webDriver);

        WebElement lnkCotizaciones = NavigationUtils.waitForElement(webDriver, LOC_LNK_COTIZACIONES, timeout);
        lnkCotizaciones.click();
    }

    private static void clickTenencias(WebDriver webDriver){
        navigateToFrameInternalCotizacionesTenencias(webDriver);

        WebElement lnkTenencias = NavigationUtils.waitForElement(webDriver, LOC_LNK_TENENCIAS, timeout);
        lnkTenencias.click();
    }

    private static void navigateToFrameInternalCotizacionesTenencias(WebDriver webDriver){
        webDriver.switchTo().defaultContent();
        NavigationUtils.changeFrame(webDriver, LOC_FRM_EXTERNAL_FONDOS, timeout);
        NavigationUtils.changeFrame(webDriver, LOC_FRM_INTERNAL_COTIZACIONES_TENENCIAS, timeout);
    }
}

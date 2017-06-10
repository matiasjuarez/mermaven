package navigation.santander.pages;

import IO.Logger;
import navigation.Frame;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import navigation.NavigationUtils;

/**
 * Created by matias on 25/05/17.
 */
public class ClientAccountPage {

    private Frame first_menu;
    private Frame second_menu;
    private Frame third_menu;
    private Frame info_menu;

    private final String firstMenuName = "FIRST_MENU";
    private final String secondMenuName = "SECOND_MENU";
    private final String thirdMenuName = "THIRD_MENU";
    private final String infoMenuName = "INFO_MENU";
    private final String secondLevelContainerName = "SECOND_LEVEL_CONTAINER";

    private final String LOC_FRM_FIRST_MENU = "//*[@id=\"framePrincipal\"]/frame";
    private final String LOC_FRM_SECOND_MENU = "/html/frameset/frame[1]";
    private final String LOC_FRM_THIRD_MENU = "/html/frameset/frame[2]";
    private final String LOC_FRM_INFO = "/html/frameset/frame[3]";
    private final String LOC_FRM_SECOND_LEVEL_CONTAINER = "//*[@id=\"frame2\"]";

    private final String LOC_LNK_INVERSIONES_1 = "//*[@id=\"inversiones\"]";
    private final String LOC_LNK_FONDOS_2 = "//*[@id=\"fondos_2\"]";
    private final String LOC_LNK_COTIZACIONES_3 = "//*[@id=\"cotizaciones_3\"]";
    private final String LOC_LNK_TENENCIAS_3 = "//*[@id=\"tenencia_1\"]";

    private final String LOC_DIV_ERROR_MESSAGE = "//*[@id=\"indiMsjErrorPage\"]";
    private final String LOC_P_ERROR_MESSAGE_CONTENT_RELATIVE = "/div/p";

    private int timeout = 10;

    public ClientAccountPage(){
        first_menu = new Frame(firstMenuName, LOC_FRM_FIRST_MENU);
        second_menu = new Frame(secondMenuName, LOC_FRM_SECOND_MENU);
        third_menu = new Frame(thirdMenuName, LOC_FRM_THIRD_MENU);
        info_menu = new Frame(infoMenuName, LOC_FRM_INFO);

        Frame secondLevelContainer = new Frame(secondLevelContainerName, LOC_FRM_SECOND_LEVEL_CONTAINER);
        second_menu.setParent(secondLevelContainer);
        third_menu.setParent(secondLevelContainer);
        info_menu.setParent(secondLevelContainer);
    }

    private void clickInversiones(WebDriver webDriver){
        NavigationUtils.goToFrameThroughParents(first_menu, webDriver, timeout);

        WebElement lnkInversiones = NavigationUtils.waitForElement(webDriver, LOC_LNK_INVERSIONES_1, timeout);
        lnkInversiones.click();
    }

    private void clickFondos(WebDriver webDriver){
        NavigationUtils.goToFrameThroughParents(second_menu, webDriver, timeout);

        WebElement lnkFondos = NavigationUtils.waitForElement(webDriver, LOC_LNK_FONDOS_2, timeout);
        lnkFondos.click();
    }

    private void clickCotizaciones(WebDriver webDriver){
        NavigationUtils.goToFrameThroughParents(third_menu, webDriver, timeout);

        WebElement lnkCotizaciones = NavigationUtils.waitForElement(webDriver, LOC_LNK_COTIZACIONES_3, timeout);
        lnkCotizaciones.click();
    }

    private void clickTenencias(WebDriver webDriver){
        NavigationUtils.goToFrameThroughParents(third_menu, webDriver, timeout);

        WebElement lnkTenencias = NavigationUtils.waitForElement(webDriver, LOC_LNK_TENENCIAS_3, timeout);
        lnkTenencias.click();
    }

    public void goToTenencias(WebDriver webDriver){
        clickInversiones(webDriver);
        clickFondos(webDriver);
        clickTenencias(webDriver);

        NavigationUtils.goToFrameThroughParents(info_menu, webDriver, timeout);

        if(isErrorMessagePresent(webDriver)){
            Logger.getInstance().log(getErrorMessage(webDriver));
        }
    }

    public void goToCotizaciones(WebDriver webDriver){
        clickInversiones(webDriver);
        clickFondos(webDriver);
        clickCotizaciones(webDriver);

        NavigationUtils.goToFrameThroughParents(info_menu, webDriver, timeout);

        if(isErrorMessagePresent(webDriver)){
            Logger.getInstance().log(getErrorMessage(webDriver));
        }
    }

    public boolean isErrorMessagePresent(WebDriver webDriver){
        try{
            getErrorMessageElement(webDriver);
            return true;
        }
        catch(TimeoutException te){
            return false;
        }
    }

    private WebElement getErrorMessageElement(WebDriver webDriver){
        return NavigationUtils.waitForElement(webDriver, LOC_DIV_ERROR_MESSAGE, 5);
    }

    private String getErrorMessage(WebDriver webDriver){
        WebElement divElement = getErrorMessageElement(webDriver);
        WebElement pElement = divElement.findElement(By.xpath(LOC_P_ERROR_MESSAGE_CONTENT_RELATIVE));

        return pElement.getText();
    }
}

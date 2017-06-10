package navigation.santander.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import navigation.NavigationUtils;

/**
 * Created by matias on 21/05/17.
 */
public class LoginPage {
    private static final String LOC_TXT_DNI = "//*[@id=\"dni\"]";
    private static final String LOC_TXT_CLAVE = "//*[@id=\"clave\"]";
    private static final String LOC_TXT_USUARIO = "//*[@id=\"usuario\"]";
    private static final String LOC_BTN_INGRESAR = "//*[@id=\"btn1\"]";

    private static final int timeout = 10;

    public static void fillDNI(String dni, WebDriver driver){
        WebElement txtDni = NavigationUtils.waitForElement(driver, LOC_TXT_DNI, timeout);
        txtDni.sendKeys(dni);
    }

    public static void fillUser(String user, WebDriver driver){
        WebElement txtUsuario = NavigationUtils.waitForElement(driver, LOC_TXT_USUARIO, timeout);
        txtUsuario.sendKeys(user);
    }

    public static void fillPassword(String password, WebDriver driver){
        WebElement txtPassword = NavigationUtils.waitForElement(driver, LOC_TXT_CLAVE, timeout);
        txtPassword.sendKeys(password);
    }

    public static void clickIngresarButton(WebDriver driver){
        WebElement btnIngresar = NavigationUtils.waitForElement(driver, LOC_BTN_INGRESAR, timeout);
        btnIngresar.click();
    }
}

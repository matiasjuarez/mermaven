package navigation.santander;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilidades.NavigationUtils;

/**
 * Created by matias on 21/05/17.
 */
public class LoginPage {
    private final String LOC_TXT_DNI = "//*[@id=\"dni\"]";
    private final String LOC_TXT_CLAVE = "//*[@id=\"clave\"]";
    private final String LOC_TXT_USUARIO = "//*[@id=\"usuario\"]";
    private final String LOC_BTN_INGRESAR = "//*[@id=\"btn1\"]";

    private String dni = "dni";
    private String clave = "clave";
    private String usuario = "usuario";
    private int timeout = 10;

    public void operate(WebDriver webDriver){
        WebElement txtDni = NavigationUtils.waitForElement(webDriver, LOC_TXT_DNI, timeout);
        WebElement txtClave = NavigationUtils.waitForElement(webDriver, LOC_TXT_CLAVE, timeout);
        WebElement txtUsuario = NavigationUtils.waitForElement(webDriver, LOC_TXT_USUARIO, timeout);
        WebElement btnIngresar = NavigationUtils.waitForElement(webDriver, LOC_BTN_INGRESAR, timeout);

        txtDni.sendKeys(dni);
        txtClave.sendKeys(clave);
        txtUsuario.sendKeys(clave);
        btnIngresar.click();
    }
}

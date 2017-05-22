package navigation.macro;

import navigation.UserDataReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilidades.NavigationUtils;

/**
 * Created by matias on 21/05/17.
 */
public class LoginPage {
    private final String url = "https://macronline.com.ar/";

    private final String LOC_FRM_FRAME = "/html/body/iframe";
    private final String LOC_SEL_DNI_TYPE = "//*[@id=\"ddmtdoc\"]";
    private final String LOC_TXT_DNI = "//*[@id=\"txtLogin\"]";
    private final String LOC_TXT_CLAVE = "//*[@id=\"txtPassword\"]";
    private final String LOC_TXT_USUARIO = "//*[@id=\"txtUsuario\"]";
    private final String LOC_BTN_INGRESAR = "//*[@id=\"loginBlock\"]/table[1]/tbody/tr[7]/td[2]/a";

    private String dni = "dni";
    private String clave = "pass";
    private String usuario = "user";
    private int timeout = 10;

    public LoginPage(String userDataURL){
        UserDataReader dataReader = new UserDataReader(userDataURL);
        dni = dataReader.getDni();
        clave = dataReader.getPass();
        usuario = dataReader.getUser();
    }

    public void operate(WebDriver webDriver){
        webDriver.navigate().to(url);
        webDriver.switchTo().frame(NavigationUtils.waitForElement(webDriver, LOC_FRM_FRAME, timeout));

        WebElement selectDniType = NavigationUtils.waitForElement(webDriver, LOC_SEL_DNI_TYPE, timeout);
        WebElement txtDni = NavigationUtils.waitForElement(webDriver, LOC_TXT_DNI, timeout);
        WebElement txtClave = NavigationUtils.waitForElement(webDriver, LOC_TXT_CLAVE, timeout);
        WebElement txtUsuario = NavigationUtils.waitForElement(webDriver, LOC_TXT_USUARIO, timeout);
        WebElement btnIngresar = NavigationUtils.waitForElement(webDriver, LOC_BTN_INGRESAR, timeout);

        Select selectElement = new Select(selectDniType);
        selectElement.selectByValue("01");

        txtDni.sendKeys(dni);
        txtClave.sendKeys(clave);
        txtUsuario.sendKeys(usuario);
        btnIngresar.click();
    }
}

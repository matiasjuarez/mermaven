package navigation.santander;

import navigation.UserDataReader;
import navigation.santander.pages.LoginPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by matias on 25/05/17.
 */
public class LoginManager {
    private String dni;
    private String user;
    private String password;

    public LoginManager(String userDataURL){
        UserDataReader dataReader = new UserDataReader(userDataURL);
        this.dni = dataReader.getDni();
        this.password = dataReader.getPass();
        this.user = dataReader.getUser();
    }

    public boolean logIn(WebDriver driver){
        LoginPage.fillDNI(dni, driver);
        LoginPage.fillPassword(password, driver);
        LoginPage.fillUser(user, driver);
        LoginPage.clickIngresarButton(driver);

        return true;
    }
}

package utilidades;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by matias on 21/05/17.
 */
public class NavigationUtils {
    public static void delay(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebElement waitForElement(WebDriver driver, String xpath, int seconds){
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public static ArrayList<String> getWindowsHandlers(WebDriver driver){
        ArrayList<String> windowsHandlers = new ArrayList<>();

        for(String winHandle : driver.getWindowHandles()){
            windowsHandlers.add(winHandle);
        }

        return windowsHandlers;
    }
}

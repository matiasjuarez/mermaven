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

    /**
     * Generates a delay in the execution of the program.
     * @param seconds - How much should the delay last in seconds
     */
    public static void delay(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Waits for a WebElement until it's present in the page
     * @param driver - The webDriver that we use to navigate
     * @param xpath - The path to the web element
     * @param seconds - The timeout in seconds
     * @return a WebElement
     */
    public static WebElement waitForElement(WebDriver driver, String xpath, int seconds){
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    /**
     * Retrieves the windowHandles that are being used by the driver.
     * @param driver - The driver that's being used to navigate
     * @return an ArrayList with the windowHandles
     */
    public static ArrayList<String> getWindowsHandlers(WebDriver driver){
        ArrayList<String> windowsHandlers = new ArrayList<>();

        for(String winHandle : driver.getWindowHandles()){
            windowsHandlers.add(winHandle);
        }

        return windowsHandlers;
    }

    /**
     * Changes the focus to a new frame.
     * @param webDriver - The webDriver that's being used to navigate
     * @param frameXpath - The xPath to the frame
     * @param seconds - The timeout in seconds
     */
    public static void changeFrame(WebDriver webDriver, String frameXpath, int seconds){
        webDriver.switchTo().frame(
                waitForElement(webDriver, frameXpath, seconds)
        );
    }
}

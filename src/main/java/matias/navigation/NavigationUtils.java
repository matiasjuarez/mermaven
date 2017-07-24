package matias.navigation;

import matias.IO.Logger;
import org.openqa.selenium.*;
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

    public static void changeFocusToLastOpenedWindow(WebDriver driver){
        ArrayList<String> windowsHandlers = getWindowsHandlers(driver);

        driver.switchTo().window(windowsHandlers.get(windowsHandlers.size() - 1));
    }

    /**
     * Changes the focus to a new frame.
     * @param webDriver - The webDriver that's being used to navigate
     * @param frameXpath - The xPath to the frame
     * @param seconds - The timeout in seconds
     */
    public static void changeToFrame(WebDriver webDriver, String frameXpath, int seconds){
        webDriver.switchTo().frame(
                waitForElement(webDriver, frameXpath, seconds)
        );
    }

    public static void changeToFrame(WebDriver webDriver, Frame frame, int timeoutInSeconds){
        changeToFrame(webDriver, frame.getXpath(), timeoutInSeconds);
    }

    /**
     * This methods tries to get to the frame sent as parameter going through the chain of
     * parent frames.
     * @param frame - The frame we want to go to
     * @param driver - The WebDriver
     * @param timeoutInSeconds - Time to wait for each frame to be ready
     */
    public static void goToFrameThroughParents(Frame frame, WebDriver driver, int timeoutInSeconds){
        driver.switchTo().defaultContent();

        ArrayList<Frame> parents = frame.getAllAscendants();
        for(Frame parentFrame : parents){
            changeToFrame(driver, parentFrame, timeoutInSeconds);
        }

        changeToFrame(driver, frame, timeoutInSeconds);
    }

    /**
     * Waits for a webpage finishes its loading.
     * @param driver
     * @param timeOutInSeconds
     */
    public static boolean waitForPageLoad(WebDriver driver, int timeOutInSeconds) {
        try{
            new WebDriverWait(driver, timeOutInSeconds).until((ExpectedCondition<Boolean>) wd ->
                    ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));

            return true;
        }
        catch(TimeoutException te){
            Logger.getInstance().info("The page didn't load in time: " + driver.getCurrentUrl());

            return false;
        }
    }
}

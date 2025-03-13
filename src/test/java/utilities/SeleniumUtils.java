package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class SeleniumUtils {
    public static void switchToNewTab(WebDriver driver, WebElement element) {
        String mainWindow = driver.getWindowHandle();
        element.click();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        System.out.println("Currently the driver is on " + driver.getCurrentUrl());
    }

    public static void click(WebDriver driver, WebElement element) {
        FluentWait wait = new FluentWait(driver)
                .ignoring(ElementClickInterceptedException.class)
                .withTimeout(Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void acceptAlerts(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.alertIsPresent());

        try {
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
            System.out.println("Alert doesnt exist");
            e.printStackTrace();
        }
    }

    public static void dismissAlerts(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.alertIsPresent());

        try {
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException e) {
            System.out.println("Alert doesnt exist");
            e.printStackTrace();
        }
    }

    /**
     * @param driver
     * @param locator
     * @return
     */
    public static boolean isElementPresent(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void clickWithRetries(WebDriver driver, By locator, int retries) throws InterruptedException {
        int numOfTrials = 0;
        while (numOfTrials < retries) {
            try {
                WebElement element = driver.findElement(locator);
                element.click();
                return;
            } catch (StaleElementReferenceException e) {
                numOfTrials++;
                waitForSec(1);
            }catch(NoSuchElementException e){
                System.out.println("Wrong locator!");
                e.printStackTrace();
                return;
            }
        }
    }
    public static void waitForSec(int numOfSec){
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
        }
    }

}

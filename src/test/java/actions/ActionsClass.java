package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
@Test
public class ActionsClass {
    public void clickAndHoldPractice() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/droppable");

        Thread.sleep(3000);
        try {

            WebElement acceptCookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
            acceptCookies.click();
        } catch (NoSuchElementException e) {
            e.getStackTrace();
        }

        Actions actions = new Actions(driver);
        actions.scrollByAmount(300, 300).perform();

        WebElement acceptButton = driver.findElement(By.cssSelector("#droppableExample-tab-accept"));
        acceptButton.click();

        WebElement dropHere = driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        WebElement notAccept = driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='notAcceptable']"));

        actions.clickAndHold(notAccept).moveToElement(dropHere).release().perform();

        String actualMessageForNotAccess = dropHere.getText();
        String expectedMessageForNotAccess = "Drop here";
        Assert.assertEquals(actualMessageForNotAccess,expectedMessageForNotAccess);

        WebElement accept = driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='acceptable']"));

        actions.clickAndHold(accept).moveToElement(dropHere).release().perform();

        String actualMessageAfterAccept = dropHere.getText();
        String expectedMessageAfterAccept = "Dropped!";
        Assert.assertEquals(actualMessageAfterAccept,expectedMessageAfterAccept);
    }
}

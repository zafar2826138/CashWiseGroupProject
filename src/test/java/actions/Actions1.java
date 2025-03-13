package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

import java.time.Duration;

public class Actions1 {
    @Test
    public void clickAndHold() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        Thread.sleep(3000);

        try {
            WebElement acceptCookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
            acceptCookies.click();
        } catch (NoSuchElementException e) {
            e.getStackTrace();
        }

        Actions actions = new Actions(driver);
        actions.scrollByAmount(300, 300).perform();

        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement blueBox = driver.findElement(By.xpath("//div[@class='test1']"));

        actions.clickAndHold(draggable).moveToElement(blueBox).release().perform();
        blueBox = driver.findElement(By.xpath("//div[@class='test1']"));

        String actualMessage = BrowserUtils.getText(blueBox);
        String expectedMessage = "You did great!";
        Assert.assertEquals(actualMessage, expectedMessage);

    }
}

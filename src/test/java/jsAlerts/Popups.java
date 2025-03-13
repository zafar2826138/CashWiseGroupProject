package jsAlerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

import java.time.Duration;
@Test
public class Popups {
    public void HTMLJSPopUp(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://sweetalert.js.org/");

        WebElement firstButton = driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        BrowserUtils.scrollWithJS(driver, firstButton);
        BrowserUtils.clickWithJS(driver,firstButton);

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Assert.assertEquals(alert.getText(),"Oops, something went wrong!");

        alert.accept();

        WebElement secondButton = driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        BrowserUtils.scrollWithJS(driver, secondButton);

        BrowserUtils.clickWithJS(driver, secondButton);
        WebElement message = driver.findElement(By.xpath("//div[@class='swal-text']"));
        System.out.println(BrowserUtils.getText(message));

        WebElement okButton = driver.findElement(By.xpath("//*[contains(text(),'OK')]"));
        BrowserUtils.clickWithJS(driver,okButton);

    }
}

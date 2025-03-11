package waitTimes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class ExplicitlyWait {
@Test
    public void practice(){
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
    WebElement startButton = driver.findElement(By.tagName("button"));
    startButton.click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement text = driver.findElement(By.xpath("//div[@id='finish']"));
    wait.until(ExpectedConditions.visibilityOf(text));
    Assert.assertEquals(BrowserUtils.getText(text), "Hello World!");
}
}

package javaScript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class ClickJS {
    @Test
    public void clickJS(){

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://codewise.academy/");

        WebElement watchVideo=driver.findElement(By.xpath("//a[.='Watch Presentation']"));
//        watchVideo.click();
        Actions actions=new Actions(driver);
//        actions.click(watchVideo).perform();

        JavascriptExecutor js= (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click()",watchVideo);

    }
}

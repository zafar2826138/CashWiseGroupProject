package javaScript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

import java.time.Duration;

public class Example1 {
    @Test
    public void scrollIntoView() throws InterruptedException {

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://codewise.academy/");

        WebElement header=driver.findElement(By.xpath("//div[contains(text(),'The Support You Need')]"));

        JavascriptExecutor js= (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true)",header);

        Thread.sleep(2000);
        WebElement message=driver.findElement(By.xpath("//div[contains(text(),'Start your')]"));

        js.executeScript("arguments[0].scrollIntoView(true)",message);
        BrowserUtils.scrollWithJS(driver, message);

    }
}

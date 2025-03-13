package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

import java.time.Duration;

public class Slider {
    @Test
    public void slider() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/horizontal_slider");

        WebElement slider=driver.findElement(By.xpath("//input"));
        WebElement range=driver.findElement(By.xpath("//span[@id='range']"));

        String expectedRange="2.5";

        while(!BrowserUtils.getText(range).equals(expectedRange)){
            slider.sendKeys(Keys.ARROW_RIGHT); // Keys.ENTER
            Thread.sleep(1000);
        }

        Assert.assertEquals(BrowserUtils.getText(range),expectedRange);

    }
}

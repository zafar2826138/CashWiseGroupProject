package windowHandle;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class example1 {
    @Test
    public void windowHandle() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://codewise.academy/')");
        js.executeScript("window.open('https://www.ebay.com/')");
        js.executeScript("window.open('https://www.etsy.com/')");
        Set<String> allPages = driver.getWindowHandles();

        for (String page : allPages) {
            driver.switchTo().window(page);
            if (driver.getTitle().contains("New Window")) {
                break;
            }
        }
    }
}


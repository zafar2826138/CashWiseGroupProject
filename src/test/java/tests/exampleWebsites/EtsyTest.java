package tests.exampleWebsites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EtsyTest {
    @Test(groups ={"login"})
    public void etsy1(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.etsy.com/");
    }
    @Test (groups ={"sanity"})
    public void etsy2(){
        System.out.println("This is Etsyyy!!");
    }
}

package tests.exampleWebsites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GoogleTest {
@Test(groups ={"login"})
    public void google1(){
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.google.com/");
}
@Test (groups ={"sanity"})
    public void google2(){
    System.out.println("This is google!");
}

}

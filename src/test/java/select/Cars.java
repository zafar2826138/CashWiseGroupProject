package select;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Cars {
    /*
  NOTE: Please use browser utils for the select classes if it is needed or getText.
  1-Navigate to the website https://www.cars.com/shopping/
  2-Choose the "New & certified" from the New/used option
  3-Choose "Lexus" for Make part
  4-Choose "RX-350"
  5-Validate the Price is selected "No max price"-->getFirstSelectedOption -->regular select
  6-Choose the distance 40 miles
  7-Put your Zip code-->Before that Clear it.60056 element.clear()
  8-Click Search Button
  9-Validate the header contains  "New and certified used Lexus RX 350 for sale"
  11-Validate the all titles has Lexus RX 350

  NOTE:If the cookies blocking you, please click Accept All Cookies button
  NOTE:If there is an advertisement, just refresh the page with automation
   */
    //TEST CASE: ValidateSearchFunctionality
    @Test
    public void cars(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.cars.com/shopping/");


        WebElement usedOrNew = driver.findElement(By.xpath("(//select[@class='sds-text-field'])[1]"));
        BrowserUtils.selectBy(usedOrNew,"New & certified", "text");
        WebElement make = driver.findElement(By.xpath("(//select[@class='sds-text-field'])[2]"));
        BrowserUtils.selectBy(make, "Lexus", "text");
        WebElement model = driver.findElement(By.xpath("(//select[@class='sds-text-field'])[3]"));
        BrowserUtils.selectBy(model, "RX 350","text");
        WebElement price = driver.findElement(By.xpath("(//select[@class='sds-text-field'])[4]"));
        Select carPrice = new Select(price);
        String actual = carPrice.getFirstSelectedOption().getText().trim();
        String expected = "No max price";
        Assert.assertEquals(actual, expected);
        WebElement milage = driver.findElement(By.xpath("(//select[@class='sds-text-field'])[5]"));
        BrowserUtils.selectBy(milage, "40", "value");
        WebElement zipCode = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipCode.clear();
        zipCode.sendKeys("60191", Keys.ENTER);
        WebElement header = driver.findElement(By.xpath("//h1[@class='spark-heading-1 sds-page-section__title']"));
        Assert.assertTrue(header.getText().trim().contains("New and certified used Lexus RX 350 for sale"));

        List<WebElement> allTitles = driver.findElements(By.xpath("//h2[@class='title']"));
        for(WebElement title: allTitles){
            Assert.assertTrue(title.getText().trim().contains("RX 350"));
        }

        WebElement sort = driver.findElement(By.xpath("//select[@data-activitykey='sort-dropdown']"));
        Select sorter = new Select(sort);
        sorter.selectByVisibleText("Lowest price");
        List<WebElement> prices = driver.findElements(By.xpath("//span[@class='primary-price']"));
        for (WebElement lexusPrice:prices){
            System.out.println(lexusPrice.getText().trim().replace("$", "").replace(",", "."));
        }















    }
}

package select;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

//public class Select {
//
//    @Test
//    public void selectPractice() throws InterruptedException {
         /*
1-Navigate to the website (https://demo.guru99.com/test/newtours/reservation.php)
2-Select one way trip button
3-Choose 4 passangers
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message from header which should be "After flight finder - No Seats Available" (you can use font_size=4)

 NOTE:Your test should fail
 NOTE2:You can use any select method value,visibleText
 nOTE3:send the bug picture directly to Ahmet
 */

//        WebDriver driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
//
//        WebElement oneWay=driver.findElement(By.xpath("//input[@value='oneway']"));
//        oneWay.click();
//
//        WebElement passengerBox=driver.findElement(By.xpath("//select[@name='passCount']"));
//        Select fromPort=new Select(passengerBox);
//        passenger.selectByVisibleText("4");
//        BrowserUtils.selectBy(passengerBox, "4", "text");
//
//        WebElement fromPortBox=driver.findElement(By.xpath("//select[@name='fromPort']"));
//
//        Select fromPort=new Select(fromPortBox);
//
//        String actualPort=fromPort.getFirstSelectedOption().getText().trim();
//        String expectedPort="Acapulco";
//        Assert.assertEquals(actualPort,expectedPort);
//
//        fromPort.selectByValue("Paris");
//
//        WebElement toMonthBox=driver.findElement(By.xpath("//select[@name='toMonth']"));
//
//        Select toMonth=new Select(toMonthBox);
//
//        toMonth.selectByIndex(7);
//        BrowserUtils.selectBy(toMonthBox,"7", "index");
//
//        WebElement airlineBox=driver.findElement(By.xpath("//select[@name='airline']"));
//
//        Select airline=new Select(airlineBox);
//
//        List<WebElement> allAirlines=airline.getOptions(); //4 options
//
//        List<String> expectedAirlines= Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");
//
//        for(int i=0;i< allAirlines.size();i++){
//            Assert.assertEquals(allAirlines.get(i).getText().trim(),expectedAirlines.get(i));
//        }
//
//        airline.selectByVisibleText("Unified Airlines");
//        Thread.sleep(3000);
//        WebElement continueButton=driver.findElement(By.xpath("//input[@name='findFlights']"));
//        continueButton.click();
//
//        WebElement header=driver.findElement(By.xpath("//font[@size='4']"));
//
//        String actualHeader=header.getText().trim();
//        String expectedHeader="After flight finder - No Seats Available";
//        Assert.assertEquals(actualHeader,expectedHeader);



//    }
//}

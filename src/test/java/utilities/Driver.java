package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Driver {

    public static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        }
        String browser = Config.getProp("browser");

        switch (browser){
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("disable-popup-blocking");
                options.addArguments("start-maximized");
                options.addArguments("incognito");

                //use preferences to disable geolocation permission prompt
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("profile.default_content_setting_values.geolocation",2);//2 is a block
                options.setExperimentalOption("prefs", prefs);

            driver = new ChromeDriver();
            break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                driver = new ChromeDriver();

        }

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        return driver;
    }
}

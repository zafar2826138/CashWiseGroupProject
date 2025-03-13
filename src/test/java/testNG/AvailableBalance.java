package testNG;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AvailableBalance {
    public AvailableBalance(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//table[@id='accountTable']//tbody//tr/td)[2]")
    public WebElement balance;
}

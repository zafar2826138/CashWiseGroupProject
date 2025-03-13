package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

    public class PIMPage {
        WebDriver driver;
        public PIMPage() {
            PageFactory.initElements(Driver.getDriver(), this);
        }
        @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--secondary']")
        public WebElement addButton;
        @FindBy(name = "firstName")
        public WebElement firstName;
        @FindBy(name = "lastName")
        public WebElement lastName;
        @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
        public WebElement employeeID;
        @FindBy(css="button[type='submit']")
        public WebElement saveButton;
        Faker faker = new Faker();

        String fName = faker.name().firstName();
        String lName = faker.name().lastName();
        String empID = faker.idNumber().valid();



        public void addEmployee(){
            addButton.click();
            firstName.sendKeys(fName);
            lastName.sendKeys(lName);
            employeeID.sendKeys(empID);
            saveButton.click();
        }
    }

package cashwise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

public class SignUpPage {
    WebDriver driver;

    public SignUpPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "(//button[@type='button'])[2]")
    WebElement signUpButton;
    @FindBy(xpath = "(//input[@name='email'])[2]")
    WebElement email;
    @FindBy(xpath = "//input[@id='password_input_text']")
    WebElement password;
    @FindBy(xpath = "//input[@id='repeat_password_input_text']")
    WebElement repeatPassword;
    @FindBy(xpath = "//button[text()= 'Continue']")
    WebElement submit;
    @FindBy(xpath="//input[@name='first_name']")
    WebElement firstName;
    @FindBy(xpath = "//input[@name='last_name']")
    WebElement lastName;
    @FindBy(id = "company_name_input_text")
    WebElement companyName;
    @FindBy(id = "mui-component-select-business_area_id")
    WebElement businessArea;
    @FindBy(xpath = "//li[contains(@class, 'MuiMenuItem-root')]")
    List<WebElement> businessAreaOptions;
    @FindBy(id = "address_input_text")
    WebElement address;
    @FindBy(xpath = "//div[@id='mui-component-select-currency']")
    WebElement currency;
    @FindBy(xpath = "//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']//li")
    List<WebElement> currencyOptions;
    @FindBy(xpath = "//button[@form='register-form-2']")
    WebElement signUpBtn;
    @FindBy(xpath = "//p[text()='Please enter a valid email address']")
    WebElement emailError;
    @FindBy(xpath = "//p[text()='Password must be at least 6 characters']")
    WebElement passwordError;
    @FindBy(xpath = "//p[text()='Password cannot be empty!']")
    WebElement emptyPasswordError;
    @FindBy(xpath = "//p[text()='Passwords do not match!']")
    WebElement confirmPasswordError;


    public void signUp(String emailVar, String passVar, String confirmedPass) {
        signUpButton.click();
        email.clear();
        password.clear();
        repeatPassword.clear();

        email.sendKeys(emailVar);
        password.sendKeys(passVar);
        repeatPassword.sendKeys(confirmedPass);

        submit.click();
    }



    public String getEmailErrorMessage() {
        try {
            return emailError.getText();
        } catch (Exception e) {
            return "";
        }
    }

    public String getPasswordErrorMessage() {
        try {
            return passwordError.getText();
        } catch (Exception e) {
            return "";
        }
    }

    public String emptyPasswordErrorMessage() {
        try {
            return emptyPasswordError.getText();
        } catch (Exception e) {
            return "";
        }
    }
    public String confirmPasswordErrorMessage() {
        try {
            return confirmPasswordError.getText();
        } catch (Exception e) {
            return "";
        }
    }
    public void signUpSecondPage(String fName, String lName, String compName, String bArea, String addrss, String crncy){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        wait.until(ExpectedConditions.visibilityOf(firstName));
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        companyName.sendKeys(compName);
        businessArea.click();
        for(WebElement option:businessAreaOptions){
            if(option.getText().equals(bArea)){
                option.click();
                break;
            }
        }
        wait.until(ExpectedConditions.visibilityOf(address));
        wait.until(ExpectedConditions.elementToBeClickable(address));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(address).click().sendKeys(addrss).build().perform();

        WebElement element = driver.findElement(By.xpath("mui-component-select-currency"));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();

        for(WebElement currencies:currencyOptions){
            currencies.getText().equals(crncy);
            currencies.click();
            break;
        }
        signUpBtn.click();

    }
}






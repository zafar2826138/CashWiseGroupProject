package com.qa.cashwise.pages.SignUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.BrowserUtils;
import utils.ConfigReader;

public class SignUpPage {
    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@class='MuiButton-root MuiButton-outlined MuiButton-outlinedPrimary MuiButton-sizeMedium MuiButton-outlinedSizeMedium MuiButtonBase-root css-k6k41x']")
    WebElement signUpButton;

    @FindBy(css = "#email_input_text")
    WebElement email;

    @FindBy(css = "#password_input_text")
    WebElement password;

    @FindBy(css = "#repeat_password_input_text")
    WebElement passwordConfirm;

    @FindBy(xpath = "//button[@class='MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-fullWidth MuiButtonBase-root css-1hz3hle']")
    WebElement continueButton;

    @FindBy(css = "#first_name_input_text")
    WebElement name;

    @FindBy(css = "#last_name_input_text")
    WebElement lastName;

    @FindBy(css = "#company_name_input_text")
    WebElement nameOfBusiness;

    @FindBy(css = "#mui-component-select-business_area_id")
    WebElement selectAreaOfBusinessBox;

    @FindBy(xpath = "//li[@data-value='3']")
    WebElement areaOfBusinessIT;

    @FindBy(css = "#address_input_text")
    WebElement address;

    @FindBy(xpath = "//div[@id='mui-component-select-currency']")
    WebElement selectCurrencyButton;

    @FindBy(xpath = "//li[@data-value='USD']")
    WebElement USDcurrency;

    @FindBy(xpath = "//button[@class='MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-fullWidth MuiButtonBase-root css-1hz3hle']")
    WebElement finalSignUpButton;

    public void clickSignUpButton() {
        signUpButton.click();
    }

    public void sendEmailAndPasswordInfo() {
        email.sendKeys(ConfigReader.ReadProperty("cashwise_email"));
        password.sendKeys(ConfigReader.ReadProperty("cashwise_password"));
        passwordConfirm.sendKeys(ConfigReader.ReadProperty("cashwise_password"));
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void sendUserInfo(WebDriver driver) throws InterruptedException {
        name.sendKeys(ConfigReader.ReadProperty("cashwiseUser_name"));
        lastName.sendKeys(ConfigReader.ReadProperty("cashwiseUser_lastName"));
        nameOfBusiness.sendKeys(ConfigReader.ReadProperty("cashwiseUser_businessName"));

        Thread.sleep(2000);

        Actions actions = new Actions(driver);
        actions.click(selectAreaOfBusinessBox).perform();
        actions.click(areaOfBusinessIT).perform();
        address.sendKeys(ConfigReader.ReadProperty("cashwiseUser_address"));
        selectCurrencyButton.click();
        Thread.sleep(2000);
        USDcurrency.click();
        Thread.sleep(2000);
        BrowserUtils.clickWithJS(driver, finalSignUpButton);



    }

}


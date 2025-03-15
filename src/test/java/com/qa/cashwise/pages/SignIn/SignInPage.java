package com.qa.cashwise.pages.SignIn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {



        @FindBy(xpath = "//button[.='Sign in']")
        WebElement signInButton;

        @FindBy(css = "#email_input_text")
        WebElement emailInput;

        @FindBy(css = "#password_input_text")
        WebElement passwordInput;

        @FindBy(xpath = "(//form)[2]//button[@type='submit']")
        WebElement loginButton;


        public SignInPage(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }


        public void clickSignInButton() {
            signInButton.click();
        }


        public void enterEmail(String email) {
            emailInput.sendKeys(email);
        }


        public void enterPassword(String password) {
            passwordInput.sendKeys(password);
        }


        public void clickLoginButton() {
            loginButton.click();
        }
}

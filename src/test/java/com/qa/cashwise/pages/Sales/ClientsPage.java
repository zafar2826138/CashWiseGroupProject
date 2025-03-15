package com.qa.cashwise.pages.Sales;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientsPage {
    public ClientsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy (css = "div[id='panel1a-header']")
    public WebElement sales;

    @FindBy (xpath = "//button[contains(text(),\"Add client\")]")
    public WebElement addClient;


    @FindBy(id ="react-select-3-input")
    WebElement clientsTag;
    @FindBy(xpath = "//div[@class=\" css-1hwfws3\"]//div[@class=\"css-12jo7m5\"]")
    WebElement itTag;
    @FindBy(xpath = "//div[@class=\" css-1hwfws3\"]")
    WebElement tagName;

    @FindBy(css = "input[id=\"company_name_input_text\"]")
    WebElement companyName;

    @FindBy(id = "client_name_input_text")
    WebElement fullName;

    @FindBy(id = "email_input_text")
    WebElement email;

    @FindBy(id = "phone_number_input_text")
    WebElement phoneNumber;

    @FindBy(id = "address_input_text")
    WebElement address;

    @FindBy(xpath = "//button[contains(text(), 'Save')]")
    WebElement saveButton;



    public void sales( String cName,String fName, String mail, String phNumber, String ads  ){
        sales.click();
        addClient.click();
        // clientsTag.click();
        // itTag.click();
        // tagName.click();
        companyName.sendKeys(cName);
        fullName.sendKeys(fName);
        email.sendKeys(mail);
        phoneNumber.sendKeys(phNumber);
        address.sendKeys(ads);
        saveButton.click();

    }
}
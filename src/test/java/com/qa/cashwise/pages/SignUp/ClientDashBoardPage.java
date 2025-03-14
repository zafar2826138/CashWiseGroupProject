package com.qa.cashwise.pages.SignUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class ClientDashBoardPage {
    public ClientDashBoardPage(WebDriver driver){
        PageFactory.initElements(driver, this);}

    @FindBy(xpath = "//*[@id=\"header\"]/h2")
    WebElement headerNameOfCompany;


    public void validationOfClientInfo(String expectedNameOfCompany){
        Assert.assertEquals(headerNameOfCompany.getText(), expectedNameOfCompany);
    }


    }


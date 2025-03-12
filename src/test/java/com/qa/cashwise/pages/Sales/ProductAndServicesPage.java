package com.qa.cashwise.pages.Sales;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class ProductAndServicesPage {
    public ProductAndServicesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//li[.='Sales']")
    WebElement SalesTab;

    @FindBy(xpath = "(//a[.='Products and services'])[1]")
    WebElement ProductAndServicesLink;

    @FindBy(xpath = "//h3")
    WebElement header;

    @FindBy(xpath = "//button[.='Add products or service']")
    WebElement addProductAndServicesButton;

    @FindBy(css = "#product_title_input_text")
    WebElement name;

    @FindBy(css = "#product_price_input_text")
    WebElement price;

    @FindBy(xpath = "//label[.='Select service type']")
    WebElement serviceType;

    @FindBy(xpath = "//*[@id=\"menu-service_type_id\"]/div[3]/ul/li[2]")
    WebElement getServiceType2;

    @FindBy(xpath = "//label[.='Select category income']")
    WebElement category;

    @FindBy(xpath = "//*[@id=\"menu-category_id\"]/div[3]/ul/li[1]")
    WebElement getCategory1;

    @FindBy(css = "#product_description_input_text")
    WebElement description;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div/div/div/div/div/div[.='Service  successfully created']")
    WebElement message;

    public void goToProductServicePage(){
        SalesTab.click();
        ProductAndServicesLink.click();
    }
    public void addProductAndServices(WebDriver driver,String name, String price, String desc) throws InterruptedException {
        Actions actions = new Actions(driver);
        addProductAndServicesButton.click();
        this.name.sendKeys(name);
        this.price.sendKeys(price);
        actions.click(serviceType).perform();
        getServiceType2.click();
        Thread.sleep(2000);
        actions.click(category).perform();
        getCategory1.click();
        description.sendKeys(desc);
        saveButton.click();
        Assert.assertEquals(BrowserUtils.getText(message), "Service successfully created");

    }



}

package com.qa.cashwise.pages.Expenses;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;
import utils.ConfigReader;

import javax.sql.rowset.BaseRowSet;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.List;

public class ProductAndServicesExpensePage {
    public ProductAndServicesExpensePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//li[.='Expenses']")
    WebElement expenses;

    @FindBy(xpath = "/html/body/div/div/div/aside/div[3]/div[2]/div/div/div/div/div/a[2]")
    WebElement productsAndServices;

    @FindBy(xpath = "//h3")
    WebElement titleProductsAndServices;

    @FindBy(xpath = "//*[@id=\"main\"]/div/header/button")
    WebElement addProductButton;

    @FindBy(xpath = "//input[@name='product_title']")
    WebElement name;

    @FindBy(xpath = "//input[@name='product_price']")
    WebElement productPrice;

    @FindBy(css = "#mui-component-select-service_type_id")
    WebElement serviceType;

    @FindBy(xpath = "//li[.='Product']")
    WebElement productOption;

    @FindBy(css = "#mui-component-select-category_id")
    WebElement category;
////li[@tabindex='0']
    @FindBy(xpath = "//*[@id=\"menu-category_id\"]/div[3]/ul/button")
    WebElement createNewCategory;

    @FindBy(css = "#category_title_input_text")
    WebElement titleCategory;

    @FindBy(css = "#category_description_input_text")
    WebElement descriptionCategory;

    @FindBy(xpath = "/html/body/div[4]/div[3]/div/div/div/button[2]")
    WebElement buttonSaveInCategory;

    @FindBy(xpath = "//li[@tabindex='0']")
    WebElement firstProduct;
    /// ?????//*[@id="menu-category_id"]/div[3]/ul/li[5]
    @FindBy(css = "#product_description_input_text")
    WebElement description;

    @FindBy(xpath = "//input[@name='remind_before_day']")
    WebElement remindBeforeButton;

    @FindBy(xpath = "//input[@value='DO_NOT_REPEAT']")
    WebElement noRepeatBox;

    @FindBy(css = "#undefined_input_text")
    WebElement dateOfPay;


    @FindBy(xpath = "//button[.='Save']")
    WebElement saveButton;

    @FindBy(xpath = "//td[@class='MuiTableCell-root MuiTableCell-body MuiTableCell-sizeMedium css-q34dxg']")
    List<WebElement> allInformation;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/table/tbody/tr/td[6]/div/button[2]")
    WebElement deleteTheCreatedProduct;

    @FindBy(xpath = "//button[.='Delete']")
    WebElement deleteButton;

    @FindBy(xpath = "//span[.='List is empty']")
    WebElement listIsEmpty;

    public void openProductAndServicesFromExpenses() throws InterruptedException {
        expenses.click();
        //Thread.sleep(2000);
        productsAndServices.click();
        Assert.assertEquals(BrowserUtils.getText(titleProductsAndServices), "Products and services (Expense)");


    }

    public void addProductAndServicesFunctionality() throws InterruptedException {
        addProductButton.click();
        //  Thread.sleep(2000);
        name.sendKeys(ConfigReader.ReadProperty("name"));
        productPrice.sendKeys(ConfigReader.ReadProperty("price"));
        serviceType.click();
        productOption.click();
        category.click();
        Thread.sleep(2000);
        createNewCategory.click();
        titleCategory.sendKeys(ConfigReader.ReadProperty("category"));
        descriptionCategory.sendKeys(ConfigReader.ReadProperty("categoryDescription"));
        buttonSaveInCategory.click();
        Thread.sleep(2000);
        firstProduct.click();
        //Thread.sleep(2000);
        description.sendKeys(ConfigReader.ReadProperty("description"));
        dateOfPay.sendKeys(ConfigReader.ReadProperty("date"));
        remindBeforeButton.clear();
        remindBeforeButton.sendKeys(ConfigReader.ReadProperty("remind"));
        noRepeatBox.click();
        saveButton.click();


        List<String> expectedInformation = Arrays.asList("book", "90 $", "book", "New Book");

        for (int i = 1; i < allInformation.size() - 2; i++) {
            Assert.assertEquals(expectedInformation.get(i), BrowserUtils.getText(allInformation.get(i)));
        }

    }

    public void deleteTheProduct() {
        deleteTheCreatedProduct.click();
        deleteButton.click();
        Assert.assertEquals(BrowserUtils.getText(listIsEmpty), "List is empty");
    }
}

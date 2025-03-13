package cashwise;


import cashwise.SignUpPage;
import jdk.jfr.DataAmount;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.Driver;

import java.time.Duration;

import static utilities.Driver.driver;

public class SignUpTest {
    SignUpPage signUpPage;

    @BeforeMethod
    public void setup() {
        signUpPage = new SignUpPage();
        Driver.getDriver().get("https://cashwise.us/main");

    }

    @Test(dataProvider = "signUpData")
    public void testSignUp(String email, String password, String confirmPassword,
                           String expectedEmailMsg, String expectedPasswordMsg, String expectedConfirmPassMsg, String emptyPassMessage) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        signUpPage.signUp(email, password, confirmPassword);

        String actualEmailMsg = signUpPage.getEmailErrorMessage();
        String actualPasswordMsg = signUpPage.getPasswordErrorMessage();
        String actualConfirmPassMsg = signUpPage.confirmPasswordErrorMessage();
        String emptyPasswordMessage = signUpPage.emptyPasswordErrorMessage();


        if (!expectedEmailMsg.isEmpty()) {
            Assert.assertEquals(actualEmailMsg, expectedEmailMsg,
                    "Expected email message: " + expectedEmailMsg + ", but got: " + actualEmailMsg);
        }

        // ✅ Validate password error message
        if (!expectedPasswordMsg.isEmpty()) {
            Assert.assertEquals(actualPasswordMsg, expectedPasswordMsg,
                    "Expected password message: " + expectedPasswordMsg + ", but got: " + actualPasswordMsg);
        }

        // ✅ Validate confirm password error message
        if (!expectedConfirmPassMsg.isEmpty()) {
            Assert.assertEquals(actualConfirmPassMsg, expectedConfirmPassMsg,
                    "Expected confirm password message: " + expectedConfirmPassMsg + ", but got: " + actualConfirmPassMsg);
        }
        if (expectedConfirmPassMsg.isEmpty()) {
            Assert.assertEquals(emptyPasswordMessage, emptyPassMessage,
                    "Expected confirm password message: " + expectedConfirmPassMsg + ", but got: " + actualConfirmPassMsg);
        }

    }

    @DataProvider(name = "signUpData")
    public Object[][] getSignUpData() {
        return new Object[][]{

                {"test1234@gmail.com", "Pass@123", "Pass@123", "", "", "", ""},

                //  Email cases
                {"", "Pass@123", "Pass@123", "Please enter a valid email address", "", "", ""},
                {"invalid-email", "Pass@123", "Pass@123", "Please enter a valid email address", "", "", ""},
                {"test#gmail.com", "Pass@123", "Pass@123", "Please enter a valid email address", "", "", ""},
                {"test@gmail.co", "Pass@123", "Pass@123", "Please enter a valid email address", "", "", ""},

//                    //  Password cases
                {"test@gmail.com", "12345", "12345", "", "Password must be at least 6 characters", "", ""},
                {"test@gmail.com", "", "123456", "", "", "", "Password cannot be empty!"},
                {"test@gmail.com", "123456", "654321", "", "", "Passwords do not match!", ""},
                {"test@gmail.com", "123456", "12", "", "", "Passwords do not match!", ""},
//
//
        };
    }


    @Test(dataProvider = "signUpData2")
    public void testSignUpSecondPage(String fName, String lName, String compName, String bArea, String addrss, String crncy,
                                     String expectedFirstNameMsg, String expectedLastNameMsg, String expectedCompNameMsg,String expectedBusinessAreaMsg,
                                     String expectedAddressMsg, String expectedCurrencyMsg) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        signUpPage.signUp("cashwise11123@gmail.com", "Pass@123", "Pass@123"); // First page submission

        signUpPage.signUpSecondPage(fName, lName, compName, bArea, addrss, crncy);
        if (!expectedFirstNameMsg.isEmpty()) {
            String firstNameValidationMsg = signUpPage.firstName.getAttribute("validationMessage");
            Assert.assertEquals(firstNameValidationMsg, expectedFirstNameMsg,
                    "Expected first name validation message: " + expectedFirstNameMsg + ", but got: " + firstNameValidationMsg);
        }


        if (!expectedLastNameMsg.isEmpty()) {
            String lastNameValidationMsg = signUpPage.lastName.getAttribute("validationMessage");
            Assert.assertEquals(lastNameValidationMsg, expectedLastNameMsg,
                    "Expected last name validation message: " + expectedLastNameMsg + ", but got: " + lastNameValidationMsg);
        }


        if (!expectedCompNameMsg.isEmpty()) {
            String companyNameValidationMsg = signUpPage.companyName.getAttribute("validationMessage");
            Assert.assertEquals(companyNameValidationMsg, expectedCompNameMsg,
                    "Expected company name validation message: " + expectedCompNameMsg + ", but got: " + companyNameValidationMsg);
        }
if(!expectedBusinessAreaMsg.isEmpty()){
    String businessAreaNameValidationMsg = signUpPage.businessArea.getAttribute("validationMessage");
    Assert.assertEquals(businessAreaNameValidationMsg,expectedBusinessAreaMsg, "Expected address validation message: " + expectedBusinessAreaMsg + ", but got: " + businessAreaNameValidationMsg);
}

        if (!expectedAddressMsg.isEmpty()) {
            String addressValidationMsg = signUpPage.address.getAttribute("validationMessage");
            Assert.assertEquals(addressValidationMsg, expectedAddressMsg,
                    "Expected address validation message: " + expectedAddressMsg + ", but got: " + addressValidationMsg);
        }

        if (!expectedCurrencyMsg.isEmpty()) {
            String currencyValidationMsg = signUpPage.currency.getAttribute("validationMessage");
            Assert.assertEquals(currencyValidationMsg, expectedCurrencyMsg,
                    "Expected currency validation message: " + expectedCurrencyMsg + ", but got: " + currencyValidationMsg);
        }

    }

    @DataProvider(name = "signUpData2")
    public Object[][] getSignUpData2() {
        return new Object[][]{
                // Positive cases
                {"Liza", "Adams", "Tech Corp", "IT, Software Development,", "1124 School St", "USD", "", "", "", "", "",""},
                {"John", "SmIth", "Health Solutions", "Consulting", "456 Elm St", "EUR", "", "", "", "", "",""},
                {"adam", "SMITH", "Mercy Corps", "Retail trade", "45689 Elm St", "KGS", "", "", "", "", "",""},
                {"adam", "SMITH", "Bishkek Stroy", "Construction,repair services", "45689 Elm St", "USD", "", "", "", "", "",""},
                {"ADAM", "SMITH", "Cozy Home", "Design services", "45689 Elm St", "USD", "", "", "", "", ""},
                {"adam", "JhonsonJhonsonJhonsonJhonsonJhonsonJhonsonJhonsonJhonsonJhonsonJhonson", "CHARITY ", "Education and training", "12 Grove Ave", "USD", "", "", "", "", ""},
                {"adam", "SMITH", "duBUY", "Realty", "4578 Real St", "USD", "", "", "", "", "",""},
                {"adam", "SMITH", "Face Beauty", "Cosmetology services", "6789 Grove St", "RUB", "", "", "", "", "",""},


                {"", "Doe", "Tech Corp", "IT", "123 Main St", "USD", "Please fill out this field.", "", "", "", "",""},
                {"John", "", "Tech Corp", "IT", "123 Main St", "USD", "", "Please fill out this field.", "", "", "",""},
                {"John", "Doe", "", "IT", "123 Main St", "USD", "", "", "Please fill out this field.", "", "",""},
                {"John", "Doe", "Tech Corp", "", "123 Main St", "USD", "", "", "", "Please fill out this field.", "",""},
                {"John", "Doe", "Tech Corp", "IT", "", "USD", "", "", "", "", "Please fill out this field.",""},
                {"John", "Doe", "Tech Corp", "IT", "123 Main St", "", "", "", "", "","", "Please fill out this field."},
                {"########", "SMITH", "Face Beauty", "Cosmetology services", "6789 Grove St", "RUB", "Enter a valid name", "", "", "", "",""},
                {"John", "123", "Face Beauty", "Cosmetology services", "6789 Grove St", "RUB", "", "Enter a valid lastname", "", "", "",""},
                {"John", "SMITH", "Computer", "IT, Software Development,", "$%^^&", "KGS", "", "","","", "Enter a valid address", ""},
        };
    }

}



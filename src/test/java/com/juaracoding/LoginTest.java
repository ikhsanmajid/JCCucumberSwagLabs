package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.InventoryPage;
import com.juaracoding.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class LoginTest {

    private static WebDriver driver;
    private static LoginPage loginPage = new LoginPage();
    private static InventoryPage inventoryPage = new InventoryPage();
    private static ExtentTest extentTest;
    public LoginTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }
    @Given("User enter URL web SwagLabs")
    public void user_enter_url_web_swaglabs(){
        String url = "https://www.saucedemo.com/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        extentTest.log(LogStatus.PASS, "User enter URL web SwagLabs");
    }

    @When("User enter username")
    public void user_enter_username(){
        loginPage.setUsername("standard_user");
        extentTest.log(LogStatus.PASS, "User enter username");
    }

    @When("User enter empty {string} or {string}")
    public void user_enter_empty_username_or_password(String username, String password){
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        extentTest.log(LogStatus.PASS, "User enter empty username or password");
    }

    @When("User enter invalid {string} or {string}")
    public void user_enter_invalid_username_or_password(String username, String password){
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        extentTest.log(LogStatus.PASS, "User enter invalid username or password");
    }

    @And("User enter password")
    public void user_enter_password(){
        loginPage.setPassword("secret_sauce");
        extentTest.log(LogStatus.PASS, "User enter password");
    }

    @And("User click login button")
    public void user_click_login_button(){
        loginPage.clickLoginBtn();
        extentTest.log(LogStatus.PASS, "User click login button");
    }

    @Then("User login successful redirect to page home")
    public void user_login_successful_redirect_to_page_home(){
        Assert.assertEquals(inventoryPage.getProductPageTitle(), "Products");
        extentTest.log(LogStatus.PASS, "User login successful redirect to page home");
    }

    @Then("Show login error message")
    public void show_login_error_message(){
        Assert.assertTrue(loginPage.getLoginErrorMsg().contains("Password is required") || loginPage.getLoginErrorMsg().contains("Username is required") || loginPage.getLoginErrorMsg().contains("password do not match"));
        extentTest.log(LogStatus.PASS, "Show login error message");
    }

    @AfterAll
    public static void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }


}

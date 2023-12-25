package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.InventoryPage;
import com.juaracoding.pages.LoginPage;
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
    private static LoginPage loginPage;
    private static InventoryPage inventoryPage;
    @BeforeAll
    public static void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        String url = "https://www.saucedemo.com/";
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
    }


    @Given("User enter URL web SwagLabs")
    public void user_enter_url_web_swaglabs(){
        String url = "https://www.saucedemo.com/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @When("User enter username")
    public void user_enter_username(){
        loginPage.setUsername("standard_user");
    }

    @When("User enter empty {string} or {string}")
    public void user_enter_empty_username_or_password(String username, String password){
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }

    @When("User enter invalid {string} or {string}")
    public void user_enter_invalid_username_or_password(String username, String password){
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }

    @And("User enter password")
    public void user_enter_password(){
        loginPage.setPassword("secret_sauce");
    }

    @And("User click login button")
    public void user_click_login_button(){
        loginPage.clickLoginBtn();
    }

    @Then("User login successful redirect to page home")
    public void user_login_successful_redirect_to_page_home(){
        Assert.assertEquals(inventoryPage.getProductPageTitle(), "Products");
    }

    @Then("Show login error message")
    public void show_login_error_message(){
        Assert.assertTrue(loginPage.getLoginErrorMsg().contains("Password is required") || loginPage.getLoginErrorMsg().contains("Username is required") || loginPage.getLoginErrorMsg().contains("password do not match"));
    }

    @AfterAll
    public static void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }


}

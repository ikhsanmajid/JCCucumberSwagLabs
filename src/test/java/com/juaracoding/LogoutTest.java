package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.InventoryPage;
import com.juaracoding.pages.LoginPage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LogoutTest{
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
    @When("User click hamburger button")
    public void user_click_hamburger_button(){
        inventoryPage.clickHamburgerBtn();
    }

    @And("User click logout button")
    public void user_click_logout_button(){
        inventoryPage.clickLogoutBtn();
    }

    @Then("User back to login page")
    public void user_back_to_login_page(){
        boolean isExist = loginPage.isUsernameExist();
        Assert.assertTrue(isExist);
    }

    @AfterAll
    public static void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }
}

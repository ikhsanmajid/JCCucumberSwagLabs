package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.InventoryPage;
import com.juaracoding.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LogoutTest{
    private static WebDriver driver;
    private static LoginPage loginPage = new LoginPage();
    private static InventoryPage inventoryPage = new InventoryPage();
    private static ExtentTest extentTest;
    public LogoutTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @When("User click hamburger button")
    public void user_click_hamburger_button(){
        inventoryPage.clickHamburgerBtn();
        extentTest.log(LogStatus.PASS, "User click hamburger button");
    }

    @And("User click logout button")
    public void user_click_logout_button(){
        inventoryPage.clickLogoutBtn();
        extentTest.log(LogStatus.PASS, "User click logout button");
    }

    @Then("User back to login page")
    public void user_back_to_login_page(){
        boolean isExist = loginPage.isUsernameExist();
        Assert.assertTrue(isExist);
        extentTest.log(LogStatus.PASS, "User back to login page");
    }

    @AfterAll
    public static void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }
}

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

import java.sql.Driver;

public class CheckoutTest {

    private static WebDriver driver;
    private static LoginPage loginPage = new LoginPage();
    private static InventoryPage inventoryPage = new InventoryPage();
    private static ExtentTest extentTest;
    public CheckoutTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @When("User add to cart {int}")
    public void user_add_to_cart(Integer item) {
        inventoryPage.clickAddToCart(item);
        extentTest.log(LogStatus.PASS, "User add to cart");
    }
    @Then("User added items to cart")
    public void user_added_items_to_cart() {
        Assert.assertEquals(inventoryPage.getCartValueText(), "2");
        extentTest.log(LogStatus.PASS, "User added items to cart");
    }

    @When("User click cart button")
    public void user_click_cart_button(){
        inventoryPage.clickCartBtn();
        extentTest.log(LogStatus.PASS, "User click cart button");
    }

    @And("User cart {int} right {string} and {string}")
    public void user_cart_int_right_item_and_price(Integer item, String name, String price){
        Assert.assertEquals(inventoryPage.getItemName(item), name);
        Assert.assertEquals(inventoryPage.getItemPrice(item), price);
        extentTest.log(LogStatus.PASS, "User cart item right name and price");
    }

    @And("User click checkout button")
    public void user_click_checkout_button(){
        inventoryPage.clickCheckoutBtn();
        extentTest.log(LogStatus.PASS, "User click checkout button");
    }

    @Then("User redirect to shipping information")
    public void user_redirect_to_shipping_information(){
        Assert.assertEquals(inventoryPage.getInformationCheckout(), "Checkout: Your Information");
        extentTest.log(LogStatus.PASS, "User redirect to shipping information");
    }

    @When("User input empty {string} or empty {string} or empty {string}")
    public void user_input_empty_firstname_or_empty_lastname_or_empty_postalcode(String firstName, String lastName, String postalCode){
        inventoryPage.setFirstName(firstName);
        inventoryPage.setLastName(lastName);
        inventoryPage.setPostalCode(postalCode);
        extentTest.log(LogStatus.PASS, "User input empty firstName or empty lastName or empty postalCode");
    }

    @And("User click continue button")
    public void user_click_continue_button(){
        inventoryPage.clickContinueBtn();
        extentTest.log(LogStatus.PASS, "User click continue button");
    }

    @Then("Show shipping error message")
    public void show_shipping_error_message(){
        boolean firstNameEmpty = inventoryPage.getShippingErrorText().contains("First Name is required");
        boolean lastNameEmpty = inventoryPage.getShippingErrorText().contains("Last Name is required");
        boolean postalCodeEmpty = inventoryPage.getShippingErrorText().contains("Postal Code is required");
        Assert.assertTrue(firstNameEmpty || lastNameEmpty || postalCodeEmpty);
        extentTest.log(LogStatus.PASS, "Show shipping error message");
    }

    @When("User input valid firstName and valid lastName and valid postalCode")
    public void user_input_valid_firstname_and_valid_lastname_and_valid_postalcode(){
        inventoryPage.setFirstName("ikhsan");
        inventoryPage.setLastName("majid");
        inventoryPage.setPostalCode("12345");
        extentTest.log(LogStatus.PASS, "User input valid firstName and valid lastName and valid postalCode");
    }

    @Then("Show checkout overview page")
    public void show_checkout_overview_page(){
        Assert.assertEquals(inventoryPage.getOverviewText(), "Checkout: Overview");
        extentTest.log(LogStatus.PASS, "Show checkout overview page");
    }

    @When("User click finish button")
    public void user_click_finish_button(){
        inventoryPage.clickFinishBtn();
        extentTest.log(LogStatus.PASS, "User click finish button");
    }

    @Then("Show success order")
    public void show_success_order(){
        Assert.assertEquals(inventoryPage.getSuccessOrderText(), "Thank you for your order!");
        extentTest.log(LogStatus.PASS, "Show success order");
    }

    @When("User click back home button")
    public void user_click_back_home_button(){
        inventoryPage.clickBackToHomeBtn();
        extentTest.log(LogStatus.PASS, "User click back home button");
    }

    @Then("User redirect to page products")
    public void user_redirect_to_page_products(){
        Assert.assertEquals(inventoryPage.getProductPageTitle(), "Products");
        extentTest.log(LogStatus.PASS, "User redirect to page products");
    }

    @AfterAll
    public static void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }

}

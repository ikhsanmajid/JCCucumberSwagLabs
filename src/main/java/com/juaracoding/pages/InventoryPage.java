package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.security.Key;
import java.util.List;

public class InventoryPage {
    @FindBy(xpath = "//div[1]/div[2]/span[@class='title']")
    WebElement productPageTitle;
    @FindBy(xpath = "//div[@class='bm-burger-button']")
    WebElement hamburgerBtn;
    @FindBy(xpath = "//div[2]/div[1]/nav[@class='bm-item-list']/a")
    List<WebElement> linkHamburger;

    @FindBy(xpath = "//div[@id='inventory_container']//button[contains(@class, 'btn_small btn_inventory')]")
    List<WebElement> addToCartsBtn;

    @FindBy(xpath = "//div[@id='shopping_cart_container']")
    WebElement cartBtn;

    @FindBy(xpath = "//div[@id='shopping_cart_container']/a/span")
    WebElement cartValue;

    @FindBy(xpath = "//div[@id='cart_contents_container']/div/div[@class='cart_list']/div[@class='cart_item']//div[@class='inventory_item_name']")
    List<WebElement> itemName;

    @FindBy(xpath = "//div[@id='cart_contents_container']/div/div[@class='cart_list']/div[@class='cart_item']//div[@class='inventory_item_price']")
    List<WebElement> itemPrice;

    @FindBy(id = "checkout")
    WebElement checkoutBtn;

    @FindBy(xpath = "//div[@id='header_container']/div[@class='header_secondary_container']")
    WebElement informationCheckout;

    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastName;
    @FindBy(id = "postal-code")
    WebElement postalCode;

    @FindBy(id = "continue")
    WebElement continueBtn;
    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement shippingErrorText;

    @FindBy(xpath = "//span[@class='title']")
    WebElement overviewText;

    @FindBy(id = "finish")
    WebElement finishBtn;

    @FindBy(xpath = "//h2[@class='complete-header']")
    WebElement successOrderText;

    @FindBy(id = "back-to-products")
    WebElement backToHomeBtn;




    private final WebDriver driver;
    private final Actions actions;

    public InventoryPage() {
        this.driver = DriverSingleton.getDriver();
        this.actions = new Actions(this.driver);
        PageFactory.initElements(driver, this);
    }

    public String getProductPageTitle() {
        return productPageTitle.getText();
    }

    public void clickHamburgerBtn() {
        actions.click(hamburgerBtn).perform();
    }

    public void clickLogoutBtn() {
        linkHamburger.get(2).click();
    }

    public void clickAddToCart(int item){
        actions.click(addToCartsBtn.get(item)).perform();

    }

    public String getCartValueText(){
        return cartValue.getText();
    }

    public void clickCartBtn(){
        cartBtn.click();
    }

    public String getItemPrice(int item){
        String fullPrice = itemPrice.get(item).getText();
        String modifiedPrice = fullPrice.substring(1);
        return modifiedPrice;
    }

    public String getItemName(int item){
        String fullText = itemName.get(item).getText();
        return fullText;
    }

    public void clickCheckoutBtn(){
        checkoutBtn.click();
    }

    public String getInformationCheckout(){
        return informationCheckout.getText();
    }

    public void setFirstName(String firstName){
        this.firstName.sendKeys(Keys.CONTROL + "A" + Keys.DELETE);
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName){
        this.lastName.sendKeys(Keys.CONTROL + "A" + Keys.DELETE);
        this.lastName.sendKeys(lastName);
    }

    public void setPostalCode(String postalCode){
        this.postalCode.sendKeys(Keys.CONTROL + "A" + Keys.DELETE);
        this.postalCode.sendKeys(postalCode);
    }

    public void clickContinueBtn(){
        actions.click(continueBtn).perform();
    }

    public String getShippingErrorText(){
        return this.shippingErrorText.getText();
    }

    public String getOverviewText(){
        return this.overviewText.getText();
    }

    public void clickFinishBtn(){
        actions.click(finishBtn).perform();
    }

    public String getSuccessOrderText(){
        return successOrderText.getText();
    }

    public void clickBackToHomeBtn(){
        actions.click(backToHomeBtn).perform();
    }




}

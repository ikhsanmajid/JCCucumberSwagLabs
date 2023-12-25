package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(xpath = "//div[@id='shopping_cart_container']/a/span")
    WebElement cartValue;

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
        System.out.println(item);
    }

    public String getCartValueText(){
        return cartValue.getText();
    }
}

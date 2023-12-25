package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "login-button")
    WebElement loginBtn;

    @FindBy(xpath = "//form/div[3]/h3[@data-test='error']")
    WebElement errorMsg;

    public void setUsername(String username){
       this.username.sendKeys(username);
    }

    public void setPassword(String password){
        this.password.sendKeys(password);
    }

    public boolean isUsernameExist(){
        return username.isDisplayed();
    }

    public String getLoginErrorMsg(){
        return errorMsg.getText();
    }

    public void clickLoginBtn(){
        this.loginBtn.click();
    }

}

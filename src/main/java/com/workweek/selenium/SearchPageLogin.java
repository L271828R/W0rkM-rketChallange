package com.workweek.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by luisrueda on 1/30/19.
 */
public class SearchPageLogin extends PageObject{

    public SearchPageLogin(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"login-email\"]")
    private WebElement elEmail;

    @FindBy(xpath = "//*[@id=\"login-password\"]")
    private WebElement elPassword;

    // //*[@id="login-password"]

    @FindBy(xpath = "//*[@id=\"login_page_button\"]")
    private WebElement elSubmitButton;


    public void enterEmail(String email){
        elEmail.sendKeys(email);
    }

    public void enterPassword(String password){
        elPassword.sendKeys(password);
    }

    public void clickSubmit(){
        elSubmitButton.click();
    }

}

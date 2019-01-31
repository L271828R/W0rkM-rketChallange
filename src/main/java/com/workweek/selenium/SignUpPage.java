package com.workweek.selenium;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by luisrueda on 1/30/19.
 */
public class SignUpPage extends PageObject {


    public SignUpPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//*[@id=\"landing-page-bucket\"]/div/div[1]/div[2]/div[2]/div/button")
    private WebElement elJoinAsIndividual;


    @FindBy(id = "firstname")
    private WebElement elFirstName;

    @FindBy(id = "lastname")
    private WebElement elLastName;

    @FindBy(id = "email")
    private WebElement elEmail;

    @FindBy(id = "password")
    private WebElement elPassword;

    @FindBy(xpath = "//*[@id=\"landing-page-bucket\"]/div/div[2]/div[2]/div/div[5]/div/input")
    private WebElement elPrivacyCheckBox;

    @FindBy(xpath = "//*[@id=\"landing-page-bucket\"]/div/div[2]/div[2]/div/div[5]/small/span[1]/a")
    private WebElement elTermsOfAgreement;

    @FindBy(xpath = "//*[@id=\"landing-page-bucket\"]/div/div[2]/div[2]/div/div[5]/small/span[2]/a")
    private WebElement elPrivacyStatement;

    @FindBy(xpath = "//*[@id=\"landing-page-bucket\"]/div/div[2]/div[2]/div/div[1]/label/span/span[1]")
    private WebElement elFirstNameLabel;

    @FindBy(xpath = "//*[@id=\"landing-page-bucket\"]/div/div[2]/div[2]/div/div[2]/label")
    private WebElement elLastNameLabel;

    @FindBy(xpath = "//*[@id=\"landing-page-bucket\"]/div/div[2]/div[2]/div/div[3]/label")
    private WebElement elEmailLabel;

    @FindBy(xpath = "//*[@id=\"landing-page-bucket\"]/div/div[2]/div[2]/div/div[4]/label")
    private WebElement elPasswordLabel;

    //  //*[@id="landing-page-bucket"]/div/div[2]/div[2]/div/div[4]/label

    @FindBy(xpath = "//*[@id=\"landing-page-bucket\"]/div/div[2]/div[2]/footer/div/button")
    private WebElement elSubmitButton;

    @FindBy(xpath = "//*[@id=\"campaign_landing\"]/div[1]/h2")
    private WebElement elRegistrationConfirmation;

    @FindBy(xpath = "//*[@id=\"landing-page-bucket\"]/div/div[2]/div[2]/div/div[3]/div[2]")
    private WebElement elEmailValidationPrompt;

    @FindBy(xpath = "//*[@id=\"landing-page-bucket\"]/div/div[2]/div[2]/div/div[4]/div[3]")
    private WebElement elPasswordValidationPrompt;

    // //*[@id="landing-page-bucket"]/div/div[2]/div[2]/div/div[3]/div[2]

    // //*[@id="campaign_landing"]/div[1]/h2

    // //*[@id="landing-page-bucket"]/div/div[2]/div[2]/footer/div/button/div/div/span



    public void clickJoinAsIndividual(){
        elJoinAsIndividual.click();
    }


    public String getFirstNameLabelText(){
        return elFirstNameLabel.getText();
    }

    public String getLasttNameLabelText(){
        return elLastNameLabel.getText();
    }

    public String getEmailLabelText(){
        return elEmailLabel.getText();
    }

    public String getPasswordLabelText(){
        return elPasswordLabel.getText();
    }

    public void enterFirstName(String firstName){
        elFirstName.clear();
        elFirstName.sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        elLastName.clear();
        elLastName.sendKeys(lastName);
    }

    public void enterEmail(String email){
        elEmail.clear();
        elEmail.sendKeys(email);
        //Tab out to enable validation
        elEmail.sendKeys(Keys.TAB);
    }


    public void enterPassword(String password){
        elPassword.clear();
        elPassword.sendKeys(password);
        //Tab out to enable validation
        elEmail.sendKeys(Keys.TAB);
    }

    public void clickPrivacyCheckBox(){
        elPrivacyCheckBox.click();
    }

    public void clickOnSubmitButton(){
        elSubmitButton.click();
    }


    public String getConfirmationText(){
        return elRegistrationConfirmation.getText();
    }

    public String getEmailValidationText(){
        try {
            return elEmailValidationPrompt.getText();
        }
        catch (NoSuchElementException e){
            return "";
        }
    }

    public String getPasswordValidationText(){
        try {
            return elPasswordValidationPrompt.getText();
        }
        catch (NoSuchElementException e){
            return "";
        }
    }

    public Boolean isSubmitButtonEnabled(){
        return elSubmitButton.isEnabled();
    }

    public String getTermsOfAgreementUrl(){
        return elTermsOfAgreement.getAttribute("href");
    }

    public String getPrivacyStatementUrl() {
        return elPrivacyStatement.getAttribute("href");
    }

// //*[@id="landing-page-bucket"]/div/div[2]/div[2]/footer/div/button
// //*[@id="landing-page-bucket"]/div/div[2]/div[2]/div/div[5]/div/input
}


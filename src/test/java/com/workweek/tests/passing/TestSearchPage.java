package com.workweek.tests.passing;

import com.workweek.selenium.SignUpPage;
import com.ww.tooling.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by luisrueda on 1/30/19.
 */
public class TestSearchPage {

    private static WebDriver webDriver;
    HashMap<String, String> config;
    EmailRandomizer emailRandomizer;
    NameRandomizer nameRandomizer;
    PasswordRandomizer passwordRandomizer;
    URLvalidator urLvalidator;

    @Before
    public void setUp(){

        emailRandomizer = new EmailRandomizer();
        nameRandomizer = new NameRandomizer();
        passwordRandomizer = new PasswordRandomizer();
        urLvalidator = new URLvalidator();
        ChromeOptions options = new ChromeOptions();


        try {
            ConfigReader configReader = new ConfigReader("/properties.json");
            config = configReader.getConfig();
            System.setProperty(
                    "webdriver.chrome.driver", config.get("driver_location"));

            if (config.get("is_driver_headless").equals("true")){
                options.addArguments("headless");
            }

            webDriver = new ChromeDriver(options);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }

    @Test
    public void happyPath(){
            webDriver.navigate().to(config.get("registration_page"));
            SignUpPage signUpPage = new SignUpPage(webDriver);
            signUpPage.clickJoinAsIndividual();
            assertTrue(signUpPage.getFirstNameLabelText().contains("First Name"));
            assertTrue(signUpPage.getLasttNameLabelText().contains("Last Name"));
            assertTrue(signUpPage.getEmailLabelText().contains("Email"));
            assertTrue(signUpPage.getPasswordLabelText().contains("Password"));
            signUpPage.enterFirstName(nameRandomizer.generateRandomName(10));
            assertFalse(signUpPage.isSubmitButtonEnabled());
            signUpPage.enterLastName(nameRandomizer.generateRandomName(10));
            assertFalse(signUpPage.isSubmitButtonEnabled());
            signUpPage.enterEmail(emailRandomizer.generateRandomEmail(8));
            assertFalse(signUpPage.isSubmitButtonEnabled());
            assertTrue(signUpPage.getEmailValidationText().length() == 0);
            signUpPage.enterPassword(passwordRandomizer.generateRandomPassword(8, 1));
            assertFalse(signUpPage.isSubmitButtonEnabled());
            assertTrue(signUpPage.getPasswordValidationText().length() == 0);
            signUpPage.clickPrivacyCheckBox();
            assertTrue(signUpPage.isSubmitButtonEnabled());
            assertFalse(urLvalidator.isLinkBroken(signUpPage.getPrivacyStatementUrl()));
            assertFalse(urLvalidator.isLinkBroken(signUpPage.getTermsOfAgreementUrl()));

            signUpPage.clickOnSubmitButton();
            WebDriverWait wait = new WebDriverWait (webDriver, 15);
            wait.until(ExpectedConditions.titleIs(
                    config.get("registration_page_success_title")));
            String confirmationText = signUpPage.getConfirmationText();
            assertTrue(confirmationText.contains(
                    config.get("registration_page_success_text")));
    }

    @Test
    public void incorrectEmail() throws InterruptedException {
        webDriver.navigate().to(config.get("registration_page"));
        SignUpPage signUpPage = new SignUpPage(webDriver);
        signUpPage.clickJoinAsIndividual();
        signUpPage.enterEmail("xxxxx");
        assertTrue(signUpPage.getEmailValidationText().contains(
                config.get("registration_page_email_validation_text")));
    }

    @Test
    public void incorrectPassword() {
        webDriver.navigate().to(config.get("registration_page"));
        SignUpPage signUpPage = new SignUpPage(webDriver);
        signUpPage.clickJoinAsIndividual();
        signUpPage.enterPassword("xxxxx");
        assertTrue(signUpPage.getPasswordValidationText().contains(
                config.get("registration_page_password_validation_text")));
    }

    @Test
    public void longEmailField() {
        webDriver.navigate().to(config.get("registration_page"));
        SignUpPage signUpPage = new SignUpPage(webDriver);
        signUpPage.clickJoinAsIndividual();
        signUpPage.enterEmail(emailRandomizer.generateRandomEmail(77));
        assertTrue(signUpPage.getEmailValidationText().contains(
                config.get("registration_page_email_validation_text")));
    }

}
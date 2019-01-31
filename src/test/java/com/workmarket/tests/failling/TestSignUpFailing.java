package com.workmarket.tests.failling;

import com.workweek.selenium.SignUpPage;
import com.ww.tooling.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.util.HashMap;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

/**
 * Created by luisrueda on 1/30/19.
 */
public class TestSignUpFailing {

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
    public void largeFirstName() throws InterruptedException {
        webDriver.navigate().to(config.get("registration_page"));
        SignUpPage signUpPage = new SignUpPage(webDriver);
        signUpPage.clickJoinAsIndividual();
        signUpPage.enterFirstName(nameRandomizer.generateRandomName(70));
        signUpPage.enterLastName(nameRandomizer.generateRandomName(10));
        signUpPage.enterEmail(emailRandomizer.generateRandomEmail(8));
        signUpPage.enterPassword(passwordRandomizer.generateRandomPassword(8, 1));
        signUpPage.clickPrivacyCheckBox();
        assertTrue(signUpPage.isSubmitButtonEnabled());
        signUpPage.clickOnSubmitButton();
        Thread.sleep(Integer.parseInt(config.get("high_sleep")));
        throw new java.lang.Error(
                "Registration produces an error when Firstname has many chars." +
                        "Validation should not allow Submit button to be enabled.");

    }

    @Test
    public void digitsInFirstNameLastName() throws InterruptedException {
        webDriver.navigate().to(config.get("registration_page"));
        SignUpPage signUpPage = new SignUpPage(webDriver);
        signUpPage.clickJoinAsIndividual();
        signUpPage.enterFirstName("12345");
        signUpPage.enterLastName("12345");
        signUpPage.enterEmail(emailRandomizer.generateRandomEmail(8));
        signUpPage.enterPassword(passwordRandomizer.generateRandomPassword(8, 1));
        signUpPage.clickPrivacyCheckBox();
        assertTrue(signUpPage.isSubmitButtonEnabled());
        signUpPage.clickOnSubmitButton();
        sleep(5000);
        throw new java.lang.Error(
                "Registration was successful despite not having a valid name" +
                        "Validation should not allow Submit button to be enabled.");

    }


}
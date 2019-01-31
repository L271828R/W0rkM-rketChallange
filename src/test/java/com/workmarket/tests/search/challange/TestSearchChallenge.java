package com.workmarket.tests.search.challange;

import com.workweek.selenium.SearchPage;
import com.workweek.selenium.SearchPageLogin;
import com.workweek.selenium.SignUpPage;
import com.ww.tooling.*;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

/**
 * Created by luisrueda on 1/31/19.
 */
public class TestSearchChallenge {

    private static WebDriver webDriver;
    HashMap<String, String> config;
    WebDriverWait wait;

    @Before
    public void setUp(){

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
            wait = new WebDriverWait (webDriver, 15);

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
    public void RunSearchChallange () throws InterruptedException {

        int currentPage = 1;
        Integer searchTotalPages;

        webDriver.navigate().to(config.get("search_page_login"));
        SearchPageLogin searchPageLogin = new SearchPageLogin(webDriver);

        Thread.sleep(Integer.parseInt(config.get("low_sleep")));
        searchPageLogin.enterEmail(config.get("search_page_user"));
        searchPageLogin.enterPassword(config.get("search_page_password"));
        searchPageLogin.clickSubmit();

        wait.until(ExpectedConditions.titleIs(
                config.get("search_main_title")));

        SearchPage searchPage = new SearchPage(webDriver);
        searchPage.clickFindTalent();
        searchPage.enterTextSearchbar("test");
        searchPage.clickSearchbar();

        Thread.sleep(Integer.parseInt(config.get("high_sleep")));
        searchTotalPages = searchPage.getSearchTotal();

        List<WebElement> allProfileCards = searchPage.getAllProfileCards();
        Pattern p = Pattern.compile("test", Pattern.CASE_INSENSITIVE);


        while (currentPage <= searchTotalPages) {
            for (WebElement we : allProfileCards) {

                //System.out.println(we.getText());
                Matcher m = p.matcher(we.getText());
                    assertTrue("Could not find regex in page=" +
                            currentPage + "with text=" +
                            we.getText(), m.find());
            }
            searchPage.clickNext();
            Thread.sleep(Integer.parseInt(config.get("low_sleep")));
            currentPage = currentPage +1;

        }


    }

}

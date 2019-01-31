package com.workweek.selenium;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by luisrueda on 1/30/19.
 */
public class SearchPage extends PageObject{

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"wm-main-nav\"]/div/div[1]/div/div/div[2]/div[2]/a/div/div/div")
    private WebElement elFindTalent;

    @FindBy(xpath = "//*[@id=\"input-text\"]")
    private WebElement elSearchbar;


    @FindBy(xpath = "//*[@id=\"cart\"]/div[1]")
    private WebElement elSearchTotal;

    // class="profile-card"

    @FindAll(@FindBy(className="profile-card"))
    List<WebElement> allProfileCards;

    @FindBy(xpath = "//*[@id=\"cart\"]/div[1]/a[2]")
    private WebElement elNextButton;


    public void clickFindTalent(){
        elFindTalent.click();
    }


    public void enterTextSearchbar(String search){
        elSearchbar.sendKeys(search);
    }

    public void clickSearchbar(){
        elSearchbar.sendKeys(Keys.RETURN);
    }

    public Integer getSearchTotal(){
        return Integer.parseInt(elSearchTotal.getAttribute("data-max"));
    }

    public List<WebElement> getAllProfileCards(){
        return allProfileCards;
    }

    public void clickNext(){
        elNextButton.click();
    }

}

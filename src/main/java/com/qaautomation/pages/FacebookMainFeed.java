package com.qaautomation.pages;

import com.qaautomation.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Dmytro_Kapeliukh on 4/10/17.
 */
public class FacebookMainFeed extends BasePage{
    @FindBy(css = "[title^='Abraham LLincoln']")
    WebElement linkWelcomeName;

    public FacebookMainFeed(WebDriver driver) {
        super(driver);
    }

    public String getUserNameText(){
        return linkWelcomeName.getText();
    }
}

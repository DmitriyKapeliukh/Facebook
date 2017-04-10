package com.qaautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Dmytro_Kapeliukh on 4/10/17.
 */
public class FacebookMainFeed {
    @FindBy(css = "[title^='Abraham LLincoln']")
    WebElement linkWelcomeName;

    public String getUserNameText(){
        return linkWelcomeName.getText();
    }
}

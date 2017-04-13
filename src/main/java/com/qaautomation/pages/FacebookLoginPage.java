package com.qaautomation.pages;

import com.qaautomation.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Dmytro_Kapeliukh on 4/10/2017.
 */
public class FacebookLoginPage extends BasePage{

    public static final String PAGE_TITLE = "Войдите на Facebook, чтобы общаться с друзьями, родственниками и знакомыми.";
    public static final String PAGE_URL = "https://www.facebook.com.login.php";

    @FindBy(css = "._4rbf._53ij")
    WebElement errorHeader;

    public FacebookLoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkErrorHeader(String text){
        try {
            String check = errorHeader.getText();
            return errorHeader.getText().equals(text);
        }catch (NoSuchElementException e){
            return false;
        }
    }
}

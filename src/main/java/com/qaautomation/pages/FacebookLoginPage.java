package com.qaautomation.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Dmytro_Kapeliukh on 4/10/2017.
 */
public class FacebookLoginPage {

    public static final String PAGE_TITLE = "Войдите на Facebook, чтобы общаться с друзьями, родственниками и знакомыми.";
    public static final String PAGE_URL = "https://www.facebook.com.login.php";

    @FindBy(css = "._4rbf._53ij")
    WebElement errorHeader;

    public boolean checkErrorHeader(String text){
        try {
            String check = errorHeader.getText();
            return errorHeader.getText().equals(text);
        }catch (NoSuchElementException e){
            return false;
        }
    }
}

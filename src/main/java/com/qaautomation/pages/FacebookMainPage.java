package com.qaautomation.pages;

import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Dmytro_Kapeliukh on 4/9/17.
 */
public class FacebookMainPage {

    public static final String PAGE_TITLE = "Добро пожаловать на Фейсбук - заходите, регистрируйтесь и находите друзей.";
    public static final String PAGE_URL = "https://www.facebook.com";

    @FindBy(id = "email")
    WebElement fieldEmailLogin;

    @FindBy(id = "pass")
    WebElement filedPasswordLogin;

    @FindBy(id = "u_0_q")
    WebElement buttonLogin;

/*    String fieldEmailLogin = "#email";
    String filedPasswordLogin = "#pass";*/
    WebDriver driver;

    public FacebookMainPage(WebDriver driver){
        this.driver = driver;
    }

    public void setTextEmailLogin (String text){
        //WebElement element = driver.findElement(By.cssSelector(fieldEmailLogin));
        //element.sendKeys(text);
        fieldEmailLogin.sendKeys(text);
        Assert.assertEquals(fieldEmailLogin.getAttribute("value"), text);
    }

    public void setTextPasswordLogin (String text){
        //WebElement element = driver.findElement(By.cssSelector(filedPasswordLogin));
        //element.sendKeys(text);
        filedPasswordLogin.sendKeys(text);
        Assert.assertEquals(filedPasswordLogin.getAttribute("value"), text);
    }

    public void clickLoginMain(){
        buttonLogin.click();
    }
}

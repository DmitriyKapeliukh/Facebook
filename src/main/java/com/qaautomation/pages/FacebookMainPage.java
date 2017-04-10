package com.qaautomation.pages;

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

    String fieldEmailLogin = "#email";
    String filedPasswordLogin = "#pass";
    WebDriver driver;

    public FacebookMainPage(WebDriver driver){
        this.driver = driver;
    }

    public void setTextEmailLogin (String text){
        WebElement element = driver.findElement(By.cssSelector(fieldEmailLogin));
        element.sendKeys(text);
        Assert.assertEquals(element.getAttribute("value"), text);
    }

    public void setTextPasswordLogin (String text){
        WebElement element = driver.findElement(By.cssSelector(filedPasswordLogin));
        element.sendKeys(text);
        Assert.assertEquals(element.getAttribute("value"), text);
    }
}

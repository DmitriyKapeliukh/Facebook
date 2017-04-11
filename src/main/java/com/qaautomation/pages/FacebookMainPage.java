package com.qaautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

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

    @FindBy(name = "firstname")
    WebElement filedFirstNameSignUp;

    @FindBy(name = "lastname")
    WebElement fieldLastNameSignUp;

    @FindBy(name = "reg_email__")
    WebElement fieldEmailMobileSignUp;

    @FindBy(name = "reg_email_confirmation__")
    WebElement filedReenterEmailMobileSignUp;

    @FindBy(name = "reg_passwd__")
    WebElement fieldPasswordSignUp;

    @FindBy(id = "day")
    WebElement dropdownDay;

    @FindBy(id = "month")
    WebElement dropdownMonth;

    @FindBy(id = "year")
    WebElement dropdownYear;

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

    public void setTextFirstNameField(String text){
        filedFirstNameSignUp.sendKeys(text);
        Assert.assertEquals(filedFirstNameSignUp.getAttribute("value"), text);
    }

    public void setTextLastNameField(String text){
        fieldLastNameSignUp.sendKeys(text);
        Assert.assertEquals(fieldLastNameSignUp.getAttribute("value"), text);
    }

    public void setTextEmailMobileField(String text){
        fieldEmailMobileSignUp.sendKeys(text);
        Assert.assertEquals(fieldEmailMobileSignUp.getAttribute("value"), text);
    }

    public void setTextReenterEmailMobileField(String text){
        filedReenterEmailMobileSignUp.sendKeys(text);
        Assert.assertEquals(filedReenterEmailMobileSignUp.getAttribute("value"), text);
    }

    public void setTextPasswordField(String text){
        fieldPasswordSignUp.sendKeys(text);
        Assert.assertEquals(fieldPasswordSignUp.getAttribute("value"), text);
    }

    public void selectDay(String value){
        Select select = new Select(dropdownDay);
        select.selectByValue(value);
    }

    public void selectMonth(String value){
        Select select = new Select(dropdownMonth);
        select.selectByValue(value);
    }

    public void selectYear(String value){
        Select select = new Select(dropdownYear);
        select.selectByValue(value);
    }
}

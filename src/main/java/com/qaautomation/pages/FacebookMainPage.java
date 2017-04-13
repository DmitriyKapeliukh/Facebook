package com.qaautomation.pages;

import com.qaautomation.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

/**
 * Created by Dmytro_Kapeliukh on 4/9/17.
 */
public class FacebookMainPage extends BasePage{

    @FindBy(id = "email")
    WebElement fieldEmailLogin;

    @FindBy(id = "pass")
    WebElement fieldPasswordLogin;

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

    @FindBy(css = "#u_0_h")
    WebElement radioMale;

    @FindBy(css = "#u_0_l")
    WebElement buttonSignUp;

    public FacebookMainPage(WebDriver driver){
        super(driver);
        this.PAGE_TITLE = "Добро пожаловать на Фейсбук - заходите, регистрируйтесь и находите друзей.";
        this.PAGE_URL = "https://www.facebook.com";
    }

    public void login(String email, String password){
        wait.until(ExpectedConditions.elementToBeClickable(fieldEmailLogin));
        setTextEmailLogin(email);
        setTextPasswordLogin(password);
        clickLoginMain();
    }

    public void setTextEmailLogin (String text){
        setElementText(fieldEmailLogin, text);
    }

    public void setTextPasswordLogin (String text){
        setElementText(fieldPasswordLogin, text);
    }

    public void clickLoginMain(){
        clickElement(buttonLogin);
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
        selectValueInDropDown(dropdownDay, value);
/*        Select select = new Select(dropdownDay);
        select.selectByValue(value);*/
    }

    public void selectMonth(String value){
        selectValueInDropDown(dropdownMonth, value);
/*        Select select = new Select(dropdownMonth);
        select.selectByValue(value);*/
    }

    public void selectYear(String value){
        selectValueInDropDown(dropdownYear, value);
/*        Select select = new Select(dropdownYear);
        select.selectByValue(value);*/
    }

    public void clickRadioMale(){
        clickElement(radioMale);
    }

    public void clickSignUpButton(){
        clickElement(buttonSignUp);
    }
}

package com.qaautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by Dmytro_Kapeliukh on 4/12/2017.
 */
public class BasePage {

    public WebDriver driver;
    public String PAGE_URL;
    public String PAGE_TITLE;
    public WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    public void loadPage(){
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(getPAGE_URL());
//        Assert.assertEquals(driver.getTitle(), getPAGE_TITLE());
    }

    public void clickElement(WebElement element){
        element.click();
    }

    public void setElementText(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
        Assert.assertEquals(element.getAttribute("value"), text);
    }

    public void selectValueInDropDown(WebElement dropdown, String value){
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    public String getPAGE_URL(){
        return PAGE_URL;
    }

    public String getPAGE_TITLE(){
        return PAGE_TITLE;
    }
}

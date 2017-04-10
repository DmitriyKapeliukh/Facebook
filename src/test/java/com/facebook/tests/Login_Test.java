package com.facebook.tests;

import com.gargoylesoftware.htmlunit.util.StringUtils;
import com.qaautomation.data.FacebookData;
import com.qaautomation.pages.FacebookLoginPage;
import com.qaautomation.pages.FacebookMainPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.commons.*;

/**
 * Created by Dmytro_Kapeliukh on 4/8/17.
 */
public class Login_Test {
    public WebDriver driver;
    FacebookMainPage fbMainPage;
    FacebookLoginPage fbLoginPage;

    @BeforeClass (alwaysRun = true)
    public void setup() {
        this.driver = new FirefoxDriver();
        //fbMainPage = new FacebookMainPage(driver);
        fbMainPage = PageFactory.initElements(driver, FacebookMainPage.class);
        fbLoginPage = PageFactory.initElements(driver, FacebookLoginPage.class);
    }

    @AfterClass (alwaysRun = true)
    public void teardown() throws InterruptedException {
        Thread.sleep(3000L);
        this.driver.quit();
    }

    @Test (groups = {"p1", "pageLoad"})
    public void loadPage() {
        driver.get(fbMainPage.PAGE_URL);
        Assert.assertEquals(driver.getTitle(), fbMainPage.PAGE_TITLE);
    }

    @Test(groups = {"p2", "field"}, dependsOnMethods = "loadPage")
    public void fillOutEmailFld() {
        fbMainPage.setTextEmailLogin("testuser@gmail.com");
    }

    @Test(groups = {"p2", "filed"}, dependsOnMethods = {"fillOutEmailFld", "loadPage"})
    public void fillOutPassFld() {
        fbMainPage.setTextPasswordLogin("123456");
    }

    @Test(groups = {"p1"}, dataProviderClass = FacebookData.class, dataProvider = "login")
    public void testLoginMainPage(String email, String password, String errorType){
        driver.get(fbMainPage.PAGE_URL);
        Assert.assertEquals(driver.getTitle(), fbMainPage.PAGE_TITLE);
        fbMainPage.setTextEmailLogin(email);
        fbMainPage.setTextPasswordLogin(password);
        fbMainPage.clickLoginMain();

        if (StringUtils.isBlank)
        Assert.assertEquals(driver.getTitle(), "Facebook");
    }
}

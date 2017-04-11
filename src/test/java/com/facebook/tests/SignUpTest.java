package com.facebook.tests;

import com.qaautomation.pages.FacebookMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Dmytro_Kapeliukh on 4/11/2017.
 */
public class SignUpTest {
    public WebDriver driver;
    FacebookMainPage fbMainPage;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        this.driver = new FirefoxDriver();
        fbMainPage = PageFactory.initElements(driver, FacebookMainPage.class);
    }

    @AfterClass(alwaysRun = true)
    public void teardown() throws InterruptedException {
        Thread.sleep(3000L);
        this.driver.quit();
    }

    @Test(groups = "p1")
    public void testSignUpMainPage(){
        driver.manage().deleteAllCookies();
        driver.get(fbMainPage.PAGE_URL);
        Assert.assertEquals(driver.getTitle(), fbMainPage.PAGE_TITLE);
        fbMainPage.setTextFirstNameField("QA");
        fbMainPage.setTextLastNameField("Automan");
        fbMainPage.setTextEmailMobileField("validEmail@facebook.com");
        fbMainPage.setTextReenterEmailMobileField("validEmail@facebook.com");
        fbMainPage.setTextPasswordField("password");
    }
}

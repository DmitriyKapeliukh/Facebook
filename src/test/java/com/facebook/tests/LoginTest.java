package com.facebook.tests;

import com.qaautomation.data.FacebookData;
import com.qaautomation.pages.FacebookLoginPage;
import com.qaautomation.pages.FacebookMainFeed;
import com.qaautomation.pages.FacebookMainPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Dmytro_Kapeliukh on 4/8/17.
 */
public class LoginTest {
    public WebDriver driver;
    FacebookMainPage fbMainPage;
    FacebookLoginPage fbLoginPage;
    FacebookMainFeed fbMainFeed;

    @BeforeClass (alwaysRun = true)
    public void setup() {
        this.driver = new FirefoxDriver();
        //fbMainPage = new FacebookMainPage(driver);
        fbMainPage = PageFactory.initElements(driver, FacebookMainPage.class);
        fbLoginPage = PageFactory.initElements(driver, FacebookLoginPage.class);
        fbMainFeed = PageFactory.initElements(driver, FacebookMainFeed.class);
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
    public void testLoginMainPage(String email, String password, String isError) {
        driver.manage().deleteAllCookies();
        driver.get(fbMainPage.PAGE_URL);
        Assert.assertEquals(driver.getTitle(), fbMainPage.PAGE_TITLE);
        fbMainPage.setTextEmailLogin(email);
        fbMainPage.setTextPasswordLogin(password);
        fbMainPage.clickLoginMain();

        if (!StringUtils.isBlank(isError)) {
            boolean result = fbLoginPage.checkErrorHeader(isError);
            Assert.assertTrue(result, "Expected error: " + isError);
        } else {
            Assert.assertTrue(!fbMainFeed.getUserNameText().isEmpty());
        }
    }
}

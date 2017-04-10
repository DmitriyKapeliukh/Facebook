package com.facebook.tests;

import com.qaautomation.pages.FacebookMainPage;
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

/**
 * Created by Dmytro_Kapeliukh on 4/8/17.
 */
public class Login_Test {
    public WebDriver driver;
    FacebookMainPage fbMainPage;

    @BeforeClass (alwaysRun = true)
    public void setup() {
        this.driver = new FirefoxDriver();
        fbMainPage = new FacebookMainPage(driver);

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
}

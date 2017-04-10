package com.facebook.tests;

import com.qaautomation.data.FacebookData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Dmytro_Kapeliukh on 4/9/17.
 */
public class Login_Test_DataProvider {
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver();

    }

    @AfterClass(alwaysRun = true)
    public void teardown() throws InterruptedException {
        Thread.sleep(3000L);
        driver.quit();
    }

    @Test(groups = {"p1", "pageLoad"}, dataProvider = "pages", dataProviderClass = FacebookData.class)
    public void loadPage(String url, String title) {
        driver.get(url);
        Assert.assertEquals(driver.getTitle(), title);
    }

    @Test(groups = {"p2", "field"}, dependsOnMethods = "loadPage")
    public void fillOutEmailFld() {
        String email = "testuser@gmail.com";
        WebElement emailFld = driver.findElement(By.cssSelector("#email"));
        emailFld.sendKeys(email);
        Assert.assertEquals(emailFld.getAttribute("value"), email);
    }

    @Test(groups = {"p2", "filed"}, dependsOnMethods = {"fillOutEmailFld", "loadPage"})
    public void fillOutPassFld() {
        String password = "123456";
        WebElement passwordFld = driver.findElement(By.cssSelector("#pass"));
        passwordFld.sendKeys(password);
        Assert.assertEquals(passwordFld.getAttribute("value"), password);
    }
}

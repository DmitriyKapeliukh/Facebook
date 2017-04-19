package com.facebook.tests;

import com.qaautomation.pages.FacebookMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;

/**
 * Created by Dmytro_Kapeliukh on 4/11/2017.
 */
public class SignUpTest {
    public WebDriver driver;
    public WebDriverWait wait;
    FacebookMainPage fbMainPage;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        this.driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 5); //explicitly wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //implicitly wait
        fbMainPage = PageFactory.initElements(driver, FacebookMainPage.class);
    }

    @AfterClass(alwaysRun = true)
    public void teardown() throws InterruptedException {
        sleep(6000L);
        this.driver.quit();
    }

    @Test(groups = "p1")
    public void testSignUpMainPage(){
        driver.manage().deleteAllCookies();

        fbMainPage.loadPage();
        fbMainPage.setTextFirstNameField("QA");
        fbMainPage.setTextLastNameField("Automan");
        fbMainPage.setTextEmailMobileField("validEmail@qaautoman.com");
        fbMainPage.setTextReenterEmailMobileField("validEmail@qaautoman.com");
        fbMainPage.setTextPasswordField("password");

        fbMainPage.selectDay("5");
        fbMainPage.selectMonth("12");
        fbMainPage.selectYear("1988");
        fbMainPage.clickRadioMale();
        fbMainPage.clickSignUpButton();
    }
}

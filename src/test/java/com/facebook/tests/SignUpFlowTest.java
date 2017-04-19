package com.facebook.tests;

import com.qaautomation.data.FacebookData;
import com.qaautomation.pages.FacebookMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dmytro_Kapeliukh on 4/19/17.
 */
public class SignUpFlowTest {
    public WebDriver driver;
    public WebDriverWait wait;
    FacebookMainPage fbMainPage;

    HashMap<String, String> signUpMap;

    @Factory(dataProvider = "signup", dataProviderClass = FacebookData.class)
    public SignUpFlowTest(String first, String last, String email){
        signUpMap = new HashMap<String, String>();
        signUpMap.put("firstname", first);
        signUpMap.put("lastname", last);
        signUpMap.put("email", email);

    }

    @BeforeClass(alwaysRun = true)
    public void setup(){
        this.driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 5); //explicitly wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //implicitly wait
        fbMainPage = PageFactory.initElements(driver, FacebookMainPage.class);
    }

    @AfterClass(alwaysRun = true)
    public void teardown() throws InterruptedException {
        Thread.sleep(6000L);
        this.driver.quit();
    }

    @Test
    public void loadSignUpMainPage(){
        fbMainPage.loadPage();
        driver.manage().deleteAllCookies();
    }

    @Test(dependsOnMethods = "loadSignUpMainPage")
    public void signUpMainPageFirstNameField(){
        fbMainPage.setTextFirstNameField(signUpMap.get("firstname"));
    }

    @Test(dependsOnMethods = "signUpMainPageFirstNameField")
    public void signUpMainPageLastNameField(){
        fbMainPage.setTextLastNameField(signUpMap.get("lastname"));
    }

    @Test(dependsOnMethods = "signUpMainPageLastNameField")
    public void signUpMainPageMobileFone(){
        fbMainPage.setTextEmailMobileField(signUpMap.get("email"));
    }

}

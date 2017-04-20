package com.facebook.tests;

import com.qaautomation.data.FacebookData;
import com.qaautomation.pages.FacebookLoginPage;
import com.qaautomation.pages.FacebookMainFeed;
import com.qaautomation.pages.FacebookMainPage;
import com.qaautomation.utilites.DriverFactory;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static com.qaautomation.utilites.DriverFactory.getWebDriver;
import static org.openqa.selenium.support.PageFactory.initElements;
import static org.testng.Assert.assertTrue;

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
        this.driver = getWebDriver(DriverFactory.getBrowserTypeByProperty());
        //fbMainPage = new FacebookMainPage(driver);
        fbMainPage = initElements(driver, FacebookMainPage.class);
        fbLoginPage = initElements(driver, FacebookLoginPage.class);
        fbMainFeed = initElements(driver, FacebookMainFeed.class);
    }

    @AfterClass (alwaysRun = true)
    public void teardown() throws InterruptedException {
        Thread.sleep(3000L);
        this.driver.quit();
    }
    @Parameters({"browserType"})
    @Test (groups = {"p1", "pageLoad"})
    public void loadPage(@Optional("Firefox") String browserType) {
        fbMainPage.loadPage();
        System.out.println("Browser: "+browserType);
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
        fbMainPage.loadPage();
        fbMainPage.login(email, password);

        if (!StringUtils.isBlank(isError)) {
            boolean result = fbLoginPage.checkErrorHeader(isError);
            assertTrue(result, "Expected error: " + isError);
        } else {
            assertTrue(!fbMainFeed.getUserNameText().isEmpty());
        }
    }
}

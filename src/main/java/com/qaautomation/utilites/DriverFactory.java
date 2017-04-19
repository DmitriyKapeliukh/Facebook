package com.qaautomation.utilites;

import junitx.util.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Dmytro_Kapeliukh on 4/19/17.
 */
public class DriverFactory {
    public enum BrowserType{
        FIREFOX("firefox"),
        CHROME("chrome"),
        IE("internet_explorer"),
        SAFARI("safari");

        private String value;

        BrowserType(String value){
            this.value = value;
        }

        public String getBrowserName(){
            return this.value;
        }
    }

    public static WebDriver getWebDriver(BrowserType type){
        WebDriver driver = null;
        switch (type){
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "/Users/Dmytro_Kapeliukh/Selenium storage/chromedriver");
                driver = new ChromeDriver();
                break;
            default:
                driver = new FirefoxDriver();
                break;
        }
        return driver;
    }

    public static BrowserType getBrowserTypeByProperty(){
        BrowserType type = null;
        String browsername = PropertyManager.getProperty("BROWSER");
        for (BrowserType btype : BrowserType.values()){
            if (btype.getBrowserName().equalsIgnoreCase(browsername)){
                type = btype;
                System.out.println("BROWSER "+type.getBrowserName());
            }
        }
        return type;
    }
}

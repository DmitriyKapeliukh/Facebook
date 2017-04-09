import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmytro_Kapeliukh on 4/7/2017.
 */
public class FirstTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("http://facebook.com");
        WebElement textbox = driver.findElement(By.cssSelector("#email"));
        textbox.sendKeys("MY LOGIN NAME");

        WebElement forgotLink = driver.findElement(By.cssSelector("#login_form tr:nth-child(3)>td:nth-child(2)>div>a"));
        forgotLink.click();

        Thread.sleep(2000L);

        driver.get("http://amazon.com");
        String url = driver.getCurrentUrl();
        System.out.println(url);
        String title = driver.getTitle();
        System.out.println(title);
        List<WebElement> navButtons = driver.findElements(By.cssSelector(".nav-line-2"));
        for (WebElement button : navButtons){
            System.out.println(button.getText());
        }

        WebElement accountDD = driver.findElement(By.cssSelector("#nav-link-accountList>.nav-line-2>.nav-icon.nav-arrow"));
        accountDD.click();
        driver.close();
    }
}

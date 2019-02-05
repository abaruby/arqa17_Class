import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OpenFirefoxBrowser {

    WebDriver wd;
    @BeforeClass

    public void setUp(){
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
    }

    @Test
    public void testeBaySearch(){
        //open site
        openSite();
        type();
        clickSearchButton();
    }

    @Test
    public void testeBayFilter(){
        openSite();
        type();
        clickSearchButton();
        filterItems();
    }

    public void filterItems() {
        wd.findElement(By.linkText("Auction")).click();
    }


    public void clickSearchButton() {
        wd.findElement(By.id("gh-btn")).click();
    }

    public void type() {
        wd.findElement(By.id("gh-ac")).click();
        wd.findElement(By.id("gh-ac")).clear();
        wd.findElement(By.id("gh-ac")).sendKeys("glasses");
    }

    public void openSite() {
        wd.get("https://www.ebay.com/");
    }


    @AfterClass
    public void tearDown() throws InterruptedException {
        wd.quit();
    }
}

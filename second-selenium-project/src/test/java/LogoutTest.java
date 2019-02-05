import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.isUserLoggedIn()) ;
        app.login();
    }


    @Test
    public void testLogout() throws InterruptedException {
        Thread.sleep(5000);
        app.clickOnAvatar();
        app.clickOnLogOutButton();
        Assert.assertFalse(app.isUserLoggedIn());
    }




}

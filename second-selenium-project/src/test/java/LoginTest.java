import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void testLogin() {
        app.clickOnLoginButton();
        app.fillLoginForm();
        app.confirmLogin();

    }

}

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.isUserLoggedIn()) {
            app.login();
        }
    }
    @Test
    public void teamCreationFromLeftNavMenu(){
        app.clickOnCreateTeamButtonOnNavMenu();
        app.fillTeamCreationForm("New Team QA17_2", "Write Description");
        app.submitTeamCreationForm();
    }

}
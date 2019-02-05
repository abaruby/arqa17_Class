import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.isUserLoggedIn()) {
            app.login();
        }
    }

    @Test
    public void boardCreationTestHeaderRightButton() throws InterruptedException {
        Thread.sleep(5000);
        app.clickOnHeaderAddButton();
        app.selectCreateBoardFromList();
        app.fillCreateBoardForm("TestBoardQA17_AR");
        app.selectTeamFromList();
        app.selectAccessLevel();
        app.selectBackground();
        app.confirmCreateBoard();

    }
}

package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeleteTest extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getSessionHelper().isUserLoggedIn()) {
            app.getSessionHelper().login();
        }
    }

//    public void ensureObjectExist(){
//        if(!app.getBoardHelper().isObjectExist()){
//            app.getBoardHelper().clickTheCreateNewBoardOnTheEndOfList();
//        }
//    }

    @Test
    public void boardDelete(){
        int before = app.getBoardHelper().NewTeamLenaQA17();

        app.getBoardHelper().selectBoardForDelete();
        app.getBoardHelper().selectDeleteOptionFromMenu();

        int after = app.getBoardHelper().NewTeamLenaQA17();

        Assert.assertEquals(after, before-1);

    }
}

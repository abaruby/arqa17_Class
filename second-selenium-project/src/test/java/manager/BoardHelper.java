package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BoardHelper extends  HelperBase {

    public BoardHelper(WebDriver wd) {
        super(wd);

    }

    public void clickTheCreateNewBoardOnTheEndOfList() {
        WebElement personalBoards = wd.findElement(By.xpath("//*[@class='icon-lg icon-member']/../../.."));
        int boardsCount = personalBoards.findElements(By.xpath(".//*[@class='boards-page-board-section-list-item']")).size();
        personalBoards.findElement(By.xpath(".//*[@class='boards-page-board-section-list-item']["+(boardsCount)+"]")).click();

    }

    public int PersonalBoardsCount(){
        WebElement personalBoards =
                wd.findElement(By.xpath("//*[@class='icon-lg icon-member']/../../.."));
        return
                personalBoards.findElements(By.xpath(".//*[@class='boards-page-board-section-list-item']")).size()-1;
    }

    public int NewTeamLenaQA17(){
        WebElement personalBoards =
                wd.findElement(By.xpath("//span[@class='icon-lg icon-member']/following::ul[@class='boards-page-board-section-list'][17]"));
        return
                personalBoards.findElements(By.xpath(".//*[@class='boards-page-board-section-list-item']")).size()-1;
    }

    public void addBoardTitle(String boardName) {
        type(By.cssSelector("input.subtle-input"), boardName);
    }

    public void clickTheCreateButton() {
        click(By.cssSelector("[type=submit]"));
    }

    public void selectCreateBoard() {
        click(By.cssSelector(".js-new-board"));
    }

    public void selectBoardForDelete(){

        click(By.xpath("//div[@title='TestBoardQA17_AR']"));
    }
    public void selectDeleteOptionFromMenu(){
        click(By.xpath("//a[contains(@class,'js-open-more')]"));
        click(By.xpath("//a[contains(@class,'js-close-board')]"));
        click(By.cssSelector("input[value=Close]"));
        click(By.cssSelector("a[class='quiet js-delete']"));
        click(By.cssSelector("input[type='submit']"));

    }


}
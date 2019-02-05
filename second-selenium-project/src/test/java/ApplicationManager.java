import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;

    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        openSite("https://trello.com/");
    }

    public void clickOnLoginButton() {

        click(By.className("header-button-secondary"));
    }

    protected void fillLoginForm() {
        type(By.cssSelector("input[type=email]"), "elena.telran@yahoo.com");
        type(By.cssSelector("input[type=password]"), "12345.com");

    }

    private void type(By locator, String text) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void confirmLogin() {
        click(By.cssSelector("#login"));
    }

    public void openSite(String url) {
        wd.get(url);
    }

    public void login() {

        clickOnLoginButton();
        fillLoginForm();
        confirmLogin();
    }

    public void stop() {
        wd.quit();
    }

    public boolean isUserLoggedIn() {

        return isElementPresent(By.cssSelector("img.member-avatar"));
    }

    public boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private void click(By locator) {
        wd.findElement(locator).click();
    }

    public void clickOnAvatar() {

        wd.findElement(By.cssSelector("img.member-avatar")).click();
    }

    public void clickOnLogOutButton() {

        wd.findElement(By.cssSelector("a.js-logout")).click();
    }

    public void clickOnCreateTeamButtonOnNavMenu() {
        click(By.cssSelector("[data-test-id='home-navigation-create-team-button']"));
    }

    public void fillTeamCreationForm(String teamName, String description) {
        type(By.id("org-display-name"), teamName);
        type(By.id("org-desc"), description);

    }

    public void submitTeamCreationForm() {
        click(By.xpath("//*[@value='Create']"));
    }

    public void clickOnHeaderAddButton() {
        click(By.xpath("//a[@aria-label='Create Board or Organization']"));
    }

    public void selectCreateBoardFromList() {
        click(By.cssSelector("a.js-new-board"));
    }

    public void fillCreateBoardForm(String boardTitle) {
        type(By.cssSelector("input[placeholder='Add board title']"), boardTitle);
    }

    public void selectTeamFromList() {
        click(By.cssSelector("button[class='subtle-chooser-trigger unstyled-button org-chooser-trigger']"));
        click(By.xpath("//div[contains(text(),'New Team Lena QA17')]"));
    }

    public void selectAccessLevel() {
        click(By.cssSelector("button.subtle-chooser-trigger.unstyled-button.vis-chooser-trigger"));
        click(By.xpath("//span[contains(text(),'Private')]"));

    }

    public void selectBackground() {
        click(By.xpath("//button[contains(@style,'1549323783-f85bb2fedde4')]"));

    }

    public void confirmCreateBoard() {
        click(By.xpath("//span[contains(text(),'Create Board')]"));
    }
}

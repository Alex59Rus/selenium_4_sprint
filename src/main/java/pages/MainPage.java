package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By; //импортировали класс By
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static configuration.BrowserConfig.HOST;

public class MainPage {

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public final By dropDownFields = By.xpath(".//div[@class='accordion__button']");
    public final By dropDownText = By.xpath(".//div[@class='accordion__panel']/p");
    private final By orderButtonHeader = By.xpath(".//button[@class='Button_Button__ra12g']");
    private final By orderButtonBottom = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public void openPage() {
        driver.get(HOST);
    }

    public void waitUntilTextIsVisible(int answerId) {
        WebElement element = driver.findElements(dropDownText).get(answerId);
        new WebDriverWait(driver, Duration.ofSeconds(8)).until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollDownToDropDown() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElements(dropDownFields).get(7));
    }

    public void scrollDownToOrderButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(orderButtonBottom));
    }

    public void clickQuestionByID(int questionID) {
        driver.findElements(dropDownFields).get(questionID).click();
    }

    public String getQuestionTextByID(int questionID) {
        return driver.findElements(dropDownFields).get(questionID).getText();
    }

    public String getAnswerTextByID(int questionID) {
        clickQuestionByID(questionID);
        waitUntilTextIsVisible(questionID);
        return driver.findElements(dropDownText).get(questionID).getText();
    }

    public int getQuestionsCount() {
        return driver.findElements(dropDownFields).size();
    }

    public void clickOrderButtonHeader() {
        driver.findElement(orderButtonHeader).click();
    }

    public void clickOrderButtonBottom() {
        driver.findElement(orderButtonBottom).click();
    }

    public void waitPage() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

}



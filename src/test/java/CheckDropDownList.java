import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckDropDownList {
    DropDownListItems dropDownListItems = new DropDownListItems();
    PageElements item = new PageElements();
    WebDriver driver = new ChromeDriver();

    void delay() throws InterruptedException {
        Thread.sleep(500);
    }

    @Before
    public void openBrowserAndScroll() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        WebElement element = driver.findElement(item.dropDownFourthElement);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    @After
    public void quitBrowser() {
        driver.quit();
    }
    @Test
    public void expandingFirstElement() throws InterruptedException {
        driver.findElement(item.dropDownFirstElement).click();
        delay();
        assertThat(driver.findElement(item.dropDownFirstElementText).getText(),is(dropDownListItems.firstDropDownItem));
    }
    @Test
    public void expandingSecondElement() throws InterruptedException {
        driver.findElement(item.dropDownSecondElement).click();
        delay();
        assertThat(driver.findElement(item.dropDownSecondElementText).getText(),is(dropDownListItems.secondDropDownItem));
    }
    @Test
    public void expandingThirdElement() throws InterruptedException {
        driver.findElement(item.dropDownThirdElement).click();
        delay();
        assertThat(driver.findElement(item.dropDownThirdElementText).getText(),is(dropDownListItems.thirdDropDownItem));
    }
    @Test
    public void expandingFourthElement() throws InterruptedException {
        driver.findElement(item.dropDownFourthElement).click();
        delay();
        assertThat(driver.findElement(item.dropDownFourthElementText).getText(),is(dropDownListItems.fourthDropDownItem));
    }
    @Test
    public void expandingFifthElement() throws InterruptedException {
        driver.findElement(item.dropDownFifthElement).click();
        delay();
        assertThat(driver.findElement(item.dropDownFifthElementText).getText(),is(dropDownListItems.fifthDropDownItem));
    }
    @Test
    public void expandingSixthElement() throws InterruptedException {
        driver.findElement(item.dropDownSixthElement).click();
        delay();
        assertThat(driver.findElement(item.dropDownSixthElementText).getText(),is(dropDownListItems.sixthDropDownItem));
    }
    @Test
    public void expandingSeventhElement() throws InterruptedException {
        driver.findElement(item.dropDownSeventhElement).click();
        delay();
        assertThat(driver.findElement(item.dropDownSeventhElementText).getText(),is(dropDownListItems.seventhDropDownItem));
    }
    @Test
    public void expandingEightElement() throws InterruptedException {
        driver.findElement(item.dropDownEightElement).click();
        delay();
        assertThat(driver.findElement(item.dropDownEightElementText).getText(),is(dropDownListItems.eightDropDownItem));
    }

}

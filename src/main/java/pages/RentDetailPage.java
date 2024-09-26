package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RentDetailPage {
    WebDriver driver;

    public RentDetailPage(WebDriver driver){
        this.driver = driver;
    }

    private final By datePlaceHolder = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By rentalPeriodPlaceHolder = By.xpath(".//div[@class='Dropdown-placeholder' and text()='* Срок аренды']");
    private final By orderComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By accessOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    public final String successExpectation = "Заказ оформлен";
    private final By windowSuccess = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");


    public void inputDate(String date) {
        driver.findElement(datePlaceHolder).click();
        driver.findElement(By.xpath(".//div[text()='" + date + "']")).click();
    }

    public void inputRentalPeriod(String rentPeriod) {
        driver.findElement(rentalPeriodPlaceHolder).click();
        WebElement rentPeriodScroll = driver.findElement(By.xpath(".//div[text()='" + rentPeriod + "']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", rentPeriodScroll);
        driver.findElement(By.xpath(".//div[text()='" + rentPeriod + "']")).click();
    }

    public void inputColor(String color) {
        driver.findElement(By.id(color)).click();
    }

    public void inputComment(String comment) {
        driver.findElement(orderComment).click();
        driver.findElement(orderComment).sendKeys(comment);
    }

    public void pushOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void accessOrder() {
        driver.findElement(accessOrderButton).click();
    }
    public boolean orderResultIsDisplayed() {
        return (!driver.findElements(windowSuccess).isEmpty());
    }

    public String getOrderResultText() {
        return driver.findElement(windowSuccess).getText();
    }
}

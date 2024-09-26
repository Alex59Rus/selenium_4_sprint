package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserInfoPage {
    private final WebDriver driver;

    public UserInfoPage(WebDriver driver){
        this.driver = driver;
    }

    public final By namePlaceHolder = By.xpath(".//input[@placeholder='* Имя']");
    public final By surnamePlaceHolder = By.xpath(".//input[@placeholder='* Фамилия']");
    public final By addressPlaceHolder = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    public final By stationPlaceHolder = By.xpath(".//div[@class='Order_Form__17u6u']//div[@class='select-search__value']");
    public final By phonePlaceHolder = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    public final By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");


    public void inputName(String name) {
        driver.findElement(namePlaceHolder).sendKeys(name);
    }

    public void inputSurname(String surname) {
        driver.findElement(surnamePlaceHolder).sendKeys(surname);
    }

    public void inputAddress(String address) {
        driver.findElement(addressPlaceHolder).sendKeys(address);
    }

    public void choiceStation(String nameStation) {
        driver.findElement(stationPlaceHolder).click();
        driver.findElement(By.xpath(String.format(".//div[text()='%s']/parent::button",nameStation))).click();
    }


    public void inputPhone(String phone) {
        driver.findElement(phonePlaceHolder).sendKeys(phone);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
}

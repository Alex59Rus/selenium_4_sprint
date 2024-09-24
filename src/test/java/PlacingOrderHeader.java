import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class PlacingOrderHeader {
    //WebDriver driver = new ChromeDriver(); (на нем тест оформления покупки валится)
    WebDriver driver = new FirefoxDriver();
    PageElements item = new PageElements();

    @Before
    public void openPageAndClickButtonOrder() {
        driver.get("https://qa-scooter.praktikum-services.ru/");

    }
    @After
    public void quitBrowser() {
        driver.quit();
    }
    private final String name;
    private final String surname;
    private final String address;
    private final String phone;
    private final String date;
    private final String rentPeriod;
    private final String color;
    private final String comment;
    private final String nameStation;


    public PlacingOrderHeader(String name, String surname, String address, String number, String date, String rentPeriod, String color, String comment, String nameStation) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = number;
        this.date = date;
        this.rentPeriod = rentPeriod;
        this.color = color;
        this.comment = comment;
        this.nameStation = nameStation;
    }
    @Parameterized.Parameters
    public static Object[][] fillOutData() {
        return new Object[][]{
                {"Алексей", "Оборин", "г. Москва, Улица Фадеева, 4а", "+79990001122", "11", "сутки", "black", "тест", "Лихоборы"},
                {"Шалтай", "Болтай", "г. Массква,Кремлин", "79990001122", "24", "двое суток", "grey", "тесттест", "Киевская"},
                {"Венцеслав ", "Венгржановский", "ДОМ 2", "89990001122", "1", "трое суток", "black", "тесттесттест", "Ясенево"},
                {"тест", "тест", "Питер", "+79990012322", "19", "четверо суток", "grey", "+_)(**^^%^#!%", "Лубянка"},
                //для этого набора нужны эксепшны на негатив при вводе большого количества символов, либо править)
                //{"тест1тест1тест1", "тест1тест1тест1", "Массква", "89999999999", "20", "пятеро суток", "grey", "asddas", "Спартак"},
                //для этого набора нужны эксепшны на негатив при вводе английских символов, либо править)
                //{"Alex", "Oborin", "Караганда", "89999999999", "11", "шестеро суток", "black", "    ", "Минская"}
                {"Самса", "Говядина", "Перекустаксистачек", "89999999999", "28", "семеро суток", "grey", "123456", "Лужники"}
        };
    }

    @Test
    public void makeOrderHeaderButton() {
        driver.findElement(item.orderButtonHeader).click();

        driver.findElement(item.namePlaceHolder).sendKeys(name);
        driver.findElement(item.surnamePlaceHolder).sendKeys(surname);
        driver.findElement(item.addressPlaceHolder).sendKeys(address);
        driver.findElement(item.stationPlaceHolder).click();
        WebElement stationScroll = driver.findElement(By.xpath(".//div[text()='" + nameStation +"']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", stationScroll);
        driver.findElement(By.xpath(".//div[text()='" + nameStation +"']")).click();
        driver.findElement(item.phonePlaceHolder).click();
        driver.findElement(item.phonePlaceHolder).sendKeys(phone);

        driver.findElement(item.nextButton).click();

        driver.findElement(item.datePlaceHolder).click();
        driver.findElement(By.xpath(".//div[text()='" + date +"']")).click();
        driver.findElement(item.rentalPeriodPlaceHolder).click();
        WebElement rentPeriodScroll = driver.findElement(By.xpath(".//div[text()='" + rentPeriod +"']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", rentPeriodScroll);
        driver.findElement(By.xpath(".//div[text()='" + rentPeriod +"']")).click();
        driver.findElement(By.id(color)).click();
        driver.findElement(item.orderComment).click();
        driver.findElement(item.orderComment).sendKeys(comment);

        driver.findElement(item.orderButton).click();
        driver.findElement(item.accessOrderButton).click();

        assertThat(driver.findElement(item.windowSuccess).getText(), is(containsString(item.success)));

    }

}

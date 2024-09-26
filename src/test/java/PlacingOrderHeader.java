import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.MainPage;
import pages.RentDetailPage;
import pages.UserInfoPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class PlacingOrderHeader {
    private WebDriver driver;

    private final String name;
    private final String surname;
    private final String address;
    private final String phone;
    private final String date;
    private final String rentPeriod;
    private final String color;
    private final String comment;
    private final String nameStation;

    public PlacingOrderHeader(String name, String surname, String address,
                              String number, String date, String rentPeriod,
                              String color, String comment, String nameStation) {
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

    @Before
    public void openPageAndClickButtonOrder() {
        //driver = new ChromeDriver(); (тесты валились на оформлении заказа)
        driver = new FirefoxDriver();
        MainPage main = new MainPage(driver);
        main.openPage();
        main.waitPage();
        main.clickOrderButtonHeader();
    }

    @Parameterized.Parameters
    public static Object[][] fillOutData() {
        return new Object[][]{
                {"Алексей", "Оборин", "г. Москва, Улица Фадеева, 4а", "+79990001122", "11", "сутки", "black", "тест", "Лихоборы"},
                {"Шалтай", "Болтай", "г. Массква,Кремлин", "79990001122", "24", "двое суток", "grey", "тесттест", "Киевская"},
                {"Венцеслав ", "Венгржановский", "ДОМ 2", "89990001122", "1", "трое суток", "black", "тесттесттест", "Ясенево"},
                {"тест", "тест", "Питер", "+79990012322", "19", "четверо суток", "grey", "+_)(**^^%^#!%", "Лубянка"},
                {"Самса", "Говядина", "Перекустаксистачек", "89999999999", "28", "семеро суток", "grey", "123456", "Лужники"}
        };
    }

    @Test
    public void makeOrder() {
        UserInfoPage userInfo = new UserInfoPage(driver);
        userInfo.inputName(name);
        userInfo.inputSurname(surname);
        userInfo.inputAddress(address);
        userInfo.choiceStation(nameStation);
        userInfo.inputPhone(phone);

        userInfo.clickNextButton();
        RentDetailPage rentDetail = new RentDetailPage(driver);

        rentDetail.inputDate(date);
        rentDetail.inputRentalPeriod(rentPeriod);
        rentDetail.inputColor(color);
        rentDetail.inputComment(comment);
        rentDetail.pushOrderButton();
        rentDetail.accessOrder();

        //Проверяем что отображается сообщение об оформлении заказа
        assertTrue("Сообщение об оформлении заказа отображается некорректно", rentDetail.orderResultIsDisplayed());
        //Убеждаемся что в итоговом сообщении указано, что заказ оформлен
        assertTrue("Результат в сообщении не успешный",  rentDetail.getOrderResultText().contains(rentDetail.successExpectation));
    }
    @After
    public void quitBrowser() {
        driver.quit();
    }
}


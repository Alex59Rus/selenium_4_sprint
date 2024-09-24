import org.openqa.selenium.By;

public class PageElements {
    protected final String success = "Заказ оформлен";
    //Элементы выпадающего списка "вопросы о важном"
    By dropDownFirstElement = By.id("accordion__heading-0");
    By dropDownFirstElementText = By.id("accordion__panel-0");
    By dropDownSecondElement = By.id("accordion__heading-1");
    By dropDownSecondElementText = By.id("accordion__panel-1");
    By dropDownThirdElement = By.id("accordion__heading-2");
    By dropDownThirdElementText = By.id("accordion__panel-2");
    By dropDownFourthElement = By.id("accordion__heading-3");
    By dropDownFourthElementText = By.id("accordion__panel-3");
    By dropDownFifthElement = By.id("accordion__heading-4");
    By dropDownFifthElementText = By.id("accordion__panel-4");
    By dropDownSixthElement = By.id("accordion__heading-5");
    By dropDownSixthElementText = By.id("accordion__panel-5");
    By dropDownSeventhElement = By.id("accordion__heading-6");
    By dropDownSeventhElementText = By.id("accordion__panel-6");
    By dropDownEightElement = By.id("accordion__heading-7");
    By dropDownEightElementText = By.id("accordion__panel-7");

    //Кнопки заказа
    By orderButtonHeader = By.xpath(".//button[@class='Button_Button__ra12g' and text()='Заказать']");
    By orderButtonBottom = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");

    //Идентификаторы поля ввода первого раздела
    By namePlaceHolder = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Имя']");
    By surnamePlaceHolder = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Фамилия']");
    By addressPlaceHolder = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Адрес: куда привезти заказ']");
    By stationPlaceHolder = By.xpath(".//input[@class='select-search__input' and @placeholder='* Станция метро']");
    By phonePlaceHolder = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Телефон: на него позвонит курьер']");
    By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Идентификаторы поля ввода второго раздела
    By datePlaceHolder = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Когда привезти самокат']");
    By rentalPeriodPlaceHolder = By.xpath(".//div[@class='Dropdown-placeholder' and text()='* Срок аренды']");
    By orderComment = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='Комментарий для курьера']");
    By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");

    //Окно успеха, после заполнения формы
    By accessOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    By windowSuccess = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");
}

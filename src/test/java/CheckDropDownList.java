import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.MainPage;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CheckDropDownList {
    private WebDriver driver;
    private MainPage main;

    private final String fieldText;
    private final String answerText;
    private final int fieldIndex;

    public CheckDropDownList(int fieldIndex, String fieldText, String answerText) {
        this.fieldIndex = fieldIndex;
        this.fieldText = fieldText;
        this.answerText = answerText;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, "Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Я живу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        });
    }

    @Before
    public void openPageAndScrollDown() {
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        main = new MainPage(driver);
        main.openPage();
        main.waitPage();
        main.scrollDownToDropDown();
    }

    @Test
    public void checkDropDown() {
        //Проверка текста вопросов
        assertEquals("Вопрос отличается от ожидаемого", fieldText, main.getQuestionTextByID(fieldIndex));
        assertEquals("Ответ отличается от ожидаемого", answerText, main.getAnswerTextByID(fieldIndex));
        assertEquals("Количество вопросов отличается от ожидаемого", 8, main.getQuestionsCount());
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}

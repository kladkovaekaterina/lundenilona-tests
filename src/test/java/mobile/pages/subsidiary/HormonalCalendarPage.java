package mobile.pages.subsidiary;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import mobile.pages.MainPage;
import mobile.pages.components.CalendarComponent;
import mobile.pages.components.EditTextComponent;
import mobile.pages.onboarding.OnboardingCommonPage;
import mobile.data.TestTextData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;

public class HormonalCalendarPage {

    OnboardingCommonPage onboardingCommonPage = new OnboardingCommonPage();
    EditTextComponent editTextComponent = new EditTextComponent();
    CalendarComponent calendarComponent = new CalendarComponent();
    TestTextData testTextData = new TestTextData();
    MainPage mainPage = new MainPage();

    private final SelenideElement textView = $(className("android.widget.TextView"), 1),
                                  dateElement = $(id("com.sybirex.ilonandroid:id/txt_hormon_date")),
                                  inputButton = $(className("android.widget.EditText"), 0),
                                  okButton = $(id("android:id/button1"));
    private final ElementsCollection textViewCollection = $$(className("android.widget.TextView"));

    @Step("Открыть страницу {linkName}")
    public HormonalCalendarPage openHormonalCalendarPage(String linkName) {
        onboardingCommonPage.skipOnboardingPage();
        mainPage.clickButtonWhichContainsText(testTextData.getExpectedTextMainPage().get(0), linkName);

        return this;
    }

    @Step("Установить дату")
    public HormonalCalendarPage setDate(String day, String month, String year) {
        inputButton.click();
        calendarComponent.setDate(day, month, year);
        okButton.shouldHave(text("OK")).click();
        return this;
    }

    @Step("Установить длительность")
    public HormonalCalendarPage setLength(int length) {
        editTextComponent.setValueInEditTextLocator(1, length);

        return this;
    }

    @Step("Установить количество дней")
    public HormonalCalendarPage setDaysAmount(int daysAmount) {
        editTextComponent.setValueInEditTextLocator(2, daysAmount);

        return this;
    }

    @Step("Нажать на кнопку Готово")
    public HormonalCalendarPage clickReadyButton() {
        textViewCollection.findBy(text("Готово")).click();

        return this;
    }

    @Step("Проверить, что следующая страница корректно открылась")
    public void checkCurrentWindowOpensWithCurrentDate(String currentDay, String currentMonth) {
        textView.shouldHave(text(currentMonth));
        dateElement.shouldHave(text(currentDay + " " + currentMonth));
    }
}
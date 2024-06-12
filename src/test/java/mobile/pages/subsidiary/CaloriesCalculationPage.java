package mobile.pages.subsidiary;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import mobile.pages.MainPage;
import mobile.pages.components.EditTextComponent;
import mobile.pages.onboarding.OnboardingCommonPage;
import mobile.tests.TestTextData;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;

public class CaloriesCalculationPage {

    OnboardingCommonPage onboardingCommonPage = new OnboardingCommonPage();
    EditTextComponent editTextComponent = new EditTextComponent();
    TestTextData testTextData = new TestTextData();
    MainPage mainPage = new MainPage();

    private final SelenideElement caloriesCalculationResult = $(id("com.sybirex.ilonandroid:id/result")),
                                  textView = $(className("android.widget.TextView"), 1);
    private final ElementsCollection textViewCollection = $$(className("android.widget.TextView"));

    @Step("Открыть страницу {linkName}")
    public CaloriesCalculationPage openCaloriesCalculationPage(String linkName) {
        onboardingCommonPage.skipOnboardingPage();
        mainPage.clickButtonWhichContainsText(testTextData.getExpectedTextMainPage().get(1), linkName);

        return this;
    }

    @Step("Установить вес")
    public CaloriesCalculationPage setWeight(int weight) {
        editTextComponent.setValueInEditTextLocator(0, weight);

        return this;
    }

    @Step("Установить рост")
    public CaloriesCalculationPage setHeight(int height) {
        editTextComponent.setValueInEditTextLocator(1, height);

        return this;
    }

    @Step("Установить возраст")
    public CaloriesCalculationPage setAge(int age) {
        editTextComponent.setValueInEditTextLocator(2, age);

        return this;
    }

    @Step("Проверить, что значение расчета калорий начинается со знака минус")
    public CaloriesCalculationPage caloriesCalculationResultShouldStartWithMinusSign() {
        caloriesCalculationResult.shouldHave(matchText("^-.*"));

        return this;
    }

    @Step("Нажать на кнопку Next")
    public CaloriesCalculationPage clickNextButton() {
        textViewCollection.findBy(text("Next")).click();

        return this;
    }

    @Step("Проверить, что следующая страница не открылась")
    public void checkCurrentWindowDoesNotHaveText(String text) {
        textView.shouldNotHave(text(text));
    }

    @Step("Проверить, что следующая страница корректно открылась")
    public void checkCurrentWindowDoesHaveText(String text) {
        textView.shouldHave(text(text));
    }
}
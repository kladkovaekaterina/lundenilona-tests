package mobile.pages.onboarding;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;

public class OnboardingScreenFirstPage {

    private final SelenideElement continueButton = $(id("com.sybirex.ilonandroid:id/welcome_button_next"));
    private final ElementsCollection textViewCollection = $$(className("android.widget.TextView"));

    @Step("Проверить корректность результата открытия первой страницы onboarding screen")
    public OnboardingScreenFirstPage checkPageOpenedCorrectly(List<String> expectedText) {
        textViewCollection.filter(visible).shouldHave(texts(expectedText));

        return this;
    }

    @Step("Нажать на кнопку Продолжить")
    public void pressContinueButton() {
        continueButton.click();
    }
}
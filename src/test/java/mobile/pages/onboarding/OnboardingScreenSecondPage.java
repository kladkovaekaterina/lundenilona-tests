package mobile.pages.onboarding;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class OnboardingScreenSecondPage {

    private final SelenideElement firstTextView = $(id("com.sybirex.ilonandroid:id/textView")),
                                  secondTextView = $(id("com.sybirex.ilonandroid:id/textView2")),
                                  thirdTextView = $(id("com.sybirex.ilonandroid:id/textView3")),
                                  okButton = $(id("com.sybirex.ilonandroid:id/disclaimer_button_accept"));

    @Step("Проверить корректность результата открытия второй страницы onboarding screen")
    public OnboardingScreenSecondPage checkPageOpenedCorrectly
            (String firstExpectedText, String secondExpectedText, String thirdExpectedText) {
        firstTextView.shouldHave(text(firstExpectedText));
        secondTextView.shouldHave(text(secondExpectedText));
        thirdTextView.shouldHave(text(thirdExpectedText));

        return this;
    }

    @Step("Нажать на кнопку ОК")
    public void pressOkButton() {
        okButton.click();
    }
}
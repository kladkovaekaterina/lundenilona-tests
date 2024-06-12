package mobile.pages.subsidiary;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.className;

public class CommonPage {

    private final SelenideElement textView = $(className("android.widget.TextView"), 1);

    @Step("Проверить корректность результата открытия окна приложения после клика по кнопке на главной странице")
    public void checkCorrectLinkOpenedAfterButtonClick(String expectedText) {
        textView.shouldHave(text(expectedText));
    }
}
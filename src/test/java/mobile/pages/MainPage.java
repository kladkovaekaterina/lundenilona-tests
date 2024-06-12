package mobile.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.containExactTextsCaseSensitive;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;

public class MainPage {

    private final SelenideElement toolbar = $(id("com.sybirex.ilonandroid:id/toolbar")),
                                  mainContainer = $(id("com.sybirex.ilonandroid:id/main_container")),
                                  beautyElement = $(id("com.sybirex.ilonandroid:id/home_text_beauty")),
                                  foodElement = $(id("com.sybirex.ilonandroid:id/home_text_food")),
                                  pregnancyElement = $(id("com.sybirex.ilonandroid:id/home_text_pregnancy")),
                                  navigationBarButton = $(accessibilityId("Open navigation drawer")),
                                  navigationList = $(id("com.sybirex.ilonandroid:id/nav_list"));
    private final ElementsCollection textViewCollection = $$(className("android.widget.TextView"));

    @Step("Проверить корректность результата открытия главной страницы после перехода с onboarding screen")
    public void checkPageOpenedCorrectly(List<String> expectedText) {
        textViewCollection.filter(visible).shouldHave(containExactTextsCaseSensitive(expectedText));
    }

    @Step("Проверить корректность отображения главной страницы")
    public void checkPageDisplayedCorrectly(List<String> expectedText) {
        toolbar.is(visible);
        mainContainer.is(visible);
        beautyElement.shouldHave(text(expectedText.get(0)));
        foodElement.shouldHave(text(expectedText.get(1)));
        textViewCollection.findBy(text(expectedText.get(2))).shouldBe(visible);
        pregnancyElement.shouldHave(text(expectedText.get(3)));
    }

    @Step("Нажать на кнопку {headerName}, затем нажать на кнопку {linkName}")
    public void clickButtonWhichContainsText(String headerName, String linkName) {
        textViewCollection.findBy(text(headerName)).click();
        textViewCollection.findBy(text(linkName)).click();
    }

    @Step("Проверить, что navigation bar виден при нажатии на кнопку")
    public void checkNavigationBarIsVisible() {
        navigationBarButton.click();
        navigationList.is(visible);
    }
}
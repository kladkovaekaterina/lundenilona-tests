package web.pages.searchengine.google;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class GoogleMainPage {

    private final SelenideElement searchString = $("[name=q]");

    @Step("Открыть главную страницу поисковика Google")
    public GoogleMainPage openPage() {
        open("https://www.google.ru/");

        return this;
    }

    @Step("Ввести запрос в поисковую строку")
    public void makeSearchQuery(String searchQuery) {
        searchString.setValue(searchQuery).pressEnter();
    }
}
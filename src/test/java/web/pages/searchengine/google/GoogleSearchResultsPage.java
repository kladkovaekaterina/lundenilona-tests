package web.pages.searchengine.google;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GoogleSearchResultsPage {

    private final SelenideElement firstLink = $("#search").$("div a");
    private final ElementsCollection linkList = $$("div a");

    @Step("Проверить, что ссылка на сайт присутствует в первом результате выдачи")
    public void checkSearchWithKeyWordsResults(String liMainPageLink) {
        firstLink.shouldHave(attribute("href", liMainPageLink));
    }

    @Step("Кликнуть по ссылке, ведущей на сайт")
    public void clickOnLink(String liMainPageLink) {
        linkList.findBy(attribute("href", liMainPageLink)).click();
    }
}
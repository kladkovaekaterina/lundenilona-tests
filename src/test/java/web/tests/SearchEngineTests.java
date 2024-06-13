package web.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import web.pages.lundenilona.MainPage;
import web.pages.searchengine.google.GoogleMainPage;
import web.pages.searchengine.google.GoogleSearchResultsPage;

import static web.tests.TestData.href;

@Tag("search-engine")
@Owner("e.kladkova")
@DisplayName("WEB. Проверка корректности отображения информации в поисковых сервисах")
public class SearchEngineTests extends TestBaseWebWithAttach {

    GoogleMainPage googleMainPage = new GoogleMainPage();
    GoogleSearchResultsPage googleSearchResultsPage = new GoogleSearchResultsPage();
    MainPage liMainPage = new MainPage();

    @ParameterizedTest(name = "В результате поиска по ключевому слову {0} Google должен отобразить сайт на первой позиции на странице с результатами поиска")
    @ValueSource(strings = {"lunden ilona", "илона лунден"})
    @DisplayName("WEB. Поисковый сервер отображает страницу на первой позиции")
    void googleKeyWordsSearchTest(String searchQuery) {
        googleMainPage.openPage()
                      .makeSearchQuery(searchQuery);
        googleSearchResultsPage.checkSearchWithKeyWordsResults(href);
    }

    @Test
    @DisplayName("WEB. При клике по ссылке на странице с результатами поиска в Google должно происходить открытие сайта")
    void googleLinkClickTest() {
        googleMainPage.openPage();
        googleMainPage.makeSearchQuery("lunden ilona");
        googleSearchResultsPage.clickOnLink(href);
        liMainPage.checkCorrectUrlOpened(href);
    }
}
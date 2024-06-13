package web.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import web.pages.lundenilona.CommonArticlePage;
import web.pages.lundenilona.MainPage;
import web.utils.RandomUtilsWeb;

import java.util.Arrays;
import java.util.List;

@Tag("main-page")
@Owner("e.kladkova")
@DisplayName("WEB. Проверка главной страницы сайта")
public class MainPageTests extends TestBaseWebWithAttach {

    MainPage mainPage = new MainPage();
    CommonArticlePage commonArticlePage = new CommonArticlePage();
    RandomUtilsWeb randomUtilsWeb = new RandomUtilsWeb();

    @Test
    @DisplayName("WEB. Проверка заголовков в верхней части страницы")
    void websiteShouldDisplayCorrectHeadersTest() {
        List<String> expectedHeaders = Arrays.asList("Коллекции", "BEAUTY-сеты", "Отзывы", "Блог", "Доставка и оплата", "О нас", "Гостям", "Контакты");
        mainPage.openPage()
                .checkHeaders(expectedHeaders);
    }

    @ParameterizedTest(name = "Проверка, что при наведении мыши на иконку {0} и клике на иконку {1}, открывается корректная ссылка")
    @CsvFileSource(resources = "/web/clickResultsShouldContainSpecificData.csv", numLinesToSkip = 1)
    @DisplayName("WEB. Проверка корректного открытия статьи по клику на ссылку в заголовках")
    void websiteShouldOpenCorrectLinkTest(String headerName, String linkName, String expectedText, String expectedHref) {
        mainPage.openPage()
                .hoverOverAButton(headerName)
                .clickButtonWhichContainsText(linkName);
        commonArticlePage.checkCorrectArticleOpened(expectedHref, expectedText);
    }

    @Test
    @DisplayName("WEB. Проверка, что регистрация неуспешна, если не пройдена капча")
    void registrationIsUnsuccessfulWhenCaptchaIsNotPassedTest() {
        mainPage.openPage()
                .clickLoginButton()
                .clickRegistrationButton();
        mainPage.setFirstName(randomUtilsWeb.firstName)
                .setLastName(randomUtilsWeb.lastName)
                .setEmail(randomUtilsWeb.email)
                .setPhone(randomUtilsWeb.phone)
                .setDateOfBirth(randomUtilsWeb.day, randomUtilsWeb.month, randomUtilsWeb.year)
                .setPassword(randomUtilsWeb.pass)
                .setConfirmPassword(randomUtilsWeb.pass)
                .clickRegistrationButton()
                .checkCaptchaIsNotPassed("Введите слово на картинке", "Это поле обязательное");
    }
}
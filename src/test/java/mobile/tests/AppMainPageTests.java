package mobile.tests;

import io.qameta.allure.Owner;
import mobile.data.TestTextData;
import mobile.pages.MainPage;
import mobile.pages.onboarding.OnboardingCommonPage;
import mobile.pages.subsidiary.CommonPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@Tag("main-page-app")
@Owner("e.kladkova")
@DisplayName("APP. Проверка главной страницы приложения")
public class AppMainPageTests extends TestBaseMob {

    OnboardingCommonPage onboardingCommonPage = new OnboardingCommonPage();
    TestTextData testTextData = new TestTextData();
    CommonPage commonPage = new CommonPage();
    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("APP. Проверка успешной загрузки главного экрана")
    void successfulAppMainPageTest() {
        onboardingCommonPage.skipOnboardingPage();
        mainPage.checkPageDisplayedCorrectly(testTextData.getExpectedTextMainPage());
    }

    @ParameterizedTest(name = "Проверка, что при клике на иконку {0} и выборе иконки {1}, открывается корректная ссылка")
    @CsvFileSource(resources = "/mobile/clickResultsShouldContainSpecificData.csv", numLinesToSkip = 1)
    @DisplayName("APP. Проверка корректного открытия окна приложения по клику на иконку")
    void appShouldOpenCorrectLinkTest(String headerName, String linkName, String expectedText) {
        onboardingCommonPage.skipOnboardingPage();
        mainPage.clickButtonWhichContainsText(headerName, linkName);
        commonPage.checkCorrectLinkOpenedAfterButtonClick(expectedText);
    }

    @Test
    @DisplayName("APP. Проверка успешной загрузки navigation bar")
    void successfulNavigationBarTest() {
        onboardingCommonPage.skipOnboardingPage();
        mainPage.checkNavigationBarIsVisible();
    }
}
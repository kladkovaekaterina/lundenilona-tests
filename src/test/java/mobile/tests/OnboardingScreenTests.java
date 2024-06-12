package mobile.tests;

import io.qameta.allure.Owner;
import mobile.pages.MainPage;
import mobile.pages.onboarding.OnboardingScreenFirstPage;
import mobile.pages.onboarding.OnboardingScreenSecondPage;
import mobile.pages.onboarding.OnboardingScreenThirdPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("onboarding-page")
@Owner("e.kladkova")
@DisplayName("Проверка onboarding экрана")
public class OnboardingScreenTests extends TestBaseMob {

    OnboardingScreenFirstPage onboardingScreenFirstPage = new OnboardingScreenFirstPage();
    OnboardingScreenSecondPage onboardingScreenSecondPage = new OnboardingScreenSecondPage();
    OnboardingScreenThirdPage onboardingScreenThirdPage = new OnboardingScreenThirdPage();
    TestTextData testTextData = new TestTextData();
    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Проверка успешной загрузки и прохождения onboarding экрана")
    void successfulGettingStartedPageTest() {
        onboardingScreenFirstPage.checkPageOpenedCorrectly(testTextData.getExpectedTextForFirstOnboardingPage())
                                 .pressContinueButton();
        onboardingScreenSecondPage.checkPageOpenedCorrectly(testTextData.getExpectedFirstTextForSecondOnboardingPage(),
                                                            testTextData.getExpectedSecondTextForSecondOnboardingPage(),
                                                            testTextData.getExpectedThirdTextForSecondOnboardingPage())
                                  .pressOkButton();
        onboardingScreenThirdPage.pressAllowButton();
        mainPage.checkPageOpenedCorrectly(testTextData.getExpectedTextMainPage());
    }
}
package mobile.pages.onboarding;

import io.qameta.allure.Step;

public class OnboardingCommonPage {

    OnboardingScreenFirstPage onboardingScreenFirstPage = new OnboardingScreenFirstPage();
    OnboardingScreenSecondPage onboardingScreenSecondPage = new OnboardingScreenSecondPage();
    OnboardingScreenThirdPage onboardingScreenThirdPage = new OnboardingScreenThirdPage();

    @Step("Пройти onboarding screen")
    public void skipOnboardingPage() {
        onboardingScreenFirstPage.pressContinueButton();
        onboardingScreenSecondPage.pressOkButton();
        onboardingScreenThirdPage.pressAllowButton();
    }
}
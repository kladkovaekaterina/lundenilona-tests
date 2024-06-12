package mobile.pages.onboarding;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class OnboardingScreenThirdPage {

    private final SelenideElement allowButton = $(id("com.android.permissioncontroller:id/permission_allow_button"));

    @Step("Нажать на кнопку Allow")
    public void pressAllowButton() {
        allowButton.click();
    }
}
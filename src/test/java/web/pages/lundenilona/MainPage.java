package web.pages.lundenilona;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.*;
import static web.tests.TestData.*;

public class MainPage {

    private final SelenideElement loginButton = $("#header-login"),
                                  loginEmailInput = $("#login-email"),
                                  loginPassInput = $("#login-password"),
                                  enterButton = $$("#form_login button").findBy(text("Войти")),
                                  inputError = $("#login-password-error"),
                                  headersList = $(".header-menu__list");
    private final ElementsCollection headersCollection = $$(".header-menu__item"),
                                     subHeadersCollection = $$("a.submenu__link"),
                                     buttonsCollection = $$("button");

    // for registration usage
    private final SelenideElement firstNameInput = $("[name=registration-name]"),
                                  lastNameInput = $("[name=registration-lastname]"),
                                  emailInput = $("[name=registration-email]"),
                                  phoneInput = $("[name=registration-phone]"),
                                  dateInput = $("[name=registration-date]"),
                                  passInput = $("[name=registration-password]"),
                                  confirmPassInput = $("[name=registration-password-repeat]"),
                                  inputLabel = $("label[for=captcha_word]"),
                                  captchaError = $("span[id=captcha_word-error]");

    @Step("Проверить, что открылась корректная ссылка сайта")
    public void checkCorrectUrlOpened(String expectedHref) {
        switchTo().window(1);
        assertThat(WebDriverRunner.url()).isEqualTo(expectedHref);
    }

    @Step("Открыть главную страницу сайта")
    public MainPage openPage() {
        open(href);

        return this;
    }

    @Step("Нажать на кнопку Войти в правом верхнем углу")
    public MainPage clickLoginButton() {
        loginButton.click();

        return this;
    }

    @Step("В открывшейся форме ввести Email пользователя")
    public MainPage setLoginEmail(String userEmail) {
        loginEmailInput.setValue(userEmail);

        return this;
    }

    @Step("В открывшейся форме ввести Пароль пользователя")
    public MainPage setLoginPass(String userPass) {
        loginPassInput.setValue(userPass);

        return this;
    }

    @Step("В открывшейся форме нажать на кнопку Войти")
    public MainPage pressEnterButton() {
        enterButton.click();

        return this;
    }

    @Step("Проверить, что авторизация пользователя через UI прошла успешно")
    public void checkSuccessfulAuth(String userName) {
        loginButton.shouldHave(text(userName));
    }

    @Step("Проверить, что авторизация пользователя через UI из-за неверного пароля прошла неуспешно")
    public void checkWrongPassAuth(String errorMessage) {
        inputError.shouldHave(text(errorMessage));
        enterButton.shouldHave(text("Войти"));
    }

    @Step("Проверить корректность отображения заголовков на главной странице")
    public void checkHeaders(List<String> expectedHeaders) {
        headersCollection.filter(visible).shouldHave(texts(expectedHeaders));
    }

    @Step("В правом верхнем углу страницы навести курсор мыши на иконку {headerName}")
    public MainPage hoverOverAButton(String headerName) {
        headersList.$(byText((headerName))).hover();

        return this;
    }

    @Step("В правом верхнем углу страницы нажать на иконку, содержащую текст {linkName}")
    public void clickButtonWhichContainsText(String linkName) {
        subHeadersCollection.find(text(linkName)).click();
    }

    @Step("Ввести имя пользователя")
    public MainPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Ввести фамилию пользователя")
    public MainPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Ввести email пользователя")
    public MainPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    @Step("Ввести телефон пользователя")
    public MainPage setPhone(String value) {
        phoneInput.setValue(value);

        return this;
    }

    @Step("Ввести дату рождения пользователя")
    public MainPage setDateOfBirth(String day, String month, String year) {
        String date = String.format("%s.%s.%s", day, month, year);
        dateInput.setValue(date);

        return this;
    }

    @Step("Ввести пароль")
    public MainPage setPassword(String value) {
        passInput.setValue(value);

        return this;
    }

    @Step("Ввести пароль еще раз для подтверждения")
    public MainPage setConfirmPassword(String value) {
        confirmPassInput.setValue(value);

        return this;
    }

    @Step("Нажать на кнопку Регистрация")
    public MainPage clickRegistrationButton() {
        buttonsCollection.findBy(text("регистрация")).click();

        return this;
    }

    @Step("Проверить, что капча не пройдена (появляется ошибка {errorText})")
    public void checkCaptchaIsNotPassed(String text, String errorText) {
        inputLabel.shouldHave(text(text));
        captchaError.shouldHave(text(errorText));
    }
}
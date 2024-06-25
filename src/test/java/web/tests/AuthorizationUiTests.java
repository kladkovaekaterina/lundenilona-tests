package web.tests;

import io.qameta.allure.Owner;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import web.config.AuthConfig;
import web.pages.lundenilona.MainPage;

import static web.data.TestData.*;

@Tag("auth-user")
@Owner("e.kladkova")
@DisplayName("WEB. Проверка действий пользователя в модуле авторизации")
public class AuthorizationUiTests extends TestBaseWebWithAttach {

    MainPage MainPage = new MainPage();
    AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());

    @Test
    @DisplayName("WEB. Проверка успешной авторизации пользователя")
    void successfulUiAuthTest() {
        MainPage.openPage()
                .clickLoginButton()
                .setLoginEmail(authConfig.userLogin())
                .setLoginPass(authConfig.userPass())
                .pressEnterButton()
                .checkSuccessfulAuth(authConfig.userName());
    }

    @Test
    @DisplayName("WEB. Проверка неуспешной авторизации пользователя из-за неверного пароля")
    void wrongPassUiAuthTest() {
        MainPage.openPage()
                .clickLoginButton()
                .setLoginEmail(authConfig.userLogin())
                .setLoginPass(wrongUserPass)
                .pressEnterButton()
                .checkWrongPassAuth("Неверный логин или пароль.");
    }
}
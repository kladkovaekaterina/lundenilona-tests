package web.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import web.pages.lundenilona.MainPage;

import static web.tests.TestData.*;

@Tag("auth-user")
@Owner("e.kladkova")
@DisplayName("Проверка действий пользователя в модуле авторизации")
public class AuthorizationUiTests extends TestBaseWebWithAttach {

    MainPage MainPage = new MainPage();

    @Test
    @DisplayName("Проверка успешной авторизации пользователя")
    void successfulUiAuthTest() {
        MainPage.openPage()
                .clickLoginButton()
                .setLoginEmail(userLogin)
                .setLoginPass(userPass)
                .pressEnterButton()
                .checkSuccessfulAuth(userName);
    }

    @Test
    @DisplayName("Проверка неуспешной авторизации пользователя из-за неверного пароля")
    void wrongPassUiAuthTest() {
        MainPage.openPage()
                .clickLoginButton()
                .setLoginEmail(userLogin)
                .setLoginPass(wrongUserPass)
                .pressEnterButton()
                .checkWrongPassAuth("Неверный логин или пароль.");
    }
}
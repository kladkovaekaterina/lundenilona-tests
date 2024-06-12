package web.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import web.api.AuthApi;

import static web.tests.TestData.userPass;
import static web.tests.TestData.wrongUserPass;

@Tag("auth-server")
@Owner("e.kladkova")
@DisplayName("Проверка работы сервера в модуле авторизации")
public class AuthorizationApiTests extends TestBaseWebApiServer {

    AuthApi authApi = new AuthApi();

    @Test
    @DisplayName("Проверка ответа сервера на успешную авторизацию пользователя")
    void successfulApiAuthTest() {
        authApi.makeAuthApiPostRequest(userPass);
        authApi.checkSuccessfulAuthApiResponse();
    }

    @Test
    @DisplayName("Проверка ответа сервера на неуспешную авторизацию пользователя из-за неверного пароля")
    void wrongPassApiAuthTest() {
        authApi.makeAuthApiPostRequest(wrongUserPass);
        authApi.checkWrongPassAuthApiResponse();
    }
}
package web.tests;

import io.qameta.allure.Owner;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import web.api.AuthApi;
import web.config.AuthConfig;

import static web.data.TestData.wrongUserPass;

@Tag("auth-server")
@Owner("e.kladkova")
@DisplayName("WEB. Проверка работы сервера в модуле авторизации")
public class AuthorizationApiTests extends TestBaseWebApiServer {

    AuthApi authApi = new AuthApi();
    AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());

    @Test
    @DisplayName("WEB. Проверка ответа сервера на успешную авторизацию пользователя")
    void successfulApiAuthTest() {
        authApi.makeAuthApiPostRequest(authConfig.userPass());
        authApi.checkSuccessfulAuthApiResponse();
    }

    @Test
    @DisplayName("WEB. Проверка ответа сервера на неуспешную авторизацию пользователя из-за неверного пароля")
    void wrongPassApiAuthTest() {
        authApi.makeAuthApiPostRequest(wrongUserPass);
        authApi.checkWrongPassAuthApiResponse();
    }
}
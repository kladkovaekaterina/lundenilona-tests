package web.api;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.text.StringEscapeUtils;
import web.config.AuthConfig;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static web.specs.Specs.requestUserAuthSpec;
import static web.specs.Specs.responseUserAuthSpec;
import static web.data.TestData.*;

public class AuthApi {

    AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());

    String successfulAuthResponse = makeAuthApiPostRequest(authConfig.userPass()),
            wrongPassAuthResponse = makeAuthApiPostRequest(wrongUserPass);

    @Step("Выполнить авторизацию через API")
    public String makeAuthApiPostRequest(String userPass) {
        String authRequest = String.format("AUTH_FORM=Y&TYPE=AUTH&login=yes&USER_LOGIN=%s&USER_PASSWORD=%s",
                authConfig.userLogin(), userPass);

        return given(requestUserAuthSpec)
                .body(authRequest)

                .when()
                .post("/ajax/login.php")

                .then()
                .spec(responseUserAuthSpec(200, ContentType.HTML.withCharset("UTF-8")))
                .extract().asString();
    }

    @Step("Проверить выполнение успешной авторизации через API")
    public void checkSuccessfulAuthApiResponse() {
        String authResponseDecoded = StringEscapeUtils.unescapeJava(successfulAuthResponse);
        assertEquals(String.format("""
                {"login":"%s","type":"OK","message":"Вы успешно авторизованы"}""", authConfig.userName()), authResponseDecoded);
    }

    @Step("Проверить выполнение неуспешной авторизации через API из-за неправильного пароля")
    public void checkWrongPassAuthApiResponse() {
        String authResponseDecoded = StringEscapeUtils.unescapeJava(wrongPassAuthResponse);
        assertEquals("""
                {"message":"Неверный логин или пароль.<br>","type":"ERROR","error_type":"LOGIN"}""", authResponseDecoded);
    }
}
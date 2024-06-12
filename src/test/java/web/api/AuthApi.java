package web.api;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import org.apache.commons.text.StringEscapeUtils;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static web.specs.Specs.requestUserAuthSpec;
import static web.specs.Specs.responseUserAuthSpec;
import static web.tests.TestData.*;
import static web.tests.TestData.userName;

public class AuthApi {

    String successfulAuthResponse = makeAuthApiPostRequest(userPass),
            wrongPassAuthResponse = makeAuthApiPostRequest(wrongUserPass);

    @Step("Выполнить авторизацию через API")
    public String makeAuthApiPostRequest(String userPass) {
        String authRequest = String.format("AUTH_FORM=Y&TYPE=AUTH&login=yes&USER_LOGIN=%s&USER_PASSWORD=%s",
                userLogin, userPass);

        return given(requestUserAuthSpec)
                .body(authRequest)

                .when()
                .post("/ajax/login.php")

                .then()
                .spec(responseUserAuthSpec(200, ContentType.HTML.withCharset("UTF-8")))
                .extract().asString();
    }

    @Step("Проверить выполнение успешной авторизации через API")
    public AuthApi checkSuccessfulAuthApiResponse() {
        String authResponseDecoded = StringEscapeUtils.unescapeJava(successfulAuthResponse);
        assertEquals(String.format("""
                {"login":"%s","type":"OK","message":"Вы успешно авторизованы"}""", userName), authResponseDecoded);

        return this;
    }

    @Step("Проверить выполнение неуспешной авторизации через API из-за неправильного пароля")
    public AuthApi checkWrongPassAuthApiResponse() {
        String authResponseDecoded = StringEscapeUtils.unescapeJava(wrongPassAuthResponse);
        assertEquals("""
                {"message":"Неверный логин или пароль.<br>","type":"ERROR","error_type":"LOGIN"}""", authResponseDecoded);

        return this;
    }
}
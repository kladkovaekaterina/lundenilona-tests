package mobile.helpers;

import org.aeonbits.owner.ConfigFactory;
import mobile.config.AuthBrowserstackConfig;

import static io.restassured.RestAssured.given;

public class BrowserstackVideo {

    public static String videoUrl(String sessionId) {

        AuthBrowserstackConfig authBrowserstackConfig = ConfigFactory.create(AuthBrowserstackConfig.class, System.getProperties());

        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(authBrowserstackConfig.username(), authBrowserstackConfig.authkey())
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
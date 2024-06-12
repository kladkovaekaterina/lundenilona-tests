package mobile.helpers;

import org.aeonbits.owner.ConfigFactory;
import mobile.config.AuthConfig;

import static io.restassured.RestAssured.given;

public class Browserstack {

    public static String videoUrl(String sessionId) {

        AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());

        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(authConfig.username(), authConfig.authkey())
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
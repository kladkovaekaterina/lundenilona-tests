package web.tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import static web.tests.TestData.href;

public class TestBaseWebApiServer {

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = href;
    }
}
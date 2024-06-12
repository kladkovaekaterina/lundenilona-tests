package web.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;

public class Specs {

    public static RequestSpecification requestUserAuthSpec = with()
            .filter(withCustomTemplates())
            .log().uri()
            .log().method()
            .log().body()
            .log().headers()
            .contentType(ContentType.URLENC.withCharset("UTF-8"));

    public static ResponseSpecification responseUserAuthSpec(int statusCode, String contentType) {
        return new ResponseSpecBuilder()
                .expectContentType(contentType)
                .expectStatusCode(statusCode)
                .log(STATUS)
                .log(BODY)
                .build();
    }
}
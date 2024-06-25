package web.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import web.config.BrowserConfig;
import web.helpers.AttachmentsWeb;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static web.data.TestData.liMainPageLink;

public class TestBaseWebWithAttach {

    BrowserConfig browserConfig = ConfigFactory.create(BrowserConfig.class, System.getProperties());

    @BeforeAll
    static void beforeAll() {
        BrowserConfig browserConfig = ConfigFactory.create(BrowserConfig.class, System.getProperties());

        Configuration.baseUrl = liMainPageLink;
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = browserConfig.browserName();
        Configuration.browserVersion = browserConfig.browserVersion();
        Configuration.browserSize = "1920x1080";
        RestAssured.baseURI = liMainPageLink;

        if (!"local".equals(System.getProperty("driver"))) {
            Configuration.remote  = browserConfig.remoteDriver();
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Запуск тестов на driver: " + browserConfig.driverName() + "; browser: " + browserConfig.browserName());
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        AttachmentsWeb.screenshotAs("Last screenshot");
        AttachmentsWeb.pageSource();
        AttachmentsWeb.browserConsoleLogs();
        AttachmentsWeb.addVideo();

        closeWebDriver();
    }
}
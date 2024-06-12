package mobile.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import mobile.config.HostConfig;
import mobile.drivers.BrowserstackDriver;
import mobile.drivers.EmulatorDriver;
import mobile.drivers.RealDeviceDriver;
import mobile.helpers.AttachmentsMobile;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBaseMob {

    HostConfig hostConfig = ConfigFactory.create(HostConfig.class, System.getProperties());

    @BeforeAll
    static void beforeAll() {
        if ("browserstack".equals(System.getProperty("deviceHost"))) {
            Configuration.browser = BrowserstackDriver.class.getName();
        } else if ("emulation".equals(System.getProperty("deviceHost"))) {
            Configuration.browser = EmulatorDriver.class.getName();
        } else if ("real".equals(System.getProperty("deviceHost"))) {
            Configuration.browser = RealDeviceDriver.class.getName();
        } else {
            Configuration.browser = BrowserstackDriver.class.getName();
        }

        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Запуск тестов на host: " + hostConfig.hostName() + "; platform: " + hostConfig.platformName() + "; device: "+ hostConfig.deviceName());
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = Selenide.sessionId().toString();

        if ("browserstack".equals(System.getProperty("deviceHost"))) {
            AttachmentsMobile.pageSource();
            closeWebDriver();
            AttachmentsMobile.addVideo(sessionId);
        } else if ("emulation".equals(System.getProperty("deviceHost")) || "real".equals(System.getProperty("deviceHost"))) {
            AttachmentsMobile.pageSource();
            AttachmentsMobile.screenshotAs("Last screenshot");
            closeWebDriver();
        } else {
            AttachmentsMobile.pageSource();
            closeWebDriver();
            AttachmentsMobile.addVideo(sessionId);
        }
    }
}
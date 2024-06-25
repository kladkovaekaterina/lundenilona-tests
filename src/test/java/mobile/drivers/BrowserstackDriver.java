package mobile.drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import mobile.config.HostConfig;
import mobile.config.AuthBrowserstackConfig;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        AuthBrowserstackConfig authBrowserstackConfig = ConfigFactory.create(AuthBrowserstackConfig.class, System.getProperties());
        HostConfig hostConfig = ConfigFactory.create(HostConfig.class, System.getProperties());

        caps.setCapability("browserstack.user", authBrowserstackConfig.username());
        caps.setCapability("browserstack.key", authBrowserstackConfig.authkey());
        caps.setCapability("app", hostConfig.appUrl());
        caps.setCapability("device", hostConfig.deviceName());
        caps.setCapability("os_version", hostConfig.platformVersion());
        caps.setCapability("project", "BrowserStack Sample");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");

        try {
            return new RemoteWebDriver(
                    new URL(authBrowserstackConfig.url()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
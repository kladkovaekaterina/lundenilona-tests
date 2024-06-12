package mobile.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import mobile.config.HostConfig;

import javax.annotation.Nonnull;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;

public class EmulatorDriver implements WebDriverProvider {

    HostConfig hostConfig = ConfigFactory.create(HostConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();

        File app = new File("src/test/resources/mobile/apps/IlonaLunden.apk");

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setPlatformVersion(hostConfig.platformVersion())
                .setDeviceName(hostConfig.deviceName())
                .setApp(app.getAbsolutePath())
                .setAppPackage("com.sybirex.ilonandroid")
                .setAppActivity("com.sybirex.ilonandroid.StartActivity");

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    public URL getAppiumServerUrl() {
        try {
            return new URL(hostConfig.hostUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
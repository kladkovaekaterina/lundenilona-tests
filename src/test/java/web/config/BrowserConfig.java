package web.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:web/properties/${driver}.properties",
        "classpath:web/properties/default.properties"
})
public interface BrowserConfig extends Config {

    @Key("driver.name")
    String driverName();

    @Key("browser.name")
    String browserName();

    @Key("browser.version")
    String browserVersion();

    @Key("remote.driver")
    String remoteDriver();
}
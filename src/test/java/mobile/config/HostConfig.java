package mobile.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:mobile/host/${deviceHost}.properties",
        "classpath:mobile/host/default.properties"
})
public interface HostConfig extends Config {
    @Key("host.name")
    String hostName();

    @Key("host.url")
    String hostUrl();

    @Key("platform.name")
    String platformName();

    @Key("device.name")
    String deviceName();

    @Key("platform.version")
    String platformVersion();

    @Key("app.url")
    String appUrl();
}
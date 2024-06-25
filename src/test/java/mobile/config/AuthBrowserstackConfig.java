package mobile.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:mobile/testing.properties"
})
public interface AuthBrowserstackConfig extends Config {

    @Key("auth.userName")
    String username();

    @Key("auth.authKey")
    String authkey();

    @Key("auth.url")
    String url();
}
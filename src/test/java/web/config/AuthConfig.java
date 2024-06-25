package web.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:web/testing.properties"
})
public interface AuthConfig extends Config {

    @Key("auth.userLogin")
    String userLogin();

    @Key("auth.userName")
    String userName();

    @Key("auth.userPass")
    String userPass();
}
package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${setConfig}.properties"
})

public interface WebConfig extends Config {

    @Key("browser")
    String getBrowser();

    @Key("version")
    String getVersionBrowser();

    @Key("baseUrl")
    String getURL();

    @Key("browserSize")
    String getSize();

    @Key("isRemote")
    Boolean isRemote();

    @Key("remoteURL")
    String getRemoteURL();
}

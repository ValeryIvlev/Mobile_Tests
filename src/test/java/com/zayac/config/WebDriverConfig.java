package com.zayac.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${device}.properties",
        "classpath:mobile.properties"
})

public interface WebDriverConfig extends Config {

    @Key("browserstack.user")
    String getBrowserstackUser();

    @Key("browserstack.key")
    String getBrowserstackKey();

    @Key("Url")
    String getUrl();

    @Key("App")
    String getApp();

    @Key("device.name")
    String getDeviceName();

    @Key("platform.version")
    String getPlatformVersion();
}

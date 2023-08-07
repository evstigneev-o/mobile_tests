package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:config/baseconfig.properties",
        "classpath:config/${env}.properties"
})
public interface BrowserstackConfig extends Config {

    @Key("user")
    @DefaultValue("jeffbezos_DrqNJO")
    String user();

    @Key("key")
    @DefaultValue("GvsVzaDY76sHyVY2fLnn")
    String key();

    @Key("baseUrl")
    @DefaultValue("http://hub.browserstack.com/wd/hub")
    String baseUrl();

    @Key("app")
    @DefaultValue("bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c")
    String app();

    @Key("device")
    @DefaultValue("Google Pixel 3")
    String device();

    @Key("osVersion")
    @DefaultValue("9.0")
    String osVersion();

    @Key("project")
    @DefaultValue("First Java Project")
    String project();

    @Key("build")
    @DefaultValue("browserstack-build-1")
    String build();

    @Key("name")
    @DefaultValue("first_test")
    String name();
}


package configreader;

import org.aeonbits.owner.Config;

@org.aeonbits.owner.Config.LoadPolicy(org.aeonbits.owner.Config.LoadType.MERGE)
@org.aeonbits.owner.Config.Sources({
        "system:properties",
        "file:src/main/resources/config.properties",
})

public interface PropertiesReader extends org.aeonbits.owner.Config {

    @Config.Key("BROWSER")
    String browser();

    @Config.Key("BASE_URL")
    String baseUrl();

    @Config.Key("size")
    String size();

    @Config.Key("DRIVER_MANAGER_ENABLED")
    Boolean driverManagerEnabled();

    @Config.Key("HEADLESS")
    Boolean headless();

    @Config.Key("SCREENSHOTS")
    Boolean screenshots();

    @Config.Key("TIMEOUT")
    int timeout();

    @Config.Key("DURATION")
    int duration();

}

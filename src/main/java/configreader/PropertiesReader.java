package configreader;

import org.aeonbits.owner.Config;

@org.aeonbits.owner.Config.LoadPolicy(org.aeonbits.owner.Config.LoadType.MERGE)
@org.aeonbits.owner.Config.Sources({
        "system:properties",
        "file:src/main/resources/config.properties",
})

public interface PropertiesReader extends org.aeonbits.owner.Config {

    @Config.Key("browser")
    String browser();

    @Config.Key("base_url")
    String baseUrl();

    @Config.Key("size")
    String size();

    @Config.Key("driverManagerEnabled")
    Boolean driverManagerEnabled();

    @Config.Key("headless")
    Boolean headless();

    @Config.Key("screenshots")
    Boolean screenshots();

    @Config.Key("timeout")
    int timeout();

    @Config.Key("duration")
    int duration();

}

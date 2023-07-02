package config;

import com.codeborne.selenide.Configuration;
import configreader.ConfigReader;

public class SelenideConfiguration {

    private static final String BROWSER = ConfigReader.properties.browser();
    private static final Boolean MANAGERENABLED = ConfigReader.properties.driverManagerEnabled();
    private static final Boolean HEADLESS = ConfigReader.properties.headless();
    private static final String BROWSERSIZE = ConfigReader.properties.size();
    private static final String BASEURL = ConfigReader.properties.baseUrl();
    private static final int TIMEOUT = ConfigReader.properties.timeout();

    public static void config() {
        Configuration.browser = BROWSER;
        Configuration.driverManagerEnabled = MANAGERENABLED;
        Configuration.headless = HEADLESS;
        Configuration.browserSize = BROWSERSIZE;
        Configuration.baseUrl = BASEURL;
        Configuration.pageLoadTimeout = TIMEOUT;
    }

}

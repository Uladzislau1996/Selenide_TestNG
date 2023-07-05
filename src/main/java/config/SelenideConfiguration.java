package config;

import com.codeborne.selenide.Configuration;
import configreader.ConfigReader;

public class SelenideConfiguration {

    private static final String BROWSER = ConfigReader.properties.browser();
    private static final Boolean MANAGER_ENABLED = ConfigReader.properties.driverManagerEnabled();
    private static final Boolean HEADLESS = ConfigReader.properties.headless();
    private static final String BROWSER_SIZE = ConfigReader.properties.size();
    private static final String BASE_URL = ConfigReader.properties.baseUrl();
    private static final int TIMEOUT = ConfigReader.properties.timeout();

    public static void config() {
        Configuration.browser = BROWSER;
        Configuration.driverManagerEnabled = MANAGER_ENABLED;
        Configuration.headless = HEADLESS;
        Configuration.browserSize = BROWSER_SIZE;
        Configuration.baseUrl = BASE_URL;
        Configuration.pageLoadTimeout = TIMEOUT;
    }

}

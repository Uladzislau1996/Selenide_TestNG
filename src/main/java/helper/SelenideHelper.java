package helper;

import com.codeborne.selenide.Selenide;
import configreader.ConfigReader;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;

public class SelenideHelper {

    public static final int SECONDS = ConfigReader.properties.duration();

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] attachScreenshot() {
        return Selenide.screenshot(OutputType.BYTES);
    }


}

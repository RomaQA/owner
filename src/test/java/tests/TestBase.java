package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
    @BeforeAll
    static void beforeAll(){
        System.setProperty("setConfig", "local");

        WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());
        Configuration.browser = config.getBrowser();
        Configuration.browserVersion = config.getVersionBrowser();
        Configuration.browserSize= config.getSize();
        Configuration.baseUrl= config.getURL();

        if (config.isRemote()) {
            Configuration.remote = config.getRemoteURL();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC",true);
            capabilities.setCapability("enableVideo",true);
            Configuration.browserCapabilities = capabilities;
        }
    }

    @BeforeEach
    void addListener(){
        SelenideLogger.addListener("AllureSelenide",new AllureSelenide());

    }

    @AfterEach
    void addAttachments(){
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }
}

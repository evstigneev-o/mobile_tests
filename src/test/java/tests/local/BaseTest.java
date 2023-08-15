package tests.local;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.AndroidLocalDriver;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;


public class BaseTest {
    @BeforeAll
    public static void setUp() {
        Configuration.browser = AndroidLocalDriver.class.getName();
        Configuration.browserSize = null;
        Configuration.timeout = 5000;
    }

    @BeforeEach
    public void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    public void tearDown() {
        //  Attach.screenshotAs("Last screenshot"); //todo
        // Attach.pageSource();

        closeWebDriver();

        //  Attach.addVideo(sessionId);
    }

}

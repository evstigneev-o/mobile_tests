package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import drivers.BrowserstackDriver;
import helpers.Attach;

import static com.codeborne.selenide.Selenide.*;


public class BaseTest {
    @BeforeAll
    public static void setUp(){
        Configuration.browser = BrowserstackDriver.class.getName();
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void addListener(){
        SelenideLogger.addListener("AllureSelenide",new AllureSelenide());
        open();
    }
    @AfterEach
    public void tearDown(){
        String sessionId = sessionId().toString();

//        Attach.screenshotAs("Last screenshot"); //todo
        Attach.pageSource();

        closeWebDriver();

        Attach.addVideo(sessionId);
    }

}

package tests.ios;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@DisplayName("IOS sample app tests")
@Tag("ios")
public class SampleAppTest extends BaseTest {
    private final String text = "QA GURU epta";

    @Test
    void sampleTest() {
        step("Переход на форму ввода текста", () ->
                $(AppiumBy.accessibilityId("Text Button")).click());
        step("Ввод текста и его отправка", () -> {
            $(AppiumBy.accessibilityId("Text Input")).sendKeys(text);
            $(AppiumBy.accessibilityId("Text Input")).pressEnter();
        });
        step("Проверка отображения введенного текста", () ->
                $(AppiumBy.accessibilityId("Text Output")).shouldHave(text(text)));
    }
}

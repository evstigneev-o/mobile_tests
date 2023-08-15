package tests.local;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertAll;

@Tag("android")
@DisplayName("Android wikipedia app test")
public class SearchTest extends BaseTest {

    @BeforeEach
    public void skipOnboarding(){
        step("Пропуск онбординга", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click()
        );
    }
    @Test
    public void successfulSearchTest() {
        step("Ввод запроса для поиска", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Проверка результатов поиска", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/search_container"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    public void searchResultErrorPageTest() {
        step("Ввод запроса для поиска", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Клик по первому результату поиска", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/search_container")).get(0).click()
        );
        step("Проверка экрана ошибки", () ->
                assertAll(
                        () -> $(AppiumBy.id("org.wikipedia.alpha:id/view_wiki_error_text")).
                                shouldHave(text("An error occurred")),
                        () -> $(AppiumBy.id("org.wikipedia.alpha:id/view_wiki_error_button")).
                                shouldBe(visible)
                )
        );
    }
}
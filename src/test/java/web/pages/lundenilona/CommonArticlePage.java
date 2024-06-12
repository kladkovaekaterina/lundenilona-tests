package web.pages.lundenilona;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class CommonArticlePage {

    private final SelenideElement pageTitle = $(".page__title");

    @Step("Проверить, что открылась корректная ссылка на статью")
    public void checkCorrectArticleOpened(String expectedHref, String expectedText) {
        assertThat(WebDriverRunner.url()).isEqualTo(expectedHref);
        pageTitle.shouldHave(text(expectedText));
    }
}
package com.github;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class CheckSoftAssertions {
    @BeforeEach
    void openGitHub() {
        open("https://github.com/");
    }

    @Test
    void checkSoftAssertions() {
        $("[placeholder='Search GitHub']").setValue("selenide").pressEnter();
        $("ul.repo-list li").$("a").click();
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $$("[data-filterable-for='wiki-pages-filter']").first().shouldHave(text("SoftAssertions")).click();
        $("div.markdown-body").$(withTagAndText("h4", "JUnit5")).shouldBe(visible);
    }
}

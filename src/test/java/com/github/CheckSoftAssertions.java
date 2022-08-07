package com.github;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CheckSoftAssertions {
    @BeforeEach
    void openGitHub(){
        open("https://github.com/");
    }

    @Test
    void checkSoftAssertions(){
        $("[placeholder='Search GitHub']").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $$("[data-filterable-for='wiki-pages-filter']").first().shouldHave(text("SoftAssertions"));


    }
}

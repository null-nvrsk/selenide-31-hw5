package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class EnterprisePageTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserPosition = "0x0";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void openEnterprisePageTest() {
        open("/");
        $$("button.HeaderMenu-link").findBy(text("Solutions")).hover();
        $$("a.HeaderMenu-dropdown-link").findBy(text("Enterprises")).click();
        $("h1#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform."));
    }
}
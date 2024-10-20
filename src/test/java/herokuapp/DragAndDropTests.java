package herokuapp;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.browserPosition = "0x0";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void  rectangleDragAndDropTest() {
        open("/drag_and_drop");
        SelenideElement blockA = $("#column-a");
        SelenideElement blockB = $("#column-b");

        blockA.dragAndDrop(to(blockB));

        blockA.shouldHave(text("B"));
        blockB.shouldHave(text("A"));
    }
}

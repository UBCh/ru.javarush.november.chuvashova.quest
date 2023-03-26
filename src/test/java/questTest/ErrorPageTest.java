package questTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;
import quest.controller.Option;
import quest.repositories.Content;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ErrorPageTest {


    Option choice;
    String path = "/";
    String value = "";
    int tmp;


    @BeforeAll
    static void setUpAll() {
	SelenideLogger.addListener("allure", new AllureSelenide());
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	Configuration.browserCapabilities = options;

    }

    @AfterAll
    static void tearDownAll() {
	SelenideLogger.removeListener("allure");

    }

    @DisplayName("should give an error page according to game level exceeded")
    @Test
    @Order(13)
    void shouldGiveErrorPage() {
	value = "right";
	Content.setLevel(4);
	int level = Content.getLevel();
	tmp = Content.getQuestions().size();
	if (value.equals("right")) {
	    choice = Option.RIGHT;
	} else if (value.equals("wrong")) {
	    choice = Option.WRONG;
	}

	switch (choice) {
	    case RIGHT -> path = choiceOfPath(Content.getLevel());
	    case WRONG -> path = "/fail";
	}
	open(path);
	$("#id_error").shouldBe(visible);

	String expected = "/error.jsp";
	String actual = path;
	assertEquals(expected, actual);
    }

    private String choiceOfPath(int level) {
	if (level < tmp) {
	    return "/fundament.jsp";
	} else if (level == tmp) {
	    return "/victory.jsp";
	}
	return "/error.jsp";
    }

}

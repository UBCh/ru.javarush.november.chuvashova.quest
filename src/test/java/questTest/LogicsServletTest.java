package questTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;
import quest.repositories.Content;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LogicsServletTest {

    SelenideElement button = $("#submit");

    @BeforeAll
    static void setUpAll() {
	SelenideLogger.addListener("allure", new AllureSelenide());
	Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
	
    }

    @AfterAll
    static void tearDownAll() {
	SelenideLogger.removeListener("allure");

    }


    @DisplayName("should give question according to the level1")
    @Test
    @Order(4)
    void shouldGiveQuestionNumberLevelOn() {
	open("/index.jsp");
	$("#submit").click();
	String expected = Content.getQuestions().get(1);
	String actual = $("#id_content").getText();
	open("/reStart");
	closeWebDriver();
	assertEquals(expected, actual);
	    }

    @DisplayName("should give question according to the level2")
    @Test
    @Order(5)
    void shouldGiveQuestionNumberLevelTwo() {
	open("/index.jsp");
	button.click();
	$("#id_choice").selectOptionByValue("right");
	button.click();
	String expected = Content.getQuestions().get(2);
	String actual = $("#id_content").getText();
	open("/reStart");
	closeWebDriver();
	assertEquals(expected, actual);
    }

    @DisplayName("should give question according to the level3")
    @Test
    @Order(6)
    void shouldGiveQuestionNumberLevelThree() {
	open("/index.jsp");
	button.click();
	String expected = Content.getQuestions().get(3);
	$("#id_choice").selectOptionByValue("right");
	button.click();
	$("#id_choice").selectOptionByValue("right");
	button.click();
	String actual = " " + $("#id_content").getText();
	open("/reStart");
	closeWebDriver();
	assertEquals(expected, actual);
    }

    @DisplayName("should give fail according to the level1")
    @Test
    @Order(7)
    void shouldGiveFailNumberLevelOn() {
	open("/index.jsp");
	button.click();
	String expected = Content.getAnswersFail().get(1);
	$("#id_choice").selectOptionByValue("wrong");
	button.click();
	String actual = $("#id_fail").getText();
	open("/reStart");
	closeWebDriver();
	assertEquals(expected, actual);
    }

    @DisplayName("should give fail according to the level2")
    @Test
    @Order(8)
    void shouldGiveFailNumberLevelTwo() {
	String expected = Content.getAnswersFail().get(2);
	open("/index.jsp");
	button.click();
	$("#id_choice").selectOptionByValue("right");
	button.click();
	$("#id_choice").selectOptionByValue("wrong");
	button.click();
	String actual = $("#id_fail").getText();
	open("/reStart");
	closeWebDriver();
	assertEquals(expected, actual);
    }

    @DisplayName("should give fail according to the level3")
    @Test
    @Order(9)
    void shouldGiveFailNumberLevelThree() {
	String expected = Content.getAnswersFail().get(3);
	open("/index.jsp");
	button.click();
	$("#id_choice").selectOptionByValue("right");
	button.click();
	$("#id_choice").selectOptionByValue("right");
	button.click();
	$("#id_choice").selectOptionByValue("wrong");
	button.click();
	String actual = $("#id_fail").getText();
	open("/reStart");
	closeWebDriver();
	assertEquals(expected, actual);
    }

}
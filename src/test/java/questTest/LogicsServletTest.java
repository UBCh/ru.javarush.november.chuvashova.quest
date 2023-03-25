package questTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;

import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;
import quest.controller.Option;
import quest.repositories.Content;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LogicsServletTest {

    @BeforeAll
    static void setUpAll() {
	SelenideLogger.addListener("allure", new AllureSelenide());
	Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
	open("/index.jsp");
	$("#submit").click();
    }

    @AfterAll
    static void tearDownAll() {
	SelenideLogger.removeListener("allure"	);
//	open("/reStart");
    }


    @DisplayName("should give question according to the level1")
    @Test
    @Order(1)
    void shouldGiveQuestionNumberLevelOn() {
	String expected = Content.getQuestions().get(1);
	String actual = $("#id_content").getText();
	assertEquals(expected, actual);
	closeWebDriver();
    }

    @DisplayName("should give question according to the level2")
    @Test
    @Order(2)
    void shouldGiveQuestionNumberLevelTwo() {
	$("#id_choice").selectOptionByValue("right");
	$("#submit").click();
	String expected = Content.getQuestions().get(2);
	String actual = $("#id_content").getText();
	assertEquals(expected, actual);
	closeWebDriver();
    }

    @DisplayName("should give question according to the level3")
    @Test
    @Order(3)
    void shouldGiveQuestionNumberLevelThree() {
	String expected = Content.getQuestions().get(3);
	SelenideElement button = $("#submit");
	$("#id_choice").selectOptionByValue("right");
	button.click();
	sleep(3000);
	$("#id_choice").selectOptionByValue("right");
	button.click();
	sleep(5000);
	String actual = " " + $("#id_content").getText();
	assertEquals(expected, actual);
	closeWebDriver();
    }

    @DisplayName("should give fail according to the level1")
    @Test
    @Order(4)
    void shouldGiveFailNumberLevelOn() {
	String expected = Content.getAnswersFail().get(1);
	SelenideElement button = $("#submit");
	$("#id_choice").selectOptionByValue("wrong");
	button.click();
	String actual = $("#id_fail").getText();
	assertEquals(expected, actual);
	closeWebDriver();
    }

    @DisplayName("should give fail according to the level2")
    @Test
    @Order(5)
    void shouldGiveFailNumberLevelTwo() {
	String expected = Content.getAnswersFail().get(2);
	SelenideElement button = $("#submit");
	$("#id_choice").selectOptionByValue("right");
	button.click();
	$("#id_choice").selectOptionByValue("wrong");
	button.click();
	String actual = $("#id_fail").getText();
	assertEquals(expected, actual);
	closeWebDriver();
    }

    @DisplayName("should give fail according to the level3")
    @Test
    @Order(6)
    void shouldGiveFailNumberLevelThree() {
	String expected = Content.getAnswersFail().get(3);
	SelenideElement button = $("#submit");
	$("#id_choice").selectOptionByValue("right");
	button.click();
	$("#id_choice").selectOptionByValue("right");
	button.click();
	$("#id_choice").selectOptionByValue("wrong");
	button.click();
	String actual = $("#id_fail").getText();
	assertEquals(expected, actual);
	closeWebDriver();
    }



}
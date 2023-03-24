package questTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;

import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;
import quest.repositories.Content;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LogicsServletTest {

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
    @Order(1)
    void shouldGiveQuestionNumberLevelOn() {
	open("/index.jsp");
	$("#submit").click();
	sleep(5000);
	String expected=Content.getQuestions().get(1);
	String actual=$("#id_content").getText();
		assertEquals(expected, actual);
	closeWindow();
	    }

    @DisplayName("should give question according to the level2")
    @Test
    @Order(2)
    void shouldGiveQuestionNumberLevelTwo() {
	open("/index.jsp");
	$("#submit").click();
	sleep(5000);
	String expected=Content.getQuestions().get(2);
	$("#id_right").click();
	String actual=$("#id_content").getText();
	assertEquals(expected, actual);
	closeWindow();
    }

    @DisplayName("should give question according to the level3")
    @Test
    @Order(3)
    void shouldGiveQuestionNumberLevelThree() {
	open("/index.jsp");
	$("#submit").click();
	sleep(5000);
	String expected=Content.getQuestions().get(3);
	SelenideElement button = $("#id_right");
	button.click();
	sleep(3000);
	button.click();
	sleep(5000);
	String actual=" "+$("#id_content").getText();
	assertEquals(expected, actual);
	closeWindow();
    }

    @DisplayName("should give fail according to the level1")
    @Test
    @Order(4)
    void shouldGiveFailNumberLevelOn() {
	open("/index.jsp");
	$("#submit").click();
	String expected=Content.getAnswersFail().get(1);
	sleep(5000);
	SelenideElement button=$("#id_wrong");
	button.click();
	sleep(3000);
	String actual=$("#id_fail").getText();
	assertEquals(expected, actual);
	closeWindow();
    }
    @DisplayName("should give fail according to the level2")
    @Test
    @Order(5)
    void shouldGiveFailNumberLevelTwo() {
	open("/index.jsp");
	$("#submit").click();
	String expected= Content.getAnswersFail().get(2);
	sleep(5000);
	$("#id_right").click();
	sleep(3000);
	$("#id_wrong").click();
	String actual=$("#id_fail").getText();
	assertEquals(expected, actual);
	closeWindow();
    }

    @DisplayName("should give fail according to the level3")
    @Test
    @Order(6)
    void shouldGiveFailNumberLevelThree() {
	open("/index.jsp");
	$("#submit").click();
	String expected=Content.getAnswersFail().get(3);
	sleep(5000);
	$("#id_right").click();
	sleep(5000);
	$("#id_right").click();
	sleep(5000);
	$("#id_wrong").click();
	String actual=$("#id_fail").getText();
	assertEquals(expected, actual);
	closeWindow();
    }

}
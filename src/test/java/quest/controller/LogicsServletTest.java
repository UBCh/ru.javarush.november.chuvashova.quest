package quest.controller;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;
import quest.repositories.LoaderBDContentForTest;

import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LogicsServletTest {

    SelenideElement button = $("#submit");
    LoaderBDContentForTest contentTest = new LoaderBDContentForTest();

    LogicsServletTest() throws SQLException, ClassNotFoundException {
    }


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
    @Order(6)
    void shouldGiveQuestionNumberLevelOn() {
	open("/index.jsp");
	sleep(2000);
	$("#submit").click();
	sleep(2000);
	$("#submit").click();
	String expected = LoaderBDContentForTest.getQuestionsTest().get(1);
	String actual = $("#id_content").getText();
	open("/reStart");
	closeWebDriver();
	assertEquals(expected, actual);
    }

    @DisplayName("should give question according to the level2")
    @Test
    @Order(7)
    void shouldGiveQuestionNumberLevelTwo() {
	open("/index.jsp");
	button.click();
	sleep(2000);
	button.click();
	$("#id_choice").selectOptionByValue("right");
	button.click();
	String expected = LoaderBDContentForTest.getQuestionsTest().get(2);
	String actual = $("#id_content").getText();
	open("/reStart");
	closeWebDriver();
	assertEquals(expected, actual);
    }

    @DisplayName("should give question according to the level3")
    @Test
    @Order(8)
    void shouldGiveQuestionNumberLevelThree() {
	open("/index.jsp");
	button.click();
	sleep(2000);
	button.click();
	var expected = LoaderBDContentForTest.getQuestionsTest().get(3).getBytes();
	$("#id_choice").selectOptionByValue("right");
	button.click();
	$("#id_choice").selectOptionByValue("right");
	button.click();
	var actual = $("#id_content").getText().getBytes();
	open("/reStart");
	closeWebDriver();
	for (int i = 0; i < actual.length; i++) {
	    assertEquals(expected[i], actual[i]);
	}
	    }


    @DisplayName("should give fail according to the level1")
    @Test
    @Order(9)
    void shouldGiveFailNumberLevelOn() {
	open("/index.jsp");
	button.click();
	sleep(2000);
	button.click();
	String expected = LoaderBDContentForTest.getAnswersFailTest().get(1);
	$("#id_choice").selectOptionByValue("wrong");
	button.click();
	String actual = $("#id_fail").getText();
	open("/reStart");
	closeWebDriver();
	assertEquals(expected, actual);
    }

    @DisplayName("should give fail according to the level2")
    @Test
    @Order(10)
    void shouldGiveFailNumberLevelTwo() {
	String expected = LoaderBDContentForTest.getAnswersFailTest().get(2);
	open("/index.jsp");
	button.click();
	sleep(5000);
	button.click();
	$("#id_choice").selectOptionByValue("right");
	sleep(5000);
	button.click();
	$("#id_choice").selectOptionByValue("wrong");
	sleep(5000);
	button.click();
	String actual = $("#id_fail").getText();
	open("/reStart");
	closeWebDriver();
	assertEquals(expected, actual);
    }

    @DisplayName("should give fail according to the level3")
    @Test
    @Order(11)
    void shouldGiveFailNumberLevelThree() {
	String expected = LoaderBDContentForTest.getAnswersFailTest().get(3);
	open("/index.jsp");
	button.click();
	sleep(5000);
	button.click();
	$("#id_choice").selectOptionByValue("right");
	sleep(5000);
	button.click();
	$("#id_choice").selectOptionByValue("right");
	sleep(5000);
	button.click();
	$("#id_choice").selectOptionByValue("wrong");
	sleep(5000);
	button.click();
	String actual = $("#id_fail").getText();
	sleep(5000);
	open("/reStart");
	closeWebDriver();
	assertEquals(expected, actual);
    }

    @DisplayName("should give victory page")
    @Test
    @Order(12)
    void shouldGiveVictoryPage() {
	open("/index.jsp");
	button.click();
	sleep(2000);
	button.click();
	String expected = LoaderBDContentForTest.victoryTextTest;
	$("#id_choice").selectOptionByValue("right");
	button.click();
	$("#id_choice").selectOptionByValue("right");
	button.click();
	$("#id_choice").selectOptionByValue("right");
	button.click();
	String actual = $("#id_victory").getText();
	open("/reStart");
	closeWebDriver();
	assertEquals(expected, actual);
    }

}
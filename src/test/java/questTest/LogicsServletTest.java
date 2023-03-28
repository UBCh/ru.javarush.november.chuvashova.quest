package questTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;
import quest.repositories.Content;
import quest.repositories.LoaderBDContentTest;

import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LogicsServletTest {

    SelenideElement button = $("#submit");
    LoaderBDContentTest contentTest=new LoaderBDContentTest();

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
    @Order(4)
    void shouldGiveQuestionNumberLevelOn() {
	open("/index.jsp");
	sleep(5000);
	$("#submit").click();
	String expected = contentTest.getQuestionsTest().get(1);
	String actual = $("#id_content").getText().trim();
	open("/reStart");
	closeWebDriver();
	assertEquals(expected, actual);
	    }

    @DisplayName("should give question according to the level2")
    @Test
    @Order(5)
    void shouldGiveQuestionNumberLevelTwo() {
	open("/index.jsp");
	sleep(5000);
	button.click();
	$("#id_choice").selectOptionByValue("right");
	button.click();
	String expected = contentTest.getQuestionsTest().get(2);
	String actual = $("#id_content").getText().trim();
	open("/reStart");
	closeWebDriver();
	assertEquals(expected, actual);
    }

    @DisplayName("should give question according to the level3")
    @Test
    @Order(6)
    void shouldGiveQuestionNumberLevelThree() {
	open("/index.jsp");
	sleep(5000);
	button.click();
	String expected = contentTest.getQuestionsTest().get(3);
	$("#id_choice").selectOptionByValue("right");
	button.click();
	$("#id_choice").selectOptionByValue("right");
	button.click();
	String actual =$("#id_content").getText().trim();
	open("/reStart");
	closeWebDriver();
	assertEquals(expected, actual);
    }



    @DisplayName("should give fail according to the level1")
    @Test
    @Order(7)
    void shouldGiveFailNumberLevelOn() {
	open("/index.jsp");
	sleep(5000);
	button.click();
	String expected = contentTest.getAnswersFailTest().get(1);
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
	String expected = contentTest.getAnswersFailTest().get(2);
	sleep(5000);
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
	String expected = contentTest.getAnswersFailTest().get(3);
	sleep(5000);
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
    @DisplayName("should give victory page")
    @Test
    @Order(10)
    void shouldGiveVictoryPage() {
	open("/index.jsp");
	sleep(5000);
	button.click();
	String expected = contentTest.victoryTextTest;
	$("#id_choice").selectOptionByValue("right");
	button.click();
	$("#id_choice").selectOptionByValue("right");
	button.click();
	$("#id_choice").selectOptionByValue("right");
	button.click();
	String actual =$("#id_victory").getText();
	open("/reStart");
	closeWebDriver();
	assertEquals(expected, actual);
    }

}
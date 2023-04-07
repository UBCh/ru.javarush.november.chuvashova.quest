package quest.controller;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;
import quest.repositories.LoaderBDContentForTest;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ReStartServletTest {
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


    @DisplayName("from the losing page should return to the start")
    @Test
    @Order(13)
    void shouldMustReturnToStartFail() {
	open("/index.jsp");
	button.click();
	sleep(2000);
	button.click();
	String expected = LoaderBDContentForTest.getAnswersFailTest().get(1);
	$("#id_choice").selectOptionByValue("wrong");
	button.click();
	$("#reStart_button").click();
	$("#id_choice").shouldBe(visible);
	open("/reStart");
	closeWebDriver();
    }


    @DisplayName("from the last page should return to the start")
    @Test
    @Order(14)
    void shouldMustReturnToStartVictory() {
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
	$("#reStart_button").click();
	$("#id_choice").shouldBe(visible);
	open("/reStart");
	closeWebDriver();
    }


    @DisplayName("from the last page should return to the start")
    @Test
    @Order(15)
    void shouldMustReturnToStartError() {
	open("/error.jsp");
	$("#reStart_button").click();
	$("#id_choice").shouldBe(visible);
	open("/reStart");
	closeWebDriver();
    }

}
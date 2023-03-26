package questTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ReStartServletTest {


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
    @Order(10)
    void shouldMustReturnToStartFail() {
	open("/fail");
	$("#reStart_button").click();
	$("#action").shouldBe(visible);
	open("/reStart");
	closeWebDriver();
	    }


    @DisplayName("from the last page should return to the start")
    @Test
    @Order(11)
    void shouldMustReturnToStartVictory() {
	open("/victory.jsp");
	$("#reStart_button").click();
	$("#action").shouldBe(visible);
	open("/reStart");
	closeWebDriver();
	    }


    @DisplayName("from the last page should return to the start")
    @Test
    @Order(12)
    void shouldMustReturnToStartError() {
	open("/error.jsp");
	$("#reStart_button").click();
	$("#action").shouldBe(visible);
	open("/reStart");
	closeWebDriver();
	    }

}
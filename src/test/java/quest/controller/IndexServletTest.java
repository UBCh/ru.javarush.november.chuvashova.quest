package quest.controller;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class IndexServletTest {

    SelenideElement button = $("#submit");

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


    @Test
    @DisplayName("the user entered his name, and it was saved in the session")
    @Order(5)
    public void shouldStoreName() {
	open("/index.jsp");
	button.click();
	$("#lname").setValue("johny");
	$("#submit").click();
	String expected = "johny";
	String actual = getValue($("#player_name").getText());
	open("/reStart");
	closeWindow();
	assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should get session id")
    @Order(4)
    public void shouldGetSessionId() {
	open("/index.jsp");
	button.click();
	sleep(3000);
	$("#lname").setValue("johny");
	$("#submit").click();
	String temp = $("#idSession").getText();
	String expected = getValue(temp);
	open("/reStart");
	$("#submit").click();
	sleep(2000);
	button.click();
	String actual = getValue($("#idSession").getText());
	open("/reStart");
	closeWindow();
	assertEquals(expected, actual);
    }

    @Test
    @DisplayName("gotta get the game number")
    @Order(3)
    public void shouldGetGameNumber() {
	open("/index.jsp");
	button.click();
	$("#lname").setValue("johny");
	button.click();
	$("#id_content").shouldBe(visible);
	int currentGame = Integer.parseInt(getValue($("#current_game").getText()));
	closeWindow();
	open("/index.jsp");
	button.click();
	sleep(3000);
	button.click();
	int expected = currentGame + 1;
	int actual = Integer.parseInt(getValue($("#current_game").getText()));
	open("/reStart");
	closeWebDriver();
	assertEquals(expected, actual);
    }


    private String getValue(String value) {
	String[] temp = value.split(":");
	return temp[1].trim();
    }

}
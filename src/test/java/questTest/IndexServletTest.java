package questTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class IndexServletTest {


    @BeforeAll
    static void setUpAll() {
	SelenideLogger.addListener("allure", new AllureSelenide());
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	Configuration.browserCapabilities = options;
    }

    @AfterAll
    static void tearDownAll() {
	SelenideLogger.removeListener("allure");

    }


    @Test
    @DisplayName("the user entered his name, and it was saved in the session")
    @Order(3)
    public void shouldStoreName() {
	open("/index.jsp");
	$("#lname").setValue("johny");
	$("#submit").click();
//	var expected = "Player name : johny";
	String expected ="johny";
	String actual  =getValue($("#player_name").getText());
	assertEquals(expected, actual);
	closeWindow();
    }

    @Test
    @DisplayName("should get session id")
    @Order(2)
    public void shouldGetSessionId() {
	open("/index.jsp");
	$("#lname").setValue("johny");
	$("#submit").click();
	sleep(7000);
	String temp=$("#idSession").getText();
	String expected = getValue(temp);
	closeWindow();
	open("/index.jsp");
	$("#submit").click();
	String actual =getValue($("#idSession").getText());
	assertNotEquals(expected, actual);
	closeWindow();
	    }

    @Test
    @DisplayName("gotta get the game number")
    @Order(1)
     public void shouldGetGameNumber() {
	open("/index.jsp");
	$("#lname").setValue("johny");
	$("#submit").click();
	$("#id_content").shouldBe(visible);
	int currentGame= Integer.parseInt(getValue($("#current_game").getText()));
	closeWindow();
	open("/index.jsp");
	$("#submit").click();
	int expected = currentGame+1;
	  int actual = Integer.parseInt(getValue($("#current_game").getText()));
	assertEquals(expected, actual);
    }


        private   String  getValue(String value){
	    String[] temp = value.split(":");
		return temp[1].trim();
	}


}
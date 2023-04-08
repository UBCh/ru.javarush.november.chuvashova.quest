package com.example.quest.controller;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.example.quest.controller.DispatherQuest.NameBD;
import com.example.quest.repositories.dispather.DispatcherRepository;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ErrorPageTest {

    DispatcherRepository dispatcher = new DispatcherRepository(NameBD.BD_QUEST);
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

    @DisplayName("should open an error page when selecting an unconnected game -psychology ")
    @Test
    @Order(1)
    void shouldGiveErrorPagePsychology() {
	open("/index.jsp");
	$("#id_choice").selectOptionByValue("BD_QUEST2");
	button.click();
	$("#id_error").shouldBe(visible);
	open("/reStart");
	closeWebDriver();
    }




    @DisplayName("should open an error page when selecting an unconnected game-humor")
    @Test
    @Order(2)
    void shouldGiveErrorPageHumor() {
	open("/index.jsp");
	$("#id_choice").selectOptionByValue("BD_QUEST3");
	button.click();
	$("#id_error").shouldBe(visible);
	open("/reStart");
	closeWebDriver();
    }
}

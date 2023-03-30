package quest.controller;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StartServletTest {
    @Mock
    HttpServletRequest request;

    @BeforeAll
    static void setUpAll() {
	SelenideLogger.addListener("allure", new AllureSelenide());
	Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");

    }

    @AfterAll
    static void tearDownAll() {
	SelenideLogger.removeListener("allure");
    }


    @DisplayName("when throwing SQLException should redirect to error.jsp page")
    @Test
    @Order(14)
    void shouldRedirectToErrorPageSQLException() throws SQLException, ClassNotFoundException, ServletException, IOException {
	StartServlet startServlet = spy(StartServlet.class);
	HttpServletResponse response =spy(HttpServletResponse.class);
	Mockito.doThrow(new SQLException()).when(startServlet).activateContent();
	startServlet.doGet(request, response);
	verify(response, times(1)).sendRedirect("/error.jsp");
    }

    @DisplayName("when throwing ClassNotFoundException should redirect to error.jsp page")
    @Test
    @Order(15)
    void shouldRedirectToErrorClassNotFoundException() throws SQLException, ClassNotFoundException, ServletException, IOException {
	StartServlet startServlet = spy(StartServlet.class);
	HttpServletResponse response =spy(HttpServletResponse.class);
	Mockito.doThrow(new ClassNotFoundException()).when(startServlet).activateContent();
	startServlet.doGet(request, response);
	verify(response, times(1)).sendRedirect("/error.jsp");
    }
}
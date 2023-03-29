package quest.controller;


import quest.repositories.Loader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "startServlet", value = "/start")
public class StartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
	    activateContent();
	} catch (SQLException e) {
	    e.printStackTrace();
	    resp.sendRedirect("/error.jsp");
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();  resp.sendRedirect("/error.jsp");
	}
	resp.sendRedirect("/start.jsp");

    }


    private void activateContent() throws SQLException, ClassNotFoundException {
	Loader loader = new Loader();
	loader.searchValue();
    }
}



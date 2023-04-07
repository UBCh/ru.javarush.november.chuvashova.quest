package quest.controller.servlets;


import quest.controller.DispatherQuest.DisperserQuest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "logicsServlet", value = "/logic")
public class LogicsServlet extends HttpServlet {

    int maxLevel = DisperserQuest.PAGE_CONTENT_by_LEVEL.size() - 1;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	Option choice = null;
	String path = "/";
	String value = "";
	resp.setContentType("text/html");
	value = req.getParameter("choice");

	if (value.equals("right")) {
	    choice = Option.RIGHT;
	} else if (value.equals("wrong")) {
	    choice = Option.WRONG;
	}

	switch (choice) {
	    case RIGHT -> path = choiceOfPath(Integer.parseInt(DisperserQuest.PAGE_CONTENT_by_LEVEL.get(0).get(3)));

	    case WRONG -> path = "/fail";
	}
	resp.sendRedirect(path);
    }

    private String choiceOfPath(int level) {
	if (level < maxLevel) {
	    return "/fundament.jsp";
	} else if (level == maxLevel) {
	    return "/victory.jsp";
	}
	return "/error.jsp";
    }

}

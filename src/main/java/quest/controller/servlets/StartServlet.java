package quest.controller.servlets;


import quest.controller.DispatherQuest.DisperserQuest;
import quest.controller.DispatherQuest.NameBD;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "startServlet", value = "/start")
public class StartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String path="";
	resp.setContentType("text/html,charset=UTF-8");
	String nameBD = req.getParameter("choice");
	switch (nameBD){
	    case ("BD_QUEST")->{path="/start.jsp"; break;}
	    case ("BD_QUEST2"), ("BD_QUEST3") -> {path="/error.jsp"; break;}
	}
	resp.sendRedirect(path);

    }


}



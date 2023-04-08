package com.example.quest.controller.servlets;


import com.example.quest.controller.DispatherQuest.DisperserQuest;

import javax.servlet.ServletException;
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
	int currentLevel= Integer.parseInt(DisperserQuest.PAGE_CONTENT_by_LEVEL.get(0).get(3));
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
	    case RIGHT :{path = choiceOfPath(currentLevel); break;}

	    case WRONG :{path = "/fail"; break;}
	}
	resp.sendRedirect(path);
	String level= String.valueOf(currentLevel+1);
	DisperserQuest.PAGE_CONTENT_by_LEVEL.get(0).set(3,level);

    }

    private String choiceOfPath(int level) {
	if (level < maxLevel) {
	    return "/fundament.jsp";
	} else if (level == maxLevel) {
	    return "/victory.jsp";
	}
	return "/error.jsp";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req,resp);
    }
}
package com.example.quest.controller.servlets;


import com.example.quest.controller.DispatherQuest.DisperserQuest;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "restartServlet", value = "/reStart")
public class ReStartServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

	response.setContentType("text/html;charset=UTF-8");
	DisperserQuest.PAGE_CONTENT_by_LEVEL.get(0).set(3, String.valueOf(0));
	response.sendRedirect("/index.jsp");
    }

}

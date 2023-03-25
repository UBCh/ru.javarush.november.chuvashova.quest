package quest.controller;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.sampled.AudioFormat;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "initServlet", value = "/init")
public class InitServlet extends HttpServlet {
    int current = 0;
    String name = "";


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

	resp.setContentType("text/html,charset=UTF-8");
	name=req.getParameter("lname");

	current = current + 1;
	HttpSession session = req.getSession();
	String idSession = session.getId();
      	session.setAttribute("idSession", idSession);
	session.setAttribute("name",name);
	session.setAttribute("current", current);
	resp.sendRedirect("/fundament.jsp");
	    }


	    }



package quest.controller;



import quest.repositories.Content;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "logicsServlet", value = "/logic")
public class LogicsServlet extends HttpServlet{
    Option choice;
      String path="/";
String value="";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
       value = req.getParameter("choice");

       if (value.equals("right")) {
           choice= Option.RIGHT;}
       else if (value.equals("wrong")){ choice= Option.WRONG;}

           switch (choice){
               case RIGHT ->  path=choiceOfPath(Content.getLevel());
               case WRONG -> path="/fail";
       }
        resp.sendRedirect(path);
          }




     private String choiceOfPath( int  level) {
         switch (level) {
             case 1,2: {
                   return "/fundament.jsp";
             }
                        case 3:
                 return "/victory.jsp";
         }

         return null;
     }


}

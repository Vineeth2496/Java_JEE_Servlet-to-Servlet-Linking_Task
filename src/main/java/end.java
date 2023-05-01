

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class end extends HttpServlet {


	  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException
	  {
		  HttpSession ses=   req.getSession();
		   // closoing firpage(login) to last pase(end) converzatio.. so that anothter user re login
		   ses.invalidate();
		   
		  PrintWriter  out=   resp.getWriter();
		     
		   out.println(" sucfylly logout");
		   // re direct to login(ui)
	   RequestDispatcher  rd=	   req.getRequestDispatcher("ui.html");
		   
	      rd.include(req, resp);
	  }
}

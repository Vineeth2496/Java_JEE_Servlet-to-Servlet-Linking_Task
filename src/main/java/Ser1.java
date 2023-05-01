

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class Ser1 extends HttpServlet {

	
	  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException
	  {
		  
		   // reading ui data
		  
		   String email=  req.getParameter("email");
		   String pass=  req.getParameter("pass");
		     
		      
		  PrintWriter out=  resp.getWriter();
		    
		   // Q: the abaove compare to DB data
		   
		   HttpSession  ses=  req.getSession();
		   
		    if(email.equals("ravi@gmail.com")&& pass.equalsIgnoreCase("R123"))
		    {
		    	 // forwading req, resp to anther servlet, then another servlet is givign respon
		      // the above email , pass data/values are sending to  Ser2 using HttpSession methods
		    	
		      ses.setAttribute("a", email);
		      ses.setAttribute("b", pass);
		       
		       RequestDispatcher rd=  req.getRequestDispatcher("Ser2");
		         
		         rd.forward(req, resp);
		    }
		    else
		    {
		    	// same servlet is giving respon
		    	 // here we can include, servlet and html also
		    	
		    	 out.println("LOGIN FAIL");
		    	 out.println("<html>");
		    	  
			     RequestDispatcher rd=  req.getRequestDispatcher("ui.html");
			     rd.include(req, resp);
			     out.println("</html>");
			    
		    } 
		    
		   
		   
		   
		  
		  
	  }

}

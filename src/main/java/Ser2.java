

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class Ser2 extends HttpServlet {
 
	  public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException
	  {
		PrintWriter  out=  resp.getWriter();
		  
		
		  // recieving data from Ser1 into current servelet
		
	 HttpSession	 hs=  req.getSession(false);
		  	   
	   // other peoples  not accessong
	     if(hs !=  null)
	     {

	  	   String email=(String)  hs.getAttribute("a");

	  	   String pass=(String)  hs.getAttribute("b");
	  	    

	      out.println(email+","+pass);
		  
	      out.println("<h1>WELCOME TO INBOX</h1>");
		 
	       // after information closing convernaion so that linking  Ser3
	      
	      // session/order completed
	      
	  // RequestDispatcher rd=     req.getRequestDispatcher("end");
	       out.println("<a href='end'>click for close</a>");
	       
	      //rd.include(req, resp);
	      
	     }
	     else
	     {
	    	  // continue order
	    	 
	    	 // not in session/ not in login
	       out.println(" u did not login/session.. so plze login");
	       
	    RequestDispatcher rd= req.getRequestDispatcher("ui.html");
	         rd.include(req, resp);
	     }
		  
		  
	  }

}

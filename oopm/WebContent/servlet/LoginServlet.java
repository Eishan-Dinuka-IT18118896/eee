package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Customerloginimplent;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		    String username = request.getParameter("uid");
		    String password = request.getParameter("pass");
		    
		    boolean isTrue;
		    
		    isTrue = Customerloginimplent.validate(username, password);
		    if(isTrue == false)
		    {
		    
		    RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
		    dis.forward(request, response);    
		    }
		    else if (isTrue == true)
		    {
		    	RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
			    dis.forward(request, response);
		    }
		}

	}


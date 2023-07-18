package JavaClasses.Handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import JavaClasses.DAO.DAO_Logic;


@WebServlet("/SignInPageHandler")
public class SignInPageHandler extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	public SignInPageHandler()
	{
		super();
	}

	protected void doPost(HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException  
	{
		response.setContentType("text/html");
		PrintWriter pw= response.getWriter();
		
		String Email = request.getParameter("Email");
		String Password = request.getParameter("Password");
		
		if(DAO_Logic.loginPage(Email, Password))
		{
			RequestDispatcher rd =request.getRequestDispatcher("HomePage.html");
			rd.forward(request, response);
		}
		else
		{	
			pw.write("<script> alert('somthing went wrong !!! please try again')</script> ");
			RequestDispatcher rd =request.getRequestDispatcher("Sign_in.html");
			rd.forward(request, response);
		}
	}

}

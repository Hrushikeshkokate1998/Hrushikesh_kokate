package JavaClasses.Handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JavaClasses.BO.SignBO;
import JavaClasses.DAO.DAO_Logic;

@WebServlet("/SignUpPageHandler")

public class SignUpPageHandler extends HttpServlet {
	
	
	
	private static final long serialVersionUID = 1L;
	
	public SignUpPageHandler() {
        super();
        
    }

	protected void doPost(HttpServletRequest request , HttpServletResponse response ) throws IOException ,ServletException 
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String name 	  = request.getParameter("name");
		String email 	  = request.getParameter("email");
		String Password   = request.getParameter("pass_1");
		String Repassword = request.getParameter("pass_2");
		
	SignBO ps = new SignBO(name , email , Password , Repassword);
	
	int status  = DAO_Logic.insertSingUp(ps);
	
	if(status>0)
	{
		pw.print("<center><h2><Data is inserted></h2></center>");
		RequestDispatcher rd=request.getRequestDispatcher("Sign_in.html");
		rd.include(request, response);
		
	} 
	else 
	{
		pw.print("<center><h2><Data is inserted></h2></center>");
		RequestDispatcher rd=request.getRequestDispatcher("SignUp.html");
		rd.include(request, response);
	}
	
	}
	
}

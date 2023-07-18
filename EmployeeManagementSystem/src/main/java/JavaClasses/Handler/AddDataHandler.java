package JavaClasses.Handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JavaClasses.BO.EmployeeBO;
import JavaClasses.DAO.DAO_Logic;

@WebServlet("/AddDataHandler")
public class AddDataHandler extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public AddDataHandler() {super();} 
	
	protected void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException
	{
		response.setContentType("text/html");
		PrintWriter pw= response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobileNo = request.getParameter("phone");
		String DOJ = request.getParameter("doj");
		String DOB = request.getParameter("dob");
		String AdharNo = request.getParameter("adhar");
		
		EmployeeBO ob =new EmployeeBO(id,name, email, mobileNo, DOJ, DOB, AdharNo); 
		
		int status = DAO_Logic.addEmployee(ob);
		
		if(status>0)
		{
			pw.print("Employee data Inserted");
			RequestDispatcher rd = request.getRequestDispatcher("HomePage.html");
			rd.forward(request, response);
		}
		else
		{
			pw.print("Employee data is not Insert");
			RequestDispatcher rd = request.getRequestDispatcher("AddingDataPage.html");
			rd.forward(request, response);
		}
	
	}

}
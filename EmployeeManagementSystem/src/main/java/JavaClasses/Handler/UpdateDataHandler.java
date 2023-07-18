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

@WebServlet("/UpdateDataHandler")
public class UpdateDataHandler extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public UpdateDataHandler() {super();}
	
	protected void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		String name= request.getParameter("name");
		String email= request.getParameter("email");
		String mobile= request.getParameter("phone");
		String DOJ= request.getParameter("doj");
		String DOB= request.getParameter("dob");
		String adhar= request.getParameter("adhar");
		
		EmployeeBO eb=new EmployeeBO();
		
		eb.setId(id);
		eb.setName(name);
		eb.setEmail(email);
		eb.setMobileNo(mobile);
		eb.setDOJ(DOJ);
		eb.setDOB(DOB);
		eb.setAdharNo(adhar);
		
		int status = DAO_Logic.update(eb);
		
		
		if(status>0)
        {
       	 RequestDispatcher rd= request.getRequestDispatcher("FetchingDataHandler");
       	 
       	 rd.forward(request, response);
        }
		
				
		
	}
	
	
	
}

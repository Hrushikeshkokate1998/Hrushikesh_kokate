package JavaClasses.Handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JavaClasses.BO.EmployeeBO;
import JavaClasses.DAO.DAO_Logic;

@WebServlet("/UpdateDataHandler2")
public class UpdateDataHandler2  extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	public UpdateDataHandler2() {super();}
	
	protected void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException ,ServletException
	{
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();  
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		DAO_Logic.getElementById(id);
		
		EmployeeBO eb = DAO_Logic.getElementById(id);
		
			pw.print("<center><form  action ='UpdateDataHandler' method = 'get'> ");
			pw.print("<table>");
			
			pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+eb.getId()+"'/></td></tr>");  
			pw.print("<tr><td>Name: </td> <td><input type='text' name='name' value='"+eb.getName()+"'/></td></tr>");
		   	pw.print("<tr><td>Email: </td> <td><input type='text' name='email' value='"+eb.getEmail()+"'/></td></tr>");
		   	pw.print("<tr><td>Phone:</td> <td><input type='text' name='phone' value='"+eb.getMobleNo()+"'/></td></tr>");
		   	pw.print("<tr><td>Date of Joining : </td> <td><input type='text' name='doj' value='"+eb.getDOJ()+"'/></td></tr>");
		   	pw.print("<tr><td>Date of Birth: </td> <td><input type='text' name='dob' value='"+eb.getDOB()+"'/></td></tr>");
		   	pw.print("<tr><td>Adhar Card: </td> <td><input type='text' name='adhar' value='"+eb.getAdharNo()+"'/></td></tr>");
		
		
			pw.print("<tr><td><input type='submit' value='Update'/></td></tr>"); 
		
			pw.print("</table>");
		
			pw.print("</form>");
		
		
			pw.print("<Button><a href='FetchingDataHandler'>Back</a></Button>");
		   pw.print("<link rel=\"stylesheet\" href=\"CSS/insert3.css\"></center>");
		
		
		
	}

}

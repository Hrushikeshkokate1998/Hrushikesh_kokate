package JavaClasses.Handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JavaClasses.BO.EmployeeBO;
import JavaClasses.DAO.DAO_Logic;

@WebServlet("/SearchDataHandler")
public class SearchDataHandler extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public SearchDataHandler(){super();}
	
	protected void doGet(HttpServletRequest request , HttpServletResponse response ) throws IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw= response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id")); 
		pw.print("<table border='1px' width='100%'>");
		pw.print("<tr style='color:white;'> <th>ID</th> <th>Name</th> <th>Email</th> <th>Mobile No</th> <th>Date of Join</th> <th>Date of Birth</th> <th>Adhar ID</th> </tr>");
		
			
		List<EmployeeBO> ob = DAO_Logic.search(id);
		
		for(EmployeeBO el:ob)
		{
			pw.print(" <tr style='color:white;'> <td>"+el.getId()+"</td> <td>"+el.getName()+"</td> <td>"+el.getEmail()+"</td> <td>"+el.getMobleNo()+"</td> <td>"+el.getDOJ()+"</td> <td>"+el.getDOB()+"</td> <td>"+el.getAdharNo()+"</td> </tr>");
		}
		
		
		
		 pw.print("<Button><a href='FetchingDataHandler'>Back</a></Button>");
		   pw.print("<link rel=\"stylesheet\" href=\"CSS/insert.css\">");
	
	
	}
	

}



















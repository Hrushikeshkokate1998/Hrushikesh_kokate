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

@WebServlet("/FetchingDataHandler")
public class FetchingDataHandler extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public FetchingDataHandler() {super();}
	
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		pw.print("<form action=\"SearchDataHandler\"  method = \"Get\"> ");
		
		pw.print("<h2>Enter the ID for Searching Data : <input type =\"text\" Name = \"id\"  Placeholder =\"Enter the ID\" />"
				+ "<Button type=\"submit\" id =\"button2\">  Serach</Button> </h2>");
		
		pw.print("</form>");
		
		
		pw.print("<table border='1px' width='100%'> ");
		
		pw.print("<tr style='color:white;'> <th >Id</th>  <th>Name</th>  <th>Email</th>  <th>Mobile No</th>  <th>Date Of Join</th>  <th>Date of Birth</th>  <th>Adhar Number</th> <th>Action</th> <th>Action</th> </tr>");
		
		List<EmployeeBO> list =DAO_Logic.fetchData();
		
		for(EmployeeBO eb :list)
		{
			pw.print("<tr style ='color:white;'> <td>"+eb.getId()+"</td> <td>"+eb.getName()+"</td> <td>"+eb.getEmail()+"</td> <td>"+eb.getMobleNo()+"</td> <td>"+eb.getDOJ()+"</td> <td>"+eb.getDOB()+"</td> <td>"+eb.getAdharNo()+"</td> <td> <a  href='UpdateDataHandler2?id="+eb.getId()+"'><center> <Button id=\"bt1\"> Update </Button></center> </a> </td>  "+" <td> <a  href='DeleteDataHandler?id="+eb.getId()+"'> <center><Button id=\"bt1\"> Delete</Button></center> </a> </td>  </tr>");
		}
		
		 pw.print("</table>");			

		  

		 pw.print("<Button id =\"button2\"><a href='HomePage.html'>Back</a></Button>");
		 pw.print("<link rel=\"stylesheet\" href=\"CSS/insert2.css\">");
	
		
	}
}

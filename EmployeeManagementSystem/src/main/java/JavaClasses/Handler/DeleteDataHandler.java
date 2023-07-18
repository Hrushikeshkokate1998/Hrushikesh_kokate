package JavaClasses.Handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JavaClasses.DAO.DAO_Logic;

@WebServlet("/DeleteDataHandler")
public class DeleteDataHandler extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public DeleteDataHandler() {super();}
	
	
	protected void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException
	{
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		int id =Integer.parseInt(request.getParameter("id"));
		
		DAO_Logic.delete(id);
		
		response.sendRedirect("FetchingDataHandler");
		
		
	}
	

}

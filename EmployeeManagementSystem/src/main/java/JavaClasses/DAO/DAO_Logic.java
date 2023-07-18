package JavaClasses.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import JavaClasses.BO.EmployeeBO;
import JavaClasses.BO.SignBO;


public class DAO_Logic {
	
	public static Connection connect()
	{
		Connection con = null;
		
		String url = "jdbc:mysql://localhost:3306/Project"; 
		String id ="root";
		String password = "Hrushikesh@123";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url,id,password);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
		
	}
	//-----------------------------------------------------
	public static int insertSingUp(SignBO lb)
	{
		int status =0;
		try {
		Connection con = DAO_Logic.connect();
		String query = "INSERT into Login values(?,?,?,?);";
		
		PreparedStatement ps = con.prepareStatement(query);
		
		ps.setString(1, lb.getName());
		ps.setString(2, lb.getEmail());
		ps.setString(3, lb.getPassword());
		ps.setString(4, lb.getRepassword());
		
		status =ps.executeUpdate(); 
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return status;
	}
	//---------------------------------------------------------------
	public static boolean loginPage(String Email ,String Password)
	{	
		boolean status = false;
		
		try {
			Connection con = DAO_Logic.connect();
			
			String query = "Select * from login where Email=? AND Password=?";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, Email);
			ps.setString(2, Password);
			
			ResultSet rs = ps.executeQuery();
			
			status = rs.next();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}
	//---------------------------------------------------------------
	public static int addEmployee(EmployeeBO l1)
	{
		int status = 0;
		
		try
		{
			Connection con = DAO_Logic.connect();
			String queary = "INSERT INTO employeeinfomation values( ?,?,?,?,?,?,? )";
			PreparedStatement ps =con.prepareStatement(queary);
			
			ps.setInt(1, l1.getId());
			ps.setString(2, l1.getName());
			ps.setString(3, l1.getEmail());
			ps.setString(4, l1.getMobleNo());
			ps.setString(5, l1.getDOJ());
			ps.setString(6, l1.getDOB());
			ps.setString(7, l1.getAdharNo());
			
			status = ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
		return status;
			
	}
	//-----------------------------------------------------
	public static List fetchData()
	{
		List<EmployeeBO> list = new ArrayList<EmployeeBO>();
		
		try
		{
			Connection con = DAO_Logic.connect();
			
			PreparedStatement ps =con.prepareStatement("SELECT * from employeeinfomation");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				EmployeeBO eb = new EmployeeBO();
			
				eb.setId(rs.getInt(1));
				eb.setName(rs.getString(2));
				eb.setEmail(rs.getString(3));
				eb.setMobileNo(rs.getString(4));
				eb.setDOJ(rs.getString(5));
				eb.setDOB(rs.getString(6));
				eb.setAdharNo(rs.getString(7));
				
				list.add(eb);
				
			}
		}catch (Exception e) {
			
		}
		return list;
	}
	
	//-----------------------------------------------------
	public static int update(EmployeeBO eb )
	{
		int status = 0;
		
		try {
			Connection con = DAO_Logic.connect();
			
			String query ="update  employeeinfomation SET name=? , Email=? , MobileNo=?, DOJ=? ,DOB=? , AdharNo=?  where ID=?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, eb.getName());
			ps.setString(2, eb.getEmail());
			ps.setString(3, eb.getMobleNo());
			ps.setString(4, eb.getDOJ());
			ps.setString(5, eb.getDOB());
			ps.setString(6, eb.getAdharNo());
			ps.setInt(7, eb.getId());
			
			status = ps.executeUpdate();
		}
		catch (Exception e) {
			
		}
		return status;
	}
	//----------------------------------------------------- 
	public static EmployeeBO getElementById(int id)
	{	
		EmployeeBO eb= new EmployeeBO();
		
		try 
		{
			Connection con = DAO_Logic.connect();
			
			String query = "Select * from employeeinfomation  where ID=? ";
			
			PreparedStatement ps =con.prepareStatement(query);
			
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				eb.setId(rs.getInt(1));
				eb.setName(rs.getString(2));
				eb.setEmail(rs.getString(3));
				eb.setMobileNo(rs.getString(4));
				eb.setDOJ(rs.getString(5));
				eb.setDOB(rs.getString(6));
				eb.setAdharNo(rs.getString(7));
			}
				
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return eb;
	}
	//----------------------------------------------------- 
	public static int delete(int id)
	{		
		int status = 0;
		
		try {
			
			Connection con = DAO_Logic.connect();
			
			String query  = "Delete from employeeinfomation where ID=?";
			PreparedStatement ps =con.prepareStatement(query);
			
			ps.setInt(1, id);
			
			status = ps.executeUpdate();
			
		} catch (Exception e) {
			
		}
		return status;
		
	}
	
	//------------------------------------------------------------------
	public static List search(int id)
	{
		int status = 0;
		List<EmployeeBO> ob = new ArrayList(); 
		
		try
		{
			Connection con = DAO_Logic.connect();
			String query = "Select * from employeeinfomation where ID=? "; 
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				EmployeeBO eb=new EmployeeBO();
				
				eb.setId(rs.getInt(1));
				eb.setName(rs.getString(2));
				eb.setEmail(rs.getString(3));
				eb.setMobileNo(rs.getString(4));
				eb.setDOJ(rs.getString(5));
				eb.setDOB(rs.getString(6));
				eb.setAdharNo(rs.getString(7));
				
				ob.add(eb);
				
			}
			
		}catch (Exception e) {
			
		}
		
		return ob;
	}
	

}



















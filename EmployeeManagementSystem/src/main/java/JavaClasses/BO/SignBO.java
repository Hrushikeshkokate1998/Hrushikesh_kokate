package JavaClasses.BO;

public class SignBO {
	
	private String Name;
	private String Email;
	private String Password;
	private String Repassword;
	
	public SignBO(String Name , String Email ,String Password ,String Repassword )
	{
		this.Name=Name;
		this.Email= Email;
		this.Password= Password;
		this.Repassword = Repassword;	
	}
	//-------------------------------------
	public String getName()
	{
		return Name;
	}
	public String getEmail()
	{
		return Email;
	}
	public String getPassword()
	{
		return Password;
	}
	public String getRepassword()
	{
		return Repassword;
	}
	
	public String toString()
	{
		return "\n Name :"+Name+" Email :"+Email+" Password :"+Password+" RePassword :"+Repassword;
		
	}
	
	
}

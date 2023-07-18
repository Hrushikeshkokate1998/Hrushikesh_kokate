package JavaClasses.BO;

public class EmployeeBO {
	
	private int Id;
	private String Name;
	private String Email;
	private String MobileNo;
	private String DOJ;
	private String DOB;
	private String AdharNo;
	
	public int getId()
	{
		return Id;
	}
	public String getName()
	{
		return Name;
	}
	public String getEmail()
	{
		return Email;
	}
	public String getMobleNo()
	{
		return MobileNo;
	}
	public String getDOJ()
	{
		return DOJ;
	}
	public String getDOB()
	{
		return DOB;
	}
	public String getAdharNo()
	{
		return AdharNo ;
	}
	//-------------------------------------------
	public void setId(int id) {
		Id = id;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}
	public void setDOJ(String dOJ) {
		DOJ = dOJ;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public void setAdharNo(String adharNo) {
		AdharNo = adharNo;
	}
	
	public EmployeeBO(int Id , String Name ,String Email ,String MobileNo ,String DOJ , String DOB, String AdharNo )
	{
		super();
		this.Id=Id;
		this.Name=Name;
		this.Email=Email;
		this.MobileNo=MobileNo;
		this.DOJ=DOJ;
		this.DOB=DOB;
		this.AdharNo=AdharNo;
	}
	
	public EmployeeBO() {
		super();
		
	}
	
	@Override
	public String toString()
	{
		return "\n id = "+Id+", name="+Name+" Email ="+Email+ " Mobile no = "+MobileNo+" DOJ = "+DOJ +"DOB "+DOB+" ADHAR NO ="+AdharNo;
	}
	
	
}

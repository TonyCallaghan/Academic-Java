import java.text.DecimalFormat;

public class Employee {
	
	private int id;
	private String name;
	private String title;
	private Department dept;
	private int annualSalary;
	private static DecimalFormat currency = new DecimalFormat("£,000.00");//for displaying Salaries.	
	
	public Employee()
	{
		//null constructor
	}
	
	public Employee(int id, String name, String title, int annualSalary)
	{
		this.id= id;
		this.name = name;
		this.title = title;
		this.annualSalary = annualSalary;
		
	}
	
	public void printDetails()
	{
		
		System.out.println("ID:     \t" + id);
		System.out.println("Name:   \t" + name);
		System.out.println("Job title:\t" + title);
		System.out.println("Salary: \t" + currency.format(annualSalary));
		
		if(dept.equals(null))
		{
			System.out.println("Department not found. Please edit.");
		}
		else
		{
			System.out.println("Department: \t" + dept.getDeptName());
		}
		System.out.println("****************************");
	}
	public void printSimpleDetails() 
	{
		System.out.println("ID:  " + id + "\t Name:  " + name);
	}
	public void printSimpleMDetails() 
	{
		System.out.println("ID: " + id  + " | Salary: " + currency.format(annualSalary)+ " |\t Name: " + name);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public int getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(int annualSalary) {
		this.annualSalary = annualSalary;
	}


	
	
}

	

import java.util.ArrayList;

public class Department {

	private int deptID;
	private String deptName;
	private ArrayList<Employee> departmentEmployees = new ArrayList<Employee>();
	
	
	public Department()
	{
		//null constructor
	}
	
	public Department(int deptID, String deptName)
	{
		this.deptID = deptID;
		this.deptName = deptName;
	}
	
	public void addEmployee(Employee e)
	{
		//use the add() method to add an Employee to the ArrayList
		departmentEmployees.add(e);
	}
	public void removeEmployee(Employee e)
	{
		//use the remove() method to remove an Employee from ArrayList(Department)
		departmentEmployees.remove(e);
		
	}
	
	public void printDeptDetails()
	{
		System.out.println("Department ID:   \t" + deptID );
		System.out.println("Department Name: \t" + deptName );
		System.out.println("**********************************");
	}
		
	
	

	public int getDeptID() {
		return deptID;
	}

	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public ArrayList<Employee> getDepartmentEmployees() {
		return departmentEmployees;
	}

	public void setDepartmentEmployees(ArrayList<Employee> DepartmentEmployees) {
		this.departmentEmployees = departmentEmployees;
	}
	
	
}

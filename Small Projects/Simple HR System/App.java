import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

	private static Scanner input = new Scanner(System.in); //Capturing user input (ints, doubles, etc.)
	private static InputStreamReader textInput = new InputStreamReader(System.in);//Capturing user input (Strings)
	private static BufferedReader reader = new BufferedReader(textInput);//Capturing user input (Strings)
	private static DecimalFormat currency = new DecimalFormat("£,000.00");//for displaying salaries.
	private static DecimalFormat perc = new DecimalFormat("00");//for displaying percentages.

	static int pin = 1234 ;// Administrator Entry
	static double totalWages= 0; //for calculating total salary per department.
	private static int centralEmpID = 19;//Setting the ID value,
	private static int centralDeptID = 105;//so the user doesn't overlap.
	static double departmentsNo;// for calculating Percentage.
	static double totalAnnualSalaries = 0;// for calculating total salary.
	
	
	private static ArrayList<Department> allDepartments = new ArrayList<Department>();//arrayList for departments.
	private static ArrayList<Employee> allEmployees = new ArrayList<Employee>();//arrayList for Employees
	

	public static void main(String[] args)//main
	{
		prePopulate();//calls Method that will create various objects.
		mainMenu();//calls menu.
	}
	
	public static void mainMenu()// welcome page.
	{
		System.out.println("	*****WELCOME*****	");
		System.out.println("");
		System.out.println("Please select from the following options:");
		System.out.println("");
		System.out.println("Press 1 for Employee Menu.");
		System.out.println("Press 2 for Department Menu.");
		
		String choice = input.next();//Captures User's choice.
		switch(choice) //Switch statement
		{
			case "1":
			{
				System.out.println("Loading Employee Menu...");
				System.out.println("");
				empMenu();//Calls Employee Menu
				break;
			}
			case "2":
			{
				System.out.println("Loading Department Menu...");
				System.out.println("");
				deptMenu();//Calls Department Menu
				break;
			}
			case "a":
			case "A"://Incase CAPS are on.
			{
				System.out.println("Please enter pin number:");//stops random user's accessing the admin's page
				int enteredPin = input.nextInt();//User types in pin
				
				if(enteredPin==pin)// if user's pin equals pin, then call admin().
				{
					System.out.println("Correct Pin. Loading Admin Mode...");
					admin();//calls admin method
				}
				else //if not, return to menu.
				{
					System.out.println("Pin is Incorrect.. Returning to Menu.");
					mainMenu(); //return
				}
				break;
			}
			default:
			{
				System.out.println("Invalid choice.. Returning to Menu.");
				mainMenu(); // If user enters anything else(String/char etc.)
			}
		}
	}
	
	public static void empMenu() // Menu for all the Employee Options
	{
		System.out.println("	*****Employee Menu*****	");
		System.out.println("");
		System.out.println("Please select from the following options:");
		System.out.println("");
		System.out.println("Press 1 To view all Employees.");
		System.out.println("Press 2 To view all Employess by Department.");
		System.out.println("Press 3 To edit an Employee from the System.");
		System.out.println("Press 4 To Add an Employee to the System.");
		System.out.println("Press 5 To Remove an Employee from the System.");
		System.out.println("Press 6 To Return to menu");
		
		
		String choice = input.next(); //Captures User's choice.
		switch(choice) //Switch statement
		{
		case"1":
			{
				viewEmployees();// calls employee viewer.
				break;
			}
		case"2":
			{
				viewEmployeesByDept(); // calls employee viewer(by dept).
				break;
			}
		case"3":
			{
				try { // Try and Catch blocks
				editEmployee(); // edit
				break;
				}catch(Exception e){
					empMenu(); // if not, call menu;
				}
			}
		case"4":
			{
				try {
					addEmployee();
				} catch (Exception e) {
					empMenu();
				}
				break;
			}
		case"5":
			{
				removeEmployee();
				break;
			}
		case"6":
			{
				mainMenu(); // return
				break;
			}
		default:
			{
				System.out.println("Invalid choice..");
				empMenu(); // If user enters something incorrect.
			}
		}
	}
	
	public static void viewEmployees() // Allows User to view all Employees.
	{
		for(Employee e: allEmployees) //Loop calling all Employee objects.
		{
			e.printDetails(); //print method from 'Employee' class.
		}
		empMenu();// return
	}
	
	public static void viewEmployeesByDept() // Allows User to view Employees by dept.
	{
		
		
		
		for(Department d: allDepartments) //Loop calling all Department objects.
		{
			System.out.println(d.getDeptID() +"\t"+ d.getDeptName() ); //GET and Print ID and Name of each Department.
		}
		System.out.println("Choose Department you wish to view."); 
		
		int departmentChoice = input.nextInt(); //Captures User's choice of dept.
		for(Employee e: allEmployees)//Loop calling all Employee objects.
		{
			if(departmentChoice == e.getDept().getDeptID()) // If department choice equals that of the Employee
			{
				e.printDetails(); // Then print details.
			}
		}	
		empMenu();// Return when loop has finished
	}
		
	public static void editEmployee() throws Exception // Allows User to edit Employee
	{
		for(Employee e: allEmployees) // Loop calling all Employee objects.
		{
			e.printSimpleDetails(); // print details, in shortened form.
		}
		System.out.println("Choose  to edit by ID"); // 
		int chosenEmp = input.nextInt(); //Captures User's choice.
		
		for(Employee e: allEmployees) //loop
		{
			if(chosenEmp==e.getId()) // if choice equals id of Employee
			{
				System.out.println("Enter new name for " + e.getName());// edit - get name
				e.setName(reader.readLine());							// edit - set new name.
				System.out.println("Enter new Title to replace " + e.getTitle());
				e.setTitle(reader.readLine());
				System.out.println("Enter new Salary to replace " + e.getAnnualSalary());
				e.setAnnualSalary(input.nextInt());// Update Employee's Details.
				
				System.out.println("Employee Details have been recorded.");
				System.out.println("Would you like to edit another? ");
				System.out.println("Press 1 for yes.");
				System.out.println("Press 2 to return to menu");
				
				String choice = input.next();//Captures User's choice.
				switch(choice) // Switch statement.
				{
				case"1":
					{
						editEmployee(); // Edit another.
						break;
					}
				default:
					{
						mainMenu(); // Return.
						break;
					}
				}
				
				
			}
		}
	}
	
	public static void addEmployee() throws Exception // Allows the user to add an Employee.
	{
		Employee e = new Employee(); //Creates an empty Employee object
		e.setId(centralEmpID); //Use set methods to fill in the values
		centralEmpID++; // Increments the ID, so the Data values don't overlap.
		System.out.println("Enter Employee Name:");
		e.setName(reader.readLine());
		System.out.println("Enter Employee Title:");
		e.setTitle(reader.readLine());
		System.out.println("Enter Employee Salary:");
		e.setAnnualSalary(input.nextInt());
		
		System.out.println("Choose Employee Department by ID number");
		for(Department d: allDepartments)
		{
			d.printDeptDetails();
		} //Print list of Departments
		int DeptID = input.nextInt(); //capture id number from user.

		for(Department d: allDepartments)
		{
			if(DeptID==d.getDeptID())
			{
				e.setDept(d); //Add chosen department to Employer
				d.addEmployee(e); //Add employee to Department
				System.out.println(e.getName() +" has been employed for " + d.getDeptName());
			}
			
		}
		allEmployees.add(e); // Adds the new Employee to the arrayList
		
		System.out.println("***************************************");
		System.out.println("Would you like to add another employee? ");
		System.out.println("Press 1 for yes.");
		System.out.println("Press 2 to return to menu");
		String choice = input.next();//Captures User's choice.
		switch(choice)
		{
		case"1":
			{
				addEmployee(); // add another.
				break;
			}
		default:
			{
				mainMenu(); //Return
				break;
			}
		}
	}
	
	public static void removeEmployee() //Delete Employee
	{
		for(Employee e: allEmployees) // Loop calling all Employee objects.
		{
			e.printSimpleDetails();//Print method.
		}
		System.out.println("Choose ID number of Employee to delete:");
		int chosenEmp = input.nextInt();//Captures User's choice of Employee.
		
		for(Employee e: allEmployees) // Loop calling all Employee objects.
		{
			if(chosenEmp==e.getId())
			{
				allEmployees.remove(e); // Removes object from Employee arrayList.
				for(Department d: allDepartments) // Loop calling all Department objects.
				{
					if(e.getDept().equals(d))
					{
						e.setDept(null);// sets dept as null.
						d.removeEmployee(e); // Removes object from dept.
						System.out.println("Employee has been removed from the system..");
						System.out.println("Returning to Menu..");
						empMenu(); // Return
					}
				}
			}
		}
	}

	public static void deptMenu() //Menu for Departments
	{
		System.out.println("	*****Department Menu*****	");
		System.out.println("");
		System.out.println("Please select from the following options:");
		System.out.println("");
		System.out.println("Press 1 to view Departments. ");
		System.out.println("Press 2 to add Department. ");
		System.out.println("Press 3 to delete Department. ");
		System.out.println("Press 4 to return to menu.");
		
		String choice = input.next(); //Captures User's choice.
		switch(choice) //Switch statement
		{
		case"1":
			{
				viewDepartments();
				break;
			}
		case"2":
			{
				try {
					addDepartment();
				} catch (Exception e) {
					deptMenu(); // Return
				}
				break;
			}
		case"3":
			{
				try {
					deleteDepartment();
				} catch (Exception e) {
					deptMenu(); //Return
				}
				break;
			}
		case"4":
			{ 
				mainMenu();//Return
				break;
			}
		default:
			{
				System.out.println("Invalid choice..");
				deptMenu(); // error
			}
		}
	}
	
	public static void viewDepartments() //Allows the user to View departments.
	{
		for(Department d: allDepartments) // Loop calling all department objects.
		{
			d.printDeptDetails(); //Print Method from 'Department'
		}
		deptMenu(); //Return
	}
	
	public static void addDepartment() throws Exception //Allows User to add department
	{
		Department d = new Department(); //Creates an empty Department object
		d.setDeptID(centralDeptID); //Use set methods to fill in the values
		centralDeptID++; // Increments the ID, so the Data values don't overlap.
		System.out.println("Enter Department Name:");
		d.setDeptName(reader.readLine()); //capture String from user
		allDepartments.add(d); // Adds the new Department to the arrayList.
		 
		System.out.println(d.getDeptName() +" department has been established."); // success message.
			
		
		System.out.println("***************************************");
		System.out.println("Would you like to add another Department? ");
		System.out.println("Press 1 for yes.");
		System.out.println("Press 2 to return to menu");
		
		String choice = input.next();//Captures User's choice.
		switch(choice) //Switch Statement.
		{
		case"1":
			{
				addDepartment(); // Add another dept.
				break;
			}
		default:
			{
				mainMenu(); //Return.
				break;
			}
		}
	}
		
	public static void deleteDepartment() throws Exception //Allows User to delete department
	{
		for(Department d: allDepartments)
		{
			d.printDeptDetails();
		}
		System.out.println("Choose ID number of Department to delete:");
		int chosenDept = input.nextInt();
		
		for(Department d: allDepartments)
		{
			if(chosenDept==d.getDeptID())
			{
				System.out.println("This Department has been removed from the system..");
				System.out.println("Please Edit any Employees attached to: '" +d.getDeptName() + "'");
				allDepartments.remove(d);
				
				System.out.println("Returning to Menu..");
				deptMenu();
					
				}
			}
		}
	
	public static void admin() //Menu for administrator.
	{
		System.out.println("	*****WELCOME*****	");
		System.out.println("");
		System.out.println("Please select from the following options:");
		System.out.println("");
		System.out.println("Press 1 to view Salary by Department.");
		System.out.println("Press 2 to view Total Salary spending in the company.");
		System.out.println("Press x to return to Menu.");
		
		String choice = input.next(); //Captures User's choice.
		switch(choice)
		{
		case"1":
			{
				deptSalary();
				break;
			}
		case"2":
			{
				totalSalary();//
				break;
			}
		case"x":
		case"X":
			{
				mainMenu();
			}
		default:
			{
				System.out.println("Invalid Choice..");
				admin();
				break;
			}
		}
	}
	
	public static void deptSalary() //Calculation for total annual Salaries per Department
	{
		double totalPerDept = 0; //Reset total..
		//This will make sure 2 different 'total' values are not added together.
		for(Department d: allDepartments) // Loop calling all Department objects.
		{
			System.out.println(d.getDeptID() +"\t"+ d.getDeptName() );//Print Details
		}
		System.out.println("Choose Department you wish to view total salaries of by ID");//User chooses which one to display
		
		int departmentChoice = input.nextInt();// Captures user's choice for dept.
		for(Employee e: allEmployees)//Loop calling all Employee objects
		{
			if(departmentChoice == e.getDept().getDeptID())//choice matches department..
			{
				totalPerDept = e.getAnnualSalary() + totalPerDept; // Add annual Salary of each employee in dept. to total
			}
		}	
			System.out.println("total Annual Salary for choosen dept: " + currency.format(totalPerDept));// print total
		
			for(Employee e: allEmployees) //Loop calling all Employee objects
			{
				
				{
					totalAnnualSalaries = e.getAnnualSalary() + totalAnnualSalaries;// calculation for current total
				}
			}
			
			totalWages = totalPerDept / totalAnnualSalaries * 100;// total of that department divided by total overall.
			//Then multiplied by 100 to give a percentage.
			System.out.println("This is "+perc.format(totalWages)+"% of the total wages."); // Print Percentage
			System.out.println("");//Spacing for console
			System.out.println("***************************************************");
			
			totalPerDept =0;
			totalAnnualSalaries =0;
			totalWages =0;
		
			admin();
	}
	
	public static void totalSalary() //Calculation for total annual Salaries
	{
		totalAnnualSalaries =0;	//Make sure total is set to zero before calculation
		for(Employee e: allEmployees) //for loop for every Employee
		{
			e.printSimpleMDetails();//Only print neccessary Details
			totalAnnualSalaries = e.getAnnualSalary() + totalAnnualSalaries; //Add AnnualSalary to Total
			System.out.println("");//spacing for console
		}
		
			System.out.println("Total Annual Salary: " + currency.format(totalAnnualSalaries));// print total now that the loop is executed.
			System.out.println("");
			System.out.println("***************************************************");
			totalAnnualSalaries =0;// Reset total, Incase the method is called again... 
			//This will make sure 2 different 'total' values are not added together.
			admin();//Return
	}
	
	public static void prePopulate()// So the user has information to begin with
	{
		//SALES
		Department d1 = new Department(101, "Sales");//New department
		allDepartments.add(d1);// Add to arrayList
		Employee e1 = new Employee(1, "Tony Callaghan", "Sales Representative", 99999); //New Employee (object) 
		Employee e2 = new Employee(2, "Johnson Rhem", "Senior Sales Representative", 42650); //New Employee (object) 
		Employee e3 = new Employee(3, "Gisele Ellingsworth", "Sales Consultant", 59700); //New Employee (object) 
		Employee e4 = new Employee(4, "Nicki Mcguire", "Sales Manager", 62000); //New Employee (object) 
		e1.setDept(d1); //Set the department of object 1 the 'Sales'
		e2.setDept(d1); //Set the department of object 2 the 'Sales'
		e3.setDept(d1); //Set the department of object 3 the 'Sales'
		e4.setDept(d1); //Set the department of object 4 the 'Sales'
		allEmployees.add(e1); // Add employee(1) to arrayList
		allEmployees.add(e2); // Add employee(2) to arrayList
		allEmployees.add(e3); // Add employee(3) to arrayList
		allEmployees.add(e4); // Add employee(4) to arrayList
		
		//PRODUCTION
		Department d2 = new Department(102, "Production");
		allDepartments.add(d2);
		Employee e5 = new Employee(5, "Brant Quintal", "Assembly Supervisor", 25500);
		Employee e6 = new Employee(6, "Vernia Langner", "Chief Manufacturing Executive", 43200);
		Employee e7 = new Employee(7, "Laurel Gullion", "Director of Quality Management", 31100);
		Employee e8 = new Employee(8, "Ellen Ruddy", "Operator", 26600);
		Employee e9 = new Employee(9, "Antione Bickerstaff", "Operator", 24700);
		Employee e10 = new Employee(10, "Staci Bird", "Operator", 23900);
		e5.setDept(d2);
		e6.setDept(d2);
		e7.setDept(d2);
		e8.setDept(d2);
		e9.setDept(d2);
		e10.setDept(d2);
		allEmployees.add(e5);
		allEmployees.add(e6);
		allEmployees.add(e7);
		allEmployees.add(e8);
		allEmployees.add(e9);
		allEmployees.add(e10);
			
		//MARKETING
		Department d3 = new Department(103, "Marketing");
		allDepartments.add(d3);
		Employee e11 = new Employee(11, "Billy Leanos", "Marketing analyst.", 47600);
		Employee e12 = new Employee(12, "Zackary Degraffenreid", "Social Media Representative", 28100);
		Employee e13 = new Employee(13, "Jefferson Yokoyama", "Social Media Representative", 32300);
		Employee e14 = new Employee(14, "Chasity Ferrigno", "Marketing and promotions manager", 77800);
		e11.setDept(d3);
		e12.setDept(d3);
		e13.setDept(d3);
		e14.setDept(d3);
		allEmployees.add(e11);
		allEmployees.add(e12);
		allEmployees.add(e13);
		allEmployees.add(e14);
		
		//FINANCE
		Department d4 = new Department(104, "Finance");
		allDepartments.add(d4);
		Employee e15 = new Employee(15, "Lionel Lebowitz", "Accountant", 47550);
		Employee e16 = new Employee(16, "Damien Ghent", "Financial branch manager", 88975);
		Employee e17 = new Employee(17, "Kasi Usry", "Financial analyst", 38650);
		Employee e18 = new Employee(18, "Mazie Yockey", "Financial examiner", 32980);
		e15.setDept(d4);
		e16.setDept(d4);
		e17.setDept(d4);
		e18.setDept(d4);
		allEmployees.add(e15);
		allEmployees.add(e16);
		allEmployees.add(e17);
		allEmployees.add(e18);		
	}

}
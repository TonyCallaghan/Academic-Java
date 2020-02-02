import java.util.Scanner;

public class Con4 
{
	static String name;
	static int age;
	static String city;
	static Scanner input = new Scanner(System.in);
	
	
	public static void main(String[] args)
	{
		menu();
	}
	
	public static void menu()
	{
		//Give user options
		System.out.println("Press 1 to Enter Name");
		System.out.println("Press 2 to Enter Age");
		System.out.println("Press 3 to Enter City");
		System.out.println("Press 4 to Print All");
		System.out.println("Press X to Exit");
		
		// Capture user choice
		String choice = input.next(); 
		
		// Match choice to relevant case
		switch(choice)
		{
			case "1":
			{
				enterName();
				break;
			}
			case "2":
			{
				enterAge();
				break;
			}
			case "3":
			{
				enterCity();
				break;
			}
			case "4":
			{
				printAll();
				break;
			}
			case "x":
			{
				System.out.println("Closing Program...");
				System.exit(0); //Program stops running here.
			}
			default:
			{
				System.out.println("Invalid Choice. Please try again");
				break;
			}
		
		}
		
		menu();
	}
	
	public static void enterName()
	{
		System.out.println("Enter name");
		name = input.next();
	}
	
	public static void enterAge()
	{
		System.out.println("Enter age");
		age = input.nextInt();
	}
	
	public static void enterCity()
	{
		System.out.println("Enter city");
		city = input.next();
	}
	
	public static void printAll()
	{
		System.out.println("Name is " + name);
		System.out.println("Age is " + age);
		System.out.println("City is " + city);
	}

}

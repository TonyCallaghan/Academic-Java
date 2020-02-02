import java.util.Scanner;

public class Con3 
{
	static Scanner input = new Scanner(System.in);
	
	static int counter =0;
	
	
	public static void main(String[] args)
	{
		menu();
	}
	
	public static void menu()
	{
		if(counter==3) //Use double equals for matching
		{
			System.out.println("Too many incorrect attempts. System shutting down");
			System.exit(1);
		}
		
		
		System.out.println("Press 1 to Say Hello");
		System.out.println("Press 2 to Exit");
		
		String choice = input.next();
		
		switch(choice)
		{
			case "1":
			{
				sayHello();
				break; //Always place break at bottom of case, code below here won't run
			}
			case "2":
			{
				System.out.println("Closing program...");
				System.exit(0);
				break; //Break command exits the Switch Statement
			}
			default:
			{
				counter++;
				System.out.println("Invalid Choice. Please Try Again");
				break;
			}
		}
		
		
		
		menu();
	}
	
	public static void sayHello()
	{
		System.out.println("Say Hello");
	}
	

}

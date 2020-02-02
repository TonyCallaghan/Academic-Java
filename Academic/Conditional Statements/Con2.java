import java.util.Scanner;

public class Con2 
{
	static Scanner input = new Scanner(System.in);
	static int numPasses =0;
	static int numFails =0;
	
	public static void main(String[] args)
	{
		menu();
	}
	
	public static void menu()
	{
		System.out.println("Press 1 to Check a Score");
		System.out.println("Press 2 to Exit Program");
		
		int choice = input.nextInt();
		
		switch(choice)
		{
			case 1:
			{
				checkScore();
				break;
			}
			case 2:
			{
				System.out.println("Passed: " + numPasses);
				System.out.println("Failed: " + numFails);
				System.out.println("Program shut down");
				System.exit(0);
			}
			default:
			{
				System.out.println("Invalid Choice. Please try again");
				break;
			}
		}
		menu();
	}
	
	public static void checkScore()
	{
		System.out.println("Enter a score");
		double score = input.nextDouble();
		
		if(score<40)
		{
			System.out.println("Failed");
			numFails++;
		}
		else
		{
			System.out.println("Passed");
			numPasses++;
		}
	}

}

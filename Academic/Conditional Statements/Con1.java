import java.util.Scanner;

public class Con1 
{
	/*
	 * Program Flow is the execution order of a program.
	 * As we know, the starting point is the main method.
	 * Commands/Statements are then executed line by line.
	 * When the program has no more commands to execute it stops
	 * or "terminates"
	 */
	
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter score");
		
		double score = input.nextDouble();
		
		if(score<40)
		{
			System.out.println("This score has failed");
		}
		else
		{
			System.out.println("This score has passed");
		}
		
	}

}

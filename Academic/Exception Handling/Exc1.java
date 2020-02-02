import java.util.Scanner;

public class Exc1 {

	public static void main(String[] args) 
	{
		/*
		 * Three types of errors we can encounter in programming
		 * (1) Syntax: The code is wrong, i.e. missing semicolon, wrong case etc.
		 * Syntax errors highlight red in Eclipse and we are unable to save & compile our
		 * code until we correct our mistake.
		 * 
		 * (2) Logic: A logic error occurs where the output of a program is incorrect. So my syntax 
		 * may be correct but the maths, calculation or processing inside of the program give me the 
		 * wrong answer. This can be difficult to spot. Debugging and tracing are good ways to find
		 * logic errors.
		 * 
		 * (3) Run Time: A run time error occurs during the execution of the program i.e. an error is 
		 * encountered and crashes the program. Common examples including entering text into a field 
		 * which has a numeric data type, infinite loops, array out of bounds exceptions etc.
		 * 
		 * Everything in Java is an Object, which means that even errors have their own data type/classes
		 * built to capture them. This class/data type is called Exception. We can prevent our program from
		 * crashing by "catching" Exceptions.
		 */
		try 
		{
			Scanner input = new Scanner(System.in);
			
			int number = input.nextInt();
			
			System.out.println("You entered the number " + number);
		
		}
		catch(Exception e)
		{
			System.out.println("An error has been logged");
		}
		
		
	}

}

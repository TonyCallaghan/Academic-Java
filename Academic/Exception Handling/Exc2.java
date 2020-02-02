import java.util.Scanner;

public class Exc2 
{
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		
		try{
			inputMethod1();
			
		}
		catch(Exception e)
		{
			System.out.println("An error has been logged");
		}
		
	}
	
	public static void inputMethod1() throws Exception
	{
		
		System.out.println("Enter a number");
		int number = input.nextInt();
		
		
		
		outputMethod();
		
		
	}
	
	public static void outputMethod()
	{
		
	}
	

}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Exc3 
{
	static InputStreamReader textInput = new InputStreamReader(System.in);
	static BufferedReader reader = new BufferedReader(textInput);

	public static void main(String[] args) 
	{
		try {
		System.out.println("Enter your full name");
		String fullName = reader.readLine();
		
		System.out.println("Enter your address");
		String address = reader.readLine();
		
		System.out.println(fullName);
		
		System.out.println(address);
		}
		catch(Exception e)
		{
			System.out.println("An error has been logged");
		}

	}

}

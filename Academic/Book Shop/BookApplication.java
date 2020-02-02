import java.util.Scanner;

public class BookApplication 
{

	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args)
	{

		exercise3();
	}
	
	public static void exercise3() {
		Book b1 = new Book(102, "Harry Potter", "JK Rowling", 9.99, 15, true);
		b1.printBookDetails();
		
		Book b2 = b1; //We can create additional references to the same object
		//If I want to create a new object we need to call its constructor.
		b2.setBookAuthor("Tom Smith"); //This command is simply changing JK Rowling to Tom Smith
		
		b1.printBookDetails();
		
		
	}
	
	public static void exercise2()
	{
	
		Book b1 = new Book();
		System.out.println("Enter ID");
		b1.setBookID(input.nextInt());
		System.out.println("Enter title");
		b1.setBookTitle(input.next());
		System.out.println("Enter author");
		b1.setBookAuthor(input.next());
		System.out.println("Enter price");
		b1.setBookPrice(input.nextDouble());
		System.out.println("Enter quantity");
		b1.setBookQty(input.nextInt());
		b1.setBookStatus(true); //assume in print
		b1.printBookDetails();
		
	}
	
	public static void exercise1()
	{ //Skills Demo Project Requirement
		Book b1 = new Book();
		Book b2 = new Book(102, "Harry Potter", "JK Rowling", 9.99, 15, true);
		b1.setBookID(101);
		b1.setBookTitle("To Kill a Mocking Bird");
		b1.setBookAuthor("Harper Lee");
		b1.setBookPrice(5.99);
		b1.setBookQty(10);
		b1.setBookStatus(false);
		b1.printBookDetails();
		b2.printBookDetails();
		
		
	}
	
}

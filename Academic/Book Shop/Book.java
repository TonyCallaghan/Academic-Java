
public class Book 
{
	// (1) Define Properties of the Object
	private int bookID;
	private String bookTitle;
	private String bookAuthor;
	private double bookPrice;
	private int bookQty;
	private boolean inPrint;
	
	// (2) Declare Constructors
	
	public Book()
	{
		//Null Constructor - When called creates an empty object
	}
	
	public Book(int id, String title, String author, double price, int qty, boolean status)
	{
		bookID = id;
		bookTitle = title;
		bookAuthor = author;
		bookPrice = price;
		bookQty = qty;
		inPrint = status;
		//Constructor with fields - when called creates an object and values are set instantly.
		//Note: All or nothing - can only call this method, if I have book data to send
	}
	// (3) Write Methods - Remember to be consistent with the naming in the UML Diagram
	public void printBookDetails()
	{
		System.out.println("***************************");
		System.out.println("Book ID: \t" + bookID);
		System.out.println("Book Title: \t" + bookTitle);
		System.out.println("Book Author: \t" + bookAuthor);
		System.out.println("Book Price: \t" + bookPrice);
		System.out.println("Qty in Stock: \t" + bookQty);
		System.out.println("***************************");
	}
	
	public void setBookID(int id)
	{
		bookID = id;
	}
	public int getBookID()
	{
		return bookID; //Replace void with the datatype of the variable to be returned.
	}
	public void setBookTitle(String title)
	{
		bookTitle = title;
	}
	public String getBookTitle()
	{
		return bookTitle;
	}
	public boolean isBookInPrint()
	{
		return inPrint;
	}
	public void setBookStatus(boolean status)
	{
		inPrint = status;
	}
	public void setBookQty(int qty)
	{
		bookQty = qty;
	}
	public int getBookQty()
	{
		return bookQty;
	}
	public double getPrice()
	{
		return bookPrice;
	}
	public void setBookPrice(double price)
	{
		bookPrice = price;
	}
	public String getBookAuthor()
	{
		return bookAuthor;
	}
	public void setBookAuthor(String author)
	{
		bookAuthor = author;
	}

}

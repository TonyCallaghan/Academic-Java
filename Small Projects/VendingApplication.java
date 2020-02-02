import java.text.DecimalFormat;
import java.util.Scanner;

public class VendingApplication 
{
	static Scanner input = new Scanner(System.in);
	static DecimalFormat currency = new DecimalFormat("€0.00");
	static int qtyCoke = 10;
	static int qty7up = 10;
	static int qtyFanta = 2;
	static double totalCash = 0;
	static int numTransactions =0;
	static int pin = 1234;
	
	public static void main(String[] args)
	{
		menu();
	}
	
	public static void menu()
	{
		System.out.println("Welcome to the BFEI Vending Machine");
		System.out.println("-----------------------------------");
		System.out.println("Press 1 for Coke");
		System.out.println("Press 2 for 7-Up");
		System.out.println("Press 3 for Fanta");
		System.out.println("-----------------------------------");
	
		String choice = input.next();
		
		switch(choice)
		{
			case "1":
			{
				if(qtyCoke==0)
				{
					System.out.println("Item Out of Stock. Please choose another");
					menu();
				}
				String product = "coke";
				double price = 1.20;
				payment(product, price);
				break;
			}
			case "2":
			{
				if(qty7up==0)
				{
					System.out.println("Item Out of Stock. Please choose another");
					menu();
				}
				String product = "7up";
				double price = 1.10;
				payment(product, price);
				break;
			}
			case "3":
			{
				if(qtyFanta==0)
				{
					System.out.println("Item Out of Stock. Please choose another");
					menu();
				}
				
				String product = "fanta";
				double price = 1.00;
				payment(product, price);
				break;
			}
			case "a":
			{
				System.out.println("Please enter pin number");
				int enteredPin = input.nextInt();
				
				if(enteredPin==pin)
				{
					System.out.println("Correct Pin. Loading Admin Mode");
					admin();
				}
				else
				{
					System.out.println("Incorrect Pin. Try again");
				}
				break;
			}
			case "x":
			{
				System.out.println("System closing down");
				System.exit(0);
				break;
			}
			default:
			{
				System.out.println("Invalid Choice. Please choose again");
				break;
			}
		}
		menu();
	}
	
	public static void payment(String productChoice, double transactionPrice)
	{
		System.out.println("Enter Payment. Balance is " + currency.format(transactionPrice));
		
		double moneyEntered = input.nextDouble(); //User enters payment
		
		while(moneyEntered<transactionPrice)
		{
			System.out.println("Enter payment. Balance remaining is " + currency.format((transactionPrice-moneyEntered)));
			moneyEntered = moneyEntered + input.nextDouble(); //user tops up payment and overwrites existing amount
		}
		//Product has been purchased at this point
		if(moneyEntered>transactionPrice)
		{
			System.out.println("Change due is " + currency.format((moneyEntered-transactionPrice)));
		}
		System.out.println("Transaction Successful. Please take your product");
		
		numTransactions++;
		totalCash = totalCash + transactionPrice; //Update total takings with value of the transaction
		
		if(productChoice.equals("coke"))
		{
			qtyCoke--;
		}
		else if (productChoice.equals("fanta"))
		{
			qtyFanta--;
		}
		else
		{
			qty7up--;
		}
		
	}
	
	public static void admin()
	{
		System.out.println("Total Takings: " + currency.format(totalCash));
		System.out.println("Number of Transactions: " + numTransactions);
		System.out.println("Average Value of a Transaction " + currency.format((totalCash/numTransactions)));
		System.out.println("Coke Stock Remaining " + qtyCoke);
		System.out.println("7up Stock Remaining " + qty7up);
		System.out.println("Fanta Stock Remaining " + qtyFanta);
		
		System.out.println("Press r to restock or any other key to exit admin mode");
		
		String choice = input.next();
		
		if(choice.equals("r"))
		{
			qtyCoke =10;
			qty7up =10;
			qtyFanta =10;
		}
	
		
		
	}
	

}

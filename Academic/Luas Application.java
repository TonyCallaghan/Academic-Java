import java.text.DecimalFormat;
import java.util.Scanner;

public class LuasApplication 
{
	//Ticket Price Variables
	static double adultSingle = 1.20;
	static double adultReturn = 2.00;
	static double childSingle = 0.60;
	static double childReturn = 1.00;
	
	static double multiTransactionPrice =0;
	
	//Admin/Stats Variables
	static double totalCash =0;
	static int numTransactions =0;
	static int numAdultTicketsSold =0;
	static int numChildTicketsSold =0;
	static int transactionAdultTickets=0;
	static int transactionChildTickets=0;
   
	
	//Library Object variables
	static Scanner input = new Scanner(System.in);
	static DecimalFormat currency = new DecimalFormat("€0.00");
	
	public static void main (String[] args)
	{
		chooseZone();
	}
	
	public static void calcCost(int numZones, double ticketPrice, String ticketType)
	{
		double multiZoneDiscount = .20;
		double transactionPrice = numZones * ticketPrice;
		double transactionDiscount = numZones * multiZoneDiscount;
		transactionPrice = transactionPrice - transactionDiscount;
		payment(numZones, transactionPrice, ticketType);
		
	}
	public static void chooseTicketType(int numZones)
	{
		System.out.println("Press 1 for Adult Single");
		System.out.println("Press 2 for Adult Return");
		System.out.println("Press 3 for Child Single");
		System.out.println("Press 4 for Child Return");
		System.out.println("Press 5 for Multiple Tickets");
		System.out.println("Press X to Cancel");
		
		String choice = input.next();
		
		switch(choice)
		{
			case "1":
			{
				System.out.println("You have chosen Adult Single");
				calcCost(numZones, adultSingle, "adult");
				break;
			}
			case "2":
			{
				System.out.println("You have chosen Adult Return");
				calcCost(numZones, adultReturn, "adult");
				break;
			}
			case "3":
			{
				System.out.println("You have chosen Child Single");
				calcCost(numZones, childSingle, "child");
				break;
			}
			case "4":
			{
				System.out.println("You have chosen Child Return");
				calcCost(numZones, childReturn, "child");
				break;
			}
			case "5":
			{
				addTickets(numZones);
				break;
			}
			case "x":
			{
				System.out.println("Transaction Cancelled");
				chooseZone();
				break;
			}
			default:
			{
				System.out.println("Invalid Choice. Please try again");
				chooseTicketType(numZones);
			}
		}
	
	}

	public static void addTickets(int numZones)
	{
		System.out.println("Please enter number of Adult tickets");
		transactionAdultTickets = input.nextInt();
		
		System.out.println("Please enter number of Child tickets");
		transactionChildTickets = input.nextInt();
		
	
		
		System.out.println("Press 1 for Single");
		System.out.println("Press 2 for Return");
		
		String choice = input.next();
		double adultTransactionPrice =0;
		double childTransactionPrice =0;
		
		if(choice.equals("1"))
		{
			System.out.println("You have chosen Single");
			
			adultTransactionPrice = adultSingle * numZones;
			double adultTransactionDiscount = .20 *numZones;
			adultTransactionPrice = adultTransactionPrice - adultTransactionDiscount;
			adultTransactionPrice = adultTransactionPrice * transactionAdultTickets;
			
			childTransactionPrice = childSingle* numZones;
			double childTransactionDiscount = .20 * numZones;
			childTransactionPrice = childTransactionPrice - childTransactionDiscount;
			childTransactionPrice = childTransactionPrice * transactionChildTickets;
				
			
			multiTransactionPrice = adultTransactionPrice + childTransactionPrice;
			payment(numZones,multiTransactionPrice,"multi");
		}
		else if(choice.equals("2"))
		{
			System.out.println("You have chosen Return");
			adultTransactionPrice = adultReturn * numZones;
			double adultTransactionDiscount = .20 *numZones;
			adultTransactionPrice = adultTransactionPrice - adultTransactionDiscount;
			adultTransactionPrice = adultTransactionPrice * transactionAdultTickets;
			
			childTransactionPrice = childReturn * numZones;
			double childTransactionDiscount = .20 * numZones;
			childTransactionPrice = childTransactionPrice - childTransactionDiscount;
			childTransactionPrice = childTransactionPrice * transactionChildTickets;
			multiTransactionPrice = adultTransactionPrice + childTransactionPrice;
			payment(numZones,multiTransactionPrice,"multi");
		}
		else
		{
			System.out.println("Invalid Choice. Please try again");
			addTickets(numZones); //Bring them back to the start of the method
		}
		

	}
	public static void payment(int numZones, double transactionPrice, String ticketType)
	{
		System.out.println("You have chosen to travel " + numZones + " zones");
		System.out.println("Transaction Price is " + currency.format(transactionPrice));
		System.out.println("Please enter payment");
		
		double moneyEntered = input.nextDouble();
		
		while(moneyEntered<transactionPrice)
		{
			System.out.println("Balance Remaining is " + currency.format(transactionPrice-moneyEntered));
			System.out.println("Enter cash");
			moneyEntered = moneyEntered + input.nextDouble();
		}
		//Successful Transaction
		if(moneyEntered>transactionPrice)
		{
			System.out.println("Change is " + currency.format(moneyEntered-transactionPrice));
		}
		totalCash = totalCash + transactionPrice;
		numTransactions++;
		
		if(ticketType.equals("adult"))
		{
			numAdultTicketsSold++; 
		}
		else if(ticketType.equals("child"))
		{
			numChildTicketsSold++;
		}
		else
		{
			//Executes for the multi ticket option
			numAdultTicketsSold = numAdultTicketsSold + transactionAdultTickets;
			numChildTicketsSold = numChildTicketsSold + transactionChildTickets; 
		}
		reset();
		
	}
	public static void reset()
	{
		transactionAdultTickets =0; //Reset to zero to delete any existing data
		transactionChildTickets=0; // " " " "
		multiTransactionPrice=0;
		chooseZone(); //Go back to the beginning
	}
	public static void admin()
	{
		System.out.println("Total Number of Tickets Sold  \t" + (numAdultTicketsSold+numChildTicketsSold));
		System.out.println("Adult Tickets Sold: \t " + numAdultTicketsSold);
		System.out.println("Child Tickets Sold: \t " + numChildTicketsSold);
		System.out.println("Total Number of Transactions: " + numTransactions);
		System.out.println("Total Cash: \t" + currency.format(totalCash));
		System.out.println("Average Cash Per Transaction: " + currency.format(totalCash/numTransactions));
	}
	
	public static void chooseZone()
	{
		System.out.println("******Welcome to the Luas*************");
		System.out.println("Enter number of zones to travel");
		System.out.println("Press 1 for one zone");
		System.out.println("Press 2 for two zones");
		System.out.println("Press 3 for three zones");
		System.out.println("Press 4 for four zones");
		System.out.println("Press 5 for five zones");
		System.out.println("***************************************");
		
		String choice = input.next();
		
		switch(choice)
		{
			case "1":
			{
				System.out.println("You have chosen travel one zone.");
				chooseTicketType(1);
				break;
			}
			case "2":
			{
				System.out.println("You have chosen travel two zones.");
				chooseTicketType(2);
				break;
			}
			case "3":
			{
				System.out.println("You have chosen travel three zones.");
				chooseTicketType(3);
				break;
			}
			case "4":
			{
				System.out.println("You have chosen travel four zones.");
				chooseTicketType(4);
				break;
			}
			case "5":
			{
				System.out.println("You have chosen travel five zones.");
				chooseTicketType(5);
				break;
			}
			case "a":
			{
				admin();
				break;
			}
		}
		

		chooseZone();
	}
	
}

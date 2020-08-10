package test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Program 
{
	static Scanner sc = new Scanner(System.in);
	public static Account[] getAccounts( )
	{
		Account[] arr = new Account[ 5 ];
		arr[ 0 ] = new Account(5492,"Current", 150000);
		arr[ 1 ] = new Account(3183,"Saving",75000);
		arr[ 2 ] = new Account(4826,"Loan",480000);
		arr[ 3 ] = new Account(2591,"Pention",25000);
		arr[ 4 ] = new Account(1521,"Joint",80000);
		return arr;
	}
	public static Customer[] getCustomers( )
	{
		Customer[] arr = new Customer[ 5 ];
		arr[ 0 ] = new Customer("Rahul","Pune","rahul@sunbeaminfo.com");
		arr[ 1 ] = new Customer("Amol","Karad","amol@gmail.com");
		arr[ 2 ] = new Customer("Prashant","A.nagar","prashant@yahoo.com");
		arr[ 3 ] = new Customer("Nitin","Panchgani","nitin@hotmail.com");
		arr[ 4 ] = new Customer("Sarang","Satara","sarang@rediffmail.com");
		return arr;
	}
	private static void acceptRecord(int[] accNumber) 
	{
		if( accNumber != null )
		{
			System.out.print("Enter account number	:	");
			accNumber[ 0 ] = sc.nextInt();
		}
	}
	private static void printRecord(Customer value) 
	{
		if( value != null )
			System.out.println(value.toString());
		else
			System.out.println("Key not found");
	}
	private static void printRecord(boolean removedStatus) 
	{
		if( removedStatus )
			System.out.println("Entry is removed");
		else
			System.out.println("Entry is not removed");	
	}
	public static int menuList( )
	{
		System.out.println("0.Exit");
		System.out.println("1.Add Entry");
		System.out.println("2.Find Customer");
		System.out.println("3.Remove Entry");
		System.out.println("4.Print Entries");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}
	public static void main(String[] args) 
	{
		int choice;
		int[] accNumber = new int[ 1 ];
		
		MapTest test = new MapTest();
		//test.setMap(new Hashtable<Account, Customer>());
		//test.setMap(new HashMap<Account, Customer>());
		//test.setMap(new LinkedHashMap<Account, Customer>());
		test.setMap(new TreeMap<Account, Customer>());
		while( ( choice = Program.menuList( ) ) != 0 )
		{
			switch( choice )
			{
			case 1:
				Account[] accounts = Program.getAccounts();
				Customer[] customers = Program.getCustomers();
				test.addEntry( accounts, customers );
				break;
			case 2:
				Program.acceptRecord( accNumber );
				Customer value = test.findCustomer( accNumber[ 0 ] );
				Program.printRecord( value );
				break;
			case 3:
				Program.acceptRecord( accNumber );
				boolean removedStatus = test.removeEntry( accNumber[ 0 ] );
				Program.printRecord(removedStatus);
				break;
			case 4:
				test.printEntries( );
				break;
			}
		}
	}
}

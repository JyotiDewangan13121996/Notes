package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Vector;

public class Program
{
	static Scanner sc = new Scanner(System.in);
	public static Employee[] getEmployees( )
	{
		Employee[] arr = new Employee[ 5 ];
		arr[ 0 ] = new Employee("Nitin",50,55000);
		arr[ 1 ] = new Employee("Prashant",10,50000);
		arr[ 2 ] = new Employee("Amol",40,45000);
		arr[ 3 ] = new Employee("Yogesh",20,40000);
		arr[ 4 ] = new Employee("Sachin",30,35000);
		return arr;
	}
	public static void acceptRecord( int[] empid )
	{
		System.out.print("Enter empid	:	");
		empid[ 0 ] = sc.nextInt();
	}
	private static void printRecord(Employee value)
	{
		if( value != null )
			System.out.println(value.toString());
		else
			System.out.println("Record not found");
	}
	private static void printRecord(boolean removedStatus)
	{
		if( removedStatus )
			System.out.println("Record is removed");
		else
			System.out.println("Record is not removed");
	}
	public static int menuList( )
	{
		System.out.println("0.Exit");
		System.out.println("1.Add Record");
		System.out.println("2.Find Record");
		System.out.println("3.Remove Record");
		System.out.println("4.Print Record(s)[ Sorted ]");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}
	public static void main(String[] args) 
	{
		int choice;
		int[] empid = new int[ 1 ]; 
		SetTest test = new SetTest();
		//test.setEmpList(new TreeSet<Employee>( ) );
		//test.setEmpList(new TreeSet<Employee>( new SortByEmpid()));
		
		//test.setEmpList(new HashSet<Employee>() );
		test.setEmpList(new LinkedHashSet<Employee>() );
		while( ( choice = Program.menuList( ) ) != 0 )
		{
			switch( choice )
			{
			case 1:
				Employee[] employees = Program.getEmployees();
				test.addRecord( employees );
				break;
			case 2:
				Program.acceptRecord( empid );
				Employee value = test.findRecord( empid[ 0 ] );
				Program.printRecord( value );
				break;
			case 3:
				Program.acceptRecord( empid );
				boolean removedStatus = test.removeRecord( empid[ 0 ] );
				Program.printRecord(removedStatus);
				break;
			case 4:
				test.printRecord( );
				break;
			}
		}
	}
}

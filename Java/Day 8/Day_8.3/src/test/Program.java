package test;

import java.util.Arrays;
import java.util.Comparator;

abstract class Person
{
	private String name;
	public Person( String name )
	{
		this.name = name;
	}
	public String getName() 
	{
		return name;
	}
	@Override
	public String toString() 
	{
		return this.name;
	}
}
class Student extends Person
{
	private int rollNumber;
	public Student( String name, int rollNumber )
	{
		super( name );
		this.rollNumber = rollNumber;
	}
	public int getRollNumber() 
	{
		return rollNumber;
	}
	@Override
	public String toString() 
	{
		return String.format("%-15s%-5d", super.toString(), this.rollNumber);
	}
}
class Employee extends Person
{
	private int empid;
	public Employee( String name, int empid )
	{
		super( name );
		this.empid = empid;
	}
	public int getEmpid() 
	{
		return empid;
	}
	@Override
	public String toString() 
	{
		return String.format("%-15s%-5d", super.toString(), this.empid);
	}
}
class SortByName implements Comparator<Person>
{
	@Override
	public int compare(Person p1, Person p2) 
	{
		return p1.getName().compareTo(p2.getName());
	}
}
class SortById implements Comparator<Person>
{
	@Override
	public int compare(Person p1, Person p2) 
	{
		if( p1 instanceof Student && p2 instanceof Student )
		{
			Student s1 = (Student) p1;
			Student s2 = (Student) p2;
			return s1.getRollNumber() - s2.getRollNumber();
		}
		else if( p1 instanceof Employee && p2 instanceof Employee )
		{
			Employee emp1 = (Employee) p1;
			Employee emp2 = (Employee) p2;
			return emp1.getEmpid() - emp2.getEmpid();
		}
		else if( p1 instanceof Student && p2 instanceof Employee )
		{
			Student s1 = (Student) p1;
			Employee emp2 = (Employee) p2;
			return s1.getRollNumber() - emp2.getEmpid();
		}
		else
		{
			Employee emp1 = (Employee) p1;
			Student s2 = (Student) p2;
			return emp1.getEmpid() - s2.getRollNumber();
		}
	}
}
public class Program
{
	public static Person[] getPersons( )
	{
		Person[] arr = new Person[ 5 ];
		arr[ 0 ] = new Student("Rohan", 50);
		arr[ 1 ] = new Employee("Nilesh", 30);
		arr[ 2 ] = new Student("Yogesh", 20);
		arr[ 3 ] = new Employee("Amit", 10);
		arr[ 4 ] = new Student("Sachin", 40);
		return arr;
	}
	private static void printRecord(Person[] arr) 
	{
		if( arr != null )
		{
			for( Person p : arr )
				System.out.println(p.toString());
		}
		System.out.println();
	}
	public static void main(String[] args) 
	{
		Person[] arr = Program.getPersons();
		Program.printRecord( arr );
		
		Arrays.sort( arr, new SortById());
		Program.printRecord( arr );
		
		Arrays.sort( arr, new SortByName());
		Program.printRecord( arr );
	}
}

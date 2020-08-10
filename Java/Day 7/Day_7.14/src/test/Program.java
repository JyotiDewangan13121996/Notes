package test;

import java.util.Arrays;

class Employee
{
	private String name;
	private int empid;
	private float salary;
	public Employee() 
	{
		this("",0,0);
	}
	public Employee(String name, int empid, float salary) 
	{
		this.name = name;
		this.empid = empid;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public int getEmpid() {
		return empid;
	}
	public float getSalary() {
		return salary;
	}
	@Override
	public String toString() 
	{
		return String.format("%-15s%-5d%-10.2f", this.name, this.empid, this.salary);
	}
}
public class Program
{
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
	private static void printRecord(Employee[] arr) 
	{
		if( arr != null )
		{
			for (Employee emp : arr) 
				System.out.println(emp.toString());
			System.out.println();
		}
	}
	public static void main(String[] args) 
	{
		Employee[] arr = Program.getEmployees();
		Program.printRecord( arr );
		
		Arrays.sort( arr );
		Program.printRecord( arr );
	}
	
}

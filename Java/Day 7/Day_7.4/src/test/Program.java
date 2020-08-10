package test;

class A extends Exception{	}
class B extends Exception{	}
class C extends Exception{	}
class D extends Exception{	}
class Person
{
	public void print( )throws A, B, C
	{
		System.out.println("Inside super class");
	}
}
class Employee extends Person
{
	public void print( )throws A, B, C
	{
		System.out.println("Inside sub class");
	}
}
public class Program 
{
	public static void main(String[] args)  
	{
		try 
		{
			Person p = new Employee();
			p.print();
		}
		catch (A | B | C e) 
		{
			e.printStackTrace();
		}
	}
}

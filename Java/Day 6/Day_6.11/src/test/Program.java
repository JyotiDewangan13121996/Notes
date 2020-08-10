package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


class Test implements AutoCloseable
{
	@Override
	public void close() throws Exception 
	{	}
}
public class Program 
{
	/*public static void print( Object obj )
	{
		System.out.println(obj.toString());
	}*/
	
	public static <T extends Number> void print( T obj )
	{
		System.out.println(obj.toString());
	}
	public static void main(String[] args) 
	{
		Test t = new Test();
		//Program.print('A'); //Not OK
		Program.print(10);
		Program.print(10.5);
		//Program.print("Pune"); //Not Ok
		//Program.print(new Date()); //Not OK
	}
}

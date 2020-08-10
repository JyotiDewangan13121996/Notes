package test;

import java.util.ArrayList;

public class Program 
{
	private static ArrayList<Integer> getIntegerList()
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		return list;
	}
	private static ArrayList<Double> getDoubleList()
	{
		ArrayList<Double> list = new ArrayList<Double>();
		list.add(10.1);
		list.add(20.2);
		list.add(30.3);
		return list;
	}
	private static ArrayList<String> getStringList() 
	{
		ArrayList<String> list = new ArrayList<String>();
		list.add("DAC");
		list.add("DMC");
		list.add("DESD");
		return list;
	}
	private static void print(ArrayList<? extends Number> list)
	{
		for( Number element : list )
			System.out.println(element);
	}
	public static void main(String[] args) 
	{	
		ArrayList<Integer> intList = Program.getIntegerList( );
		Program.print( intList ); //OK
		
		ArrayList<Double> doubleList = Program.getDoubleList( );
		Program.print( doubleList );//OK
		
		ArrayList<String> stringList = Program.getStringList( );
		//Program.print( stringList );//Not OK
	}
	

	
}

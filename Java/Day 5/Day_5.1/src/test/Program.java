package test;

import java.util.Arrays;

public class Program 
{
	private static void printRecord(int[] arr) 
	{
		if( arr != null )
		{
			for( int index = 0; index < arr.length; ++ index )
				System.out.print(arr[ index ] +" ");
			System.out.println();
		}
	}
	public static void main(String[] args) 
	{
		int[] arr = new int[ ] { 10, 20, 30, 40, 50 };
		for(  int element : arr )
		{
			System.out.println(element);
		}
	}
	public static void main2(String[] args) 
	{
		int[] arr = new int[ ] { 10, 20, 30, 40, 50 };
		//int element = arr[ -1  ]; //ArrayIndexOutOfBoundsException
		int element = arr[ arr.length  ];//ArrayIndexOutOfBoundsException
		System.out.println("Element	:	"+element);
	}
	public static void main1(String[] args) 
	{
		int[] arr = new int[  ] { 50,10,40,20,30};
		Program.printRecord( arr );
		Arrays.sort( arr );	//Dual-Pivot Quicksort 
		Program.printRecord( arr );
	}
	
}

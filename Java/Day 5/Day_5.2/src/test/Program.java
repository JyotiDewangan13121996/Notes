package test;

import java.util.Arrays;

public class Program 
{
	private static void printRecord(int[][] arr)
	{
		if( arr != null )
		{
			for( int i = 0; i < arr.length; ++ i )
			{
				for( int  j = 0; j < arr[ i ].length; ++ j )
				{
					System.out.print(arr[ i ][ j ]+"	");
				}
				System.out.println();
			}
		}
	}
	public static void main(String[] args) 
	{
		int[][] arr = new int[  ][  ] { {10,20,30},{40,50,60},{70,80,90}};
		for( int[] i : arr )
		{
			for( int j : i )
				System.out.print( j+"	");
			System.out.println();
		}
	}
	public static void main5(String[] args) 
	{
		int[][] arr = new int[  ][  ] { {30,10,20},{40,60,50},{90,80,70}};
		
		for( int index = 0; index < arr.length; ++ index )
			Arrays.sort( arr[ index ] );
		
		for( int index = 0; index < arr.length; ++ index )
			System.out.println(Arrays.toString( arr[ index ] ) );
	}
	public static void main4(String[] args) 
	{
		int[][] arr = new int[  ][  ] { {10,20,30},{40,50,60},{70,80,90}};
		for( int index = 0; index < arr.length; ++ index )
			System.out.println(Arrays.toString( arr[ index ] ) );
	}
	public static void main3(String[] args) 
	{
		//int[][] arr = new int[  ][  ] { {10,20,30},{40,50,60},{70,80,90}};
		int[][] arr = { {10,20,30},{40,50,60},{70,80,90}};
		Program.printRecord( arr );
	}
	public static void main2(String[] args) 
	{
		int[][] arr = new int[ 3 ][ 4 ];
		Program.printRecord( arr );
	}
	public static void main1(String[] args) 
	{
		//int arr[][] = null;	//OK
		//int[] arr[] = null;	//OK
		int[][] arr = null;	//OK
	}
}

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
		int[][] arr = new int[ 3 ][ ];
		arr[ 0 ] = new int[  ] { 1,2,3,4};
		arr[ 1 ] = new int[  ] {5,6};
		arr[ 2 ] = new int[  ] {7,8,9};
		Program.printRecord(arr);
	}
	public static void main1(String[] args) 
	{
		int[][] arr = new int[ 3 ][ ];
		arr[ 0 ] = new int[ 4 ];
		arr[ 1 ] = new int[ 2 ];
		arr[ 2 ] = new int[ 3 ];
		Program.printRecord(arr);
	}
}

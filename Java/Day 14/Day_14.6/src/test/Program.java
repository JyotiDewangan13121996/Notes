package test;

import java.util.Scanner;

@FunctionalInterface
interface A
{
	void f1();
}

interface Collection
{
	void acceptRecord( );
	void printRecord( );
	int[] get( );
	static void swap(int[] arr)
	{
		int temp = arr[ 0 ];
		arr[ 0 ] = arr[ 1 ];
		arr[ 1 ] = temp;
	}
	default void sort()
	{
		int [] arr = this.get();
		for( int i = 0; i < arr.length - 1; ++ i )
		{
			for( int  j = i; j < arr.length; ++ j )
			{
				if( arr[ i ]  > arr[ j ] )
				{
					int[] temp = new int[ ] { arr[ i ], arr[ j ] };
					Collection.swap( temp );
					arr[ i ] = temp[ 0 ];
					arr[ j ] = temp[ 1 ];
				}
			}
		}
	}
	
}
class Array implements Collection
{
	private int[] arr;
	public Array() 
	{
		this( 5 );
	}
	public Array( int size ) 
	{
		this.arr = new int[ size ];
	}
	static Scanner sc = new Scanner(System.in);
	@Override
	public void acceptRecord() 
	{
		for( int index = 0; index < this.arr.length; ++ index )
		{
			System.out.print("Enter element	:	");
			arr[ index ] = sc.nextInt();
		}
	}
	@Override
	public void sort() 
	{
		for( int  i = 0; i < this.arr.length - 1; ++ i )
		{
			for( int j = 0; j < this.arr.length - i -1; ++ j )
			{
				if( arr[ j ]  > arr[ j + 1 ] )
				{
					int[] temp = new int[ ] { arr[ j ], arr[ j + 1 ] };
					Collection.swap( temp );
					arr[ j ] = temp[ 0 ];
					arr[ j + 1 ] = temp[ 1 ];
				}
			}
		}
	}
	@Override
	public void printRecord() 
	{
		for( int index = 0; index < this.arr.length; ++ index )
			System.out.println(arr[ index ]);
	}
	@Override
	public int[] get() 
	{
		return this.arr;
	}
}
public class Program
{
	public static void main(String[] args) 
	{
		Collection c = new Array();
		c.acceptRecord();
		c.sort();
		c.printRecord();
	}
}

package test;

import java.util.Arrays;

class Complex
{
	private int real;
	private int imag;
	public Complex() 
	{	}
	public void printRecord( )
	{
		System.out.println("Real Number	:	"+this.real);
		System.out.println("Imag Number	:	"+this.imag);
	}
}
public class Program 
{
	public static void main(String[] args) 
	{
		Complex[] arr = new Complex[ 3 ];
		for( int index = 0; index < arr.length; ++ index )
		{
			
			arr[ index ] = new Complex();
		}
		
		for( int index = 0; index < arr.length; ++ index )
			arr[ index ] .printRecord();
	}
}

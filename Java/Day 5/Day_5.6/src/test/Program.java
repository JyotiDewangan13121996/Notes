package test;

import java.util.Scanner;

public class Program 
{
	static Scanner sc = new Scanner(System.in);
	public static void acceptRecord(int[] arr )
	{
		System.out.print("Enter number	:	");
		arr[ 0 ] = sc.nextInt();
	}
	public static void printRecord(int[] arr )
	{
		System.out.println("Number	:	"+arr[ 0 ]);
	}
	public static void main(String[] args) 
	{
		int[] arr = new int[ 1 ];
		Program.acceptRecord( arr );
		Program.printRecord( arr );
		
	}
}

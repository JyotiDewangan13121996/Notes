package test;

import java.util.Arrays;
import java.util.Scanner;

public class Program
{
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) 
	{
		int[] arr = new int[  ] { 10, 20, 30 };
		System.out.println(arr.toString());//[I@42a57993
		System.out.println(Arrays.toString(arr));
	}
	public static void main3(String[] args) 
	{
		//int[] arr = new int[  ] { 10, 20, 30 };
		int[] arr = { 10, 20, 30 };
		for( int index = 0; index < arr.length; ++ index )
			System.out.println(arr[ index ] );
	}
	public static void main2(String[] args) 
	{
		int[] arr =  new int[ 3 ];	//OK
		for( int index = 0; index < 3; ++ index )
		{
			System.out.print("Enter element	:	");
			arr[ index ] = sc.nextInt();
		}
		for( int index = 0; index < 3; ++ index )
			System.out.println(arr[ index ] );
	}
	public static void main1(String[] args) 
	{
		//int arr[] =  new int[ 3 ];	//OK
		int[] arr =  new int[ 3 ];	//OK
	}
}

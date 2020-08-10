package test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program
{
	
	public static void main(String[] args) 
	{
		Scanner sc = null;
		try 
		{
			System.out.println("Inside try block");
			sc = new Scanner(System.in);
			System.out.print("Num1	:	");
			int num1 = sc.nextInt();
			System.out.print("Num2	:	");
			int num2 = sc.nextInt();	
			int result = num1 / num2;
			System.out.println("Result	:	"+result);
			System.exit(0);
			
		}
		catch (Exception ex) 
		{
			System.out.println("Inside catch block");
			ex.printStackTrace();
			System.exit(0);
		}
		finally 
		{
			System.out.println("Inside finally block");
			sc.close();
		}
	}
	public static void main4(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		try 
		{
			System.out.print("Num1	:	");
			int num1 = sc.nextInt();
			System.out.print("Num2	:	");
			int num2 = sc.nextInt();
			if( num2 == 0 )
				throw new ArithmeticException("Divide by zero exception");	
			int result = num1 / num2;
			System.out.println("Result	:	"+result);
		}
		catch (ArithmeticException ex) 
		{
			System.out.println(ex.getMessage());
		}
		
		/*catch( ArithmeticException | InputMismatchException ex )
		{
			System.out.println("Inside catch");
			System.out.println(ex.getMessage());
		}*/
		
		/*catch( ArithmeticException ex )
		{
			System.out.println(ex.getMessage());
		}
		catch (InputMismatchException e)
		{
			System.out.println(e.getMessage());
		}*/
	}
	public static void main3(String[] args) 
	{
		String str = "SunBeam";
		//char ch = str.charAt(0);	//S
		//char ch = str.charAt( str.length() - 1 ); //m
		char ch = str.charAt( -1 ); //StringIndexOutOfBoundsException
		System.out.println(ch);
		
	}
	public static void main2(String[] args) 
	{
		Object[] arr = new String[ 2 ];
		arr[ 0 ] = new String("DAC");
		arr[ 1 ] = new Integer(125); //ArrayStoreException
		
		for (Object e : arr) 
		{
			System.out.println(e);
		}
	}
	public static void main1(String[] args) 
	{
		Object[] arr = new String[ 3 ];
		arr[ 0 ] = new String("DAC");
		arr[ 1 ] = new String("DMC");
		arr[ 2 ] = new String("DESD");
		for (Object e : arr) 
		{
			System.out.println(e);
		}
	}
}

package org.sunbeam.dac.test;

import java.util.Scanner;

import org.sunbeam.dac.complex.Complex;

public class Program
{
	static Scanner sc = new Scanner(System.in);
	public static void acceptRecord( Complex c1 )
	{
		System.out.print("Real Number	:	");
		c1.setReal(sc.nextInt());
		System.out.print("Imag Number	:	");
		c1.setImag(sc.nextInt());
	}
	public static void printRecord( Complex c1 )
	{
		System.out.println("Real Number	:	"+c1.getReal());
		System.out.println("Imag Number	:	"+c1.getImag());
	}
	public static int menuList( )
	{	
		System.out.println("0.Exit");
		System.out.println("1.Accept Record");
		System.out.println("2.Print Record");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}
	public static void main(String[] args) 
	{
		int choice;
		Complex c1 = new Complex();
		while( ( choice = Program.menuList( ) ) != 0 )
		{
			switch( choice )
			{
			case 1:
				Program.acceptRecord( c1 );
				break;
			case 2:
				Program.printRecord( c1 );
				break;
			}
		}
	}
}

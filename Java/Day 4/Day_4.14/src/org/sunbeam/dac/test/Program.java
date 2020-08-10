package org.sunbeam.dac.test;

import java.util.Scanner;

import org.sunbeam.dac.complex.Complex;

public class Program
{
	
	public static void main(String[] args) 
	{
		int choice;
		ComplexTest test = new ComplexTest();
		while( ( choice = ComplexTest.menuList( ) ) != 0 )
		{
			switch( choice )
			{
			case 1:
				test.acceptRecord();
				break;
			case 2:
				test.printRecord();
				break;
			}
		}
	}
}

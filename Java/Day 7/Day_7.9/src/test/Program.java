package test;

import java.util.InputMismatchException;
import java.util.Scanner;

interface A
{
	void f1();
	void f2();
	void f3();
}
abstract class B implements A //Adpter class
{
	@Override
	public void f1() {	}
	@Override
	public void f2() {	}
	@Override
	public void f3() {	}
}
class C extends B
{
	@Override
	public void f2() 
	{
		System.out.println("C.f2");
	}
}
public class Program 
{
	public static void main(String[] args) 
	{
		try( Scanner sc = new Scanner(System.in))
		{
			int number = 0;
			while( true )
			{
				try
				{
					System.out.print("Number	:	");
					number = sc.nextInt();
					System.out.println("Number	:	"+number);
					break;
				}
				catch( InputMismatchException ex)
				{
					System.out.print("Re Enter ");
				}
			}
		}
		
	}
	public static void main1(String[] args) 
	{
		A a = new C();
		a.f2();
	}
}

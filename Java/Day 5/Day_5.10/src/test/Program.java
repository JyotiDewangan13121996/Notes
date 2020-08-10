package test;
abstract class A
{
	private int num1;
	private int num2;
	public A( int num1, int num2 ) //Sole Constructor
	{
		this.num1 = num1;
		this.num2 = num2;
	}
	public void printRecord( )
	{
		System.out.println("Num1	:	"+this.num1);
		System.out.println("Num2	:	"+this.num2);
	}
}
class B extends A
{
	private int num3;
	public B( int num1, int num2, int num3 )
	{
		super( num1, num2 );
		this.num3 = num3;
	}
	public void printRecord( )
	{
		super.printRecord();
		System.out.println("Num3	:	"+this.num3);
	}
}
public class Program
{
	public static void main(String[] args) 
	{
		B b = new B(10,20, 30 );
		b.printRecord();
	}
}

package test;

class A
{
	private int num1;
	private int num2;
	public A( )
	{
		this.num1 = 0;
		this.num2 = 0;
	}
	public void setNum1(int num1) 
	{
		this.num1 = num1;
	}
	public void setNum2(int num2) 
	{
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
	public B()
	{
		this.num3 = 0;
	}
	public void setNum3(int num3) 
	{
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
		A a = new B( );
		a.setNum1(10);
		a.setNum2(20);
		B b = (B) a; //Downcasting
		b.setNum3(30);
		a.printRecord();
	}
	public static void main1(String[] args) 
	{
		/*A a = new B( ); //Upcasting
		a.num1 = 10;
		a.num2 = 20;
		B b = (B) a; //Downcasting
		b.num3 = 30;*/
		
	}
}

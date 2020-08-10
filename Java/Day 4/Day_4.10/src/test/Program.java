package test;

class Test
{
	private int num1;
	private int num2;
	private static int num3;
	static	//static initializer block
	{
		Test.num3 = 500;
	}
	public Test( )
	{
		this( 0, 0);
	}
	public Test( int num1, int num2 ) 
	{
		this.num1 = num1;
		this.num2 = num2;
	}
	public int getNum1() 
	{
		return num1;
	}
	public void setNum1(int num1) 
	{
		this.num1 = num1;
	}
	public int getNum2() 
	{
		return num2;
	}
	public void setNum2(int num2) 
	{
		this.num2 = num2;
	}
	public static int getNum3() 
	{
		return num3;
	}
	public static void setNum3(int num3) 
	{
		Test.num3 = num3;
	}
	public void print( )
	{
		System.out.println("Num1	:	"+this.num1);
		System.out.println("Num2	:	"+this.num2);
		System.out.println("Num3	:	"+Test.num3);
	}
}
public class Program
{
	public static int square( int number )
	{
		return number * number;
	}
	public static void main(String[] args) 
	{
		int number = 5;
		int result = Program.square(number);
		System.out.println(result);
	}
	public static void main1(String[] args) 
	{
		
		Test t1 = new Test( 10, 20 );
		t1.print( );
		
		Test t2 = new Test( 30, 40 );
		t2.print( );
	}
}

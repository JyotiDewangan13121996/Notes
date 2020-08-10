package test;

class Test
{
	private static int count;
	public void print( )
	{	
		++ count;
		System.out.println("Count	:	"+count);
	}
}
public class Program
{
	public static void main(String[] args) 
	{
		Test t = new Test( );
		t.print();
		t.print();
		t.print();
	}
}

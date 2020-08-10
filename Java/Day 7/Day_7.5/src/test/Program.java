package test;

abstract class A
{
	public abstract void print();
}
class B extends A
{
	@Override
	public void print() throws RuntimeException
	{
		try 
		{
			for( int count = 1; count <= 10; ++ count )
			{
				System.out.println("Count	:	"+count);
				Thread.sleep(250);
			}
		}
		catch (InterruptedException cause) 
		{
			throw new RuntimeException(cause);
		}
	}
}
public class Program 
{
	public static void main(String[] args)  
	{
		try 
		{
			A a = new B();
			a.print();
		}
		catch (RuntimeException e) 
		{
			Throwable t = e.getCause();
			System.out.println(t);
			//e.printStackTrace();
		}
	}
}

package test;
public class Program 
{
	private String message = "Hello";
	public void print( ) throws InterruptedException
	{
		synchronized( this )
		{
			System.out.println(message); //Hello
			message.wait(); //IllegalMonitorStateException
		}
	}
	public static void main(String[] args) throws InterruptedException 
	{
		Program p = new Program();
		p.print();
	}
}

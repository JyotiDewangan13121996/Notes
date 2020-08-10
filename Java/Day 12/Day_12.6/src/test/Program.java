package test;

class CThread extends Thread
{
	public CThread(String name)
	{
		this.setName(name);
		this.start();
	}
	
	@Override
	public void run() throws RuntimeException
	{
		System.out.println("Starting : "+this.getName());
		try
		{
			for( int count = 1; count <= 10; ++ count )
			{
				System.out.println(this.getName()+" : "+count);
				Thread.sleep(250);
			}
		}
		catch (InterruptedException cause) 
		{
			throw new RuntimeException(cause);
		}
		System.out.println("Terminating : "+this.getName());
	}
}
public class Program
{
	public static void main(String[] args) throws InterruptedException 
	{
		CThread th1 = new CThread("A");
		th1.join();
		CThread th2 = new CThread("B");
		th2.join();
		CThread th3 = new CThread("C");
		th3.join();
		CThread th4 = new CThread("D");
		th4.join();
		CThread th5 = new CThread("E");
		th5.join();
	}	
}

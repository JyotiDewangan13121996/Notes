package test;

class CThread extends Thread
{
	/*public CThread( String name ) 
	{
		this.setName( name );
		this.start();
	}*/
	@Override
	public void run() throws RuntimeException
	{
		try
		{
			for( int count = 1; count <= 10; ++ count )
			{
				System.out.println(count);
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
	public static void main(String[] args) throws InterruptedException 
	{
		CThread th1 = new CThread();
		th1.start();
		while( th1.isAlive() )
		{
			System.out.println(th1.getState().name());
			Thread.sleep(100);
		}
			
	}	
}

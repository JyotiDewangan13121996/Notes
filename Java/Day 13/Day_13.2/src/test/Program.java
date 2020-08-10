package test;
class TickTock
{
	public void tick() throws InterruptedException
	{
		synchronized( this )
		{
			System.out.print("Tick	");
			this.notify();
			this.wait(1000);
		}
	}
	public void tock(  ) throws InterruptedException
	{
		synchronized( this )
		{
			System.out.println("	Tock");
			this.notify();
			this.wait(1000);
		}
	}
}
class CThread implements Runnable
{
	private Thread thread;
	public CThread( String name ) 
	{
		this.thread = new Thread(this);
		this.thread.setName(name);
		this.thread.start();
	}
	static TickTock tt = new TickTock();
	@Override
	public void run() 
	{
		try 
		{
			if( Thread.currentThread().getName().equalsIgnoreCase("TickThread"))
			{
				for( int count = 1; count <= 5; ++ count )
				{
					tt.tick(  );
					Thread.sleep(250);
				}
			}
			else
			{
				for( int count = 1; count <= 5; ++ count )
				{
					tt.tock(  );
					Thread.sleep(250);
				}
			}
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}
public class Program 
{
	public static void main(String[] args) 
	{
		CThread th2 = new CThread("TockThread");
		CThread th1 = new CThread("TickThread");
	}
}

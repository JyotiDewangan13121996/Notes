package test;
class TickTock
{
	public void tick( boolean running ) throws InterruptedException
	{
		synchronized( this )
		{
			if( !running )
			{
				this.notify();
				return;
			}
			System.out.print("Tick	");
			this.notify();
			this.wait();
		}
	}
	public void tock( boolean running ) throws InterruptedException
	{
		synchronized( this )
		{
			if( !running )
			{
				this.notify();
				return;
			}
			System.out.println("	Tock");
			this.notify();
			this.wait();
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
					tt.tick( true );
					Thread.sleep(250);
				}
				tt.tick( false );
			}
			else
			{
				for( int count = 1; count <= 5; ++ count )
				{
					tt.tock( true );
					Thread.sleep(250);
				}
				tt.tock( false );
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
		CThread th1 = new CThread("TickThread");
		CThread th2 = new CThread("TockThread");
	}
}

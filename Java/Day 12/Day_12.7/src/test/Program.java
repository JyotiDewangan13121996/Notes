package test;

class CThread extends Thread
{
	public CThread(String name)
	{
		this.setName(name);
		//this.start();
	}
	
	@Override
	public void run() 
	{
		System.out.println("Inside run");
	}
}
public class Program
{
	public static void main(String[] args) 
	{
		CThread th1 = new CThread("A");
		th1.start();
		th1.start();
	}
	public static void main1(String[] args) 
	{
		Thread thread = Thread.currentThread();
		thread.setPriority(Thread.NORM_PRIORITY  + 3 ); //OK
		System.out.println(thread.getName()+" : "+thread.getPriority());
		
		CThread th1 = new CThread("User Thread");
	}	
}

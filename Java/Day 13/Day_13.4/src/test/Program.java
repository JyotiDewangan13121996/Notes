package test;
class CThread extends Thread
{
	public CThread(String name )
	{
		this.setName(name);
	}
	@Override
	public void run() 
	{
		System.out.println(Thread.currentThread().getName()+" run method()");
	}
}
public class Program 
{
	public static void main(String[] args)  
	{
		CThread th1 = new CThread("Abc");
		//th1.start();
		th1.run();
	}
}

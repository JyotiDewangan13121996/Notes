package test;
class CThread implements Runnable
{
	@Override
	public void run() 
	{
		System.out.println(" Inside run method");
	}
}
public class Program
{
	public static void main(String[] args) 
	{
		Runnable target = new CThread();
		Thread th1 = new Thread(target);
		th1.setName("Thread#1");
		th1.setPriority(Thread.NORM_PRIORITY + 3 );
		th1.start();
	}	
}

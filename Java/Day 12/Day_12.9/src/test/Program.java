package test;

class SumArray
{
	public synchronized int sum( int[] arr ) throws InterruptedException
	{
		int result = 0;
		for( int element : arr )
		{
			result = result + element;
			System.out.println("Running total for "+Thread.currentThread().getName()+" is "+result);
			Thread.sleep(250);
		}
		return result;
	}
}
class CThread implements Runnable
{
	public int[] arr;
	private Thread thread;
	public CThread( String name, int[] arr )
	{
		this.arr = arr;
		this.thread = new Thread( this );
		this.thread.setName(name);
		this.thread.start();
	}
	static SumArray sa = new SumArray();
	@Override
	public void run()throws RuntimeException
	{
		try
		{
			int result = sa.sum(this.arr);
			System.out.println("Result	:	"+result);	
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
		int[] arr1 = { 1,2,3,4,5,6,7,8,9,10};
		CThread th1 = new CThread("th1",arr1);
		
		int[] arr2 = { 11,12,13,14,15,16,17,18,19,20};
		CThread th2 = new CThread("th2",arr2);
		
		int[] arr3 = { 21,22,23,24,25,26,27,28,29,30};
		CThread th3 = new CThread("th3",arr3);
		
		int[] arr4 = { 31,32,33,34,35,36,37,38,39,40};
		CThread th4 = new CThread("th4",arr4);
	}	
}

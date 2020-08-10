package test;
class InstanceCounter
{
	private static int count;
	public InstanceCounter() 
	{
		++ InstanceCounter.count;
	}
	public static int getCount() 
	{
		return  InstanceCounter.count;
	}
}
public class Program
{
	public static void main(String[] args) 
	{	
		InstanceCounter c1 = new InstanceCounter();
		InstanceCounter c2 = new InstanceCounter();
		InstanceCounter c3 = new InstanceCounter();
		
		System.out.println("Instance Count	:	"+InstanceCounter.getCount());
	}
}

package test;
interface Printable
{
	void print();
}
public class Program
{
	public static void main(String[] args) 
	{
		Printable p = new Printable() 
		{	
			@Override
			public void print() 
			{
				System.out.println("Hello");
			}
		};
		p.print();//DMD
	}
	public static void main1(String[] args) 
	{
		Object obj = new Object() //Program$1.class
		{
			private String str = "Hello";
			@Override
			public String toString() 
			{
				return str;
			}
		};
		System.out.println(obj.toString());
	}
}

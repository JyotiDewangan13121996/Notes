package test;

class Singleton
{
	private Singleton( )
	{	}
	static Singleton instance;
	public static Singleton getInstance( )
	{
		if( instance == null )
			instance = new Singleton();
		return instance;
	}
}
public class Program
{
	public static void main(String[] args) 
	{
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		Singleton s3 = Singleton.getInstance();
	}
}

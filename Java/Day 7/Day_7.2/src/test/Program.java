package test;

public class Program 
{
	private static int convert(String str) throws NumberFormatException
	{
		int number = Integer.parseInt(str);
		return number;
	}
	public static void main(String[] args)  
	{	
		try 
		{
			String str = "abc";
			int number = Program.convert( str );
			System.out.println("Number	:	"+number);
		} 
		catch (Exception e) 
		{
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}

package test;

public class Program
{
	//Hash Method
	private static int getHashCode(int data)	 
	{
		int result = 1;
		final int PRIME = 31;
		result = result * data + PRIME * data;
		return result;
	}
	public static void main(String[] args) 
	{
		for( int count = 1; count <= 100; ++ count )
		{
			int data = count;
			int hashCode = Program.getHashCode( data );
			int slot = hashCode % 5;
			System.out.println(data+"	"+hashCode+"	"+slot);
		}
	}

	
}

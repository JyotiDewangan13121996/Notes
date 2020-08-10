package test;
public class Program//Pogram.class
{
	public static void main(String[] args) 
	{
		class Complex	//Program$1Complex.class
		{
			private int real = 10;
			private int imag = 20;
			@Override
			public String toString() 
			{
				return this.real+" "+this.imag;
			}
		}
		Complex c1 = new Complex();
		System.out.println(c1.toString());
	}
}

package test;
class Complex
{
	private int real;
	private int imag;
	public Complex(int real, int imag) 
	{
		this.real = real;
		this.imag = imag;
	}
	public void setReal(int real) 
	{
		this.real = real;
	}
	public void setImag(int imag) 
	{
		this.imag = imag;
	}
	@Override
	public String toString() 
	{
		return "Complex [real=" + real + ", imag=" + imag + "]";
	}
}
public class Program
{
	public static void main(String[] args) 
	{
		final Complex c1 = new Complex(10, 20);	//OK
		c1.setReal(11);	//Ok
		c1.setImag(22);	//Ok
		//c1 = new Complex(50, 60); //Not OK
		System.out.println(c1.toString());
	}
	public static void main1(String[] args) 
	{
		Complex c1 = new Complex(10, 20);
		c1 = new Complex(50, 60);
		System.out.println(c1.toString());
	}
}

package test;

import java.io.IOException;

interface  A
{
	void f1( )throws ClassNotFoundException;
}
interface  B
{
	void f1( )throws IOException;
}
class C implements A, B
{

	@Override
	public void f1()  
	{
		System.out.println("Inside f1");
	}
	
}
public class Program 
{

	public static void main(String[] args)
	{
		try {
			A a = new C();
			a.f1();
			
			B b = new C();
			b.f1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

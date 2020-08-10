package test;

interface A
{
	void f1();
	void f3();
}
interface B
{
	void f2();
	void f3();
}
class C implements A, B 
{
	@Override
	public void f1() 
	{
		System.out.println("C.f1");
	}
	@Override
	public void f2() 
	{
		System.out.println("C.f2");
	}
	@Override
	public void f3() 
	{
		System.out.println("C.f3");
	}
}
public class Program 
{
	public static void main1(String[] args) 
	{
		A a = new C();
		a.f1();
		a.f3();
	}
	public static void main2(String[] args) 
	{
		B b = new C();
		b.f2();
		b.f3();
	}
	public static void main(String[] args) 
	{
		C c = new C();
		c.f1();
		c.f2();
		c.f3();
	}
}

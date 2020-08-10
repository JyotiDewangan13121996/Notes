package test;

import java.util.Date;

class Box
{
	private Object object;
	public Object getObject() 
	{
		return object;
	}
	public void setObject(Object object) 
	{
		this.object = object;
	}
}
public class Program 
{
	public static void main(String[] args) 
	{
		Box b1 = new Box();
		b1.setObject( new Date( 119, 10, 6 ));
		String str = (String) b1.getObject(); //ClassCastException
		System.out.println(str);
	}
	public static void main3(String[] args) 
	{
		Date date = new Date(119, 10, 6);
		Box b1 = new Box();
		b1.setObject(date);
	}
	public static void main2(String[] args) 
	{
		int number = 10;
		Box b1 = new Box();
		b1.setObject(number);
		//b1.setObject(Integer.valueOf(number));
	}
	public static void main1(String[] args) 
	{
		Box b1 = new Box();
	}
}

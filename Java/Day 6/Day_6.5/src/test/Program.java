package test;

import java.util.Date;

class Box<T extends Number >
{
	private T object;
	public T getObject() 
	{
		return object;
	}
	public void setObject(T object) 
	{
		this.object = object;
	}
}
public class Program 
{
	public static void main(String[] args) 
	{	
		Box<Number> b1 = new Box<>(); 
		Box<Integer> b2 = new Box<>();
		Box<Double> b3 = new Box<>();
		Box<String> b4 = new Box<>(); //Not OK
		Box<Date> b5 = new Box<>(); //Not Ok
	}
}

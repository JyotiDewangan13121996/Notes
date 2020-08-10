package test;
class Shape
{
	protected float area;
	public Shape() 
	{
		this.area = 0;
	}
	public float getArea() 
	{
		return this.area;
	}
}
class Rectangle extends Shape
{
	private float length;
	private float breadth;
	public Rectangle() 
	{	}
	public void setLength(float length) 
	{
		this.length = length;
	}
	public void setBreadth(float breadth) 
	{
		this.breadth = breadth;
	}
	public void calculateArea()
	{
		this.area = this.length * this.breadth;
	}
}
class Circle extends Shape
{
	private float radius;
	public Circle() 
	{	}
	public void setRadius(float radius) 
	{
		this.radius = radius;
	}
	public void calculateArea()
	{
		this.area = (float) (Math.PI * Math.pow(this.radius, 2));
	}
}
public class Program
{
	public static void main1(String[] args) 
	{
		Circle c = new Circle();
		c.setRadius(10);
		c.calculateArea();
		System.out.println("Area	:	"+c.getArea());
	}
	public static void main(String[] args) 
	{
		Rectangle rect = new Rectangle();
		rect.setLength(10);
		rect.setBreadth(20);
		rect.calculateArea( );
		System.out.println("Area	:	"+rect.getArea());
	}
}

package test;

class Person
{
	private String name;
	private int age;
	public Person() 
	{
		System.out.println("public Person()");
		this.name = "";
		this.age = 0;
	}
	public Person(String name, int age)
	{
		System.out.println("public Person(String name, int age)");
		this.name = name;
		this.age = age;
	}
	public void showRecord( )
	{
		System.out.println("Name	:	"+this.name);
		System.out.println("Age	:	"+this.age);
	}
	public void printRecord( )
	{
		System.out.println("Name	:	"+this.name);
		System.out.println("Age	:	"+this.age);
	}
}
class Employee extends Person
{
	private int empid;
	private float salary;
	public Employee() 
	{
		System.out.println("public Employee()");
		this.empid = 0;
		this.salary = 0;
	}
	public Employee(String name, int age, int empid, int salary )  
	{
		super( name, age );
		System.out.println("public Employee(String name, int age, int empid, int salary )");
		this.empid = empid;
		this.salary = salary;
	}
	public void printRecord( )
	{
		super.printRecord();
		System.out.println("Empid	:	"+this.empid);
		System.out.println("Salary	:	"+this.salary);
	}
	public void displayRecord( )
	{
		this.showRecord();	//OK
		//super.showRecord();//Ok
		System.out.println("Empid	:	"+this.empid);
		System.out.println("Salary	:	"+this.salary);
	}
}
public class Program
{
	public static void main(String[] args) 
	{
		Person p = new Person();
		Employee emp = (Employee) p;	//Downcasting
		//Output : ClassCastException
	}
		
	}
	public static void main3(String[] args) 
	{
	public static void main4(String[] args) 
	{
		Person p = new Employee("ABC",23,1672,35000); //Upcasting
		p.showRecord();
		Employee emp = (Employee) p;	//Downcasting
		emp.displayRecord();
		Employee emp = new Employee("ABC",23,1672,35000);
		//Person p = ( Person)emp;	//Upcasting
		Person p = emp;	//Upcasting
	}
	public static void main2(String[] args) 
	{
		Employee emp = new Employee("ABC",23,1672,35000);
		emp.printRecord();
	}
	public static void main1(String[] args) 
	{
		Person p = new Person("Abc",23);
		p.showRecord();
	}
}

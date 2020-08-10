package test;
class Employee
{
	private String name;
	private int empid;
	private float salary;
	public Employee(String name, int empid, float salary)
	{
		this.name = name;
		this.empid = empid;
		this.salary = salary;
	}
	//Employee this = emp1;
	//Object obj = emp2; //Upcasting
	@Override
	public boolean equals( Object obj )
	{
		if( obj != null )
		{
			Employee other = (Employee) obj;
			if( this.empid == other.empid )
				return true;
		}
		return false;
	}
	
}
public class Program 
{
	public static void main(String[] args) 
	{
		Integer n1 = new Integer(125);
		int n2 = n1;
		//int n2 = n1.intValue();
		System.out.println(n2);
	}
	public static void main2(String[] args) 
	{
		Employee emp1 = new Employee("Abc", 12, 25000);
		Employee emp2 = new Employee("Abc", 12, 25000);
		if( emp1.equals( emp2 ) )
			System.out.println("Equal");
		else
			System.out.println("Not Equal");
		
	}
	public static void main1(String[] args) 
	{
		int num1 = 10;
		int num2 = 10;
		if( num1 == num2 )
			System.out.println("Equal");
		else
			System.out.println("Not Equal");
		//Equal
	}
}

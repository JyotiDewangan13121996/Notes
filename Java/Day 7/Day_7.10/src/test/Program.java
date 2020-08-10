package test;

import java.time.LocalDate;
import java.util.ArrayList;

class Date implements Cloneable
{
	private int day;
	private int month;
	private int year;
	public Date() 
	{
		LocalDate ldt = LocalDate.now();
		this.day = ldt.getDayOfMonth();
		this.month = ldt.getMonthValue();
		this.year = ldt.getYear();
	}
	public Date(int day, int month, int year) 
	{
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public void setDay(int day)
	{
		this.day = day;
	}
	public void setMonth(int month) 
	{
		this.month = month;
	}
	public void setYear(int year) 
	{
		this.year = year;
	}
	public Date clone( ) throws CloneNotSupportedException
	{
		Date other = (Date) super.clone();
		return other;
	}
	@Override
	public String toString() 
	{
		return String.format("%d / %d / %d", this.day, this.month, this.year);
	}
}
class Employee implements Cloneable
{
	private String name;
	private int empid;
	private float salary;
	private Date joinDate;
	public Employee() 
	{
		this.name = new String( "" );
		this.empid = 0;
		this.salary = 0;
		this.joinDate = new Date( );
	}
	public Employee(String name, int empid, float salary, int day, int month, int year) 
	{
		this.name = new String( name );
		this.empid = empid;
		this.salary = salary;
		this.joinDate = new Date(day, month, year);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public Employee clone( ) throws CloneNotSupportedException
	{
		Employee other =  (Employee) super.clone();
		other.name = new String( this.name );
		other.joinDate = this.joinDate.clone();
		return other;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", empid=" + empid + ", salary=" + salary + ", joinDate=" + joinDate + "]";
	}
	
}
public class Program extends Object
{
	public static void main(String[] args) 
	{
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(10);
		list1.add(20);
		list1.add(30);
		
		ArrayList<Integer> list2 = (ArrayList<Integer>) list1.clone();
		list1.clear();
		
		for( Integer element : list2 )
			System.out.println(element);
	}
	public static void main2(String[] args) 
	{
		try
		{
			Employee emp1 = new Employee("Sandeep", 33, 45000, 26,12,2006);
			Employee emp2 = emp1.clone( );
			
			emp1.setName("Rahul");
			emp1.getJoinDate().setDay(1);
			emp1.getJoinDate().setMonth(1);
			emp1.getJoinDate().setYear(2007);
			
			System.out.println(emp1.toString());
			System.out.println(emp2.toString());
		} 
		catch (CloneNotSupportedException e) 
		{
			e.printStackTrace();
		}
	}
	public static void main1(String[] args) 
	{
		try 
		{
			Date dt1 = new Date();
			Date dt2 = dt1.clone();
			dt1.setDay(11);
			dt2.setDay(12);
			System.out.println(dt1.toString());
			System.out.println(dt2.toString());
		} 
		catch (CloneNotSupportedException e) 
		{
			e.printStackTrace();
		}
	}
}






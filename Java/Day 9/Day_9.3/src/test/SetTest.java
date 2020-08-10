package test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class SetTest 
{
	private Set<Employee> empList;
	public void setEmpList(Set<Employee> empList) 
	{
		this.empList = empList;
	}
	public void addRecord(Employee[] employees) 
	{
		if( this.empList != null && employees != null )
		{
			for (Employee employee : employees) 
			{
				this.empList.add(employee);
			}
		}
	}
	public Employee findRecord(int empid)
	{
		if( this.empList != null )
		{
			for( Employee emp : this.empList )
			{
				if( emp.getEmpid() == empid )
					return emp;
			}
		}
		return null;
	}
	
	public boolean removeRecord(int empid)
	{
		if( this.empList != null )
		{
			Employee key = new Employee();
			key.setEmpid(empid);
			if( this.empList.contains(key))
			{
				this.empList.remove(key);
				return true;
			}
		}
		return false;
	}
	public void printRecord( ) 
	{
		if( this.empList != null )
		{
			for (Employee emp : empList) 
			{
				System.out.println(emp.toString());
			}
		}
	}
	
}

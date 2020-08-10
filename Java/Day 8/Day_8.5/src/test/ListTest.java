package test;

import java.util.Comparator;
import java.util.List;

public class ListTest 
{
	private List<Employee> empList;
	public void setEmpList(List<Employee> empList) 
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
	/*public Employee findRecord(int empid)
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
	}*/
	public Employee findRecord(int empid)
	{
		if( this.empList != null )
		{
			Employee key = new Employee();
			key.setEmpid(empid);
			if( this.empList.contains(key))
			{
				int index = this.empList.indexOf(key);
				return this.empList.get(index);
			}
		}
		return null;
	}
	/*public boolean removeRecord(int empid)
	{
		if( this.empList != null )
		{
			Employee key = new Employee();
			key.setEmpid(empid);
			if( this.empList.contains(key))
			{
				int index = this.empList.indexOf(key);
				this.empList.remove( index );
				return true;
			}
		}
		return false;
	}*/
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
	public void printRecord(Comparator<Employee> comparator) 
	{
		if( this.empList != null )
		{
			this.empList.sort(comparator);
			for (Employee emp : empList) 
			{
				System.out.println(emp.toString());
			}
		}
	}
	
}

package test;

import java.util.Comparator;

public class SortByEmpid implements Comparator<Employee> 
{
	@Override
	public int compare(Employee emp1, Employee emp2) 
	{
		return emp1.getEmpid() - emp2.getEmpid();
	}
}

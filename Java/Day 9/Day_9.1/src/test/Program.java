package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Program
{
	public static void main(String[] args) 
	{
		List<Integer> list1 = new Vector<>();
		list1.add(10);
		list1.add(20);
		list1.add(30);
		list1.add(40);
		list1.add(50);
		
		//List<Integer> list2 = new ArrayList<Integer>( list1 );
		List<Integer> list2 = new ArrayList<Integer>( );
		list2.addAll(list1);
		
		if( !list2.isEmpty())
		{
			for(Integer element : list2 )
				System.out.println(element);
		}
			
	}
}

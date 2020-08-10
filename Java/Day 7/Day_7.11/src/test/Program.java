package test;

import java.util.Iterator;
import java.util.LinkedList;

public class Program extends Object
{
	public static void main(String[] args) 
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		
		/*for( Integer element : list )
			System.out.println(element);*/
		
		Iterator<Integer> itr = list.iterator();
		while( itr.hasNext())
		{
			Integer element = itr.next();
			System.out.println(element);
		}
	}
}

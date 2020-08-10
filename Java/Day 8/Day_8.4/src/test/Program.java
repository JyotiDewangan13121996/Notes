package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Program
{
	public static void printRecord( List<Integer> list )
	{
		for( Integer element : list )
			System.out.println(element);
	}
	public static List<Integer> getIntegerList( )
	{
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		return list;
	}
	public static void main(String[] args) 
	{
		List<Integer> list = Program.getIntegerList();
		
		Integer element = null;
		ListIterator<Integer> itr = list.listIterator();
		while( itr.hasNext())
		{
			element = itr.next();
			System.out.print(element+"	");
		}
		System.out.println();
		while( itr.hasPrevious())
		{
			element = itr.previous();
			System.out.print(element+"	");
		}
	}
	public static void main13(String[] args) 
	{
		List<Integer> list = Program.getIntegerList();
		Integer element = null;
		Iterator<Integer> itr = list.iterator();
		while( itr.hasNext())
		{
			element = itr.next();
			System.out.println(element);
		}
	}
	public static void main12(String[] args) 
	{
		List<Integer> list = Arrays.asList(10,20,30,40,50);
		Program.printRecord(list);
		System.out.println(list.getClass().getName()); //java.util.Arrays$ArrayList
	}
	public static void main11(String[] args) 
	{
		List<Integer> list = Program.getIntegerList();
		Integer[] arr = new Integer[ list.size() ];
		list.toArray(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void main10(String[] args) 
	{
		List<Integer> list = Program.getIntegerList();
		
		Object[] arr = list.toArray();
		System.out.println(Arrays.toString(arr));
	}
	public static void main9(String[] args) 
	{
		List<Integer> list = Program.getIntegerList();
		Collection<Integer> keys = new ArrayList<>();
		keys.add(30);
		keys.add(40);
		
		if( list.containsAll(keys))
		{
			//list.removeAll(keys);
			list.retainAll(keys);
			Program.printRecord(list);	
		}
		else
			System.out.println("keys not found");
		//Program.printRecord(list);
	}
	public static void main8(String[] args) 
	{
		List<Integer> list = Program.getIntegerList();
		Integer key = new Integer(30);
		if( list.contains(key))
		{
			int index = list.indexOf(key);
			Integer element = list.remove(index);
			System.out.println("Removed element : "+element);
		}
		else
			System.out.println(key+" not found");
		//Program.printRecord(list);
	}
	public static void main7(String[] args) 
	{
		List<Integer> list = Program.getIntegerList();
		Integer key = new Integer(30);
		if( list.contains(key))
		{
			int index = list.indexOf(key);
			Integer element = list.get(index);
			System.out.println(element);
		}
		else
			System.out.println(key+" not found");
		//Program.printRecord(list);
	}
	public static void main6(String[] args) 
	{
		List<Integer> list = Program.getIntegerList();
		
		Collection<Integer> c = new ArrayList<>();
		//List<Integer> c = new ArrayList<>();
		//ArrayList<Integer> c = new ArrayList<>();
		c.add(60);
		c.add(70);
		c.add(80);
		
		//list.addAll(c);
		list.addAll(3,c);
		Program.printRecord(list);
	}
	public static void main5(String[] args) 
	{
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(50);
		list.add(2, 40);
		list.add(2, 300);
		list.set(2, 30);
		Program.printRecord(list);
	}
	public static void main4(String[] args) 
	{
		List<Integer> list = new ArrayList<>();
		list.add(50);
		list.add(10);
		list.add(30);
		list.add(20);
		list.add(40);
		//Collections.sort(list);
		list.sort(null);
		for( Integer element : list )
			System.out.println(element);
	}
	public static void main3(String[] args) 
	{
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		for( Integer element : list )
			System.out.println(element);
	}
	public static void main2(String[] args) 
	{
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		
		Integer element = null;
		for( int index = 0; index < list.size(); ++ index )
		{
			element = list.get(index);
			System.out.println(element);
		}
		element = list.get(list.size()); //IndexOutOfBoundsException
	}
	public static void main1(String[] args) 
	{
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		int size = list.size();
		System.out.println("Size	:	"+size);
	}
}

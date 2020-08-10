package test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Deque;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

public class Program
{
	public static void main(String[] args) 
	{
		Set<Integer> set  = new  TreeSet<Integer>();
		set.add(50);
		set.add(10);
		set.add(40);
		set.add(20);
		set.add(30);
		
		set.add(50);
		set.add(10);
		set.add(40);
		set.add(20);
		set.add(30);
		
		set.add(null); //NullPointerException
		
		for( Integer element : set )
			System.out.println(element);
	}
	public static void main6(String[] args) 
	{
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(10);
		que.offer(20);
		que.offer(30);
		
		Integer ele = null;
		while( !que.isEmpty())
		{
			ele = que.peek();
			System.out.println("Removed element is : "+ele);
			que.poll();
		}
	}
	public static void main5(String[] args) 
	{
		Queue<Integer> que = new ArrayDeque<>();
		que.add(10);
		que.add(20);
		que.add(30);
		Integer ele = null;
		while( !que.isEmpty())
		{
			ele = que.element();
			System.out.println("Removed element is : "+ele);
			que.remove();
		}
	}
	public static void main4(String[] args) 
	{
		Deque<Integer> stk = new ArrayDeque<>();
		stk.push(10);
		stk.push(20);
		stk.push(30);
		Integer element = null;
		while( !stk.isEmpty())
		{
			element = stk.peek();
			System.out.println("Popped element is : "+element);
			stk.pop();
		}
	}
	public static void main3(String[] args) 
	{
		Stack<Integer> stk = new Stack<Integer>();
		stk.push(10);
		stk.push(20);
		stk.push(30);
		Integer element = null;
		while( !stk.empty() )
		{
			//element = stk.peek();
			element = stk.pop();
			System.out.println("Popped element is : "+element);
			
		}
	}
	public static void main2(String[] args) 
	{
		Vector<Integer> v = new Vector<>();
		v.add(10);
		v.add(20);
		v.add(30);
		v.add(40);
		v.add(50);
		
		Integer element = null;
		Enumeration<Integer> e = v.elements();
		while( e.hasMoreElements())
		{
			element = e.nextElement();
			System.out.print(element+" ");
			if( element == 50 )
				v.add(60); //OK
		}
		System.out.println();
	}
	public static void main1(String[] args) 
	{
		Vector<Integer> v = new Vector<>();
		v.add(10);
		v.add(20);
		v.add(30);
		v.add(40);
		v.add(50);
		
		Integer element = null;
		Iterator<Integer> itr = v.iterator();
		while( itr.hasNext())
		{
			element = itr.next();
			System.out.print(element+"	");
			if( element == 50 )
				v.add(60); //ConcurrentModificationException
		}
		System.out.println();
	}
}

package test;

import java.util.Iterator;

class Node
{
	int data;
	Node next;
	public Node( int data )
	{
		this.data = data;
		this.next = null;
	}
}
class LinkedList implements Iterable<Integer>
{
	private Node head;
	private Node tail;
	public boolean empty( )
	{
		return this.head == null;
	}
	public void addLast( int data )
	{
		Node newNode = new Node(data);
		if( this.empty() )
			this.head = newNode;
		else
			this.tail.next = newNode;
		this.tail = newNode;
	}
	@Override
	public Iterator<Integer> iterator() 
	{
		Iterator<Integer> itr = new LinkedListIterator( this.head );
		return itr;
	}
}
class LinkedListIterator implements Iterator<Integer>
{
	private Node node;
	public LinkedListIterator(Node head)
	{
		this.node = head;
	}
	@Override
	public boolean hasNext() 
	{
		if( this.node != null )
			return true;
		return false;
	}
	@Override
	public Integer next() 
	{
		Integer element = this.node.data;
		this.node = this.node.next;
		return element;
	}
}
public class Program extends Object
{
	public static void main(String[] args) 
	{
		LinkedList list = new LinkedList();
		list.addLast( 10 );
		list.addLast( 20 );
		list.addLast( 30 );
		
		for( Integer element : list )
			System.out.println(element);
		
		/*Integer element = null;
		Iterator<Integer> itr = list.iterator();
		while( itr.hasNext())
		{
			element = itr.next();
			System.out.println(element);
		}*/
	}
}

package test;

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
class LinkedList
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
	public void printList()
	{
		if( !this.empty()) 
		{
			Node trav = this.head;
			while( trav != null )
			{
				System.out.println(trav.data);
				trav = trav.next;
			}
		}
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
		list.printList();
	}
}

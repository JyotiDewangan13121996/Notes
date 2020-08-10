package test;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

class Pair<K,V> implements Entry<K, V>
{
	private K key;
	private V value;
	@Override
	public K getKey() 
	{
		return this.key;
	}
	@Override
	public V getValue() 
	{
		return this.value;
	}
	@Override
	public V setValue(V value)
	{
		this.value = value;
		return this.value;
	}
}
public class Program
{
	private static Dictionary<Integer, String> getDictionary() 
	{
		Dictionary<Integer, String> d = new Hashtable<>();
		d.put(1, "DAC");
		d.put(2, "DMC");
		d.put(3, "DESD");
		d.put(4, "DBDA");
		d.put(5, "PRECAT");
		return d;
	}
	private static void printKeys(Dictionary<Integer, String> d) 
	{
		if( d != null )
		{
			Enumeration<Integer> keys = d.keys();
			Integer key = null;
			while( keys.hasMoreElements())
			{
				key = keys.nextElement();
				System.out.println(key);
			}
		}
	}
	private static void printValues(Dictionary<Integer, String> d) 
	{
		if( d != null )
		{
			Enumeration<String> values = d.elements();
			String element = null;
			while( values.hasMoreElements())
			{
				element = values.nextElement();
				System.out.println(element);
			}
		}
	}
	private static void findValue(Dictionary<Integer, String> d, int number) 
	{
		if( d != null )
		{
			Integer key = new Integer(number);
			String value = d.get(key);
			System.out.println(value);
		}
	}
	private static void removeEntry(Dictionary<Integer, String> d, int number) 
	{
		if( d != null )
		{
			Integer key = new Integer(number);
			String value = d.remove(key);
			System.out.println(value);
		}
	}
	public static void main(String[] args) 
	{
		Dictionary<Integer, String> d = Program.getDictionary( );
		//System.out.println("Count	:	"+d.size());
		//Program.printKeys( d );
		//Program.printValues( d );
		//Program.findValue( d, 3 );
		//Program.removeEntry( d, 3 );
		Map<Integer, String> map = new Hashtable<>();
		map.put(1, "DAC");
		map.put(2, "DMC");
		map.put(3, "DESD");
	}
	
	
	
	

	
}

package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Program
{
	public static void main(String[] args) 
	{
		Map<Integer, String> map = Program.getMap( );
		//System.out.println("Count	:	"+map.size());
		//Program.printKeys( map );
		//Program.printValues( map );
		//Program.printEntries( map );
		//Program.findValue( map, 2 );
		//Program.removeEntry( map, 2 );
		
		List<Integer> keys = new ArrayList<>( map.keySet());
		List<String> values = new ArrayList<>(map.values());
	}
	private static void removeEntry(Map<Integer, String> map, int value ) 
	{
		if( map != null )
		{
			Integer key = new Integer(value);
			if( map.containsKey(key))
			{
				String val = map.remove(key);
				System.out.println(key+"	"+val);
			}
			else
				System.out.println("Key not found");
		}
	}
	private static void findValue(Map<Integer, String> map, int value ) 
	{
		if( map != null )
		{
			Integer key = new Integer(value);
			if( map.containsKey(key))
			{
				String val = map.get(key);
				System.out.println(key+"	"+val);
			}
			else
				System.out.println("Key not found");
		}
	}

	private static void printEntries(Map<Integer, String> map) 
	{
		if( map !=null )
		{
			Set<Entry<Integer, String>> entries = map.entrySet();
			for (Entry<Integer, String> entry : entries)
			{
				Integer key = entry.getKey();
				String value = entry.getValue();
				System.out.println(key+"	"+value);
			}
		}
	}

	private static void printValues(Map<Integer, String> map) 
	{
		if( map != null )
		{
			Collection<String> values = map.values();
			for (String value : values) 
			{
				System.out.println(value);
			}
		}
	}

	private static void printKeys(Map<Integer, String> map) 
	{
		if( map != null )
		{
			Set<Integer> keys = map.keySet();
			for (Integer key : keys) 
			{
				System.out.println(key);
			}
		}
	}

	private static Map<Integer, String> getMap() 
	{
		Map<Integer, String> map = new Hashtable<Integer, String>();
		map.put(1, "DAC");
		map.put(2, "DMC");
		map.put(3, "DESD");
		return map;
	}
}

package test;

class HashTable<K,V>
{
	private K key;
	private V value;
	public void put( K key, V value )
	{
		this.key = key;
		this.value = value;
	}
	public K getKey() 
	{
		return key;
	}
	public V getValue() 
	{
		return value;
	}
}
public class Program 
{
	public static void main(String[] args) 
	{	
		HashTable<Integer,String> ht = new HashTable<>( );
		ht.put(1, "DAC");
		System.out.println("Key	:	"+ht.getKey());
		System.out.println("Value	:	"+ht.getValue());
		
	}
}

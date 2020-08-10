package test;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest
{
	private Map<Account, Customer> map;
	public void setMap(Map<Account, Customer> map) 
	{
		this.map = map;
	}
	public void addEntry(Account[] accounts, Customer[] customers) 
	{
		if( this.map != null && accounts != null && customers != null )
		{
			for( int index = 0; index < accounts.length; ++ index )
				this.map.put(accounts[ index ],  customers[ index ] );
		}
	}
	public Customer findCustomer(int accNumber )
	{
		if( this.map != null )
		{
			Account key = new Account();
			key.setNumber(accNumber);
			if( this.map.containsKey(key))
			{
				return this.map.get(key);
			}
		}
		return null;
	}
	public boolean removeEntry(int accNumber) 
	{
		if( this.map != null )
		{
			Account key = new Account();
			key.setNumber(accNumber);
			if( this.map.containsKey(key))
			{
				this.map.remove(key);
				return true;
			}
		}
		return false;
	}
	public void printEntries() 
	{
		if( this.map != null )
		{
			Set<Entry<Account, Customer>> entries = this.map.entrySet();
			for (Entry<Account, Customer> entry : entries) 
			{
				Account key = entry.getKey();
				Customer value = entry.getValue();
				System.out.println(key.toString()+" "+value.toString());
			}
		}
	}
}

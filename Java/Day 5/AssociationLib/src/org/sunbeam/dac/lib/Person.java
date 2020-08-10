package org.sunbeam.dac.lib;

public class Person
{
	private String name;
	private Date birthDate;
	private Address currentAddress;
	public Person() 
	{
		this.name = new String("");
		this.birthDate = new Date();
		this.currentAddress = new Address();
	}
	public Person(String name, Date birthDate, Address currentAddress) 
	{
		this.name = name;
		this.birthDate = birthDate;
		this.currentAddress = currentAddress;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Address getCurrentAddress() {
		return currentAddress;
	}
	public void setCurrentAddress(Address currentAddress) {
		this.currentAddress = currentAddress;
	}
	@Override
	public String toString() 
	{
		return "Person [name=" + name + ", birthDate=" + birthDate + ", currentAddress=" + currentAddress + "]";
	}
	
}

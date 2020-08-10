package org.sunbeam.dac.test;

import java.util.Scanner;

import org.sunbeam.dac.lib.Address;
import org.sunbeam.dac.lib.Date;
import org.sunbeam.dac.lib.Person;

public class Program
{
	static Scanner sc = new Scanner(System.in);
	private static void acceptRecord(Date date) 
	{
		System.out.print("Day	:	");
		date.setDay(sc.nextInt());
		System.out.print("Month	:	");
		date.setMonth(sc.nextInt());
		System.out.print("Year	:	");
		date.setYear(sc.nextInt());
	}
	private static void acceptRecord(Address address) 
	{
		System.out.print("City	:	");
		address.setCity(sc.nextLine());
		System.out.print("State	:	");
		address.setState(sc.nextLine());
		System.out.print("Pincode	:	");
		address.setPincode(sc.nextInt());
	}
	private static void acceptRecord(Person p) 
	{
		System.out.print("Name	:	");
		p.setName(sc.nextLine());
		Date birthDate = p.getBirthDate();
		Program.acceptRecord(birthDate);
		sc.nextLine();
		Address currentAddress = p.getCurrentAddress();
		Program.acceptRecord(currentAddress);
	}
	private static void printRecord(Date date) 
	{
		System.out.println(date.getDay()+" / "+date.getMonth()+" / "+date.getYear());
	}
	
	private static void printRecord(Address address) 
	{
		System.out.println(address.getCity()+" "+address.getState()+" "+address.getPincode());
	}

	private static void printRecord(Person p) 
	{
		System.out.println("Name	:	"+p.getName());
		Date birthDate = p.getBirthDate();
		System.out.print("BirthDate	:	");
		Program.printRecord(birthDate);
		Address currentAddress = p.getCurrentAddress();
		System.out.print("Address	:	");
		Program.printRecord(currentAddress);
	}
	public static void main(String[] args) 
	{
		Person p = new Person( );
		Program.acceptRecord(p);
		Program.printRecord(p);
	}
	public static void main2(String[] args) 
	{
		Address address = new Address( );
		Program.acceptRecord(address);
		Program.printRecord(address);
	}
	
	public static void main1(String[] args) 
	{
		Date date = new Date();
		Program.acceptRecord( date );
		Program.printRecord( date );
	}	
}	

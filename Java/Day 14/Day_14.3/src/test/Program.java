package test;

import java.util.Date;
import java.util.StringTokenizer;

public class Program
{
	public static void main(String[] args) 
	{
		StringBuilder sb1 = new StringBuilder("Dac");
		StringBuilder sb2 = new StringBuilder("Dac");
		if( sb1.equals(sb2) )
			System.out.println("Equal");
		else
			System.out.println("Not Equal");
		//Not Equal
	}
	public static void main14(String[] args) 
	{
		StringBuilder sb1 = new StringBuilder("Dac");
		StringBuilder sb2 = new StringBuilder("Dac");
		if( sb1 == sb2 )
			System.out.println("Equal");
		else
			System.out.println("Not Equal");
		//Not Equal
	}
	public static void main13(String[] args) 
	{
		StringBuffer sb1 = new StringBuffer("Dac");
		StringBuffer sb2 = new StringBuffer("Dac");
		if( sb1.equals(sb2) )
			System.out.println("Equal");
		else
			System.out.println("Not Equal");
		//Not Equal
	}
	public static void main12(String[] args) 
	{
		StringBuffer sb1 = new StringBuffer("Dac");
		StringBuffer sb2 = new StringBuffer("Dac");
		if( sb1 == sb2 )
			System.out.println("Equal");
		else
			System.out.println("Not Equal");
		//Not Equal
	}
	public static void main11(String[] args) 
	{
		String str = "www.yahoo.com";
		StringTokenizer stk = new StringTokenizer(str,".");
		//System.out.println("Count	:	"+stk.countTokens());
		while( stk.hasMoreTokens() )
		{
			String token = stk.nextToken();
			System.out.println(token);
		}
	}
	public static void main10(String[] args) 
	{
		String str = "SunBeam Infotech Pune";
		StringTokenizer stk = new StringTokenizer(str);
		//System.out.println("Count	:	"+stk.countTokens());
		while( stk.hasMoreTokens() )
		{
			String token = stk.nextToken();
			System.out.println(token);
		}
	}
	public static void main9(String[] args) 
	{
		String str = "www.sunbeaminfo.com";
		String[] words = str.split("\\.");
		for (String word : words) 
		{
			System.out.println(word);
		}
	}
	public static void main8(String[] args) 
	{
		String str = "SunBeam Infotech Pune";
		String[] words = str.split(" ");
		for (String word : words) 
		{
			System.out.println(word);
		}
	}
	public static void main7(String[] args) 
	{
		String s1 = "SunBeam";
		s1 = s1 + new Date();
		System.out.println(s1);
	}
	public static void main6(String[] args) 
	{
		String s1 = "SunBeam";
		s1 = s1.concat("Pune");
		System.out.println(s1);
	}
	public static void main5(String[] args) 
	{
		String str = "SunBeam";
		str = str + "Pune";
		System.out.println(str);
	}
	public static void main4(String[] args) 
	{
		String s1 = "SunBeam";
		String s2 = "SunBeam";
		if( s1.equals(s2) )
			System.out.println("Equal");
		else
			System.out.println("Not Equal");
		//Output : Equal
	}
	public static void main3(String[] args) 
	{
		String s1 = "SunBeam";
		String s2 = "SunBeam";
		if( s1 == s2 )
			System.out.println("Equal");
		else
			System.out.println("Not Equal");
		//Output : Equal
	}
	public static void main2(String[] args) 
	{
		String s1 = new String("SunBeam");
		String s2 = new String("SunBeam");
		if( s1.equals(s2) )
			System.out.println("Equal");
		else
			System.out.println("Not Equal");
		//Output : Equal
	}
	public static void main1(String[] args) 
	{
		String s1 = new String("SunBeam");
		String s2 = new String("SunBeam");
		if( s1 == s2 )
			System.out.println("Equal");
		else
			System.out.println("Not Equal");
		//Output : Not Equal
	}
}

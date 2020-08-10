package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.InetAddress;
import java.util.Scanner;

public class Program 
{
	static Scanner sc = new Scanner(System.in);
	public static void writeRecord( String pathname )throws Exception
	{
		try( BufferedWriter writer = new BufferedWriter(new FileWriter(new File(pathname))))
		{
			writer.write("Diploma In Advanced Computing");
			writer.newLine();
			writer.write("SIIT Pune");
			writer.newLine();
			writer.write("12345");
		}
	}
	public static void readRecord( String pathname )throws Exception
	{
		try( BufferedReader reader = new BufferedReader(new FileReader(new File(pathname))))
		{
			String text = null;
			while( ( text = reader.readLine( ) ) != null )
				System.out.println(text);
		}
	}
	public static int menuList( )
	{
		System.out.println("0.Exit");
		System.out.println("1.Write Record");
		System.out.println("2.Read Record");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}
	public static void main(String[] args) 
	{
		try
		{
			InetAddress localhost = InetAddress.getLocalHost();
			System.out.println("Host Name	:	"+localhost.getHostName());
			System.out.println("IP Address	:	"+localhost.getHostAddress());
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}
	}
	public static void main1(String[] args) 
	{
		int choice;
		String pathname = "File.txt";
		while( ( choice = Program.menuList( ) ) != 0)
		{
			try
			{
				switch( choice )
				{
				case 1:
					Program.writeRecord(pathname);
					break;
				case 2:
					Program.readRecord(pathname);
					break;
				case 3:
					Program.readRecord("../Day_13.16/src/test/Program.java");
					break;
				}
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
}

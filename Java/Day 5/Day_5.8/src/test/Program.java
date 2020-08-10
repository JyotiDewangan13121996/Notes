package test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Program 
{
	public static void main(String[] args) 
	{
		LocalDate ld = LocalDate.now();
		int day = ld.getDayOfMonth();
		int month = ld.getMonthValue();
		int year = ld.getYear();
		System.out.println(day+" / "+month+" / "+year);
	}
	public static void main2(String[] args) 
	{
		//Date date = new Date(119, 10, 5);
		Date date = new Date();
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String strDate = sdf.format(date);
		System.out.println(strDate);
		
	}
	public static void main1(String[] args) 
	{
		 Calendar c = Calendar.getInstance();
		 int day = c.get(Calendar.DATE);
		 int month = c.get(Calendar.MONTH) + 1;
		 int year = c.get(Calendar.YEAR);
		 System.out.println(day+" / "+month+" / "+year);
	}
}

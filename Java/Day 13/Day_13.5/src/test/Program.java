package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Program 
{
	public static void main(String[] args)  
	{
		Integer n1 = new Integer(0);
		Class<?> c = n1.getClass();
		Program.printTypeInfo( c );
		System.out.println("---------------------");
		Program.fieldInfo( c );
		System.out.println("---------------------");
		Program.printConstructorInfo( c );
		System.out.println("---------------------");
		Program.printMethodInfo( c );
	}

	private static void printMethodInfo(Class<?> c)
	{
		if( c != null )
		{
			Method[] methods = c.getMethods();
			for (Method method : methods) 
			{
				System.out.println(method.toString());
			}
		}
	}

	private static void printConstructorInfo(Class<?> c)
	{
		if( c != null )
		{
			Constructor<?>[] constructors = c.getConstructors();
			for (Constructor<?> constructor : constructors)
			{
				System.out.println(constructor.toString());
			}
		}
	}

	private static void fieldInfo(Class<?> c) 
	{
		if( c != null )
		{
			Field[] fields = c.getFields();
			for (Field field : fields) 
			{
				System.out.println(field.toString());
			}
		}
	}

	private static void printTypeInfo(Class<?> c) 
	{
		if( c != null )
		{
			String name = c.getPackage().getName();
			System.out.println("Package Name	:	"+name);
			String className = c.getSimpleName();
			System.out.println("Class Name	:	"+className);
		}
	}
}

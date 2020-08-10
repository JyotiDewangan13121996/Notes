package test;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Scanner;

class Convert
{
	public static Object changeType(String value, String parameterType) 
	{
		switch( parameterType )
		{
		case "int":
			return Integer.parseInt(value);
		}
		return null;
	}	
}
public class Program 
{
	public static void main(String[] args)  
	{
		try( Scanner sc = new Scanner(System.in))
		{
			System.out.print("F.Q.Class Name	:	");
			String className = sc.nextLine();
			Class<?> c = Class.forName(className);
			System.out.print("Method Name	:	");
			String methodName = sc.nextLine();
			Method[] methods = c.getMethods( );
			for (Method method : methods) 
			{
				if( method.getName().equalsIgnoreCase(methodName))
				{
					Object[] arr = new Object[ method.getParameterCount() ];
					Parameter[] parameters = method.getParameters();
					for( int index = 0;  index < parameters.length; ++ index )
					{
						String parameterType = parameters[ index ].getType().getName();
						System.out.print("Enter value of "+parameterType+" type	:	");
						String value =  sc.nextLine();
						arr[ index ] = Convert.changeType( value, parameterType );
					}
					Object obj = c.newInstance();
					Object result =  method.invoke(obj,arr);
					System.out.println("Result	:	"+result);
					break;
				}
			}
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}
	}
}

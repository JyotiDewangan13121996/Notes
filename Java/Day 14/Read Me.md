# Day 14
### String Handling
* String is collection of character object which do not ends with '\0' character.
* If we want to manipulate String then we can use
    1. java.lang.String
    2. java.lang.StringBuffer
    3. java.lang.StringBuilder
    4. java.util.StringTokenizer
#### String
* It is a final class declared in java.lang package.
* It implements Serializable, Comparable<String> and CharSequence interface.
* We can create instance of a String with and without new operator.
```java
String str = "SunBeam"; //OK
String str = new String("SunBeam"); //OK
```
* String instance get space on heap section but String literals get space on String literal pool / String pool.
```java
String s1 = new String("SunBeam");
String s2 = new String("SunBeam");
if( s1 == s2 )
    System.out.println("Equal");
else
    System.out.println("Not Equal");
//Output : Not Equal
```
```java
String s1 = new String("SunBeam");
String s2 = new String("SunBeam");
if( s1.equals(s2) )
    System.out.println("Equal");
else
    System.out.println("Not Equal");
//Output : Equal
```
```java
String s1 = "SunBeam";
String s2 = "SunBeam";
if( s1 == s2 )
    System.out.println("Equal");
else
    System.out.println("Not Equal");
//Output : Equal
```
```java
public static void main(String[] args) 
{
    String s1 = "SunBeam";
    String s2 = "SunBeam";
    if( s1.equals(s2) )
        System.out.println("Equal");
    else
        System.out.println("Not Equal");
    //Output : Equal
}
```
* String instances are const/immutable i.e if we try to create instance of String then new String instance gets created.
* Using concat method, we can append String to another String.
```java
String s1 = "SunBeam";
s1 = s1.concat("Pune");
```
* Using + operator we can concat state of instance any primitive as well as non primitive type to the String.
```java
String s1 = "SunBeam";
s1 = s1 + 123;  //Ok

String s2 = "SunBeam";
s2 = s2 + new Date( );//Ok

String s3 = "SunBeam";
s3 = s3 + "Pune";   //Ok
```
### StringTokenizer
* On the basis of delimiter, if we want to split String then we should use StringTokenizer.
```java
public static void main(String[] args) 
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
```
### StringBuffer and StringBuilder
* Both are final classes declared in java.lang package
* Both are used to create mutable String object
* equals() and hashCode() method is not overriden in these classes
* If we want to create instances of these classes we must use new operator
* StringBuffer is synchronized whereas StringBuilder is unsynchronized.
### Nested Class
* We can define class inside scope of another class. It is called nested class.
```java
//Top Level class
class Outer	//Outer.class
{
    //Nested class
	class Inner	//Outer$Inner.class
	{
        
	}
}
```
* We can declrae top level class either package level private or public only.
* We can use any access modifier on nested class.
* During inheritance, nested class inherit into sub class.
* Using nested class, we can achive encapsulation.
* Types of nested class
    1. Non static nested class / Inner class
    2. Static nested class

#### Inner class
* Non static nested class is also called as inner class.
* If implementation of nested class depends on implementation of top level class then we should declare nested class non static.
* Note : For Simplicity, consider non static nested class as a non static method of a class.
```java
class Outer
{
	class Inner
	{
		
	}
}
public class Program
{
	public static void main(String[] args) 
	{
		Outer out = new Outer();
		//Outer.Inner in = out.new Inner();
		Outer.Inner in = new Outer().new Inner();
	}
}
```
* Inside Top-Level class we can declare static as well as non static members but inside non static nested class / Inner class we can declare only non static members.

#### Static Nested Class
* If we declare nested class static then it is called as static nested class.
* If implementation of nested class do not depends on implementation of top level class then we should declare nested class static.
*  Note : For Simplicity, consider static nested class as a static method of a class.
```java
class Outer
{
	static class Inner
	{
		
	}
}
public class Program
{
	public static void main(String[] args) 
	{
		Outer out = new Outer();
		Outer.Inner in = new Outer.Inner();
	}
}
```
* We can declare static and non static members inside top level class as well as static nested class.
### Local Class
* In java, we can define class inside method. It is called local class.
* We can not create reference and instance of local class outside method.
* Types
    1. Method Local Inner class
    2. Method Local Annonymous Inner Class
#### Method Local Inner class
```java
public class Program//Pogram.class
{
	public static void main(String[] args) 
	{
		class Complex	//Program$1Complex.class
		{
			private int real = 10;
			private int imag = 20;
			@Override
			public String toString() 
			{
				return this.real+" "+this.imag;
			}
		}
		Complex c1 = new Complex();
		System.out.println(c1.toString());
	}
}
```
#### Method Local Annonymous Inner class
```java
public static void main(String[] args) 
{
    Object obj = new Object() //Program$1.class
    {
        private String str = "Hello";
        @Override
        public String toString() 
        {
            return str;
        }
    };
    System.out.println(obj.toString());
}
```
```java
public static void main(String[] args) 
{
    Printable p = new Printable() 
    {	
        @Override
        public void print() 
        {
            System.out.println("Hello");
        }
    };
    p.print();//DMD
}
```
* If interface contains only one abstract method then such interface is called functional interface.
* Functional interface can contain multiple default method as well as multiple static methods but it can contain only one abstract method.
* @FunctionalInterface is annotation which is used to check whether interface is FunctionalInterface or not.
* java.util.function package contains library defined functional interfaces.
    1. Predicate
        - boolean test(T t)
    2. Supplier
        - T get()
    3. Consumer<T>
        - void accept(T t)
    4. Function
        - R apply(T t)
* if we want to implement functional interface then we should use lambda expression or method reference.


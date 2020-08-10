# Day 3
### Java Entry Point
    * According JVM specification, "main" should be entry point method in java application.
    * Java compiler do not check whether class contains "main" method or not. It is responsibility of JVM.
    * Syntax:
    "public static void main(String[] args)"
    * With the help of main thread, JVM invoke main method.
    * In java, we can overload main method.
    * We can define "main" method per class but only one main method can be considered as entry point method.
### Object class
    * Object is non final and concrete class declared in java.lang package.
    * In java, every class( not interface ) is directly or indirectly extended from java.lang.Object class.
    * java.lang.Object class do not have super class hence it is called as "Ultimate base class" / "Super Cosmic Base class" / "Root Of Java Class Hierarchy".
    * It is introduced in JDK 1.0
#### Members of java.lang.Object class
    * It doesn't contain nested type.
    * It doesn't contain field.
    * It contains only parameterless constructor.
    Object o1 = new Object( );  //OK
    Object o2 = new Object( 24 ); //Not OK
    * It contains 11 method( 5 non final + 6 final methods ).
    * In java, we can not override final method.
##### Methods of java.lang.Object class
1. public String toString( );

2. public boolean equals( Object obj );

3. public native int hashCode( );

4. protected native Object clone( ) throws CloneNotSupportedException;

5. protected void finalize( )throws Throwable

6. public final native Class<?> getClass( );

7. public final void wait( ) throws InterruptedException

8. public final native void wait( long timeOut ) throws InterruptedException

9. public final void wait( long timeOut, int nanos ) throws InterruptedException

10. public final native notify( );

11. public final native notifyAll( );

### Java class and Instance
    * To define class, we should use class keyword.
        class ClassName
        {
            //Fields
            //Methods
        }
    * In java class members are by default considered as package level private / default.
    * In java, data member is called as field. It can be static or non static.
    * Non static field is called as instance variable and static field is called as class-level variable.
```java
class Test
{
    private int x;  //Instance variable
    private static int y; //Class-level var.
}
```
    * If we create instance of a class then only non static field / instance variable  get space inside it.
    * In java, if we want to create instance of a reference type then it is mandatory to use new operator.
    * If we create instance using new operator then it gets space on heap section.
    * Instantiation in C++
```C++
    Complex *ptr = new Complex( );
    Complex *ptr = new Complex( 10, 20 );
```
    * Everything on heap section is anonymous. If we want to perform operations on instance then first it is mandatory to create reference of it.
    * Instantiation in Java
```java
    Complex c1 = new Complex( );    //Ok

    Complex c2;     //OK
    c2 = new Complex( );    //OK
```
    * if we want to perform operations on instance then we should define method inside class.
    * Process of calling method on instance is called message passing.
    * "this" is implict reference variable which is available in every non static method of the class that is used to store reference of current instance.
### Constructor
    * It is a method of a class which is used to intialize instance.
    * Imporant point about constructor
        1. It's name is same as class name
        2. It doesn't have return type
        3. It is designed to call implicitly
        4. It is designed to call once per instance.
    * Types
        1. Parameterless ctor
        2. Parameterized ctor
        3. Default ctor.
```java
class Complex
{
    private int real, imag;
    //Parameterless constructor
    public Complex( )
    {
        this.real = 10;
        this.imag = 20;
    }
}
Complex c1 = new Complex( );
```
```java
class Complex
{
    private int real, imag;
    //Parameterized constructor
    public Complex( int real, int imag )
    {
        this.real = real;
        this.imag = imag;
    }
}
Complex c1 = new Complex( 10, 20 );
```
    * We can write multiple constructor inside class. It is called constructor overloading.
    * If we want to reuse implementation of existing constructor then we should call constructor from another constructor.
    * If we want to call constructor from another constructor then we should use "this statement";
    * this statement must be first statement in constructor body.
    * Process of calling constructor from another constructor is called constructor chaining.
    * To reduce developer's effort we should use constructor chaining.
```java
class Complex
{
    private int real;
    private int imag;
    public Complex( )
    {
        this( 10, 20 ); //ctor Chaining
    }
    public Complex( int real, int imag )
    {
        this.real = real;
        this.imag = imag;
    }
}
```
    * we can use any access modifier on constructor.
### null
    * It is literal which is used to initialize reference variable.
```java
    int number = null;  //Not OK
    Complex c1 = null;  //Ok
```
    * If reference contains null value then it is called null reference variable or null object.
    * In above code c1 is null object.
```C++
    int *ptr = NULL;    //OK
    int number = NULL;  //OK
```
    * In C++, NULL is a macro whose implicit value is 0.
    * It is designed to initialize pointer.
### NullPointerException
    * Using null object, if we try to access any member of the class then JVM throws NullPointerException.
```java
Complex c1 = null; //OK
c1.printRecord( );  //NullPointerException
```
    * we can solve it using
```java
Complex c1 = null; //OK
c1 = new Complex( );    //OK
c1.printRecord( );  //OK
```
```java
Complex c1 = new Complex(); //Ok
c1.printRecord( );  //OK
```
### Value Type Versus Reference Type
#### Value Type
    1. Primitive type is called as value type. 
    2. Instance of value type get space on stack segment. 
    3. There are 8 value types in java.
    4. Variable of value type contains value.
    5. If we assign variable of value type to the another variable of value type then value gets copied.
        int num1 = 10;
        int num2 = num1;
    6. Default value of value type is 0.
    7. Variable of value type do not contain null.
        int number = null;  //Not OK
#### Reference Type
    1. Non Primitive type is called reference type.
    2. Instance of reference type get space on heap section.
    3. There are 4 reference types in java.
    4. Variable of reference type contains reference.
    5. If we assign variable of refence type to the another variable of reference type then reference gets copied.
        Complex c1 = new Complex( 10,20);
        Complex c2 = c1;
    6. Default value of reference type is null;
    7. Variable of reference type can contain null.
        Complex c1 = null;  //OK
    * Local reference variable get space on stack segment.
    * If reference is field of the class then it gets space on Heap section.
### toString() method
    * It is non final method of java.lang.Object class.
    * Syntax:
        public String toString( );
    * If we want to retrun state of the object in String format then we should use toString() method.
    * If we do not define toString() method inside class then super class's toString method gets called.
    * toString() method of object class returns String in following format
        "F.Q.ClassName@HashCode"
    * According to client's requirement, if implementation of super class method is partialy complete then we should redefine/override method in sub class.
    * toString method should return string which should contain concise and informative result.
    * Every class should override toString() method.
```java
public String toString( )
{
    return String.format("%-15s%-5d%-10.2f",this.name, this.empid, this.salary);
}
```
### Path
    * path is OS platforms environment variable that is used to locate java tools.
    * If we want to set path then we should use following command:
        export PATH=/usr/bin/
    * Above step is optional in linux.
    * To check value of PATH we should use:
        echo $PATH
### Classpath
    * It is environment variable of Java Platform, which is used to locate .class file / .jar file.
    * If we want to set classpath then we should use following command:
        export CLASSPATH=./bin/
    * By default, CLASSPATH is set to current directory.
### Package
    * It is java language feature, which is used 
        1. To avoid name ambiguity
        2. To group functionaly equivalent types together.
    * We can not instantiate package.
    * package is keyword in java.
    * package can contain
        1. Sub Package
        2. Interface
        3. Class
        4. Enum
        5. Error
        6. Exception
        7. Annotation
```C++
namespace std
{
    class Complex
    {

    };
}
```
```java
package p1; //OK
class Complex
{

};
```
    * If we want to define any type inside package then we must write package declaration statement inside .java file.
    * Package declaration statement must be first statement in .java file.
```java
package p1; //OK
package p2; //Not OK
class Complex
{

};
```
    * In other words, we can not define class in multiple packages.
    * package name is physically mapped to folder.
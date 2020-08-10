# Day 13
### Reflection
* Data about data / data which describes another data is called metadata.
* Applications of metadata
1. After compilation, java compiler generates bytecode and metadata. Due to this metadata, there is no need to include header file in .java file.
2. To display class information in intelisense window IDE implicitly use metadata.
3. Metadata help JVM tp serialize or clone state of java instance
4. To keep track of lifetime of object, garbage collector implicitly use metadata.

* If we want to analyze and process metadata then we should use reflection.
* Reflection is java language feature which provides type(s) that is used to analyze and process metadata.
* If we want to use Reflection then we should use types declared in java.lang and java.lang.reflect package.

* Types declared in java.lang:
1. Class
* Types declared in java.lang.reflect:
1. Array
2. Constructor
3. Field
4. Method
5. Modifier
6. Parameter

* Application of Reflection
1. javap is java language disassembler. It is used to show type information using F.Q. type name. It implicitly use reflection
2. To read metadata from .class file IDE implicitly use Reflection.
3. To access values of private field debugger implicitly use reflection.
4. For object mapping, hibernate implicitly use reflection.
5. To implement drag and drop feature, IDE implicitly use reflection
```java
class Date{ }
class Address{  }
class Person
{
    String name;
    Date birthDate;
    Address currentAddres;
}
class Program
{
    public static void main(String[] args) 
    {
        Person p = new Person();    
    }
}
javac Program.java
java Program
```
* Class<T> is a final class declared in java.lang package.
* Instances of the class java.lang.Class represent classes and interfaces in a running Java application.
* java.lang.Class has no public constructor. Instead Class objects are constructed automatically by the Java Virtual Machine.
#### How to get reference of Class<T> class instance?
1. Using getClass() method.
```java
Integer n1 = new Integer(125);
Class<?> c = n1.getClass();
```
2. Using .class syntax
```java
Class<?> c = Number.class;
```
3. Using Class.forName
```java
System.out.print("F.Q.Class Name");
String className = sc.nextLine();	
//java.lang.Thread
Class<?> c = Class.forName(className);
```
### File IO
* File is container that is used to store record permanantly on HDD.
* Stream is an abstraction(object) that is used to produce(write) and consume(read) information from source to destination.
* If we want to do file handling we should use types declared in java.io package.
* Interfaces
1. Closeable
2. Flushable
3. FilenameFilter
4. DataInput
5. DataOutput
6. ObjectInput
7. ObjectOutput
8. Serializable
* Classes
1. Console
2. File
3. InputStream
4. OutputStream
5. FileInputStream
6. FileOutputStream
7. BufferedInputStream
8. BufferedOutputStream
9. DataInputStream
10. DataOutputStream
11. ObjectInputStream
12. ObjectOutputStream
13. PrintStream
14. Reader
15. Writer
16. FileReader
17. FileWriter
18. BufferedReader
19. BufferedWriter
20. InputStreamReader
21. OutputStreamWriter
22. PrintWriter
### Binary File
* e.g .class, .obj, .mp3, .jpg etc.
* If we read binary file then we must use specific program.
* Binary require less processing hence it is faster than text file.
* It doesnt save data in human readable format.
* In java, InputStream, OutputStream and their sub classes are used to manipulate binary file.

### Text File
* e.g .java, .txt, .rtf, .doc, .xml etc.
* We can read text file using any text editor.
* Text file require more processing hence it is slower than binary file
* It can save data in human readable format
* Reader, Writer and their sub classes are used to manipulate text file.
### java.io.File
* It is a java class whose instance represent operating System file, directory or drive.
* Use:
    1. To create empty file / empty directory
    2. To read metadata of OS File, Directory and Drive.

### Socket Programming
http://www.sunbeaminfo.com:8080/Dac/Index.html
Protocol : http  
Host Name : www.sunbeaminfo.com
Port Number : 8080
Path Name : /Dac/Index.html

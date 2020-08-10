What is JNDI ?
 Java Naming and Directory Interface (JNDI) 
J2EE API --- that provides naming and directory functionality to applications written using the Java. It is independent of any specific directory service implementation. 

Thus variety of directories(new, emerging, and already deployed) can be accessed in a common way.

What is its basic use?
JNDI allows distributed applications to look up services in an abstract, resource-independent way.

When it is used?
The most common use case is to set up a database connection pool on a Java EE application/web  server. Any application that's deployed on that server can gain access to the connections they need using the JNDI name java:comp/env/myPool without having to know the details about the connection.

Advantage

Applications don't have to change as they migrate between environments.

Refer to image

Some of the common service providers

Lightweight Directory Access Protocol (LDAP)
Common Object Request Broker Architecture (CORBA) Common Object Services (COS) name service
Java Remote Method Invocation (RMI) Registry

So basically you create objects and register them on the directory services which you can later do lookup and execute operation on.

JNDI Overview

JNDI is an API specified in Java technology that provides naming and directory functionality to applications written in the Java programming language. It is designed especially for the Java platform using Java's object model. Using JNDI, applications based on Java technology can store and retrieve named Java objects of any type. In addition, JNDI provides methods for performing standard directory operations, such as associating attributes with objects and searching for objects using their attributes.

JNDI is also defined independent of any specific naming or directory service implementation. It enables applications to access different, possibly multiple, naming and directory services using a common API. Different naming and directory service providers can be plugged in seamlessly behind this common API. This enables Java technology-based applications to take advantage of information in a variety of existing naming and directory services, such as LDAP, NDS, DNS, and NIS(YP), as well as enabling the applications to coexist with legacy software and systems.


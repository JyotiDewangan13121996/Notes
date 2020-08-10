Config. steps for the pooled connectivity

MUST Copy JDBC drvr jar(mysql connector jar) to tomcat-home/lib
0. stop the srvr.
Ref Doc : <TomCat_Home>\webapps\docs\jndi-datasource-examples-howto.html

1. Open context.xml from <meta-inf> folder
& add Resource tag under Context tag.

<Resource name="jdbc/mysql_pool" auth="Container" type="javax.sql.DataSource"
		initialSize="1" maxActive="2" maxIdle="1" maxWait="-1" username="root"
		password="root" driverClassName="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/test"
		removeAbandoned="true" />


2. Open ur web-appln's web.xml(WebContent\web-inf\web.xml)

copy the Resource - ref. tag in web.xml

eg :
<resource-ref>
 <description>Oracle Datasource example</description>
 <res-ref-name>jdbc/ora_pool</res-ref-name>
 <res-type>javax.sql.DataSource</res-type>
 <res-auth>Container</res-auth>
</resource-ref>

ENSURE : res-ref-name matches with Resource name added in server.xml

Info about resource settings
1. maxActive: Maximum number of database connections in pool. 

2. maxIdle: Maximum number of idle database connections to retain in pool.
        
3. maxWait: Maximum time to wait for a database connection to become available
         in ms, An Exception is thrown if
         this timeout is exceeded.  Set to -1 to wait indefinitely.
         
4. initialSize -- initial size of the pool at start up
5. removeAbondened -- true(def=false) -- if there are any abondened cns --- then they are re-cycled to pool after tmout(def val=300 sec)
Spring Boot demo for RESTful server

Steps
1. File --New --Spring starter project -- add project name , artifact id ,pkg names , keep jar only. 
(pic1)

2. Add dependencies 
web -- web (pic2)
sql -- JPA, MYSQL
Core -- DevTools

2.4 If you are creating Spring based REST server , you don't need to add any more dependencies in pom.xml

3. Add following in application.properties file
#Tomcat server port number
server.port=7070
#context path default value /
server.servlet.context-path=/test_boot
#DB properties
spring.datasource.url=jdbc:mysql://localhost:3306/test
spring.datasource.username=root
spring.datasource.password=root
# JPA properties
spring.jpa.show-sql = true
spring.jpa.hibernate.ddl-auto = update
#logging.level.org.springframework.orm.hibernate5=DEBUG

-------------------------------
2. Spring MVC (with JSP view layer demo) (ref project : demo2) --- spring boot project

Add following  dependencies ONLY for Spring MVC with JSP as View Layer in pom.xml

0. Changed pkging from jar -->war
<packaging>war</packaging>
1.
<!--  added to work with jstl  -->
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-tomcat</artifactId>
</dependency>

2. For JSP working
<dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-jasper</artifactId>
</dependency>

3. JSTL library
<!-- for JSTL  -->
<dependency>
<groupId>javax.servlet</groupId>
<artifactId>jstl</artifactId>
</dependency>

2.5 Copied application.properties entries & added 2 more (for view layer)
# Spring MVC ViewResolver related
spring.mvc.view.prefix=/WEB-INF/views/
spring.mvc.view.suffix=.jsp

2.6 Created this folder structure under src/main (fig :spring-boot-mvc-folders.png)

3. Added DAO i/f & imple class --with @Transaction & @Repo
Autowired EntityMgr
eg : @PersistenceContext
private EntityManager mgr;

4.Added CustomerCRUDController & test it for  list customers with browser 
NOTE : since there isn't any web.xml --no way to specify to WC that index.jsp is welcome page. 
So have to give this url from web browser
http://localhost:7070/test_boot/index.jsp


-------------------------------------
Either write IndexController or below approach
(via java config approach)
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/").setViewName("home");
  }

}
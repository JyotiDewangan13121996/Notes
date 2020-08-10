Why Custom Tags.....
When JSP 2.x std actions or JSTL actions are in-sufficient to solve B.L w/o writing scriptlets --- create your own tags & use them

For separation ---
Supply B.L in custom tags & JSP can invoke the custom tags using WC


Steps for creation of Custom Tags 
1. Identify the Business logic(tag execution logic) & encapsulate the same in TagHandler class.
Custom Tag Handlers can be created using javax.servlet.jsp.tagext.SimpleTag ---i/f 
API gives u the impl. class : SimpleTagSupport . 

As a tag dev : extend from  SimpleTagSupport . 
Must override :
public void doTag() throws IOExc,JSPExc : represents the tag exec. logic.

Current objective : Generate a Hello msg from the custom tag. (1st tag will be w/o attrs & without body)

How to get the JSPWriter inst : connected to clnt browser : from inside the Tag class?
API :  inside : doTag....
getJspContext()  ---> JsPContext (env. of the JSP : impl. objs avlbl to JSP , whichever has invoked this tag)
On JSPContext : to get JSPWriter 
JspWriter getOut() 
& then invoke : out.println(dyn cont.)

2. Describe the tag to W.C : so that W.C can manage the life-cycle of the tag.

Creating : TLD (Tag library descriptor : .tld : xml syntax)
copy the template : ur web-appln's : web-inf\tlds\example.tld
eg :
 <tag>
    <name>welcome</name> : tag suffix 
    <tag-class>cust_tags.MytagHandler</tag-class> : F.Q class name
    <body-content>empty</body-content> : no body supported by the tag + no attrs.
  </tag>



3. Invoking the custom tag from the JSP
3.1  Import the TLD : which contains the description of  custom tags
<%@ taglib uri="URI of the TLD" prefix="tag prefix" %>
3.2 Invoke the tag
eg : <my:hello/>





Life-cycle of the custom Tag 
 Ref to JEE -- apidoc---javax.servlet.jsp.tagext.SimpleTag ---i/f

SimpleTag : i/f ----contains the desc of the life cycle.

1. W.C will invoke tag life cycle -- when JSP invoke tag.(eg : <ex:hello/>
2.WC locates TLD (using taglib directive) 
3. From TLD --- searches for matching tag suffix (under tag name)
4. From tag name -- gets tag class --- locates/loads/instantiates tag class in WC's mem.
5. WC invokes setJspContext(JspContext ctx) --- to pass the entire JSP page env(PageContext obj containing all impl objs) to the tag handler class.(mandatory)
6.WC will invoke the setters for attributes (optional)
7. WC will invoke setJspBody(JspFragment jspf) iff body content is non-empty.(optional)
8.Finally WC invokes --- doTag()
9. Upon returninng from doTag() --- WC GCs T.H class inst.


body-content = empty =>W.C will skip handling of body-content.
body-content = scriptless => WC will invoke setJspBody(JspFragment jspf) to pass tag body content to T.H class.
allowed content types ---- plain text/HTML/std action/custom action
How to retrieve & invoke body content from T.H class?
From doTag ---
1. get JspFragment (API --- getJspBody())
2. To invoke JspFragment ----use API
public abstract void invoke(Writer w)                   throws JspException,IOException
if w=null --- o/p(contents) will be auto. sent to clnt browser.





Objective : Create & test cust tag : to support body + attr
<ex:test count="dyn expr">
 HTML/Plain Text/custom action
</ex:test>
Expected o/p : Body -content should be displayed count no of times.


Expected o/p : Body -content should be upper-cased & then displayed count no of times.


Help for solving Custom Tag assignment --
1. Create QueryTagHandler class ---extends SimpleTagSupport.
2 Create private data members -- same name & type as attributes(eg - 2props -- dept & salary. ---provide setters.

3.Override doTag
--JspFragment jspf=getJspBody();
  StringWriter sw=new StringWriter();
  jspf.invoke(sw);
  String query=sw.getBuffer().toString();
  s.o.p(query);//confirm if u have got till body-content as query.
  //append to the query -- where dept=? and salary=?
 //invoke DAO class --- openCn,invokeQuery(query,dept,sal)
 // DAO rets to cust tag -- AL<EmpPoJO>
  //use for-each from doTag --- & display using out.println(empPojo) to clnt browser.
//dao.closeConnection();
---doTag() rets.




Objective : remove scriptlet : for discarding session from logout.jsp
Invoke JavaBean method from custTag



































































































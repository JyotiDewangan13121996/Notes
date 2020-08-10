<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>Welcome to spring MVC.....</h4>
<h4>Server Date ${requestScope.server_dt}</h4>
<h4>Number List ${requestScope.num_list}</h4>
<h4>Hello , ${requestScope.user_nm}</h4>
<h4>User Age  :  ${requestScope.user_age}</h4>
<h4>Join Date  :  
<fmt:formatDate value="${requestScope.user_dt}" 
pattern="dd-MM-yyyy"/>
</h4>
</body>
</html>
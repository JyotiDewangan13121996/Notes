<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="my-uri" prefix="test"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4 align="center">Hello, ${sessionScope.bankUser.name}</h4>
	<h4 align="center">Will be taken to index page soon....</h4>
	<test:logout />
	<%-- <%
    session.invalidate();
	String path = request.getContextPath() + "/";
	response.setHeader("refresh", "5;URL='" + path + "'");

%> --%>
</body>
</html>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!String message = "hello";//private instance var%>
<body>
	<%
		int data = 1234;//method local var
		pageContext.setAttribute("server_dt", new Date());//page scope attr
	%>
	<%@ include file="test2.jsp"%>
</body>
</html>
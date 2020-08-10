<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<spring:url value='/css/main.css'/>"
	type="text/css" />
</head>
<body>
	<h3 align="center">Testing Images</h3>
	<%-- <img alt="No Image found"
		src="<spring:url value='/upload_images/mvc/model1.jpg'/>"/>
	 --%>	
	 	<img alt="No Image found"
		src="<spring:url value='/upload_images/${requestScope.img_name}'/>">
	 	<a href="<spring:url value='/'/>">Back To Index Page</a>
</body>
</html>
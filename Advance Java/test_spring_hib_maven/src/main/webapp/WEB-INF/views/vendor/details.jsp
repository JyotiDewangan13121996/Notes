<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h4>Adhar Card :
		${requestScope.vendor_dtls.card.adharNumber}</h4>
	<h4>Vehicle Reg Numbers</h4>
	<h5>
		<c:forEach var="v"
			items="${requestScope.vendor_dtls.vehicles}">
			<li>${v.regNo}</li>
		</c:forEach>
	</h5>
	<h4><a href="<spring:url value='/vendor/list'/>">Back To Vendor List</a></h4>
</body>
</html>
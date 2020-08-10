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
	<h3 align="center">Last Action : ${requestScope.mesg}</h3>
	<h3 align="center">All Vendor Details</h3>
	<table style="background-color: cyan; margin: auto;" border="1">

		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>City</th>
			<th>Phone No</th>

		</tr>
		<c:forEach var="vend" items="${requestScope.vendor_list}">
			<tr>
				<td>${vend.name}</td>
				<td>${vend.email}</td>
				<td>${vend.city}</td>
				<td>${vend.phoneNo}</td>
				<td><a href="delete/${vend.id}">Delete</a></td>
				<td><a href="update?id=${vend.id}">Update</a></td>
				<td><a href="details/${vend.id}">Details</a></td>
				<td><a href="<spring:url value='/company/list?id=${vend.id}'/>">Company-Vendor Management</a></td>
			</tr>
		</c:forEach>


	</table>
	<h4><a href="<spring:url value='/vendor/add'/>">Add New Vendor</a></h4>
</body>
</html>
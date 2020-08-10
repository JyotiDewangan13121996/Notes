<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>All Companies : ${requestScope.all_companies}</h3>
	<h3>Vendor Registered With : ${requestScope.vendor_companies}</h3>
	<form method="post" action="<spring:url value='/company/add'/>">
		<table style="background-color: cyan; margin: auto;" border="1">
			<tr>
				<td>Your Vendor ID</td>
				<td><input type="text" name="vendorId" readonly="readonly" value="${param.id}"/></td>
			</tr>
			<tr>
				<td>Enter Company ID</td>
				<td><input name="compId" /></td>
			</tr>


			<tr>
				<td><input type="submit" value="Add Company" /></td>
				<td><input type="submit" value="Remove Company"
					formaction="<spring:url value='/company/remove'/>"></td>
			</tr>
		</table>
	</form>
	<h4><a href="<spring:url value='/vendor/list'/>">Back To Vendor List</a></h4>
</body>
</html>
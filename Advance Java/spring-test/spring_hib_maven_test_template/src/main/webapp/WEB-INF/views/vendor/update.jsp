<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form method="post" modelAttribute="vendor">
		<table style="background-color: cyan; margin: auto;" border="1">
			<tr>
				<td> Vendor ID</td>
				<td><form:input path="id" readonly="true"/></td>
			</tr>
			<tr>
				<td> Vendor Email</td>
				<td><form:input path="email" readonly="true"/></td>
			</tr>
			<tr>
				<td> Vendor Name</td>
				<td><form:input path="name" readonly="true"/></td>
			</tr>
			<tr>
				<td> Vendor City</td>
				<td><form:input path="city" /></td>
			</tr>
			<tr>
				<td> Vendor Phone No</td>
				<td><form:input path="phoneNo" /></td>
			</tr>
			<tr>
				<td> Vendor Reg Amount</td>
				<td><form:input path="regAmount" /></td>
			</tr>
			<tr>
				<td> Vendor Reg Date</td>
				<td><form:input path="regDate" /></td>
			</tr>
			

			<tr>
				<td><input type="submit" value="Update Details" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
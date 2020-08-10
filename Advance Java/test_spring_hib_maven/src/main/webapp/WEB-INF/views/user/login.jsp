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
<h3>${requestScope.mesg}</h3>
	<form:form method="post" modelAttribute="user">
		<table style="background-color: cyan; margin: auto;" border="1">
			<tr>
				<td>Enter User Email</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><form:password path="pass" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
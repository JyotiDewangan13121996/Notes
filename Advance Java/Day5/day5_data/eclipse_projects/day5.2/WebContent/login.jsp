<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="cust" class="beans.CustomerBean" scope="session" />
<jsp:useBean id="book" class="beans.BookBean" scope="session"/>
<body>
<h4 style="color: red;">${sessionScope.cust.message}</h4>
	<form action="validate.jsp">
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>Enter User Email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>


</body>
</html>
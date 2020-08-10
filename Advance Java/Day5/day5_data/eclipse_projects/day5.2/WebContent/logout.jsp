<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Hello , ${sessionScope.cust.details.name}</h4>
	<h5>Logged out successfully...</h5>
	<%--discard Http Session --%>
	${pageContext.session.invalidate()}
	<h5>
		<a href="login.jsp">Visit Again</a>
	</h5>
</body>
</html>
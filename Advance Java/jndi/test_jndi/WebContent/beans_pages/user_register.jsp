<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="bankUser" class="beans.BankBean" scope="session" />
<jsp:setProperty property="*" name="bankUser" />
<body>
	Registration Status : ${sessionScope.bankUser.registerUser()}
	<h4 align="center">
		<c:url var="url" value="logout.jsp" />
		<a href="${url}">Logout</a>
	</h4>
</body>
</html>
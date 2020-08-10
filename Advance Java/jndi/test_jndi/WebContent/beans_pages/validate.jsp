<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="bankUser" class="beans.BankBean" scope="session" />
<jsp:setProperty property="*" name="bankUser" />

<body>
	<jsp:forward page="${sessionScope.bankUser.validateUser()}.jsp" />
</body>
</html>
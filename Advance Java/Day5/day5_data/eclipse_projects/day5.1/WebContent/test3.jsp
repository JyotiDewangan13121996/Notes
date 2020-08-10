<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>From 1st page</h4>
	<%
	    out.flush();
		pageContext.setAttribute("attr1", 1234);
		request.setAttribute("attr2", 3456);
	%>
	<jsp:include page="test4.jsp" />
	<h4>Came back</h4>
</body>
</html>
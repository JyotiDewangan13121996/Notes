<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>${sessionScope.cust.message}</h4>
	<h5>Hello , ${sessionScope.cust.details.name}</h5>
	<%-- <h5>All Categories : ${sessionScope.book.listCategories()}</h5> --%>
	<form action="category_dtls.jsp">
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>Choose a Category</td>
				<td><select name="category">
						<c:forEach var="c" items="${sessionScope.book.listCategories()}">
							<option value="${c}">${c}</option>
						</c:forEach>

				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="Choose"></td>
				<td><input type="submit" value="Show Cart"
					formaction="show_cart.jsp"></td>
			</tr>
		</table>
		<h5>
			<a href="logout.jsp">Log Me Out</a>
		</h5>
	</form>
</body>
</html>
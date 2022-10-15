<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Home JSP - All Employees</h1>
	<table border="1px">
		<tr>
			<th>Eid</th>
			<th>Ename</th>
			<th>Esal</th>
		</tr>
		<c:forEach items="${employees}" var="employee">
			<tr>
				<td><c:out value="${employee.eid}"></c:out></td>
				<td><c:out value="${employee.ename}"></c:out></td>
				<td><c:out value="${employee.esal}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
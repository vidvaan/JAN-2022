<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>All Employees</h1>
	<a href="./addEmp">+ Add Employee</a>
	<table>
		<tr>
			<th>Eid</th>
			<th>Ename</th>
			<th>Esal</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${emps}" var="emp">
			<tr>
				<td><c:out value="${emp.eid}"></c:out></td>
				<td><c:out value="${emp.ename}"></c:out></td>
				<td><c:out value="${emp.esal}"></c:out></td>
				<td><a href="deleteEmp?eid=${emp.eid}">Delete</a></td>
				<td><a href="updateEmp?eid=${emp.eid}">Update</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
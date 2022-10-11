<%@page import="com.createiq.model.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
#emps {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#emps td, #emps th {
	border: 1px solid #ddd;
	padding: 8px;
}

#emps tr:nth-child(even) {
	background-color: #f2f2f2;
}

#emps tr:hover {
	background-color: #ddd;
}

#emps th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #04AA6D;
	color: white;
}
</style>
</head>
<body>
	<h1>Find All Jsp</h1>

	<a href="./addEmployee">New Employee</a>
	<div>
		<br>
	</div>




	<table id="emps">
		<tr>
			<th>Eid</th>
			<th>Ename</th>
			<th>Esal</th>
			<th>Update Here</th>
			<th>Delete Here</th>
		</tr>
		<c:forEach items="${employees}" var="employee">
			<tr>
				<td><c:out value="${employee.eid}"></c:out></td>
				<td><c:out value="${employee.ename}"></c:out></td>
				<td><c:out value="${employee.esal}"></c:out></td>
				<td><a href="./updateEmp?eid=${employee.eid}">Update</a></td>
				<td><a href="./deleteEmp?eid=${employee.eid}">Delete</a></td>
			</tr>
		</c:forEach>

	</table>



</body>
</html>
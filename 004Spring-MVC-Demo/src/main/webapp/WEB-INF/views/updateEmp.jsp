<%@page import="com.createiq.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Update Employee</h1>
	<hr>
	<hr>
	
	<%-- <% Employee employee = (Employee)request.getAttribute("employee"); %> --%>
	
	<form action="./updateEmp" method="post">
		<table>
			<tr>
				<td>Eid</td>
				<td><input type="text" name="eid" readonly="readonly" value="${employee.eid}"></td>

			</tr>
			<tr>
				<td>Ename</td>
				<td><input type="text" name="ename" value="${employee.ename}"></td>
			</tr>
			<tr>
				<td>Esal</td>
				<td><input type="text" name="esal" value="${employee.esal}"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>
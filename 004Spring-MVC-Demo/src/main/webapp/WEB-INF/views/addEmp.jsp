<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add new Employee</h1>
	<hr>
	<hr>
	<form:form action="./addEmployee" method="post" modelAttribute="employee">
		<table>
			<tr>
				<td>Eid</td>
				<td><form:input type="text" name="eid" path="eid"/></td>
				<td><form:errors  path="eid"></form:errors></td>

			</tr>
			<tr>
				<td>Ename</td>
				<td><form:input type="text" name="ename" path="ename"/></td>
				<td><form:errors  path="ename"></form:errors></td>
			</tr>
			<tr>
				<td>Esal</td>
				<td><form:input type="text" name="esal" path="esal"/></td>
				<td><form:errors  path="esal"></form:errors></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
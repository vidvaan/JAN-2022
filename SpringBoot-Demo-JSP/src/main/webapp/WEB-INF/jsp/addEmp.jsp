<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<h1>Home JSP - New Employee</h1>
	<form:form action="" method="post" modelAttribute="employee">
		<table>
			<tr>
				<td>Eid</td>
				<td><form:input path="eid" /></td>
				<td><form:errors path="eid" class="error" /></td>
			</tr>
			<tr>
				<td>Ename</td>
				<td><form:input path="ename" /></td>
				<td><form:errors path="ename" class="error" /></td>
			</tr>
			<tr>
				<td>Esal</td>
				<td><form:input path="esal" /></td>
				<td><form:errors path="esal" class="error" /></td>
			</tr>
			<tr>
				<td>Esal</td>
				<td><input type="submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
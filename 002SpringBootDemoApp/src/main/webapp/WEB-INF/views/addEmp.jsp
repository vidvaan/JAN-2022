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
	<h1>Add Employee</h1>
	<a href="./allEmployees">Get All Employees</a>
	<form action="./saveEmp" method="post">
	<table>
	  <tr>
	      <td>Eid</td>
	      <td><input type="text" name="eid" /></td>
	  </tr>	
	  <tr>
	      <td>Ename</td>
	      <td><input type="text" name="ename"/></td>
	  </tr>	
	  <tr>
	      <td>Esal</td>
	      <td><input type="text" name="esal"/></td>
	  </tr>	
	  <tr>
	      <td><input type="reset"/></td>
	      <td><input type="submit"/></td>
	  </tr>	
	</table>
	</form>
</body>
</html>
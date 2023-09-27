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
	<h1>Update Employee</h1>
	<a href="./allEmployees">Get All Employees</a>
	<form action="./updateEmp" method="post">
	<table>
	  <tr>
	      <td>Eid</td>
	      <td><input type="text" name="eid" readonly="readonly" value="${emp.eid}"/></td>
	  </tr>	
	  <tr>
	      <td>Ename</td>
	      <td><input type="text" name="ename" value="${emp.ename}"/></td>
	  </tr>	
	  <tr>
	      <td>Esal</td>
	      <td><input type="text" name="esal" value="${emp.esal}"/></td>
	  </tr>	
	  <tr>
	      <td><input type="reset"/></td>
	      <td><input type="submit"/></td>
	  </tr>	
	</table>
	</form>
</body>
</html>
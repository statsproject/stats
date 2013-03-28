<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
</head>
<body>
	<c:if test="${not empty teacher}">
		<table>
			<tbody>
				<tr>
					<td>ID:</td>
					<td>${teacher.teacherId}</td>
				</tr>
				<tr>
					<td>First Name:</td>
					<td>${teacher.firstName}</td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td>${teacher.lastName}</td>
				</tr>
				<tr>
					<td>Email:</td>
					<td>${teacher.email}</td>
				</tr>
			</tbody>
		</table>
	</c:if>
	<a href="/stats/teacher/findAll">List all teachers</a>
	<a href="/stats/assignment/find">List all assignments</a>
	<form action="/stats/assignment/findByName" method="GET">
	<select name="name">
		<option value="assn 1 for class 1">assn 1 for class 1</option>
		<option value="assn 1 for class 2">assn 1 for class 2</option>
		<option value="assn 1 for class 3">assn 1 for class 3</option>
		<option value="assn 1 for class 4">assn 1 for class 4</option>
		</select>
		<input type="submit" value="FIND"/>
	</form>
	<form action="/stats/assignment/findByCategoryName" method="GET">
	<select name="name">
		<option name="categorvalue="Derivatives">Derivatives</option>
		<option name="categoryName" value="Integrals">Integrals</option>
		<option name="categoryName" value="Functions">Functions</option>
		<option name="categoryName" value="Graphs">Graphs</option>
		</select>
		<input type="submit" value="FIND"/>
	</form>
	<a href="/stats/teacher/findAll">list all teachers</a>
	<h2>Search teachers by name:</h2>
	<br>
	<form action="/stats/teacher/findAllByName" method="GET">
		<input type="text" value="FirstName" name="firstName" /><br> <input
			type="text" value="LastName" name="lastName" /><br> <input
			type="submit" value="FIND" /><br>
	</form>
	
	<br>
	<h2>Find Student Info:</h2>
	<br>
	<form action="/stats/grade/findAllGradesByName" method="GET">
		<input type="text" value="FirstName" name="firstName" /><br> <input
			type="text" value="LastName" name="lastName" /><br> <input
			type="submit" value="FIND" /><br>
	</form>
	<h2>Find Category Info:</h2>
	<br>
	<form action="/stats/grade/findAllAssignmentsByCategoryName"
		method="GET">
		<input type="text" value="testCategory2" name="categoryName" /><br>
		<input type="submit" value="FIND" /><br>
	</form>
	<h2>Find Class Info:</h2>
	<form action="/stats/class/findAllGradesByClassName" method="GET">
		<input type="text" value="Class 1" name="className" /><br> <input
			type="submit" value="FIND" /><br>
	</form>
</body>
</html>
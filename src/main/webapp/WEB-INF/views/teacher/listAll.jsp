<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
</head>
<body>
<h2>All teachers</h2>1
<c:if test="${not empty teachers}">
		<table>
			<thead>
				<tr>
					<th>Teacher Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Clever ID</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${teachers}" var="teacher">
					<tr>
						<td>${teacher.teacherId}</td>
						<td>${teacher.firstName}</td>
						<td>${teacher.lastName}</td>
						<td>${teacher.email}</td>
						<td>${teacher.cleverTeacherId}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>
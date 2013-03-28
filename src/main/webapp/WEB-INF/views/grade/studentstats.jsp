<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
</head>
<body>
<c:if test="${not empty grades}">
		<table>
			<thead>
				<tr>
					<th>Category</th>
					<th>Assignment</th>
					<th>Grade</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${grades}" var="grade">
					<tr>
						<td>${grade.category}</td>
						<td>${grade.assignment}</td>
						<td>${grade.grade}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>
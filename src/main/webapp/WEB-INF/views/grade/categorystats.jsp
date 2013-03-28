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
					<th>Assignment Name</th>
					<th>Assignment Description</th>
					<th>Average Grade</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${grades}" var="grade">
					<tr>
						<td>${grade.assignmentName}</td>
						<td>${grade.assignmentDescription}</td>
						<td>${grade.avgGrade}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>
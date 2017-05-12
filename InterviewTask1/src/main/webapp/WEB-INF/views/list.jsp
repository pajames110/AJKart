<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<center>

		<c:if test="${!empty employeeList}">
			<table border="1" bgcolor="black" width="600px">
				<tr
					style="background-color: teal; color: white; text-align: center;"
					height="40px">

					<td>First Name</td>
					<td>Last Name</td>
					<td>Email</td>
					<td>Phone</td>
					<td>Interests</td>
					<td>Designation</td>
					<td>Department</td>
					<td>City</td>
					<td>State</td>
					<td>Country</td>

				</tr>
				<c:forEach items="${employeeList}" var="user">
					<tr
						style="background-color: white; color: black; text-align: center;"
						height="30px">

						<td><c:out value="${user.firstName}" /></td>
						<td><c:out value="${user.lastName}" /></td>
						<td><c:out value="${user.email}" /></td>
						<td><c:out value="${user.phone}" /></td>
						<td><c:out value="${user.interests}" /></td>
						<td><c:out value="${user.designation}" /></td>
						<td><c:out value="${user.department}" /></td>
						<td><c:out value="${user.city}" /></td>
						<td><c:out value="${user.state}" /></td>
						<td><c:out value="${user.country}" /></td>

						
					</tr>
				</c:forEach>
			</table>
		</c:if>


		<a href="index">Click Here to add new User</a>
	</center>
</body>
</html>

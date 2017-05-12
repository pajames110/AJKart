<html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<body>
	<c:url var="userRegistration" value="saveUser.html" />
	<form:form id="registerForm" modelAttribute="employee" method="post"
		action="register">
		<table width="400px" height="150px">
		
		<h1>Employee Details</h1>
			<tr>
				<td><form:label path="firstName">First Name</form:label></td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">Last Name</form:label></td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="phone">Phone</form:label></td>
				<td><form:input path="phone" /></td>
			</tr>
			
			<tr>
				<td><form:label path="interests">Interests</form:label></td>
				<td><form:input path="interests" /></td>
			</tr>
			<tr>
				<td><form:label path="designation">Designation</form:label></td>
				<td><form:input path="designation" /></td>
			</tr>
			<tr>
				<td><form:label path="department">Department</form:label></td>
				<td><form:input path="department" /></td>
			</tr>
			<tr>
				<td><form:label path="city">City</form:label></td>
				<td><form:input path="city" /></td>
			</tr>
			<tr>
				<td><form:label path="state">State</form:label></td>
				<td><form:input path="state" /></td>
			</tr>
			
			<tr>
				<td><form:label path="country">Country</form:label></td>
				<td><form:input path="country" /></td>
			</tr>
			
			 <tr>
                    <td>Pick file #1:</td>
                    <td><input type="file" name="fileUpload" size="50" /></td>
                </tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register" /></td>
			</tr>
		</table>
	</form:form>


	
</body>
</html>

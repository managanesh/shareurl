<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
	<div align="center">
		<form:form action="emp" method="post" modelAttribute="employee">
			<table border="0">
				<tr>
					<td colspan="2" align="center" style="border: thick; "><h2>Spring MVC Form Demo -
							Registration</h2></td>
				</tr>
				<tr>
					<td>User Name:</td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password path="state" /></td>
				</tr>
				<tr>
					<td>E-mail:</td>
					<td><form:input path="country" /></td>
				</tr>
				<tr>
					<td>Birthday (dd/mm/yyyy):</td>
					<td><form:input path="birthDate" /></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Register" /></td>
				</tr>
			</table>
		</form:form>
	</div>
	<div align="center" >
		<table align="center" width="100%" border="1" bordercolor="red">
			<tr>
			<td align="center" >Name</td>
			<td align="center" >State</td>
			<td align="center" >Country</td>
			<td align="center" >BirthDate</td>
			</tr>
			<c:forEach var="employee" items="${employeeList}">
				<tr>

					<td align="center" width="100%">${employee.name }</td>
					<td align="center" width="100%">${employee.state}</td>
					<td align="center" width="100%">${employee.country }</td>
					<td align="center" width="100%">${employee.birthDate }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>

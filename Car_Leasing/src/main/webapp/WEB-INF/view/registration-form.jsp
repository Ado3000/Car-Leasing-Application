<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>

</head>

<body>
	<div	id="wrapper">
		<div id="header">
		</div>
	
	</div>

	<div id="container">
	
		<h3>Registration</h3>
		<form:form action="saveUser" modelAttribute="user" method="POST">
		
			<table>
				<tbody>
					<tr>
						<td><label>Birth date:</label></td>
						<td><form:input path="id"/></td>
					</tr> 
					<tr>
						<td><label>Name:</label></td>
						<td><form:input path="name"/></td>
					</tr> 
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email"/></td>
					</tr> 
					<tr>
						<td><label>Address:</label></td>
						<td><form:input path="adress"/></td>
					</tr> 
					<tr>
						<td><label>City:</label></td>
						<td><form:input path="city"/></td>
					</tr> 
					<tr>
						<td><label>Phone Number:</label></td>
						<td><form:input path="phoneNumber"/></td>
					</tr> 
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr> 
				</tbody>
			</table>
		</form:form>
		<div style="clear; both;"></div>
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
		</p>
	</div>
</body>
</html>
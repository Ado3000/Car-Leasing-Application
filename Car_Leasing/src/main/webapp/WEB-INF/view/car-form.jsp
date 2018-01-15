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
		<form:form action="savecar" modelAttribute="car" method="POST">
		
			<table>
				<tbody>
					<tr>
						<td><label>Registration number:</label></td>
						<td><form:input path="regNum"/></td>
					</tr> 
					<tr>
						<td><label>Brand:</label></td>
						<td><form:input path="brand"/></td>
					</tr> 
					<tr>
						<td><label>Model:</label></td>
						<td><form:input path="model"/></td>
					</tr> 
					<tr>
						<td><label>Top Speed:</label></td>
						<td><form:input path="speed"/></td>
					</tr> 
					<tr>
						<td><label>Category:</label></td>
						<td><form:input path="category"/></td>
					</tr> 
					<tr>
						<td><label>Registered:</label></td>
						<td><form:input path="registered"/></td>
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
			<a href="${pageContext.request.contextPath}/listcars">Back to list</a>
		</p>
	</div>
</body>
</html>
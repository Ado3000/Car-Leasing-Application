<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>User List</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<table>
				<tr>
					<th>Birth Date</th>
					<th>Name</th>
					<th>Email</th>
					<th>Adress</th>
					<th>City</th>
					<th>Phonenumber</th>


				</tr>
				<c:forEach var="tempUsers" items="${users}">


					<c:url var="deleteLink" value="/userdelete">
						<c:param name="id" value="${tempUsers.id}"></c:param>
					</c:url>

					<tr>
						<td>${tempUsers.id}</td>
						<td>${tempUsers.name}</td>
						<td>${tempUsers.email}</td>
						<td>${tempUsers.adress}</td>
						<td>${tempUsers.city}</td>
						<td>${tempUsers.phoneNumber}</td>
					
					<td>
					<a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this customer'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>


			</table>


		</div>

	</div>

</body>

</html>
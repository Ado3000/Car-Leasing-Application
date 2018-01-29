<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Car List</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">
			<table>
				<tr>
					<th>Registration</th>
					<th>Brand</th>
					<th>Model</th>
					<th>Top Speed</th>
					<th>Category</th>
					<th>Registered</th>


				</tr>
				<c:forEach var="tempCars" items="${cars}">

					<c:url var="updateLink" value="/updatecar">
						<c:param name="registration" value="${tempCars.regNum}"></c:param>
					</c:url>

					<c:url var="deleteLink" value="/delete">
						<c:param name="registration" value="${tempCars.regNum}"></c:param>
					</c:url>

					<tr>
						<td>${tempCars.regNum}</td>
						<td>${tempCars.brand}</td>
						<td>${tempCars.model}</td>
						<td>${tempCars.speed}</td>
						<td>${tempCars.category}</td>
						<td>${tempCars.registered}</td>
		
					<td><a href="${updateLink}">Update</a> 
					| 
					<a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this car'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>


			</table>


		</div>

	</div>

</body>

</html>
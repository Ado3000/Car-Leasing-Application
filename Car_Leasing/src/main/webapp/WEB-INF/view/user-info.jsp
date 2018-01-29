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
	
		<h3>User info</h3>
		
			
						<label>Birth date:	${user.id}</label>
						<br>
						<label>Name: ${user.name}</label>
						<br>		
						<label>Email:  ${user.email}</label>
						<br>
						<label>Address:  ${user.adress}</label>
						<br>
						<label>City:  ${user.city}</label>
						<br>
						<label>Phone Number:  ${user.phoneNumber}</label>
						
			
					
		
		<div style="clear; both;"></div>
	</div>
</body>
</html>
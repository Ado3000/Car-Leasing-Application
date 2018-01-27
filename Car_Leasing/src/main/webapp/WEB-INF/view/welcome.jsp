<!doctype html>

<html ng-app="AngularSpringApp">

<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
	
	    
	<script src="C:\Users\Ado\Spring\Car_Leasing\src\main\webapp\WEB-INF\rescources\js\angular\angular.js"></script>
	<script src="C:\Users\Ado\Spring\Car_Leasing\src\main\webapp\WEB-INF\rescources\js\angular\angular.min.js"></script>
	<script src="C:\Users\Ado\Spring\Car_Leasing\src\main\webapp\WEB-INF\rescources\js\angular\angular-resource.js"></script>
	<script src="C:\Users\Ado\Spring\Car_Leasing\src\main\webapp\WEB-INF\rescources\js\angular\angular-resource.min.js"></script>
	<script src="C:\Users\Ado\Spring\Car_Leasing\src\main\webapp\WEB-INF\rescources\js\angular\angular-loader.js"></script>
	<script src="C:\Users\Ado\Spring\Car_Leasing\src\main\webapp\WEB-INF\rescources\js\angular\angular-loader.min.js"></script>
	<script src="C:\Users\Ado\Spring\Car_Leasing\src\main\webapp\WEB-INF\rescources\js\angular\angular-route.js"></script>
	<script src="C:\Users\Ado\Spring\Car_Leasing\src\main\webapp\WEB-INF\rescources\js\angular\angular-route.min.js"></script>
	<script src="C:\Users\Ado\Spring\Car_Leasing\src\main\webapp\WEB-INF\rescources\js\app.js"></script>
	<script src="C:\Users\Ado\Spring\Car_Leasing\src\main\webapp\WEB-INF\rescources\js\CarController.js"></script>   

	<style>
.btn-default {
	color: #333;
	background-color: lightgrey;
	border-color: #ccc;
}

.btn {
	display: inline-block;
	padding: 6px 12px;
	margin-bottom: 0;
	font-size: 14px;
	font-weight: 400;
	line-height: 1.42857143;
	text-align: center;
	white-space: nowrap;
	vertical-align: middle;
	-ms-touch-action: manipulation;
	touch-action: manipulation;
	cursor: pointer;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
	background-image: none;
	border: 1px solid transparent;
	border-radius: 4px;
}
}
</style>
</head>
<body>
	<h3>Welcome!</h3>

	<div>
		<a class="btn btn-default" href="cars/listcars">Show Cars</a> 
		<a class="btn btn-default" href="userlist">Show User Info</a>
	</div>
	
    <div ng-view></div>


</body>
</html>

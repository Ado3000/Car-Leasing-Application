<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		

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

<h3 style="margin-left:100px;">Leased list</h3>
<table class="table table-bordered table-striped" style="width:450px; margin-left: 100px;">
    <thead>
        <tr>
            <th style="text-align: center; width: 25px;"></th>
            <th style="text-align: center;">Brand</th>
            <th style="text-align: center;">Model</th>
            <th style="text-align: center;">Top Speed</th>
            <th style="text-align: center;">Category</th>
        </tr>
    </thead>

    
    <tbody>   
            <c:forEach var="tempCars" items="${cars}">
            	
            
            		<c:url var="leaseLink" value="showcars">
						<c:param name="registration" value="${tempCars.regNum}"></c:param>
					</c:url>
		         
					
					
					<tr>
						<td  style="width:70px;text-align:center;"><img src="${tempCars.image_url}" /></td>
						<td>${tempCars.brand}</td>
						<td>${tempCars.model}</td>
						<td>${tempCars.speed}</td>
						<td>${tempCars.category}</td>
						<td><a class="btn btn-default" href="${leaseLink}">Lease</a></td>		
				</c:forEach>            
        </tr>
    </tbody>
</table>

</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<%@include file="navbar.jsp"%>

<!DOCTYPE html> 
<html>
<head>
<c:url value="/resources/images" var="img"/>
<c:url value="/resources/css" var="css"/>
<c:url value="/resources/js" var="js"/>

<title></title>
<link rel="stylesheet" href="${css}/bootstrap.min.css">
<script src="${js}/jquery.min.js"></script>
<script src="${js}/bootstrap.min.js"></script>


<style>
label{
color:red;
}
h2{
color:green;
}
</style>
</head>

<body background="${img}/wall.jpg">

<title>payment</title>
</head>
<body>
<div class="row">
    <div class="col-sm-4">
	</div>
	<div class="col-sm-4">
	<div class="form-group">
	
	<label for="text">paymentid</label>
	<input type="text" path="pid" class="form-control" placeholder="enter your name"/>
	</div>
	</div>
	</div>
	<div class="row">
    <div class="col-sm-4">
    </div>
    <div class="col-sm-4">
	<div class="form-group">
	<label for="text">paymentmethod</label>
	<input type="text" path="pmethod" class="form-control" placeholder="enter your method"/>
	</div>
	</div>
	</div>
	<div class="col-sm-4">
	</div>
	<div class="col-sm-4">
	<div class="form-group">
	
	<label for="text">paymentstatus</label>
	<input type="text" path="pstatus" class="form-control" placeholder="enter your status"/>
	</div>
	</div>
</div>
<br>
	<center><button id="button" class="btn btn-primary" type="submit">submit</button></center>
	</br>
</div>

</body>
</html>
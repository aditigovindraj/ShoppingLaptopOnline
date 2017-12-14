<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@ taglib prefix="c" uri="http://www.springframework.org/tags"%> --%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<%@include file="navbar.jsp" %>
<!doctype html>
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

<center><h2>Product</h2></center>
<c:url value="/addprod" var="prod"/>
<form:form action="${prod}" method="POST" commandName="product" enctype="multipart/form-data">


	
<div class="row">
    <div class="col-sm-4">
	</div>
	<div class="col-sm-4">
	<div class="form-group">
	
	 
	 <label for="text">pid</label>
	 <form:input type="text" path="p_id" class="form-control" placeholder="enter your email id"/>
	</div>
	</div>
	</div>
	<div class="row">
    <div class="col-sm-4">
	</div>
	
    <div class="col-sm-4">
	<div class="form-group">
	<label for="text">pname</label>
	<form:input type="text" path="p_name" class="form-control" placeholder="enter your name"/>
	</div>
	</div>
	</div>
	
	<div class="row">
    <div class="col-sm-4">
	</div>
	
    <div class="col-sm-4">
	<div class="form-group">
	<label for="text">quantity</label>
	<form:input type="text" name="user mail" path="p_quantity" class="form-control"/>
	</div>
	</div>
	</div>
	<div class="row">
    <div class="col-sm-4">
	</div>
	
    <div class="col-sm-4">
	<div class="form-group">
	<label for="text">price</label>
	<form:input type="text" name="user mail" path="p_price" class="form-control"/>
	</div>
	</div>
	</div>
	<div class="row">
    <div class="col-sm-4">
	</div>
	
    <div class="col-sm-4">
	<div class="form-group">
	<label for="text">description</label>
	<form:input type="text" name="user mail" path="p_description" class="form-control"/>
	</div>
	</div>
	</div>
	<div class="row">
    <div class="col-sm-4">
	</div>
	<div class="col-sm-4">
	<div class="form-group">
	<label for="text">p image</label>
	<form:input type="file" name="image" path="pimg" value="upload file"/>
	</div>
	</div>
	</div>
	
	<center><button id="button" class="btn btn-primary" type="submit">submit</button></center>
	
	
</form:form>
<center>
<table style="border: 1px solid black">
	<tr style="background-color: #eee ">
	<th style="border: 1px solid black">$product id</th>
	<th style="border: 1px solid black">$product name</th>
	<th style="border: 1px solid black">$product description</th>
	<th style="border: 1px solid black">$product quantity</th>
	<th style="border: 1px solid black">$product image</th>
	<th colspan="2" style="border: 1px solid black">Edit/Delete</th>
	</tr>
	
	<center><tbody>
	<c1:forEach items="${products}" var="product">
	<tr style="border: 1px solid black">
	<td style="border: 1px solid black">${product.getP_id()}</td>
	<td style="border: 1px solid black">${product.getP_name()}</td>
	<td style="border: 1px solid black">${product.getP_description()}</td>
	<td style="border: 1px solid black">${product.getP_quantity()}</td>
	<td style="border: 1px solid black"><img src="<c:url value="resources/images/${product.getP_id()}.jpg"/>"></td>
	<td style="border: 1px solid black"><a href="<c:url value="/editproduct/${product.getP_id()}"/>" class="btn  btn btn-info">EDIT</a></td>
	<td style="border: 1px solid black"><a href="<c:url value="/deleteproduct/${product.getP_id()}"/>" class="btn btn btn-danger">DELETE</a></td>
	</tr>
	</c1:forEach>
	</table>

	</body>
	</html>

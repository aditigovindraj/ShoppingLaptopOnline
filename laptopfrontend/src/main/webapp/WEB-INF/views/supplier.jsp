<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@ taglib prefix="c" uri="http://www.springframework.org/tags"%> --%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<%@include file="navbar.jsp"%>
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
<body background="${img}/wall.jpg" width="150px">
<center><h2>supplier</h2></center>
<c:url value="/addsup" var="sup"/>
<form:form action="${sup}" method="POST" commandName="supplier">


	
<div class="row">
    <div class="col-sm-4">
	</div>
	<div class="col-sm-4">
	<div class="form-group">
	
	 
	 <label for="text">sid</label>
	 <form:input type="text" path="sid" class="form-control" placeholder="enter your id"/>
	</div>
	</div>
	</div>
	<div class="row">
    <div class="col-sm-4">
	</div>
	
    <div class="col-sm-4">
	<div class="form-group">
	<label for="text">sname</label>
	<form:input type="text" path="sname" class="form-control"  placeholder="enter your email name"/>
	</div>
	</div>
	</div>
	
	<div class="row">
    <div class="col-sm-4">
	</div>
	
    <div class="col-sm-4">
	<div class="form-group">
	<label for="text">address</label>
	<form:input type="text" path="address" class="form-control" placeholder="enter your address"/>
	</div>
	</div>
	</div>
	<div class="row">
    <div class="col-sm-4">
	</div>
	
    <div class="col-sm-4">
	<div class="form-group">
	<label for="text">contact</label>
	<form:input type="text" path="contact" class="form-control" placeholder="enter your number"/>
	</div>
	</div>
	</div>
	<center><button id="button" class="btn btn-primary" type="submit">submit</button></center>
	
	
</form:form>
<center>
<table style="border: 1px solid black">
	<tr style="background-color: #eee ">
	<th style="border: 1px solid black">$supplier id</th>
	<th style="border: 1px solid black">$supplier name</th>
	<th style="border: 1px solid black">$supplier address</th>
	<th style="border: 1px solid black">$supplier contact</th>
	<th colspan="2" style="border: 1px solid black">Edit/Delete</th>
	</tr>
	
	<center><tbody>
	<c1:forEach items="${suppliers}" var="supplier">
	<tr style="border: 1px solid black">
	<td style="border: 1px solid black">${supplier.getSid()}</td>
	<td style="border: 1px solid black">${supplier.getSname()}</td>
	<td style="border: 1px solid black">${supplier.getAddress()}</td>
	<td style="border: 1px solid black">${supplier.getContact()}</td>
	<td style="border: 1px solid black"><a href="<c1:url value="/editsupplier/${supplier.getSid()}"/>" class="btn btn btn-info">EDIT</a></td>
	<td style="border: 1px solid black"><a href="<c1:url value="/deletesupplier/${supplier.getSid()}"/>" class="btn btn btn-danger">DELETE</a></td>
	</tr>
	</c1:forEach>
	</table>

	</body>
	</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

<body background="${img}/wall.jpg">
<center><h2>category</h2></center>
<c:url value="/addcat" var="cat"/>
<form:form action="${cat}" method="POST" commandName="category">

<div class="row">
    <div class="col-sm-4">
	</div>
	<div class="col-sm-4">
	<div class="form-group">
	
	<label for="text">categoryid</label>
	<form:input type="text" path="cid" class="form-control" placeholder="enter your email name"/>
	</div>
	</div>
	</div>
	<div class="row">
    <div class="col-sm-4">
    </div>
    <div class="col-sm-4">
	<div class="form-group">
	<label for="text">cname</label>
	<form:input type="text" path="cname" class="form-control" placeholder="enter your email name"/>
	</div>
	</div>
	</div>
	
	<center><button id="button" class="btn btn-primary" type="submit">submit</button></center>
</div>
	
</form:form>
<center>
<table style="border: 1px solid black">
	<tr style="background-color: #eee ">
	<th style="border: 1px solid black">$category id</th>
	<th style="border: 1px solid black">$category name</th>
	<th colspan="2" style="border: 1px solid black">Edit/Delete</th>
	</tr>
	
	<center><tbody>
	<c1:forEach items="${categories}" var="category">
	<tr style="border: 1px solid black">
	<td style="border: 1px solid black">${category.getCid()}</td>
	<td style="border: 1px solid black">${category.getCname()}</td>
	<td style="border: 1px solid black"><a href="<c1:url value="/editcategory/${category.getCid()}"/>" class="btn btn btn-info">EDIT</a></td>
	<td style="border: 1px solid black"><a href="<c1:url value="/deletecategory/${category.getCid()}"/>" class="btn  btn btn-danger">DELETE</a></td>

	</tr>
	</c1:forEach>
	</table>
	
	</body>
	</html>
	
	
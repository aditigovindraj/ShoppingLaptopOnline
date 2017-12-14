<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>


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
<!-- navbar -->
 <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Laptop</a>
    </div>
      <ul class="nav navbar-nav">
     
	 
	  <li><a href="<c:url value="/laptop"/>"><span class="glyphicon glyphicon-home"></span>Home</a></li>
      <li><a href="<c:url value="/aboutus"/>">about us</a></li>
      <li><a href="<c:url value="/contact"/>">contact</a></li>
      <li><a href="<c:url value="/addrorder"/>">addrorder</a></li>
      <li><a href="<c:url value="/payment"/>">payment</a></li>
      <c1:if test="${pageContext.request.userPrincipal.name==null}">
      <li><a href="<c:url value="/login"/>">log in</a></li>
      <li><a href="<c:url value='/user'/>"><span class="glyphicon glyphicon-user"></span> User </a></li>
      </c1:if>
       <c1:if test="${pageContext.request.userPrincipal.name!=null}">
       welcome ${pageContext.request.userPrincipal.name}
       </c1:if>
	  
      </ul>
      <ul class="nav navbar-nav navbar-right">
      <c1:if test="${pageContext.request.userPrincipal.name!=null}">
      <security:authorize access="hasRole('ROLE_ADMIN')">
      <li><a href="<c:url value='/category'/>"> Category </a></li> 
      <li><a href="<c:url value='/supplier'/>"> Supplier </a></li>
      <li><a href="<c:url value='/product'/>"> Product </a></li>
      </security:authorize>
      </c1:if>
    </ul>
	</div>
</nav>

<center><h2>signup</h2></center>
<c:url value="/adduse" var="use"/>
<form:form action="${use}" method="POST" commandName="user">

	
<div class="row">
    <div class="col-sm-4">
	</div>
	<div class="col-sm-4">
	<div class="form-group">
	
	 
	 <label for="text">userid</label>
	 <form:input type="text" path="uid" class="form-control" placeholder="enter your email id" required="required"/>
	</div>
	</div>
	</div>
	<div class="row">
    <div class="col-sm-4">
	</div>
	
    <div class="col-sm-4">
	<div class="form-group">
	<label for="text">uname</label>
	<form:input type="text" path="uname" class="form-control" placeholder="enter your email name" required="required"/>
	</div>
	</div>
	</div>
	
	<div class="row">
    <div class="col-sm-4">
	</div>
	
    <div class="col-sm-4">
	<div class="form-group">
	<label for="text">address</label>
	<form:input type="text" path="address" class="form-control" placeholder="enter your address" required="required"/>
	</div>
	</div>
	</div>
	<div class="row">
    <div class="col-sm-4">
	</div>
	
    <div class="col-sm-4">
	<div class="form-group">
	<label for="text">mail</label>
	<form:input type="text" path="email" class="form-control" placeholder="enter your mailid"/>
	</div>
	</div>
	</div>
	<div class="row">
    <div class="col-sm-4">
	</div>
	
    <div class="col-sm-4">
	<div class="form-group">
	<label for="text">password</label>
	<form:input type="password" name="user mail" path="password" class="form-control" placeholder="enter your password"/>
	</div>
	</div>
	</div>
	
	<div class="row">
    <div class="col-sm-4">
	</div>
	<div class="col-sm-4">
	<div class="form-group">
	
	 
	 <label for="text">b_id</label>
	 <input type="text" path="user.b_id" class="form-control" placeholder="enter your id"/>
	</div>
	</div>
	</div>
	
	<div class="row">
    <div class="col-sm-4">
	</div>
	<div class="col-sm-4">
	<div class="form-group">
	
	 
	 <label for="text">bno</label>
	 <input type="text" path="user.b_no" class="form-control" placeholder="enter your number" required="required"/>
	</div>
	</div>
	</div>
	
	<div class="row">
    <div class="col-sm-4">
	</div>
	<div class="col-sm-4">
	<div class="form-group">
	
	 
	 <label for="text">bstreet</label>
	 <input type="text" path="b_street" class="form-control" placeholder="enter your street" required="required"/>
	</div>
	</div>
	</div>
	
	<div class="row">
    <div class="col-sm-4">
	</div>
	<div class="col-sm-4">
	<div class="form-group">
	
	 
	 <label for="text">blocality</label>
	 <input type="text" path="b_locality" class="form-control" placeholder="enter your locality" required="required"/>
	</div>
	</div>
	</div>
	
	<div class="row">
    <div class="col-sm-4">
	</div>
	<div class="col-sm-4">
	<div class="form-group">
	
	 
	 <label for="text">bcity</label>
	 <input type="text" path="b_city" class="form-control" placeholder="enter your city" required="required"/>
	</div>
	</div>
	</div>
	
	<div class="row">
    <div class="col-sm-4">
	</div>
	<div class="col-sm-4">
	<div class="form-group">
	
	 
	 <label for="text">bstate</label>
	 <input type="text" path="b_state" class="form-control" placeholder="enter your state" required="required"/>
	</div>
	</div>
	</div>
	
	
	<div class="row">
    <div class="col-sm-4">
	</div>
	<div class="col-sm-4">
	<div class="form-group">
	
	 
	 <label for="text">bpincode</label>
	 <input type="text" path="b_pincode" class="form-control" placeholder="enter your pincode" required="required"/>
	</div>
	</div>
	</div>
	
	<center><button id="button" class="btn btn-primary" type="submit">submit</button></center>
	</div>
	
</form:form>
	</body>
	</html>

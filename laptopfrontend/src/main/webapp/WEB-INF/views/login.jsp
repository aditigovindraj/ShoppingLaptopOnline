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


<title>laptop</title>
<link rel="stylesheet" href="${css}/bootstrap.min.css">
<script src="${js}/jquery.min.js"></script>
<script src="${js}/bootstrap.min.js"></script>
<style>
.carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
  }
body{
background-color:pink;
}

  </style>
</head>
<body>
<body background="${img}/wall.jpg">
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
      <li><a href="<c:url value="/log in"/>">login</a></li>
      <li><a href="<c:url value="/user"/>"><span class="glyphicon glyphicon-user"></span>User</a></li>
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
<div class="container">
<center>
<c:url value='/j_spring_security_check' var="ln"/>
<form action="${ln}" method="post" commandName="user">

<div class="row">
    <div class="col-sm-4">
	</div>
	 <div class="col-sm-4">
	 <img src=14.jpg"  class="img-circle" width="100" height="50">
	</div>
	</div>
	<div class="row">
    <div class="col-sm-4">
	</div>
	
    <div class="col-sm-4">
	<div class="form-group">
	<label for="text">email:</label>
	<input type="text" name="j_username" class="form-control" placeholder="enter your email id" required>
	</div>
	</div>
	</div>
	
	<div class="row">
    <div class="col-sm-4">
	</div>
	
    <div class="col-sm-4">
	<div class="form-group">
	<label for="text">password:</label>
	<input type="text" name="j_password" class="form-control" placeholder="enter your password">
	</div>
	</div>
	</div>
	<center><button id="button" class="btn btn-primary" type="submit">submit</button></center>
	</div>

	</div>
</form>
	</body>
	</html>
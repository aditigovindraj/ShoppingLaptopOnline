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
  <br><br>
  <center></center>

	<div class="row">
	<div class="span12">
    <ul class="breadcrumb">
		<li><a href="index.html">Home</a> <span class="divider">/</span></li>
		<li class="active">Check Out</li>
    </ul>
	<div class="well well-small">
		<h1>Check Out <small class="pull-right"> ${items} Items are in the cart </small></h1>
	<hr class="soften"/>	

	<table class="table table-bordered table-condensed">
              <thead>
                <tr>
                  <th>IMAGE</th>
                  <th>NAME</th>
				  <th>	PRICE </th>
                  <th>Remove/Buy now</th>
                  <th>Total</th>	
				</tr>
              </thead>
              <tbody>
                 <c1:forEach items="${cartItem}" var="pro">
      <tr>
        <td><img src="<c:url value='/resource/images/${pro.getProduct().getP_id()}.jpg'/>",width=50px, height=20px></td>
        <td>${pro.getProduct().getP_name() }</td>
        <td>${pro.getProduct().getP_price()}</td>
<%--         <td>${pro.getProduct().getDes()}</td> --%>
        <td><a href="<c:url value='/Remove/${pro.getCt_id()}'/>" class="btn btn-info"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Remove</a>/<a href="<c1:url value='/Buy/${pro.getProduct().getP_id()}/${pro.getCi_id()}'/>" class="btn btn-danger"><i class="fa fa-trash" aria-hidden="true"></i> Buy now</a>
        </td>
      </tr>
      </c1:forEach>
                </tbody>

  </table>
  <center>Total price=${c_grandtotal}</center>
<center> <a href="<c:url value='/Removeall'/>" class="btn btn-info"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Remove All</a>/<a href="<c1:url value='/Buyall/${pro.getProduct().getP_id()}'/>" class="btn btn-danger"><i class="fa fa-trash" aria-hidden="true"></i> Buy All </a>
  </center></div>
				
</body>
</html>
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="validator.js"></script>
<script src="contact.js"></script>



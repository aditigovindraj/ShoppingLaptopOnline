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
<body background="${img}/download.jpg">
<body>
<div class="container">
<center><h2>ADDRESS ORDER</h2></center>
<form>
<div class="row">
<div class "col-sm-4">
<label for="text">bid</label>
 <input type="text" path="b_id" class="form-control" placeholder="enter your id"/>
 <label for="text">bno</label>
 <input type="text" path="b_no" class="form-control" placeholder="enter your number" required="required"/>
 <label for="text">bstreet</label>
<input type="text" path="b_street" class="form-control" placeholder="enter your street" required="required"/>
<label for="text">blocality</label>
	 <input type="text" path="b_locality" class="form-control" placeholder="enter your locality" required="required"/>
<label for="text">bcity</label>
	 <input type="text" path="b_city" class="form-control" placeholder="enter your city" required="required"/>
<label for="text">bstate</label>
	 <input type="text" path="b_state" class="form-control" placeholder="enter your state" required="required"/>
 <label for="text">bpincode</label>
	 <input type="text" path="b_pincode" class="form-control" placeholder="enter your pincode" required="required"/>
<br>
<center><button id="button" class="btn btn-primary" type="submit">submit</button></center>	
</br>
</div>
<div class "col-sm-4">
</div>
<div class "col-sm-4">
<label for="text">s_id</label>
 <input type="text" path="s_id" class="form-control" placeholder="enter your id"/>
 <label for="text">sno</label>
 <input type="text" path="s_no" class="form-control" placeholder="enter your number" required="required"/>
 <label for="text">street</label>
<input type="text" path="s_street" class="form-control" placeholder="enter your street" required="required"/>
<label for="text">locality</label>
	 <input type="text" path="s_locality" class="form-control" placeholder="enter your locality" required="required"/>
<label for="text">s_city</label>
	 <input type="text" path="s_city" class="form-control" placeholder="enter your city" required="required"/>
<label for="text">state</label>
	 <input type="text" path="s_state" class="form-control" placeholder="enter your state" required="required"/>
 <label for="text">pincode</label>
	 <input type="text" path="s_pincode" class="form-control" placeholder="enter your pincode" required="required"/>
<br>
<center><button id="button" class="btn btn-primary" type="submit">submit</button></center>	
</br>
</div>

</form>
</body>
</html>
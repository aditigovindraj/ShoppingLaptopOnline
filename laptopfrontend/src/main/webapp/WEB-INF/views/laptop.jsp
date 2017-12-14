<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!doctype html>
<html>
<head>
<c:url value="/resources/images" var="images"/>
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
background-color:purple;
}

  </style>
  <body>
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
      <li><a href="<c:url value="/log in"/>">log in</a></li>
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

<!-- carosel -->
 <div class="container">
 <br> -->
   <div id="myCarousel" class="carousel slide" data-ride="carousel"> 
<!--       Indicators  -->
     <ol class="carousel-indicators"> 
       <li data-target="#myCarousel" data-slide-to="0" class="active"></li> 
       <li data-target="#myCarousel" data-slide-to="1"></li> 
       <li data-target="#myCarousel" data-slide-to="2"></li> 
       <li data-target="#myCarousel" data-slide-to="3"></li> 
     </ol> 

<!--      Wrapper for slides  -->
     <div class="carousel-inner" role="listbox">
       <div class="item active"> 
         <img src="${images}/22.jpg" width="260" height="245"> 
       </div> 

       <div class="item"> 
         <img src="${images}/3.jpg" width="260" height="245"> 
       </div> 
    
       <div class="item"> 
         <img src="${images}/13.jpg" width="260" height="245"> 
        
       </div> 

       <div class="item"> 
         <img src="${images}/14.jpg" width="260" height="245"> 
       </div> 
 	  </div> 
	  
  
<!--      Left and right controls  -->
     <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev"> 
       <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> 
       <span class="sr-only">Previous</span> 
     </a> 
     <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next"> 
       <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> 
       <span class="sr-only">Next</span> 
     </a> 
   </div> 
 
 </div> 
<br>
<div class="container">

  <div class="row">
    <div class="col-sm-4">
    <a href="<c:url value="/mac"/>">
	<img src="${images}/20.jpg" class="img-circle" width="300" height="300"/></a>
	</div>
    <div class="col-sm-4">
    <a href="<c:url value="/dell"/>">
	<img src="${images}/22.png" class="img-circle" width="300" height="300"/></a>
	</div>
    <div class="col-sm-4">
    <a href="<c:url value="/hp"/>">
	<img src="${images}/47.png" class="img-circle" width="300" height="300"/></a>
	</div>
  </div>


</body>
</html>


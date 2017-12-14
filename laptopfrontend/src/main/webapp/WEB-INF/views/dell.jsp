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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
  <body background="${images}\download.jpg" width="150px">

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
  
<!-- GRID1 -->  
<div class="container">
    <div class="row">
    <div class="col-sm-3">
	<figure>
    <img src="${images}/8.jpeg"  class="img-rounded" width="200" height="200" >  
     <figcaption><strong></strong><br><center>$10</center></figcaption>
</figure>
	</div>
    <div class="col-sm-3">
	<figure>
     <img src="${images}/24.jpg"  class="img-rounded" width="200" height="200" >
	  <figcaption><strong></strong><br><center>$11</center></figcaption>
</figure>
	 </div>
	 <div class="col-sm-3">
	 <figure>
     <img src="${images}/25.jpg"  class="img-rounded" width="200" height="200" >
	  <figcaption><strong>valentine cake special</strong><br><center>$11.5</center></figcaption>
</figure>
	 </div>
	 <div class="col-sm-3">
	 <figure>
    <img src="${images}/26.jpg"  class="img-rounded" width="200" height="200" >  
     <figcaption><strong>simple pink cake</strong><br><center>$9</center></figcaption>
</figure>
	</div>
  </div>
</div>
<br>
<br>
<br>
<br>
<br>

<!-- GRID2 -->  
<div class="container">
    <div class="row">
    <div class="col-sm-3">
    <img src="${images}/27.jpg"  class="img-rounded" width="200" height="200" >  
        <figcaption><strong>royal cake</strong><br><center>$9</center></figcaption>
</figure>
  
  </div>
    <div class="col-sm-3">
     <img src="${images}/28.jpg"  class="img-rounded" width="200" height="200" >
	      <figcaption><strong>fruits fanda</strong><br><center>$11</center></figcaption>
</figure>

	 </div>
	 <div class="col-sm-3">
     <img src="${images}/29.jpg"  class="img-rounded" width="200" height="200" >
     <figcaption><strong>choco valentine</strong><br><center>$8</center></figcaption>
</figure>
	
	</div>
	 <div class="col-sm-3">
    <img src="${images}/30.jpg"  class="img-rounded" width="200" height="200" >  
     <figcaption><strong>pink birthdy cake for girl</strong><br><center>$8.5</center></figcaption>
</figure>

    </div>
  </div>
</div>
<br>
<br>
<br>
<br>
<br>


<!-- grid3 -->
<div class="container">
    <div class="row">
    <div class="col-sm-3">
    <img src="${images}/32.jpg"  class="img-rounded" width="200" height="200" >  
   <figcaption><strong>royal pinky cake</strong><br><center>$13</center></figcaption>
</figure>
</div>
    <div class="col-sm-3">
     <img src="${images}/33.jpg"  class="img-rounded" width="200" height="200" >
     <figcaption><strong>chococherry down</strong><br><center>$12.5</center></figcaption>
</figure>

	 </div>
	 <div class="col-sm-3">
     <img src="${images}/4.png"  class="img-rounded" width="200" height="200" >
     <figcaption><strong>rose birthdy cake</strong><br><center>$10.3</center></figcaption>
</figure>

	 </div>
	 <div class="col-sm-3">
    <img src="${images}/3.jpg"  class="img-rounded" width="200" height="200" >  
     <figcaption><strong>forever chocolate cake</strong><br><center>$12</center></figcaption>
</figure>

    </div>
  </div>
</div>
<br>
<br>
<br>
<br>
<br>


<!--grid4 -->
<div class="container">
    <div class="row">
    <div class="col-sm-3">
    <img src="${images}/new1.jpg" class="img-rounded" width="200" height="200" >  
    <figcaption><strong>bit byte</strong><br><center>$16.6</center></figcaption>
</figure>
    </div>
    <div class="col-sm-3">
     <img src="${images}/new2.jpg" class="img-rounded" width="200" height="200" >
	  <figcaption><strong>fruit bowl cake</strong><br><center>$13</center></figcaption>
</figure>
	 </div>
	 <div class="col-sm-3">
     <img src="${images}/new3.jpg" class="img-rounded" width="200" height="200" >
	  <figcaption><strong>chococookie cake</strong><br><center>$10.6</center></figcaption>
</figure>
	 </div>
	 <div class="col-sm-3">
    <img src="${images}/23.jpg"  class="img-rounded" width="200" height="200" >  
     <figcaption><strong>black forest</strong><br><center>$14</center></figcaption>
</figure>
	</div>
  </div>
</div>
<br>
<br>
<br>
<br>
<br>



<!-- cards -->
<CENTER>
<h2>WE ACCEPT</H2>
<i class="fa fa-cc-mastercard" style="font-size:48px;color:blue"></i>
<i class="fa fa-cc-visa" style="font-size:48px;color:blue"></i>
<i class="fa fa-credit-card" style="font-size:48px;color:blue"></i>
<br>
<h2>WE ALSO ACCEPT CASH-ON-DELIVERY</H2>

</CENTER>
<br>
<br>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
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
      <c1:if test="${pageContext.request.userPrincipal.name!=null}">
      <li><a href="<c:url value="/log in"/>">log in</a></li>
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
</body>
</html>
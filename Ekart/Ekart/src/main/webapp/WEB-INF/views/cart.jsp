
<!DOCTYPE html>
<html lang="en">


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<head>

<meta charset="utf-8">
<meta name="robots" content="all,follow">
<meta name="googlebot" content="index,follow,snippet,archive">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Obaju e-commerce template">
<meta name="author" content="Ondrej Svestka | ondrejsvestka.cz">
<meta name="keywords" content="">



<title>AjKart : e-commerce musical instruments</title>

<meta name="keywords" content="">

<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,500,700,300,100'
	rel='stylesheet' type='text/css'>

<!-- styles -->
<link href="<c:url value="resources/css/font-awesome.css"/>"
	rel="stylesheet">
<link href="<c:url value="resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
<link href="<c:url value="resources/css/animate.min.css"/>"
	rel="stylesheet">
<link href="<c:url value="resources/css/owl.carousel.css"/>"
	rel="stylesheet">
<link href="<c:url value="resources/css/owl.theme.css"/>"
	rel="stylesheet">


<!-- theme stylesheet -->
<link href="<c:url value="resources/css/style.default.css"/>"
	rel="stylesheet" id="theme-stylesheet">

<!-- your stylesheet with modifications -->
<link href="<c:url value="resources/css/custom.css"/>" rel="stylesheet">

<script src="js/respond.min.js"></script>

<link rel="shortcut icon" href="favicon.png">



</head>

<body>
	<!-- *** TOPBAR ***
<%@include file="/WEB-INF/views/header.jsp"%>
    
    <!-- *** NAVBAR END *** -->

	<!-- /.container -->
<div class="span9 margin-left10">

<c:set var="grandTotal" scope="session" value="${0}"/>
<h4>${successMsg}</h4>

	<div class="row margin-left25">
	<c:if test="${!empty cartList}">
		<table class="table table-bordered table-striped fs13">
			<thead>
				<tr>
					<th>Image</th>
					<th class="width110">Product</th>
					<th>Unit Price</th>
					<th>Quantity</th>
					<th>Price(in Rs.)</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${cartList}" var="cartItem">
				<tr>
					<td class="span1"><img
						src="<c:url value='/resources/img/img/productImages/${cartItem.product.id}.png'/>"
						alt="image" width="140" height="140" /></td>
					<td>${cartItem.product.id}</td>
					<td>${cartItem.product.name}</td>
					<td>${cartItem.product.price}</td>
					<td>${cartItem.quantity}</td>
					<td>${cartItem.totalPrice}</td>					
					<td><a href="<c:url value="/usercart/cart/removeItem/${cartItem.product.id}/${cartId}"/>" class="btn btn-danger btnAction">
					 <span class="glyphicon glyphicon-remove"></span>remove
					</a></td>
					<c:set var="grandTotal" value="${cartItem.quantity+cartItem.product.price+grandTotal}"/> 
					
				</tr>
				</c:forEach>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td>Grand Total(in Rs.)</td>
					<td><c:out value="${grandTotal}"/></td>
					<td>
				</tr>
			</tbody>
		</table>
		</c:if>



		<div class="row">
			<div class="span3">
				<a href="<spring:url value="/" />" class="btn btn-primary center">Continue
					Shopping</a>
			</div>
			<div class="span3">
				<a href="<spring:url value="/shippingPage"/>"
					class="btn btn-success center"><span
					class="glyphicon-shopping-cart glyphicon"></span> Check out </a>
			</div>
			<div class="span2">
				<a href="<c:url value='/usercart/cart/clearCartItems/${cartId}'/>" class="btn btn-danger center" ><span
					class="glyphicon glyphicon-remove-sign"></span>Clear Cart</a>
			</div>
		</div>
	</div>
</div>






	<!-- *** COPYRIGHT ***
 _________________________________________________________ -->
	<div id="copyright">
		<div class="container">
			<div class="col-md-6">
				<p class="pull-left">© 2015 Your name goes here.</p>

			</div>
			<div class="col-md-6">
				<p class="pull-right">
					Template by <a href="http://bootstrapious.com/e-commerce-templates">Bootstrapious</a>
					with support from <a href="https://kakusei.cz">Kakusei</a>
					<!-- Not removing these links is part of the licence conditions of the template. Thanks for understanding :) -->
				</p>
			</div>
		</div>
	</div>
	<!-- *** COPYRIGHT END *** -->



	<!-- /#all -->

	<!-- *** FOOTER ***--!>

	<%@include file="/WEB-INF/views/footer.jsp"%>

    

    <!-- *** SCRIPTS TO INCLUDE ***
 _________________________________________________________ -->
	<script src="js/jquery-1.11.0.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.cookie.js"></script>
	<script src="js/waypoints.min.js"></script>
	<script src="js/modernizr.js"></script>
	<script src="js/bootstrap-hover-dropdown.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/front.js"></script>



</body>

</html>

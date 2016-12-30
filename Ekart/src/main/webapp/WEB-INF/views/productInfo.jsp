
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
<div id="all">
		<div id="heading-breadcrumbs">
			<div class="container">
				<div class="row">
					<div class="col-md-7">
						<h1>Product details</h1>
					</div>
					<div class="col-md-5">
						<ul class="breadcrumb">
							<li><a href="<c:url value="/"/>">Home</a></li>
							<li>${selectedProduct.name}</li>
						</ul>

					</div>
				</div>
			</div>
		</div>
		<c:if test="${!empty selectedProduct.name}">
			<section class="bar background-gray no-mb padding-big text-center-sm">

				<div class="container">
					<div class="row">
						<div class="col-md-4">
							<h2 class="text-uppercase">Product details</h2>
							<p>
								<br>${selectedProduct.id} <br>${selectedProduct.name}
								<br>${selectedProduct.description} <br>Rs.${selectedProduct.price}
								<br>${selectedProduct.category.category_name} <br>${selectedProduct.supplier.name}

								<c:if
									test="${pageContext.request.userPrincipal.name != 'Admin'}">
									<p>
										<%-- <a href="<c:url value="${url}" />" class="btn btn-primary">Back</a> --%>
										<c:if
											test="${pageContext.request.userPrincipal.name  != 'Admin'}">
											<a href="<c:url value="/usercart/cart/addItem/${selectedProduct.id}"/>" class="btn btn-primary"><span
												class="glyphicon glyphicon-shopping-cart"></span>Add to cart
											</a>

											<a href="<spring:url value="/user/cart"/>"
												class="btn btn-primary"><span
												class="glyphicon glyphicon-hand-right"></span>View Cart</a>
										</c:if>
									</p>
								</c:if>
								<c:if test="${pageContext.request.userPrincipal.name == 'Admin'}">
								<p>
										<a href="<c:url value="/product/edit/${selectedProduct.id}"/>" 
										class="btn btn-primary">Edit product
											</a>
											</p>			
								</c:if>
								<br>
								<br>
							
								<br>
							</p>
						</div>
						<div class="col-md-8 text-center">
							<img alt=""
								src="<c:url value="/resources/img/img/productImages/${selectedProduct.id}.jpeg"/>" />
						</div>
					</div>
				</div>
			</section>
		</c:if>

	
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

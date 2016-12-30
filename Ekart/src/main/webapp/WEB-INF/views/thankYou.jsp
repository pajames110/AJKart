
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
						<h1>Thank you</h1>
					</div>
					<div class="col-md-5">
						<ul class="breadcrumb">
						<li><a href="<c:url value="/"/>">Home</a></li>
						<li><a href="<c:url value="/user/cart"/>">My Cart</a></li>
						<li><a href="<c:url value="/shippingPage"/>">Shipping Details</a></li>
						<li>Thank you</li>
							
						</ul>

					</div>
				</div>
			</div>
		</div>
	<section>
	
	
	
	
	  <div id="content">
	<div class="container">
				<h3 align="center" style="color: #79be25;">Thank you, your order will be delivered in 2-3 weekdays</h3>
				<br><br>
               <a href="<c:url value="/"/>" class="btn btn-primary center">Continue Shopping</a><br><br>
				<a href="<c:url value="/j_spring_security_logout"/>" class="btn btn-danger btnAction">Log out</a>
	</div> <!-- /.container-->
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

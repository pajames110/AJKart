<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<link href="<c:url value="/resources/css/font-awesome.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/css/animate.min.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/css/owl.carousel.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/css/owl.theme.css"/>"
	rel="stylesheet">

<!-- theme stylesheet -->
<link href="resources/css/style.default.css" rel="stylesheet"
	id="theme-stylesheet">

<!-- your stylesheet with modifications -->
<link href="resources/css/custom.css" rel="stylesheet">

<script src="resources/js/respond.min.js"></script>

<link rel="shortcut icon" href="favicon.png">



</head>

<body>

	<!-- *** TOPBAR ***
 _________________________________________________________ -->
	<div id="top">
		<div class="container">
			<div class="col-md-6 offer" data-animate="fadeInDown">
			<c:choose>
							<c:when test="${pageContext.request.userPrincipal.name != null}">							
							
								<a>Hello, ${pageContext.request.userPrincipal.name}</a>
								<a href="<c:url value="/j_spring_security_logout"/>">
								<i class="fa fa-sign-out"></i>Sign Out</a>
							</c:when>						
			</c:choose>
				<a href="#" class="btn btn-success btn-sm"
					data-animate-hover="shake">Offer of the day</a> <a href="#">Get
					flat 35% off on orders over $50!</a>
			</div>
			<div class="col-md-6" data-animate="fadeInDown">

				<c:choose>
					<c:when test="${pageContext.request.userPrincipal.name != null}">
						<c:if test="${pageContext.request.userPrincipal.name == 'Admin'}">

							<li><a href="<c:url value="/categories"/>">Category</a></li>
							<li><a href="<c:url value="/suppliers"/>">Supplier</a></li>
							<li><a href="<c:url value="/product"/>">Product</a></li>
							
						</c:if>

						<c:if test="${pageContext.request.userPrincipal.name != 'Admin'}">

							<li><a href="<c:url value="/user/cart"/>">Cart</a></li>
							
						</c:if>
					</c:when>

					<c:otherwise>

						<li><a href="<c:url value="/register"/>">Register</a></li>
						<li><a href="<c:url value="/registrationsuccess"/>">Login</a></li>

					</c:otherwise>
				</c:choose>
				

			</div>
		</div>
		<div class="modal fade" id="login-modal" tabindex="-1" role="dialog"
			aria-labelledby="Login" aria-hidden="true">
			<div class="modal-dialog modal-sm">

				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="Login">Customer login</h4>
					</div>
					<div class="modal-body">
						<form action="customer-orders.html" method="post">
							<div class="form-group">
								<input type="text" class="form-control" id="email-modal"
									placeholder="email">
							</div>
							<div class="form-group">
								<input type="password" class="form-control" id="password-modal"
									placeholder="password">
							</div>

							<p class="text-center">
								<button class="btn btn-primary">
									<i class="fa fa-sign-in"></i> Log in
								</button>
							</p>

						</form>

						<p class="text-center text-muted">Not registered yet?</p>
						<p class="text-center text-muted">
							<a href="register"><strong>Register now</strong></a>! It is easy
							and done in 1&nbsp;minute and gives you access to special
							discounts and much more!
						</p>

					</div>
				</div>
			</div>
		</div>

	</div>

	<!-- *** TOP BAR END *** -->

	<!-- *** NAVBAR ***
 _________________________________________________________ -->

	<div class="navbar navbar-default yamm" role="navigation" id="navbar">
		<div class="container">
			<div class="navbar-header">

				<a class="navbar-brand home" href="index"
					data-animate-hover="bounce"> <img
					src="<c:url value="/resources/img/logo.gif"/>" alt="Obaju logo"
					class="hidden-xs"> <img
					src="<c:url value="/resources/img/logo-small.png"/>"
					alt="Obaju logo" class="visible-xs"><span class="sr-only">Obaju
						- go to homepage</span>
				</a>
				<div class="navbar-buttons">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#navigation">
						<span class="sr-only">Toggle navigation</span> <i
							class="fa fa-align-justify"></i>
					</button>
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#search">
						<span class="sr-only">Toggle search</span> <i class="fa fa-search"></i>
					</button>
					<a class="btn btn-default navbar-toggle" href="basket.html"> <i
						class="fa fa-shopping-cart"></i> <span class="hidden-xs">3
							items in cart</span>
					</a>
				</div>
			</div>
			<!--/.navbar-header -->

			<div class="navbar-collapse collapse" id="navigation">

				<ul class="nav navbar-nav navbar-left">
					<li class="active"><a href="index">Home</a></li>
					<li class="dropdown yamm-fw"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"
						data-hover="dropdown" data-delay="200">Instruments <b
							class="caret"></b></a>
						<ul class="dropdown-menu">
							<li>
								<div class="yamm-content">
									<div class="row">
										<div class="col-sm-3">
											<h5>Instruments</h5>
											<ul>
												<li><a href="category.html">Guitars</a></li>
												<li><a href="category.html">Violins</a></li>
												<li><a href="category.html">Harp</a></li>
												<li><a href="category.html">Xylophone</a></li>
											</ul>
										</div>
										<div class="col-sm-3">
											<h5>Guitar Accessories</h5>
											<ul>
												<li><a href="category.html">Tuners</a></li>
												<li><a href="category.html">Guitar Bags</a></li>
												<li><a href="category.html">Guitar Strings</a></li>
												<li><a href="category.html">Guitar Capo</a></li>
											</ul>
										</div>
										<div class="col-sm-3">
											<h5>Violin Accessories</h5>
											<ul>
												<li><a href="category.html">Violin Bridge</a></li>
												<li><a href="category.html">Violin cases</a></li>
												<li><a href="category.html">Violin Stands</a></li>
												<li><a href="category.html">Violin Strings</a></li>
												<li><a href="category.html">Violin Rosin</a></li>

											</ul>
										</div>

									</div>
								</div> <!-- /.yamm-content -->
							</li>
						</ul></li>



					<li class="dropdown yamm-fw"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"
						data-hover="dropdown" data-delay="200">Template <b
							class="caret"></b></a>
						<ul class="dropdown-menu">
							<li>
								<div class="yamm-content">
									<div class="row">
										<div class="col-sm-3">
											<h5>Shop</h5>
											<ul>
												<li><a href="index">Homepage</a></li>
												<li><a href="category.html">Category - sidebar left</a>
												</li>
												<li><a href="category-right.html">Category -
														sidebar right</a></li>
												<li><a href="category-full.html">Category - full
														width</a></li>
												<li><a href="detail.html">Product detail</a></li>
											</ul>
										</div>
										<div class="col-sm-3">
											<h5>User</h5>
											<ul>
												<li><a href="register">Register / login</a></li>
												<li><a href="customer-orders.html">Orders history</a></li>
												<li><a href="customer-order.html">Order history
														detail</a></li>
												<li><a href="customer-wishlist.html">Wishlist</a></li>
												<li><a href="customer-account.html">Customer
														account / change password</a></li>
											</ul>
										</div>
										<div class="col-sm-3">
											<h5>Order process</h5>
											<ul>
												<li><a href="basket.html">Shopping cart</a></li>
												<li><a href="checkout1.html">Checkout - step 1</a></li>
												<li><a href="checkout2.html">Checkout - step 2</a></li>
												<li><a href="checkout3.html">Checkout - step 3</a></li>
												<li><a href="checkout4.html">Checkout - step 4</a></li>
											</ul>
										</div>
										<div class="col-sm-3">
											<h5>Pages and blog</h5>
											<ul>
												<li><a href="blog.html">Blog listing</a></li>
												<li><a href="post.html">Blog Post</a></li>
												<li><a href="faq.html">FAQ</a></li>
												<li><a href="text.html">Text page</a></li>
												<li><a href="text-right.html">Text page - right
														sidebar</a></li>
												<li><a href="404.html">404 page</a></li>
												<li><a href="contact.html">Contact</a></li>
											</ul>
										</div>
									</div>
								</div> <!-- /.yamm-content -->
							</li>
						</ul></li>
				</ul>

			</div>
			<!--/.nav-collapse -->

			<div class="navbar-buttons">

				<div class="navbar-collapse collapse right" id="basket-overview">
					<a href="basket.html" class="btn btn-primary navbar-btn"><i
						class="fa fa-shopping-cart"></i><span class="hidden-sm">3
							items in cart</span></a>
				</div>
				<!--/.nav-collapse -->

				<div class="navbar-collapse collapse right" id="search-not-mobile">
					<button type="button" class="btn navbar-btn btn-primary"
						data-toggle="collapse" data-target="#search">
						<span class="sr-only">Toggle search</span> <i class="fa fa-search"></i>
					</button>
				</div>

			</div>

			<div class="collapse clearfix" id="search">

				<form class="navbar-form" role="search">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search">
						<span class="input-group-btn">

							<button type="submit" class="btn btn-primary">
								<i class="fa fa-search"></i>
							</button>

						</span>
					</div>
				</form>

			</div>
			<!--/.nav-collapse -->

		</div>
		<!-- /.container -->
	</div>
	<!-- /#navbar -->
<body>

</body>
</html>
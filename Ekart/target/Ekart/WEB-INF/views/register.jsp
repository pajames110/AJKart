
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
 _________________________________________________________ -->

<%@include file="/WEB-INF/views/header.jsp"%>


	<!-- *** TOP BAR END *** -->

	<!-- *** NAVBAR ***
 _________________________________________________________ -->

	

	<div id="all">

		<div id="content">
			<div class="container">

				<div class="col-md-12">

					<ul class="breadcrumb">
						<li><a href="#">Home</a></li>
						<li>New account / Sign in</li>
					</ul>

				</div>

				<div class="col-md-6">
					<div class="box">
						<h1>New account</h1>

						<p class="lead">Not our registered customer yet?</p>
						<p>With registration with us new world of music, fantastic
							experience and much more opens to you! The whole process will not
							take you more than a minute!</p>
						<p class="text-muted">
							If you have any questions, please feel free to <a
								href="contact.html">contact us</a>, our customer service center
							is working for you 24/7.
						</p>

						<hr>
						<div class="error" style="color: #ff0000;">${usernameError}${emailError}${userPhoneError }</div>
						<c:if test="${not empty message}">
							<div class="error" style="color: #ff0000;">${message}${usernameError}</div>
						</c:if>

						<form:form action="register" method="post"
							commandName="userdetails">
							<div class="form-group">
								<label for="name">Enter Full Name</label>
								<form:input path="userFullName" type="text" class="form-control"></form:input>
								<form:errors path="userFullName" cssStyle="color: #ff0000" />
							</div>
							<div class="form-group">
								<label for="name">Name</label>
								<form:input path="username" type="text" class="form-control"></form:input>
								<form:errors path="username" cssStyle="color: #ff0000" />
							</div>
							<div class="form-group">
								<label for="email">Email</label>
								<form:input path="userEmail" type="text" class="form-control"></form:input>
								<form:errors path="userEmail" cssStyle="color: #ff0000" />
							</div>
							<div class="form-group">
								<label for="password">Password</label>
								<form:input path="password" type="password" class="form-control"></form:input>
								<form:errors path="password" cssStyle="color: #ff0000" />
							</div>

							<div class="form-group">
								<label for="mobile">Mobile Number</label>
								<form:input path="userPhone" type="text"
									class="form-control"></form:input>
								<form:errors path="userPhone" cssStyle="color: #ff0000" />
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-primary">
									<i class="fa fa-user-md"></i> Register
								</button>
							</div>
						</form:form>
					</div>
				</div>

				<div class="col-md-6">
					<div class="box">
						<h1>Login</h1>

						<p class="lead">Already our customer?</p>
						<p class="text-muted">Log-in and welcome to the world of
							Music.</p>

						<hr>

						 <form name="login"
							action="<c:url value='/j_spring_security_check' />" method="post">
							
							
							<c:if test="${not empty error}">
								<div class="error" style="color: #ff0000;">${error}</div>
							</c:if>
							
							<div class="span9 center">
								<c:if test="${not empty msg}">
									<div class="msg">${msg} </div>
								</c:if>
							</div>
							
                            <div class="form-group">
                                <label for="username">User Name</label>
								<input  type="text" id="username" name="username" class="form-control"></input>
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
								<input  type="password" id="password" name="password" class="form-control"></input>
                            </div>
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary"><i class="fa fa-sign-in"></i> Log in</button>
                            </div>
                          
                           <input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" /> 
                        </form>
					</div>
				</div>


			</div>
			<!-- /.container -->
		</div>
		<!-- /#content -->


		<!-- *** COPYRIGHT ***
 _________________________________________________________ -->
		<div id="copyright">
			<div class="container">
				<div class="col-md-6">
					<p class="pull-left">© 2015 Your name goes here.</p>

				</div>
				<div class="col-md-6">
					<p class="pull-right">
						Template by <a
							href="http://bootstrapious.com/e-commerce-templates">Bootstrapious</a>
						with support from <a href="https://kakusei.cz">Kakusei</a>
						<!-- Not removing these links is part of the licence conditions of the template. Thanks for understanding :) -->
					</p>
				</div>
			</div>
		</div>
		<!-- *** COPYRIGHT END *** -->

	<!-- *** FOOTER ***
 <%@include file="/WEB-INF/views/footer.jsp"%>

	<!-- *** FOOTER END *** -->
	

	</div>
	<!-- /#all -->




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


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
	
			<section>
					<h2 class="text-uppercase">Category</h2>


					<hr>

					<!-- LOOK HERE -->

					<h3>Add a Category</h3>

					<c:url var="addAction" value="/category/add"></c:url>

					<form:form action="${addAction}" commandName="category">


						<div class="form-group">
							<c:choose>
								<c:when test="${!empty category.category_id}">

									<div class="form-group">
										<label for="name">ID</label>
										<div class="controls docs-input-sizes">
											<form:input  path="category_id" required="true"
												class="form-control" id="id" disabled="true" readonly="true" />
										</div>
									</div>

								</c:when>

								<c:otherwise>

									<div class="form-group">
										<form:input path="category_id" hidden="true" />
										<label for="id">ID</label>
										<div class="controls docs-input-sizes">
											<form:input  path="category_id" required="true"
												class="form-control" id="id"
												title="id should contains 6 to 7 characters"
												patttern=".{6,7}" />
										</div>
									</div>

								</c:otherwise>
							</c:choose>

						</div>

						<div class="form-group">
							<form:input path="category_id" hidden="true" />
							<label for="name">Name</label>
							<div class="controls docs-input-sizes">
								<form:input  path="category_name" required="true"
									class="form-control" id="name" />
							</div>
						</div>

						<div class="form-group">
							<label for="description">Description</label>
							<div class="controls docs-input-sizes">
								<form:input placeholder="description" path="description"
									class="form-control" id="description" />
							</div>
						</div>



						<div class="form-group">
							<div class="controls docs-input-sizes">
								<c:if test="${!empty category.category_name}">

									<button type="submit" class="btn btn-template-main pull-left">
										<i class="fa fa-user-md"></i> Edit Category
									</button>
								</c:if>
								<c:if test="${empty category.category_name}">

									<button type="submit" class="btn btn-template-main pull-left">
										<i class="fa fa-user-md"></i> Add Category
									</button>
								</c:if>
							</div>
						</div>
					</form:form>
				
<br><br>

			
					<div class="all">
						<c:if test="${!empty categoryList}">
							<h3>Category List</h3>
							<table class="tg table-hover">
								<tr>
									<th width="80">Category ID</th>
									<th width="120">Category Name</th>
									<th width="120">Category description</th>
									<th width="60">Edit</th>
									<th width="60">Delete</th>
								</tr>
								<c:forEach items="${categoryList}" var="category">
									<tr>
										<td>${category.category_id}</td>
										<td>${category.category_name}</td>
										<td>${category.description}</td>
										<td><a
											href="<c:url value='category/edit/${category.category_id}' />">Edit</a></td>
										<td><a
											href="<c:url value='category/remove/${category.category_id}' />">Delete</a></td>
									</tr>
								</c:forEach>
							</table>
						</c:if>
						<br> <br> <br>
			</div>
			</section>
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

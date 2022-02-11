<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.88.1">
<title>view product</title>

<link href="<c:url value="/resources/fontAwesome/css/all.css"/>" rel="stylesheet">
<link rel="canonical" href="https://getbootstrap.com/docs/4.6/examples/carousel/">

<!-- Bootstrap core CSS 서버로부터 URL을 가져오는 것이 좋다. -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
	
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
<script src="<c:url value="/resources/js/controller.js" /> "></script>

<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/carousel.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
</head>
<body>

		<header>
		<nav class="navbar navbar-expand-md navbar-light fixed-top" style="background-color: #C1DC7B;">
			<a class="navbar-brand" href="<c:url value="/"/>">CAFE ONE</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarCollapse" aria-controls="navbarCollapse"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="navbar-nav mr-auto my-2 my-lg-0">
					<li class="nav-item"><a class="nav-link" href="<c:url value="/login"/>">sign in</a> 
						<!-- <span class="sr-only">(current)</span> -->
					</li>
					<li class="nav-item"><a class="nav-link" href="<c:url value="/cart"/>">cart</a>
					</li>
					<li class="nav-item"><a class="nav-link " href="<c:url value="/products"/>">Menu</a>
					</li>
					<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-expanded="false"> Menu </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="#">Espresso</a> 
							<a class="dropdown-item" href="#">Frappuccino</a>
							<a class="dropdown-item" href="#">Tea</a>
							<a class="dropdown-item" href="#">Bread</a>
						</div></li>
				</ul>
			</div>
			어서오세요.
		</nav>
	</header>



	<div class="container-wrapper">
		<div class="container">
			<h2>Product Detail</h2>
			<p class="lead">Here is the detail information of the product</p>
			<div class="row" ng-controller="cartCtrl">
				<div class="col-md-6">
					<img src="<c:url value="/resources/img/${product.filename}" />"
						alt="img" style="width:80%"/>
				</div>

				<div class="col-md-6">
					<h3>${product.product_name}</h3>
					<p><strong>Id:</strong> ${product.product_id}</p>
					<p><strong>Category: </strong> ${product.product_category}</p>
					<p><strong>Price: </strong> ${product.product_price}</p>
					<p><strong>Info: </strong> ${product.product_info}</p>
					<p>
					<a href="<c:url value="/products" />" class="btn btn-danger">Back</a>

					<button class="btn btn-warning btn-large" ng-click="addToCart('${product.product_id}')">
						<i class="fas fa-shopping-cart"></i>Order Now
					</button>

					<a href="<c:url value="/cart" />" class="btn btn-info"> 
					<i
						class="fas fa-eye"></i> View Cart
					</a>
				</p>
				</div>
			</div>
		</div>
	</div>
	<br />

	<!-- FOOTER -->
	<footer class="container">
		<p class="float-right">
			<a href="#">Back to top</a>
		</p>
		<p>CAFE ONE 문의사항
		</h6>

		instagram: &copy;gyddkzzing </br> Email: dbswjddksla&copy;naver.com</br>

		</p>
	</footer>
	</main>


	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<!-- <script>window.jQuery || document.write('<script src="js/vendor/jquery.slim.min.js"><\/script>')
	</script> -->
	<script src="<c:url value="/resources/js/bootstrap.bundle.min.js"/>"></script>


</body>
</html>

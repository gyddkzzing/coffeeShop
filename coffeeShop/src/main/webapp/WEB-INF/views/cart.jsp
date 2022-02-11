<!-- spring web form 사용 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.88.1">
<title>Product Inventory</title>

<link href="<c:url value="/resources/fontAwesome/css/all.css"/>"
	rel="stylesheet">
<link rel="canonical"
	href="https://getbootstrap.com/docs/4.6/examples/carousel/">

<!-- Bootstrap core CSS 서버로부터 URL을 가져오는 것이 좋다. -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/carousel.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
<script src="<c:url value="/resources/js/controller.js" /> "></script>
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
			<div class="jumbotron">
				<div class="container">
					<h2>Cart</h2>

					<p>All the selected products in your shopping cart</p>
				</div>
			</div>


			<section class="container" ng-app="cartApp">
				<div ng-controller="cartCtrl" ng-init="initcart_id('${cart_id}')">
					<a class="btn btn-warning pull-left" ng-click="clearCart()"> <i
						class="fas fa-trash"></i> Clear Cart
					</a> <br />

					<table class="table table-hover">
						<tr>
							<th>Product</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Total Price</th>
							<th>Action</th>
						</tr>

						<tr ng-repeat="item in cart.cartItems">
							<td>{{item.product.proudct_name}}</td>
							<td>{{item.product.proudct_price}}</td>
							<td>{{item.quantity}}</td>
							<td>{{item.totalPrice}}</td>
							<td><a class="btn btn-danger"
								ng-click="removeFromCart(item.product.proudct_id)"> <i
									class="fas fa-minus"></i>remove
							</a></td>
						</tr>

						<tr>
							<td></td>
							<td></td>
							<td>Grand Total</td>
							<td>{{calGrandTotal()}}</td>
							<td></td>
						</tr>
					</table>

					<a class="btn btn-info" href="<c:url value="/products" />"
						class="btn btn-default">Continue Shopping</a>
				</div>
			</section>

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


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
<title>관리자 page</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.6/examples/carousel/">

<!-- Bootstrap core CSS 서버로부터 URL을 가져오는 것이 좋다. -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">

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


	<!-- 프로덕트 출력화면 -->
	<div class="container-wrapper">
		<div class="container">
			<h2>Admin 관리자 page</h2>
			<p>관리자 page 입니다.</p>
		</div>
		<div class="container"> 
			<h2><a href="<c:url value="/admin/productInventory" />">Product Inventory</a></h2>
			<p>Product 재고현황 확인과 수정을 할 수 있습니다.</p>
		</div>

		
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

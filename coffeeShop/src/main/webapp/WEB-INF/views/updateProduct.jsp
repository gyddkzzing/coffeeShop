<!-- spring web form 사용 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.88.1">
<title>Update Product</title>

<link href="<c:url value="/resources/fontAwesome/css/all.css"/>" rel="stylesheet">

<link rel="canonical" href="https://getbootstrap.com/docs/4.6/examples/carousel/">

<!-- Bootstrap core CSS 서버로부터 URL을 가져오는 것이 좋다. -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

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
			<h2>update product</h2>
			<p class="lead">추가할 메뉴를 적어주세요.</p>


			<sf:form action="${pageContext.request.contextPath}/admin/productInventory/updateProduct"
				method="post" modelAttribute="product" enctype="multipart/form-data">
				
				<sf:hidden path="product_id"/>

				<div class="form group">
					<label for="product_id">id</label>
					<sf:input path="product_id" id="product_id" class="form-control" />
					<sf:errors path ="product_id" cssStyle="color:#ff0000"/>
				</div>

				<div class="form group">
					<label for="product_name">name</label>
					<sf:input path="product_name" id="product_name" class="form-control" />
					<sf:errors path ="product_name" cssStyle="color:#ff0000"/>
				</div>

				<div class="form group">
					<label for="product_category">category:</label><br />
					<sf:radiobutton path="product_category" id="product_category" value="Espresso" /> 에스프레소 <br />
					<sf:radiobutton path="product_category" id="product_category" value="Frappuccino" /> 프라푸치노 <br />
					<sf:radiobutton path="product_category" id="product_category" value="tea" /> Tea 종류 <br />
					<sf:radiobutton path="product_category" id="product_category" value="bread" /> cake,bread <br />
				</div>

				<div class="form group">
					<label for="product_price">price</label>
					<sf:input path="product_price" id="product_price" class="form-control" />
					<sf:errors path ="product_price" cssStyle="color:#ff0000"/>
				</div>

				<div class="form group">
					<label for="product_info">info</label>
					<sf:input path="product_info" id="product_info" class="form-control" />
				</div>
				
				<div class="form group">
					<label for="product_image">Upload Picture</label>
					<sf:input path="product_image" id="product_image" type="file" class="form-control" />
					
				</div>
				
				<br/>
				<button type="submit" class="btn btn-primary">submit</button>
				<a href="<c:url value="/admin/productInventory"/>"
					class="btn btn-dark">Cancle</a>
			</sf:form>
			<br/>
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


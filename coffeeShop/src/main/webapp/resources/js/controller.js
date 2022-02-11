var cartApp = angular.module('cartApp', []);

cartApp.controller("cartCtrl", function($scope, $http) {

	$scope.initcart_id = function(cart_id) {
		$scope.cart_id = cart_id;
		$scope.refreshCart();

	};

	$scope.refreshCart = function() {
		
		$http.get('/coffeeShop/api/cart/' + $scope.cart_id).then(
				function successCallback(response) {
					$scope.cart = response.data;
				});
	};

	$scope.clearCart = function() {
				
		$http({
			method : 'DELETE',
			url : '/coffeeShop/api/cart/' + $scope.cart_id
		}).then(function successCallback() {
			$scope.refreshCart();
		}, function errorCallback(response) {
			console.log(response.data);
		});

	};
	
	$scope.addToCart = function(product_id) {
				
		$http.put('/coffeeShop/api/cart/cartItem/' + product_id).then(
				function successCallback() {
					alert("Product successfully added to the cart!");

				}, function errorCallback() {
					alert("Adding to the cart failed!")
				});
	};

	$scope.removeFromCart = function(product_id) {
		
		$http({
			method : 'DELETE',
			url : '/coffeeShop/api/cart/cartItem/' + product_id
		}).then(function successCallback() {
			$scope.refreshCart();
		}, function errorCallback(response) {
			console.log(response.data);
		});
	};

	$scope.calGrandTotal = function() {
		var grandTotal = 0;

		for (var i = 0; i < $scope.cart.cartItems.length; i++) {
			grandTotal += $scope.cart.cartItems[i].totalPrice;
		}

		return grandTotal;
	};
	
});
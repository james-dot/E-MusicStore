
var cartApp = angular.module("cartApp", []);

cartApp.controller("cartCtrl", function ($scope, $http){
	
	$scope.refreshCart = function (cartId){
		$http.get("/MusicStore/rest/cart/" + $scope.cartId).success(function (data){
			$scope.cart = data;
		});
	};
	
	$scope.clearCart = function (){
		$http.delete("/MusicStore/rest/cart/" + $scope.cartId).success($scope.refreshCart($scope.cartId));
	};
	
	$scope.initCartId = function (cartId){
		$scope.cartId = cartId;
		$scope.refreshCart(cartId);
	};
	
	$scope.addToCart = function (productId){
		$http.put("/MusicStore/rest/cart/add/" + productId).success(function (data){
			$scope.refreshCart($http.get("/MusicStore/rest/cart/cartId"));
			alert("Product successfuly added to the cart");
		});
	};
	
	$scope.removeFromCart = function (productId){
		$http.put("/MusicStore/rest/cart/remove/" + productId).success(function (data){
			$scope.refreshCart($http.get("/MusicStore/rest/cart/cartId"));
		});
	};
	
});
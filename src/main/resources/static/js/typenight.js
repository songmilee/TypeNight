var app = angular.module('tn', ['ngRoute', 'angular-md5']);

app.config(function($locationProvider, $routeProvider){
	$locationProvider.html5Mode({
		enabled : true,
		requireBase : false
	});
});

app.controller('loginController', function($scope, md5){	
	
	$scope.hash = function(){
		//var pwdHash = md5.createHash($scope.pwd || '');
		//$scope.pwd = pwdHash;
		
		document.getElementById('frm').submit();
		
	}
});

app.controller('registerController', function($scope){
	$scope.disableBtn = false;
	
	$scope.hash = function(){
		disableBtn = true;
		
		//document.getElementById('frm').submit();
	}
	
});

app.controller('orderController', function($scope, $window, $http){
	
	$scope.go = function(path){
		$window.location = path;
	}

});

function DateFormat(date){
	var d = new Date(date),
	month = (d.getMonth() + 1),
	day = d.getDate(),
	year = d.getFullYear();
	
	if(month < 10) month = "0"+month;
	if(day < 10) day = "0" + day;
	
	return year+"-"+month+"-"+day;
}
var app = angular.module('tn', ['ngRoute']);

app.config(function($locationProvider, $routeProvider){
	$locationProvider.html5Mode({
		enabled : true,
		requireBase : false
	});
});

app.controller('orderController', function($scope, $window, $http){
	$scope.Date = new Date();
	
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
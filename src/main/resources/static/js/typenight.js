var app = angular.module('tn', ['ngRoute']);

app.config(function($locationProvider, $routeProvider){
	$locationProvider.html5Mode({
		enabled : true,
		requireBase : false
	});
});

app.controller('Reigster', function($scope, $window, $http){
	$scope.regData = function(){
		var date = DateFormat($scope.birth);
		
		var member = {
			id : $scope.id,
			pwd : $scope.pwd,
			name : $scope.name,
			gender : $scope.gender,
			birth : date
		}
		
		console.log(member);
		
		//register 페이지로 데이터를 보내 계정 등록
		$http({
			method : "POST",
			url : "/register",
			headers : {'Content-Type': 'application/x-www-form-urlencoded'},
			data : $.param(member)
		}).then(function success(res){
			alert("회원 가입을 성공하였습니다.");
			$window.location.href="/";
		}), function fail(res){
			alert("회원가입을 실패하였습니다.");
		}
	}
});

function DateFormat(date){
	var d = new Date(date),
	month = (d.getMonth() + 1),
	day = d.getDate(),
	year = d.getFullYear();
	
	return year+"-"+month+"-"+day;
}
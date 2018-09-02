var app = angular.module('tn', ['ngRoute', 'angular-md5']);

app.config(function($locationProvider, $routeProvider){
	$locationProvider.html5Mode({
		enabled : true,
		requireBase : false
	});
});

app.controller('loginController', function($scope, md5){	
	
	$scope.hash = function(){
		var id = document.getElementById('id').value;
		var pwd = document.getElementById('pwd');
		
		if(id == "" || pwd.value == ""){
			alert("Complete the form");
		} else {
			var pwdHash = md5.createHash(pwd.value || '');
			
			pwd.value = pwdHash;
			
			var form = document.getElementById('frm');		
			form.submit();
		}			
	
	}
});

app.controller('registerController', function($scope, md5){
	$scope.disableBtn = false;
	
	$scope.hash = function(){
		$scope.disableBtn = true;
		
		var name = document.getElementById('name').value;
		var id = document.getElementById('id').value;
		var gender = document.getElementsByName('gender');
		var birth = document.getElementById('birth').value;
		var pwd = document.getElementById('pwd');
		
		if(name == "" || id == "" || birth == "" || pwd.value == "" || (!gender[0].checked && !gender[1].checked)){
			alert("Complete the form");
		} else{
			var pwdHash = md5.createHash(pwd.value || '');
			
			pwd.value = pwdHash;
			
			var form = document.getElementById('frm');		
			form.submit();
		}
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
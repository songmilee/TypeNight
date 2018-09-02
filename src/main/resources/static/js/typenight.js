var app = angular.module('tn', ['ngRoute', 'angular-md5']);

app.config(function($locationProvider, $routeProvider, $qProvider){
	$qProvider.errorOnUnhandledRejections(false);
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

app.controller('orderController', function($scope, $window){
	$scope.go = function(path){
		$window.location = path;
	}

});

app.controller('cartController', function($scope, $http, $window){
	$scope.go = function(path){
		$window.location = path;
	}
	$scope.deleteCart = function(id){
		$http({
			method : "delete",
			url : "/cart?iid="+id,
		}).then(function success(res){
			if(res.data.result == "1"){
				$window.location.reload();
			}else{
				alert("Sorry, Cannot delete");
			}
		}), function fail(res){
			alert("Sorry, Internal Error");
		}
	}
});

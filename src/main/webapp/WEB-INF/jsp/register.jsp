<!doctype html>
<html>
<%@include file="./partial/header.html" %>
<body ng-app="tn">
	<div class="content" ng-controller="Reigster">
		<div class="row">
			<form role="form" ng-submit="regData()"  method="POST">
				<div class="row bottom-space">
					<label for="id">ID : </label>
					<input type="text" name="id" ng-model="id" required>
				</div>
				<div class="row bottom-space">
					<label for="pwd">password : </label>
					<input type="password" name="pwd" ng-model="pwd" required>
				</div>
				<div class="row bottom-space">
					<label for="name">name : </label>
					<input type="text" name="name" ng-model="name" required>
				</div>
				<div class="row bottom-space">
					<p>Select your gender</p>
					<input type="radio" id="0" name="gender" ng-model="gender" value="0" required>
					<label for="0">Male</label>
					<input type="radio" id="1" name="gender" ng-model="gender" value="1">
					<label for="1">Female</label>
				</div>
				<div class="row bottom-space">
					<label for="birth">Birth : </label>
					<input type="date" name="birth" ng-model="birth" required>
				</div>
				<div class="row bottom-space">
					<button type="submit" class="btn btn-default btn-primary">Submit</button>
				</div>
				
			</form>
		</div>
	</div>	
	<%@include file="./partial/js.html" %>
</body>
</html>
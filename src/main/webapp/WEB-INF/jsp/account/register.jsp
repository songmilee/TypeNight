<!doctype html>
<html>
<%@include file="../partial/header.html" %>
<body ng-app="tn">
	<div class="account-content" ng-controller="registerController">
		<div class="table-responsive">
			<form id="frm" action="/register/regdata.do"  method="POST">
				<table class="table table-borderless">
					<tr>
						<td>
							<label for="id">ID</label>
							<input class="max-width" type="text" name="id" id="id" required>
						</td>
					</tr>
					
					<tr>
						<td>
							<label for="pwd">password</label>
							<input class="max-width" type="password" name="pwd" id="pwd" required>
						</td>
					</tr>
					
					<tr>
						<td>
							<label for="name">name</label>
							<input class="max-width" type="text" name="name" id="name" required>
						</td>
					</tr>
					
					<tr>
						<td>
							<label for="gender">Select your gender<br/></label>
							<input type="radio" id="0" name="gender" id="gender" value="0" required>
							<label for="0">Male</label>
							<input type="radio" id="1" name="gender" id="gender" value="1">
							<label for="1">Female</label>
						</td>
					</tr>
					
					<tr>
						<td>
							<label for="birth">Birth</label>
							<input class="max-width" type="date" name="birth" id="birth" required>
						</td>
					</tr>
					
					<tr>
						<td>
							<button ng-click="hash()" ng-init="disableBtn=false" class="btn btn-default btn-primary max-width">Submit</button>
						</td>
					</tr>
					
				</table>
			</form>
			
			<c:if test="${msg=='-1' }">
				<script>alert("Fail to Register");</script>
			</c:if>
			<c:if test="${msg=='2' }">
				<script>alert("Already registered id");</script>
			</c:if>
		</div>
	</div>	
	<%@include file="../partial/js.html" %>
</body>
</html>
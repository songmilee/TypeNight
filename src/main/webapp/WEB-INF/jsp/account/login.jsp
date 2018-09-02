<!doctype html>
<html>
<%@ include file="../partial/header.html" %>
<body ng-app="tn">
	<div class="account-content" ng-controller="loginController">
		<div id="login-box">
			<div id="login-box-align">
				<div id="login-box-content">					
					<form id="frm" action = "/logincheck.do" class="table-responsive" method="POST">
						<table class="table table-borderless">
							<tr>
								<td>ID</td>
								<td><input class="max-width" type="text" name="id" id="id" required></td>
							</tr>
							<tr>
								<td>Password</td>
								<td><input class="max-width" type="password" name="pwd" id="pwd" required></td>
							</tr>
							<tr>
								<td colspan="2">
									<button type="button" ng-click="hash()" class="btn btn-default btn-primary max-width">Login</button>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<button class="btn btn-default btn-primary max-width" onclick="location.href='/register/main.do'">Register</button>
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
		
		<c:if test="${msg=='2000' }">
			<script>alert("Fail to Login");</script>
		</c:if>
	</div>


<%@ include file="../partial/js.html" %>
</body>
</html>
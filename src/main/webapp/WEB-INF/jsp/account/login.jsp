<!doctype html>
<html>
<%@ include file="../partial/header.html" %>
<body>
	<div class="account-content">
		<div id="login-box">
			<div id="login-box-align">
				<div id="login-box-content">
					<form class="table-responsive" action="/logincheck.do" method="POST">
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
									<button type="submit" class="btn btn-default btn-primary max-width">Login</button>
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
<!doctype html>
<html>
<%@ include file="../partial/header.html" %>
<body>
	<div class="content">
		<div class="row">
			<form action="/logincheck.do" method="POST">
				<table>
					<tr>
						<td>ID</td>
						<td><input type="text" name="id" id="id" required></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="pwd" id="pwd" required></td>
					</tr>
					<tr>
						<td>
							<button type="submit" class="btn btn-default btn-primary">Login</button>
						</td>
					</tr>
					<tr>
						<td>
							<button class="btn btn-default btn-primary" onclick="location.href='/register/main.do'">Register</button>
						</td>
					</tr>
				</table>
			</form>
			
			<c:if test="${msg=='2000' }">
				<script>alert("Fail to Login");</script>
			</c:if>
		</div>
	</div>

<%@ include file="../partial/js.html" %>
</body>
</html>
<!doctype html>
<html>
<%@ include file="./partial/header.html" %>
<body>
<h1>Login Page</h1>

	<div class="content">
		<div class="row">
			<form action="/" method="POST">
				<div class="row bottom-space">
					<label for="id">ID</label>
					<input type="text" name="id" id="id">
				</div>
				
				<div class="row bottom-space">
					<label for="pwd">pwd</label>
					<input type="password" name="pwd" id="pwd">
				</div>
				
				<div class="row bottom-space">
					<input type="submit" class="btn btn-default btn-primary" value="submit">
				</div>
			</form>
		</div>
		
		<div class="row bottom-space">
			<button class="btn btn-default btn-primary" onclick="location.href='/register'">Register Account</button>
		</div>
	</div>

<%@ include file="./partial/js.html" %>
</body>
</html>
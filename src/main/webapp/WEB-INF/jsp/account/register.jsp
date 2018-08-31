<!doctype html>
<html>
<%@include file="../partial/header.html" %>
<body ng-app="tn">
	<div class="content" ng-controller="Reigster">
		<div class="row">
			<form action="/register/regdata.do"  method="POST">
				<table>
					<tr>
						<td>
							<label for="id">ID</label>
						</td>
						<td>
							<input type="text" name="id" id="id" required>
						</td>
					</tr>
					
					<tr>
						<td>
							<label for="pwd">password</label>
						</td>
						<td>
							<input type="password" name="pwd" id="pwd" required>
						</td>
					</tr>
					
					<tr>
						<td>
							<label for="name">name</label>
						</td>
						<td>
							<input type="text" name="name" id="name" required>
						</td>
					</tr>
					
					<tr>
						<td>
							<p>Select your gender </p>
						</td>
						<td>
							<input type="radio" id="0" name="gender" id="gender" value="0" required>
							<label for="0">Male</label>
							<input type="radio" id="1" name="gender" id="gender" value="1">
							<label for="1">Female</label>
						</td>
					</tr>
					
					<tr>
						<td>
							<label for="birth">Birth</label>
						</td>
						<td>
							<input type="date" name="birth" id="birth" required>
						</td>
					</tr>
					
					<tr>
						<td>
							<button type="submit" class="btn btn-default btn-primary">Submit</button>
						</td>
					</tr>
					
				</table>
			</form>
			
			<c:if test="${msg=='-1' }">
				<script>alert("Fail to Register");</script>
			</c:if>
		</div>
	</div>	
	<%@include file="../partial/js.html" %>
</body>
</html>
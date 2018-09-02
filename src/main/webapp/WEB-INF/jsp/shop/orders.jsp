<!doctype html>
<html>
<%@ include file="../partial/header.html" %>
<body ng-app="tn">
	<div  ng-controller="orderController">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <a class="navbar-brand" href="#" ng-click="go('${path}/shop')">ixShop</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  
		  <div class="collapse navbar-collapse" id="navbarNav">
		    <ul class="navbar-nav ml-auto">
		      <li class="nav-item">
		        <a class="nav-link" href="#" ng-click="go('${path}/shop')">Items <span class="sr-only">(current)</span></a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="#" ng-click="go('${path}/cart')">Cart</a>
		      </li>
		      <li class="nav-item active">
		      	<a class="nav-link" href="#" ng-click="go('${path}/order')">Orders</a>
		      </li>
		      <li class="nav-item">
		      	<a class="nav-link" href="#" ng-click="go('${path}/logout.do')">Log out</a>
		      </li>
		    </ul>
		  </div>
		</nav>
		
		<div class="shop-content">
			<div class="bottom-space">
						<div class="table-responsive col-lg-6 col-md-6 col-sm-6 float-sm-right float-md-right flot-lg-right">
							<form action="${path}/order">
								<table class="table table-borderless">
									<tr>
										<td><input type="date" name="start" /></td>
										<td>~</td>
										<td><input type="date" name="end"/></td>
										<td><input type="submit" class="btn btn-default btn-primary" value="search"/></td>
									</tr>
								</table>
							</form>
						
						</div>
					</div>

			<c:choose>
				<c:when test="${fn:length(orders) == 0}">
					<h4>Empty Orders</h4>
				</c:when>
				
				<c:otherwise>					
					<div class="table-responsive">
						<table class="table table-light">
							<tr>
								<th>Date</th>
								<th></th>
								<th>Item name</th>
								<th>Item Unit Price</th>
								<th>Item Amount</th>
								<th>Price</th>
							</tr>
							
							<c:forEach var="row" items="${orders}" varStatus="i">
								<tr>				
									<td class="align-middle">${row.date} </td>
									<td class="align-middle"><img src="${path}/img/${row.img}" width="300px" height="300px"></td>
									<td class="align-middle">${row.name }</td>
									<td class="align-middle">$${row.price }</td>
									<td class="align-middle">${row.amount } </td>
									<td class="align-middle">$<fmt:formatNumber value="${row.price * row.amount }" pattern=".00" /></td>						
								</tr>
							</c:forEach>
						</table>
					
					</div>
					
				</c:otherwise>
			</c:choose>
		
		</div>
	</div>
	
<%@ include file="../partial/js.html" %>
</body>
</html>
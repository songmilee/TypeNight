<!doctype html>
<html>
<%@ include file="../partial/header.html" %>
<body ng-app="tn" >
	<div ng-controller="cartController">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <a class="navbar-brand"  ng-click="go('${path}/shop')">ixShop</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  
		  <div class="collapse navbar-collapse" id="navbarNav">
		    <ul class="navbar-nav ml-auto">
		      <li class="nav-item">
		        <a class="nav-link" href="#" ng-click="go('${path}/shop')">Items <span class="sr-only">(current)</span></a>
		      </li>
		      <li class="nav-item active">
		        <a class="nav-link"  href="#" ng-click="go('${path}/cart')">Cart</a>
		      </li>
		      <li class="nav-item">
		      	<a class="nav-link" href="#" ng-click="go('${path}/order')">Orders</a>
		      </li>
		      <li class="nav-item">
		      	<a class="nav-link" href="#" ng-click="go('${path}/logout.do')">Log out</a>
		      </li>
		    </ul>
		  </div>
		</nav>
		
		<div class="shop-content">
			<c:choose>
				<c:when test="${fn:length(cartitem) == 0 }">
					<h4>Cart is Empty</h4>
				</c:when>
				<c:otherwise>
					<form action="${path}/order" method="POST">
						<div class="table-responsive">
							<table class="table table-light">
								<tr>
									<th>no</th>
									<th></th>
									<th>Item name</th>
									<th>Item Unit Price</th>
									<th>Item Amount</th>
									<th>Item Price</th>
									<th>remove</th>
								</tr>
								
								<c:forEach var="row" items="${cartitem }" varStatus="i">
									<tr>
										<td class="align-middle">${i.count }</td>
										<td class="align-middle"><img src="${path}/img/${row.img}" width="300px" height="300px"></td>
										<td class="align-middle">${row.name }</td>
										<td class="align-middle">$${row.price }</td>
										<td class="align-middle">${row.amount }</td>
										<td class="align-middle">$<fmt:formatNumber value="${row.price * row.amount }" pattern=".00" /></td>
										<td class="align-middle" ng-click="deleteCart('${row.iid}')"><a href="#">remove</a></td>
									</tr>
									
									<input type="hidden" name="iid" id="iid" value="${row.iid}" />
									<input type="hidden" name="amount" id="amount" value="${row.amount}"/>
								</c:forEach>
								<tr>
									<td colspan="7" align="right">
										Total : $${sum}
									</td>
								</tr>
							</table>
						</div>					
						<button type="submit" class="btn btn-default btn-primary float-sm-right float-md-right flot-lg-right">Buy</button>
					</form>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	
<%@ include file="../partial/js.html" %>
</body>
</html>
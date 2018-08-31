<!doctype html>
<html>
<%@ include file="../partial/header.html" %>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <a class="navbar-brand" href="${path}/shop/list.do">ixShop</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  
	  <div class="collapse navbar-collapse" id="navbarNav">
	    <ul class="navbar-nav ml-auto">
	      <li class="nav-item active">
	        <a class="nav-link" href="${path}/shop/list.do">Items <span class="sr-only">(current)</span></a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="${path}/cart/list.do">Cart</a>
	      </li>
	      <li class="nav-item">
	      	<a class="nav-link" href="${path}/order/list.do">Orders</a>
	      </li>
	      <li class="nav-item">
	      	<a class="nav-link" href="${path}/logout.do">Log out</a>
	      </li>
	    </ul>
	  </div>
	</nav>
	
	<div class="contents">
		<c:choose>
			<c:when test="${fn:length(cartitem) == 0 }">
				<h4>Cart is Empty</h4>
			</c:when>
			<c:otherwise>
				<form action="${path}/order/buy.do" method="POST">
					<table>
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
								<td>${i.count }</td>
								<td><img src="${path}/img/${row.img}" width="300px" height="300px"></td>
								<td>${row.name }</td>
								<td>${row.price }</td>
								<td>${row.amount }</td>
								<td><fmt:formatNumber value="${row.price * row.amount }" pattern=".00" /></td>
								<td><a href="${path}/cart/delete.do?iid=${row.iid}">remove</a></td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="5" align="right">
								Total : ${sum }
							</td>
						</tr>
					</table>
					
					<button type="submit" class="btn btn-default btn-primary">Buy</button>
				</form>
			</c:otherwise>
		</c:choose>
	</div>
	
<%@ include file="../partial/js.html" %>
</body>
</html>
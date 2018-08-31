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
		<table>
			<tr>
				<th>ID</th>
				<th>Item Image</th>
				<th>Item name</th>
				<th>Price</th>
			</tr>
			
			<c:forEach var="row" items="${items }">
				<tr>
					<td>${row.iid }</td>
					<td><a href="${path }/shop/detail/${row.iid}"><img src="${path}/img/${row.img}" width="300px" height="300px"></a></td>
					<td><a href="${path }/shop/detail/${row.iid}">${row.name }</a></td>
					<td><a href="${path }/shop/detail/${row.iid}">$${row.price }</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
<%@ include file="../partial/js.html" %>
</body>
</html>
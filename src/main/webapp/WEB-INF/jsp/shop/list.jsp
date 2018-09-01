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
	
	<div class="shop-content">
		<div class="row">
			<c:forEach var="row" items="${items }">
				<div class="col-lg-4 col-md-4 col-sm-4 bottom-space">
					<div class="card">
						<a href="${path }/shop/detail/${row.iid}"><img class="card-img-top" src="${path}/img/${row.img}" width="300px" height="300px"></a>
						<div class="card-body">
							<h5 class="card-title"><a href="${path }/shop/detail/${row.iid}">${row.name }</a></h5>
							<p class="card-text text-right"><a href="${path }/shop/detail/${row.iid}">$${row.price }</a></p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	
<%@ include file="../partial/js.html" %>
</body>
</html>
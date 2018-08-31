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
				<td>
					<img src="${path}/img/${item.img}" width="500px" height="500px">
				</td>
			</tr>
			<tr>
				<td>Item Name</td>
			</tr>
			<tr>
				<td>${item.name }</td>
			</tr>
			<tr>
				<td>Item Price</td>
				<td>${item.price }</td>
			</tr>	
			<tr>
				<td>Product Description</td>
			</tr>
			<tr>
				<td>${item.desc }</td>
			</tr>
			<tr>
				<td>
					<form action="${path}/cart/insert.do" method="POST">
						<input type="hidden" name="iid" id="iid" value=${item.iid }>
						<select name="amount">
							<c:forEach begin="1" end="10" var="row">
								<option value="${row }">${row}</option>
							</c:forEach>
						</select>
						
						<input type="submit" class="btn btn-default btn-primary" value="add to cart">
					</form>
				</td>
			</tr>
		</table>
	</div>
	
<%@ include file="../partial/js.html" %>
</body>
</html>
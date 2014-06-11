<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
  <meta charset="utf-8" content=""/>
  <title>Admin</title>
  <link rel="stylesheet" href="https://dl-web.dropbox.com/get/webtools_resources/jquery-ui.css?w=AADDIToXVH_ZFlArQXfB7W19yEGtNdd3-BwvQLSFESSSIA" />
  <script src="http://code.jquery.com/jquery-1.9.1.js" type="text/javascript"></script>
  <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js" type="text/javascript"></script>
 
  <script type="text/javascript">
  $(function() {
    $( "#tabs" ).tabs();
    collapsible: true;
    if($(".tab-set") && document.location.hash){
  	  $.scrollTo(".tab-set");
  	}
  });
  $( ".selector" ).tabs( "option", "heightStyle", "auto" );
  
  $(function() {
	    $( "#accordion" ).accordion();
	  });

  </script>
</head>
<body>
<div id="tabs">
  <ul>
    <li><a href="#tabs-1">Products </a></li>
    <li><a href="#tabs-2">Process Order </a></li>

  </ul>
  	<div id="tabs-1">
 		<div id="accordion">
  			<h3>Add Products</h3>
     			<div  style="margin-top: 5pt; border-radius: 40px;">
		            <form id="contactform" method="Post" action="addProduct.htm">
		                <p ><label for="name">Name</label></p>
		                <input id="name" name="name" placeholder="Product Name" required tabindex="1" type="text"><br><br>
		                
		                <p ><label for="price">Price</label></p>
		                <input id="price" name="price" placeholder="Cost in USD" required tabindex="2" type="text"><br><br>
		                
		                 <label>Product</label><br>
		                  
		                  <select  name="productType" tabindex="3">
		                  <option value="">Product Type</option>
		                  <option value="Snacks">Snacks</option>
		                  <option value="Dairy Product">Dairy Product</option>
		                  <option value="Pulses" >Pulses</option>
		                  </select><br><br>
		            
		            	<input class="buttom" name="submit" id ="submit" tabindex="4" value="Add Product" type="submit">   
		   			</form>
				</div>
  			<h3>View Products</h3>
  				<div  style="margin-top: 5pt; border-radius: 40px;">
            		<h1 align="center"> ${sessionScope.loggedUser.username} 's WorkArea</h1>
            
					   <c:if test="${fn:length(productList) eq 0}">
							<p>No Products Available</p>
						</c:if>
						 <c:if test="${fn:length(productList) gt 0}">  
						<label>Products</label>   
						        <select class="select-style">
						            <option value="">Products</option>
						               <c:if test="${fn:length(productList) gt 0}">  
						                  <c:forEach var="element" items="${requestScope.productList}">
						                  	<option value="${element.name}">${element.name}</option>
						                  </c:forEach>
						               </c:if>
						        </select>
						                <br/><br/>
								<table align="center" border="2px" >
									<tr>
										<th width="100px">Product ID</th>
										<th width="200px">Name</th>
										<th width="100px">Type</th>
										<th width="100px">Price</th>
										
									</tr>
									<c:forEach var="element" items="${requestScope.productList}">
										<input type="hidden" name="manuId" value="${element.id}">
										<tr>
											<td align="center">${element.id}</td>
											<td align="center">${element.name}</td>
											<td align="center">${element.type}</td>
											<td align="center">${element.price}</td>
											
										</tr>
									</c:forEach>
								</table>	<br/><br/>
								</c:if>
 					</div>

  			<h3>Add to Inventory</h3>
  				<div  style="margin-top: 10pt; border-radius: 40px;">
            		<h1 align="center"> ${sessionScope.loggedUser.username} 's WorkArea</h1>
            
					   <c:if test="${fn:length(productList) eq 0}">
							<p>No Products Available</p>
						</c:if>
						<c:if test="${fn:length(productList) gt 0}">  
						<form method="post" action="addInventory.htm">
						<label>Products</label>   
						        <select class="select-style" name="BirthMonth">
						            <option value="">Products</option>
						               <c:if test="${fn:length(productList) gt 0}">  
						                  <c:forEach var="element" items="${requestScope.productList}">
						                  	<option value="${element.name}">${element.name}</option>
						                  </c:forEach>
						               </c:if>
						        </select>
						                <br/><br/>
								<table align="center" border="2px" >
									<tr>
										<th width="100px">Product ID</th>
										<th width="200px">Name</th>
										<th width="100px">Type</th>
										<th width="100px">Price</th>
										<th width="100px">Quantity</th>
										<th width="100px">Add</th>
									</tr>
									
									<c:forEach var="element" items="${requestScope.productList}">
										<input type="hidden" name="manuId" value="${element.id}">
										<tr>
											<td align="center">${element.id}</td>
											<td align="center">${element.name}</td>
											<td align="center">${element.type}</td>
											<td align="center">${element.price}</td>
											<td align="center"><input type="number" name="${element.id}" min="0" maxlength="2"></td>
											<td align="center"><input type="checkbox" value="${element.id}" name = "checked" ></td>
										</tr>
									</c:forEach>
								</table>	<br/><br/>
								<input type="submit" name="submit" value="Add to Inventory">
								<input type="reset" name="reset" value="Reset">
						</form>
						</c:if>
 			</div>
 			<h3>View Inventory</h3>
 					<div  style="margin-top: 5pt; border-radius: 40px;">
            		<h1 align="center"> ${sessionScope.loggedUser.username} 's WorkArea</h1>
            
					   <c:if test="${fn:length(stockItemList) eq 0}">
							<p>No Inventory Item Available</p>
						</c:if>
						 <c:if test="${fn:length(stockItemList) gt 0}">  
						<label>Inventory Item</label>   
						        <select class="select-style" >
						            <option value="">Inventory Item</option>
						               <c:if test="${fn:length(stockItemList) gt 0}">  
						                  <c:forEach var="element" items="${requestScope.stockItemList}">
						                  	<option value="${element.product.name}">${element.product.name}</option>
						                  </c:forEach>
						               </c:if>
						        </select>
						                <br/><br/>
								<table align="center" border="2px" >
									<tr>
										<th width="100px">Inventory ID</th>
										<th width="200px">Name</th>
										<th width="100px">Type</th>
										<th width="100px">Price</th>
										<th width="100px">Quantity</th>
									</tr>
									
									<c:forEach var="element" items="${requestScope.stockItemList}">
										<input type="hidden" name="manuId" value="${element.id}">
										<tr>
											<td align="center">${element.id}</td>
											<td align="center">${element.product.name}</td>
											<td align="center">${element.product.type}</td>
											<td align="center">${element.product.price}</td>
											<td align="center">${element.quantity}</td>
										</tr>
									</c:forEach>
								</table></c:if>	<br/><br/>
 				</div>
 		</div>
 	</div>
	<div id="tabs-2" style="overflow:scroll;height:700px">
 		
  			<h3>Process Orders</h3>
  			<div  style="margin-top: 5pt; border-radius: 40px;">
  			
  				
							<p style="color: red">${requestScope.message}</p></br>
			
						
  			 <c:if test="${fn:length(orderItemList) eq 0}">
							<p>No Orders left to be processed</p>
						</c:if>
			<c:if test="${fn:length(orderItemList) gt 0}">
  				<form method="post" action="shipOrder.htm">
				<c:forEach var="element" items="${requestScope.orderItemList}">
				  <h3>Customer Order ID : ${element.id}</h3>
				  <div>
				    		<input type = "hidden" value="${element.id}" name="orderItem">
				    		<table align="center" border="2px" >
								<tr>	
									<th width="100px">Order Id</th>
									<th width="100px">Product Id</th>
									<th width="100px">Status</th>
									<th width="100px">Quantity</th>
									<th width="100px">Total Cost</th>
								</tr>
													
								<tr>
									<td align="center">${element.id}</td>
									<td align="center">${element.product.id}</td>
									<td align="center">${element.status}</td>
									<td align="center">${element.quantity}</td>
									<td align="center">${element.total}</td>
								</tr>
							</table>	<br/><br/>
						
						<input type="submit" name="submit" value="Ship">	
				  </div>
				</c:forEach>  
					<br/><br/>	
				<input type="submit" name="submit" value="Approve All">
				</form>	
				</c:if>
				</div>
				</div>
</div>
</body>
</html>	
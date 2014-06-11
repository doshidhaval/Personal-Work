<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Cart</title>
</head>
<body>
<h1 align="center"> ${sessionScope.loggedUser.username} 's WorkArea</h1>
            
					   <c:if test="${fn:length(orderItemList) eq 0}">
							<p>No Products Available</p>
						</c:if>

						<form method="post" action="updateOrder.htm">
						<label>Products</label>   
						        <select class="select-style" >
						            <option value="">OrderItems</option>
						               <c:if test="${fn:length(orderItemList) gt 0}">  
						                  <c:forEach var="element" items="${requestScope.orderItemList}">
						                  	<option value="${element.id}">${element.id}</option>
						                  </c:forEach>
						               </c:if>
						        </select>
						                <br/><br/>
								<table align="center" border="2px" >
									<tr>
										<th width="100px">Inventory ID </th>
										<th width="100px">Product Name</th>
										<th width="100px">Status</th>
										<th width="100px">Price </th>
										<th width="100px">Quantity</th>
										<th width="100px">Total</th>
										<th width="100px">Check To Update</th>
										<th width="100px">Check To Delete</th>
									</tr>
									
									<c:forEach var="element" items="${requestScope.orderItemList}">
										
										<tr>
											<td align="center">${element.id}</td>
											<td align="center">${element.product.name}</td>
											<td align="center">${element.status}</td>
											<td align="center">${element.product.price}</td>
											<td align="center"><input type="number" name="${element.id}" min="0" value="${element.quantity}"></td>
											<td align="center">${element.total}</td>
											<td align="center"><input type="checkbox" value="${element.id}" name = "checked" ></td>
											<td align="center"><input type="checkbox" value="${element.id}" name = "toDelete" ></td>
											
										</tr>
									</c:forEach>
								</table>	<br/><br/>
								<input type="submit" name="submit" value="Update">
								<input type="submit" name="submit" value="Delete">
								<input type="submit" name="submit" value="DeleteCustomerOrder">
						</form>
						
</body>
</html>
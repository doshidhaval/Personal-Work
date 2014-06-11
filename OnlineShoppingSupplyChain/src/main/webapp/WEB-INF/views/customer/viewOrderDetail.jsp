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
<h1 align="center">Welcome to Local Grocer: ${sessionScope.loggedUser.username} </h1>
<h2> The order has the following OrderItems</h2>
            
					   <c:if test="${fn:length(orderItemList) eq 0}">
							<p>No Orders </p>
						</c:if>

						<form method="post" action="updateOrder.htm">
						  	
						        
						                <br/><br/>
								<table align="center" border="2px" >
									<tr>
										<th width="100px">Inventory ID </th>
										<th width="100px">Product Name</th>
										<th width="100px">Status</th>
										<th width="100px">Price </th>
										<th width="100px">Quantity</th>
										<th width="100px">Total</th>
									
									</tr>
									
									<c:forEach var="element" items="${requestScope.orderItemList}">
										
										<tr>
											<td align="center">${element.id}</td>
											<td align="center">${element.product.name}</td>
											<td align="center">${element.status}</td>
											<td align="center">${element.product.price}</td>
											<td align="center"><input type="number" name="${element.id}" min="0" value="${element.quantity}"></td>
											<td align="center">${element.total}</td>		
										</tr>
									</c:forEach>
								</table>	<br/><br/>
							
						</form>
						
</body>
</html>
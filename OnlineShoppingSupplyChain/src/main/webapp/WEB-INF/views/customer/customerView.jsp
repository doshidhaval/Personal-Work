<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <title></title>
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css" />
  
</head>
<body>
 
<h1 align="center">Welcome to Local Grocer: ${sessionScope.loggedUser.username} </h1>
            
					   <c:if test="${fn:length(productList) eq 0}">
							<p>No Products Available</p>
						</c:if>

						<form method="post" action="customerOrder.htm">
						
						                <br/><br/>
								<table align="center" border="2px" >
									<tr>
										<th width="100px">Product ID</th>
										<th width="200px">Manufacturer</th>
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
											<td align="center">${element.manufacturer.name}</td>
											<td align="center">${element.name}</td>
											<td align="center">${element.type}</td>
											<td align="center">${element.price}</td>
											<td align="center"><input type="number" name="${element.id}" min="0"></td>
											<td align="center"><input type="checkbox" value="${element.id}" name = "checked" ></td>
										</tr>
									</c:forEach>
									<br/><br/>
								<tr><td colspan="3"><input type="submit" name="submit" value="Add to Cart"></td>
								<td colspan="3"><input type="reset" name="reset" value="Reset List"></td></tr>
								</table>
						</form>
						
</body>
</html>
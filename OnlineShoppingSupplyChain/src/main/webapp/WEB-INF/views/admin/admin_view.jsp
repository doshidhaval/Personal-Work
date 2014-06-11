<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html >
<html>	
<head>
  <meta charset="utf-8" />
  <title>Admin</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/webtools_resources/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
 
  <script>
  $(function() {
	    $( "#tabs" ).tabs();
	    $( "#accordion" ).accordion();
	  });
	  
	  </script>
</head>
<body>
<div id="tabs">
  <ul>
    <li><a href="#tabs-1">Verify Manufacturer </a></li>
    <li><a href="#tabs-2">Approve Order</a></li>

  </ul>
  <div id="tabs-1">
  <div >
            <h1 align="center"> ${sessionScope.loggedUser.username} 's WorkArea</h1>
            
   <c:if test="${fn:length(manuList) eq 0}">
		<p>You have no Work left</p>
	</c:if>

	<c:if test="${fn:length(manuList) gt 0}">         
<form method="post" action="decisionManu.htm">
		<table align="center" border="2px" >
			<tr>
				<th width="100px">Manufacturer ID</th>
				<th width="200px">Seller Name</th>
				<th width="100px">Seller's Status</th>
				<th width="100px">Accept Request</th>
				<th width="100px">Reject Request</th>
			</tr>
			<c:forEach var="element" items="${requestScope.manuList}">
				<input type="hidden" name="manuId" value="${element.id}">
				<tr>
					<td align="center">${element.id}</td>
					<td align="center">${element.name}</td>
					<td>Waiting</td>
					<td align="center"><input type="submit" name="decision" value="Accept"></td>
					<td align="center"><input type="submit" name="decision" value="Reject"></td>
				</tr>
			</c:forEach>
		</table>	
</form>
 	</c:if>
</div>
  </div>
  <div id="tabs-2">
  
  <c:if test="${fn:length(orderList) eq 0}">
		<p>You have no Orders left to be Approved</p>
	</c:if>
	<div id="accordion" >
				<c:forEach var="element" items="${requestScope.orderList}">
				  <h3>Customer Order ID : ${element.id}</h3>

				  <form action = "approveOrder.htm" method="post">
				    		<input type = "hidden" value="${element.id}" name="order">
				    		<table align="center" border="2px" >
								<tr>
									<th width="100px">Customer</th>
									<th width="100px">Order ID</th>
									<th width="100px">Status</th>
									<th width="100px">Total Cost</th>
								</tr>				
								<tr>
									<td align="center">${element.person.fname} </td>
									<td align="center">${element.id}</td>
									<td align="center">${element.status}</td>
									<td align="center">${element.cost}</td>
								</tr>
							</table>	
						<br/><br/>
						<input type="submit" name="submit" value="View Details">
						<input type="submit" name="submit" value="Approve">
						
						</form>
	
				  
				</c:forEach>  
			</div><br/><br/>	
			
		
  </div>
  </div>
  
 </body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Cart</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/webtools_resources/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css" />
  <script>
  $(function() {
    $( "#accordion" ).accordion({
      collapsible: true
    });
  });
  </script>
   <script>
  $(function() {
	  $("#tabs" ).tabs( { active: window.location.hash - 1 } ); 
  });
  </script>
</head>
<body>

<h1 align="center"> ${sessionScope.loggedUser.username} 's CART</h1>
            
					   <c:if test="${fn:length(orderList) eq 0}">
							<p>No Items in Cart</p>
						</c:if>

<div id="tabs">
  <ul>
    <li><a href="#tabs-1">Orders >></a></li>
    <li><a href="#tabs-2">Make Payment >></a></li>
  
  </ul>
  <form method="post" action="processCart.htm">
  <div id="tabs-1">
    
   			<div id="accordion">
				<c:forEach var="element" items="${requestScope.orderList}">
				  <h3>Customer Order ID : ${element.id}</h3>
				  <div>
				    		<input type = "hidden" value="${element.id}" name="customerOrder">
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
							</table>	<br/><br/>
						<input type="submit" name="submit" value="View Details">
						<input type="submit" name="submit" value="Confirm">
						
				  </div>
				</c:forEach>  
			</div><br/><br/>	
			<input type="submit" name="submit" value="Check Out">
  </div>
  <div id="tabs-2">
    <h2>Enter Payment Details</h2>

  </div>
  
  </form>	
</div>

</body>
</html>
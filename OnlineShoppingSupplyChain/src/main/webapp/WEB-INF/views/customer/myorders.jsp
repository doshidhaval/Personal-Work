<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script>
  $(function() {
    $( "#accordion" ).accordion({
      collapsible: true
    });
  });
  </script>
</head>

<body>

    <div id="accordion">
				<c:forEach var="element" items="${requestScope.orderList}">
					<form method="post" action="confirmDelivery.htm">
				  <h3>Customer Order ID : ${element.id}</h3>
				  <div>
				    		<input type = "hidden" value="${element.id}" name="order">
				    		<table align="center" border="2px" >
								<tr>
									<th width="100px">Customer Order ID</th>
									<th width="100px">Customer</th>
									<th width="100px">Status</th>
									<th width="100px">Total Cost</th>
								</tr>				
								<tr>
									<td align="center">${element.id} </td>
									<td align="center">${element.person.fname}</td>
									<td align="center">${element.status}</td>
									<td align="center">${element.cost}</td>
								</tr>
							</table>	<br/><br/>
						<input type="submit" name="submit" value="View Details">
						<input type="submit" name="submit" value="Confirm Delivery">
						
				  </div>
				    </form>
				</c:forEach>  
			<br/><br/>	
  	</div>

</body>
</html>
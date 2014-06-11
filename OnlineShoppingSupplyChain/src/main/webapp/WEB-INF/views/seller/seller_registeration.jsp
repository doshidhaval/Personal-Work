<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
 <script>
  $(function() {
    $( "#accordion" ).accordion({
      collapsible: true
    });
  });
  </script>
</head>

<body>
	
	<h1>Seller Registeration Form</h1>	
<div  class="form" style=" margin-top:40pt; border-radius: 40px;">
<form id="contactform" method="Post" action="submit_seller_reg.htm">
	<p style="color: red">${requestScope.message}</p></br></br>
	 <div id="accordion">

            <h3>Enter ADMIN Details</h3>
            <div>
                <p class="contact"><label for="name">First Name</label></p>
                <input id="name" name="fname" placeholder="First name" required tabindex="1" type="text"><br><br>
                
                <p class="contact"><label for="name">Last Name</label></p>
                <input id="name" name="lname" placeholder="Last name" required tabindex="2" type="text">
                
            </div>
            <h3>Enter Manufacturer Details</h3>
            <div>
                <p class="contact"><label for="name">Manufacturer Name</label></p>
                <input id="name" name="mname" placeholder="Manufacturer name" required tabindex="3" type="text"><br><br>
                
                <p class="contact"><label for="email">Email</label></p>
                <input id="email" name="email" placeholder="example@domain.com" required type="email" tabindex="4"><br><br>
                
                <p class="contact"><label for="phone">Mobile phone</label></p>
            	<input id="phone" name="phone" placeholder="phone number" required type="tel" tabindex="5"> 
            </div>
              
             <h3>Enter User Account Details</h3>
            <div>   
                <p class="contact"><label for="username">Create a user name</label></p>
                <input id="username" name="username" placeholder="Enter Username" required tabindex="4" type="text"><br><br>
                
                <p class="contact"><label for="password">Create a password</label></p>
                <input type="password" id="password" name="password" required placeholder="Enter Password"><br><br>
               
			</div>
            <h3>Enter Manufacturer Address</h3>
            <div> 
                  <p class="contact"><label for="repassword">Street1</label></p>
                <input type="text"  name="street1" required type="text" required placeholder="Enter Street 1"><br>
                
                <p class="contact"><label for="repassword">Street2</label></p>
                <input type="text"  name="street2" required type="text" required placeholder="Enter Street 2"><br>
                
                <p class="contact"><label for="repassword">City</label></p>
                <input type="text"  name="city" required type="text" required placeholder="Enter City"><br>
                
                <p class="contact"><label for="repassword">State</label></p>
                <input type="text"  name="state" required type="text" required placeholder="Enter State"><br>
                
                <p class="contact"><label for="repassword">Country</label></p>
                <input type="text"  name="country" required type="text" required placeholder="Enter Country"><br>
                
                <p class="contact"><label for="repassword">Zip code</label></p>
                <input type="text"  name="zip" required type="text" required placeholder="Enter Zip Code" maxlength="5"><br>
              </div>
			<br>
                      
         
            </div>   
     		<input class="buttom" name="submit" id ="submit" tabindex="5" value="Sign me up!" type="submit" >
             </form>
   
</div>

</body>
</html>
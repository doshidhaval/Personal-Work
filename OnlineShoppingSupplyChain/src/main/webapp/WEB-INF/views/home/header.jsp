<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="${pageContext.request.contextPath}/resources/webtools_resources/modal_header.css" rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Bubblegum+Sans & effect=shadow-multiple | 3d-float' rel='stylesheet' type='text/css'>
<img src="http://www.clipular.com/c?4701021=GOdATX1FDSHRvWR4T7i2FyT-u-Q&f=.png" style="float:left; margin:5pt">


<div style="float:left; margin:10pt; font-family: 'Bubblegum Sans', cursive; font-size: 55px" >Local Grocer</div>
	<div style="margin:10pt; float: right; ">
		<form id="contactform" method="Post" action="signIn.htm" >
		
			<c:if test="${!empty sessionScope.loggedUser.username}">
					<label for="username">User Name</label>
                	<input id="username" name="username" placeholder="username" required tabindex="1" type="text"size= 15 value="${sessionScope.loggedUser.username}"><br><br>
			</c:if>
			<c:if test="${empty sessionScope.loggedUser.username}">
					<label for="username">User Name</label>
                	<input id="username" name="username" placeholder="username" required tabindex="1" type="text"size= 15><br><br>
			</c:if>
			
			<c:if test="${!empty sessionScope.loggedUser.password}">
					<label for="password">Password  :</label>
                	<input type="password" id="password" placeholder="password" name="password" required type="text" size= 15 value="${sessionScope.loggedUser.password}"><br><br>
			</c:if>
			<c:if test="${empty sessionScope.loggedUser.password}">
					<label for="password">Password  :</label>
                	<input type="password" id="password" placeholder="password" name="password" required type="text" size= 15><br><br>
			</c:if>
					
                <input class="buttom" name="submit" id ="submit" tabindex="1" value="Log In" type="submit" style="float: right; margin-right: 15pt" >  
         </form>
      </div>
    
   <div id="openModal" class="modalDialog">
	<div>
		<a href="#close" title="Close" class="close">X</a>
		  <div  class="form">
            <form id="contactform" method="Post" action="signUp.htm" >
            
                <p ><label for="name">First Name</label></p>
                <input  name="name" placeholder="First name" required tabindex="1" type="text"/><br>
                
                <p ><label for="name">Last Name</label></p>
                <input  name="name" placeholder="Last name" required tabindex="1" type="text"/><br>
               
                <p><label for="email">Email</label></p>
                <input name="email" placeholder="example@domain.com" required /><br>
                
                <p class="contact"><label for="phone">Mobile phone</label></p>
            	<input id="phone" name="phone" placeholder="phone number" required type="tel" tabindex="5"> 
                
                <p class="contact"><label for="username">Create a username</label></p>
                <input name="username" placeholder="username" required tabindex="2" type="text"/>
                             
                <p class="contact"><label for="password">Create a password</label></p>
                <input type="password" id="password" required />
                
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
                <input type="text"  name="zip" required type="text" required placeholder="Enter Zip Code" maxlength="5"><br><br>
            <input class="buttom" name="submit" id ="submit" tabindex="5" value="Sign me up!" type="submit">   
   </form>
   </div>
   </div>
	</div>


<nav>
  <ul>
    <li><a href="home.htm">Home</a></li>
    <li><a href="#openModal">New User?</a></li>
  </ul>
</nav>

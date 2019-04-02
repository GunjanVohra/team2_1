<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/forgotpass.css">
<meta charset="ISO-8859-1">
<title>CapBook</title>
</head>
<body>
<div class="login-page">
 <div class="form">
  <form class="login-form" action="forgotPasswordSecurity" method="post" >
   <p><strong>Enter email id</strong></p><input type="text" placeholder="Email id" name="emailId" data-type="emailId"
						pattern="^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$"
						title="Must maintain the syntax : someone@email.com"
						required="required"/> <br> 
   	 <font color="red"><button	type="submit" name="submit" >Submit</button></font>
   	</form>
   <form class="login-form" action="forgotPassword" method="post" >

	<input type="hidden" name="emailId" value="${requestScope.user.emailId}" readonly="readonly"><br>
			<p><strong>Security Question:</strong></p> <input type="text" value="${requestScope.user.securityQues}" readonly="readonly"><br>
  <p><strong>Enter Security Answer</strong></p><input type="text" placeholder="Security Answer" name="securityAnswer" required="required"/>
  	<button	type="submit" name="submit" >Verify </button> 
  
</form>
   <p><strong>Your Password :</strong><input type="text" value="${requestScope.password}" readonly="readonly">
   <a href="/">Login</a>
 </div>
</div>
</body>
</html>
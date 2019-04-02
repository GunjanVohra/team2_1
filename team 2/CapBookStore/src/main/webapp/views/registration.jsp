<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<link type="text/css" rel="stylesheet" href="resources/js/main.js" />
<title>Capbook.com</title>
<style>
body {
	height: 750px;
}

.fb-header-base {
	width: 100%;
	height: 90px;
	position: absolute;
	top: 0;
	left: 0;
	color: red;
	z-index: 7;
	font-family: verdana;
	-webkit-box-shadow: 0 3px 8px rgba(0, 0, 0, .25);
}

.fb-header {
	width: 100%;
	height: 90px;
	position: absolute;
	background: #FF5B33;
	top: 0;
	left: 0;
	color: white;
	z-index: 7;
	font-family: verdana;
}

#img1 {
	left: 100px;
	height: 5px;
	width: 10px;
	top: 10px;
}

#form1 {
	left: 750px;
	height: 60px;
	width: 180px;
	top: 20px;
	font-family: verdana;
	font-size: 12px;
}

#form2 {
	left: 940px;
	height: 60px;
	width: 250px;
	top: 20px;
	font-family: verdana;
	font-size: 12px;
}

.submit1 {
	left: 1130px;
	top: 35px;
	background: #5b7bc0;
	color: white;
	position: fixed;
	z-index: 20;
	height: 22px;
	width: 50px;
	cursor: pointer;
}

.fb-body {
	position: absolute;
	left: 0px;
	top: 90px;
	width: 100%;
	height: 645px;
}

#intro1 {
	left: 178px;
	top: 20px;
	font-family: verdana;
	font-size: 20px;
	color: #142170;
	height: 75px;
	width: 550px;
}

#intro2 {
	left: 750px;
	top: 20px;
	font-family: verdana;
	font-size: 30px;
	color: #000;
	font-weight: bold;
	height: 75px;
	width: 500px;
}

#img2 {
	top: 130px;
	left: 178px;
	width: 450px;
	height: 200px;
}

#intro3 {
	left: 750px;
	top: 70px;
	font-family: verdana;
	font-size: 18px;
	color: #000;
	height: 50px;
	width: 300px;
}

#form3 {
	top: 120px;
	left: 750px;
	font-family: verdana;
	font-size: 20px;
	color: #142170;
	width: 450px;
	height: 495px;
}

#namebox {
	width: 200px;
	height: 40px;
	border-radius: 5px 5px 5px 5px;
	background: white;
	padding: 10px;
	font-size: 18px;
	margin-top: 8px;
	border-width: 1px;
	border-style: solid;
	border-color: gray;
}

#mailbox {
	width: 408px;
	height: 40px;
	border-radius: 5px 5px 5px 5px;
	background: white;
	padding: 10px;
	font-size: 18px;
	margin-top: 8px;
	border-width: 1px;
	border-style: solid;
	border-color: gray;
}

#r-b {
	font-size: 12px;
	height: 15px;
	width: 15px;
}

.button2 {
	width: 250px;
	height: 40px;
	left: 750px;
	top: 625px;
	background: green;
	font-family: verdana;
	font-size: 18px;
	color: white;
	border-radius: 5px 5px 5px 5px;
	border-width: 1px;
	border-style: solid;
	border-color: gray;
	cursor: pointer;
	outline: none;
}

#intro4 {
	font-family: verdana;
	font-size: 12px;
	color: gray;
}

#intro5 {
	font-family: verdana;
	font-size: 14px;
	color: gray;
}

.fb-body-footer {
	width: 100%;
	position: absolute;
	left: 0px;
	height: 80px;
	background: white;
	top: 700px;
}

#fb-body-footer-base {
	width: 900px;
	top: 15px;
	left: 200px;
	color: blue;
	height: 60px;
}
</style>
<body>
	<div class="fb-header-base">
		<form action="login" method="post" id="loginForm"
			onsubmit="return formValidation() &&userid_validation()&&passid_validation()">
			<div class="fb-header">
				<div id="img1" class="fb-header">
					<img src="cbLogo.jpg" />
				</div>
				<div id="form1" class="fb-header">
					Email or Phone<br> <input placeholder="Email" type="text"
						name="emailId" 
						data-type="emailId"
						pattern="^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$"
						title="Must maintain the syntax : someone@email.com"
						required="required"/> <br> <input type="checkbox" />	
						keep me
					logged in
				</div>
				<div id="form2" class="fb-header">
					Password<br> <input placeholder="Password" type="password"
						name="password" data-type="password"
						pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
						title="Must contain
							at least one number and one uppercase and lowercase letter, and
							at least 8 or more characters"
						required="required" /><br>
						 <a href="forgotPasswordPage">Forgotten
						your password?</a>

				</div>
			</div>
	

	<input type="submit" class="submit1" value="login" />
	</form>
	</div>
	</div>
	<div class="fb-body">
		<div id="intro1" class="fb-body">
			Capbook helps you connect and share with the <br> people in your
			life.
		</div>
		<div id="intro2" class="fb-body">Create an account</div>
		<div id="img2" class="fb-body">
			<img src="background.jpg" />
		</div>
		<div id="intro3" class="fb-body">It's free and always will be.</div>
		<div id="form3" class="fb-body">
			<table>
				<form:form action="registrationForm" method="post"
					modelAttribute="user">
					<tr>
						<td>First Name</td>
						<td><input type="text" name="firstName" id="namebox" /></td>
					</tr>
					<tr>
						<td>Last Name</td>
						<td><input type="text" name="lastName" id="namebox" /></td>

					</tr>
					<tr>
						<td>Date Of Birth</td>
						<td><input type="date" name="dob" size="30" id="namebox" /></td>

					</tr>
					<tr>
						<td>Gender</td>
						<td>Male<input type="radio" id="r-b" name="gender"
							value="male"></td>
						<td>Female<input type="radio" id="r-b" name="gender"
							value="female">
						</td>
					</tr>
					<tr>
						<td>EmailId</td>
						<td><input placeholder="Email" type="email" name="emailId" size="30" data-type="emailId"
						pattern="^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$"
						title="Must maintain the syntax : someone@email.com"
						required="required" id="mailbox" /></td>

					</tr>
					<tr>
						<td>Password</td>
						<td><input placeholder="Password" type="password" name="password" size="30" data-type="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
						title="Must contain
							at least one number and one uppercase and lowercase letter, and
							at least 8 or more characters"
						required="required" 
							id="mailbox" /></td>
					</tr>
					<tr>
						<td>City</td>
						<td><form:input path="address.city" size="30" id="namebox" /></td>
					</tr>
					<tr>
						<td>State</td>
						<td><form:input path="address.state" size="30" id="namebox" /></td>
					</tr>
					<tr>
						<td>Country</td>
						<td><form:input path="address.country" size="30" id="namebox" /></td>
					</tr>
					<tr>
						<td>ZipCode:</td>
						<td><form:input path="address.zipCode" size="30" id="namebox" /></td>
					</tr>
					<tr>
						<td>Security Ques</td>
						<td><select name="securityQues" id="namebox">
								<option value="Your School Name">Your School Name</option>
								<option value="Your NickName">Your NickName</option>
								<option value="Your Birth Place">Your Birth Place</option>
						</select></td>
					</tr>
					<tr>
						<td>Security Ques Answer</td>
						<td><form:input path="securityAnswer" size="30" id="namebox" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Submit" />
					</tr>
					<tr>
						<td>||HOME||<a href="/"></a></td>
					</tr>
				</form:form>
			</table>
			<br>
			<hr>


		</div>

	</div>
</body>

</html>
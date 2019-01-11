<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>


<link rel=stylesheet HREF="<%=request.getContextPath()%>/css/Style.css"
	type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/register.js"></script>

</head>

<body>

	<div class="logo" style="margin-top: 2%; margin-left:10px;">
		<img src="<%=request.getContextPath()%>/images/final.jpg"
			alt="Smart Trader" height="100px" width="25%" align="top">
	</div>


	<div class="loginbox" style="margin-top: 5%;">
		<form action="<%=request.getContextPath()%>/RegistrationController" method="post" name="register" onsubmit='return validateForm()'>
			<fieldset style="display: block;" id="p1">

				<select name="title">
					<option value="Mr." selected>Mr.</option>
					<option value="Ms.">Ms.</option>
					<option value="Mrs.">Mrs.</option>
					<option value="Dr.">Dr.</option>
				</select> 
				<br> 
				First Name: <input type="text" id="fn"  placeholder="First Name" name="firstName" onkeypress='return event.charCode == 08 || (event.charCode >= 65 && event.charCode <= 90)||(event.charCode >= 97 && event.charCode <= 122)||(event.charCode == 32)'/> 
				<!-- <span id="ea1" style="color: Red; display: none">*Input alphabet (A-Z or a-z)</span>  -->
				<br> 
				Last Name:<input type="text" id="ln" name="lastName"  placeholder="Last Name" onkeypress='return event.charCode == 08 || (event.charCode >= 65 && event.charCode <= 90)||(event.charCode >= 97 && event.charCode <= 122)||(event.charCode == 32)' data-validate-length-range="10"/> 
				<!--  <span id="ea2" style="color: Red; display: none">*Input alphabet (A-Z or a-z)</span> -->
				<br> 
				Date of Birth: <input type="date" required placeholder="Date Of Birth" name="dob"/> 
				<!-- <span id="ed1" style="color: Red; display: none">*Invalid Date</span> -->
				Gender: <input type="radio" name="gender" value="male" />Male &nbsp;&nbsp;&nbsp;
				<input type="radio" name="gender" value="female" />Female
				<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
				Country : <select name="country" required>
					<option value="Select">Select</option>
					<option value="India">India</option>
					<option value="Cuba">Cuba</option>
					<option value="China">China</option>
					<option value="Nepal">Nepal</option>
					<option value="Russia">Russia</option>
				</select>
				<br> 
				Phone Number: <input type="number" id="mn" placeholder="Mobile number" name="phoneNumber" onkeypress='return event.charCode == 08 || (event.charCode >= 48 && event.charCode <= 57)||event.charCode == 32)' data-validate-pattern="numeric" /> 
				<!-- <span id="en2" style="color: Red; display: none">*Input digits (0 - 9)</span>
				<span id="el2" style="color: Red; display: none">*Input 13 digits only</span> -->
				<br> 
				Email:<br><input type="text" id="em" placeholder="E-mail" name="email" /> 
				<!-- <span id="ee1" style="color: Red; display: none">*Enter valid E-mail</span>  -->
				<br> 
				Confirm Email:<input type="text" id="ce" placeholder="Confirm E-mail" name="confirmEmail" data-validate-linked="email" /> 
				<!-- <span id="ee2" style="color: Red; display: none">*Enter valid E-mail</span> -->
				<br>
				<!-- <input type="submit" id="loginb" value="Next" style="margin-left: 37%"> -->
				<br> <br>
			<!-- </fieldset>
				</form>
			<form action="RegistrationController" method="post" name="Form" onsubmit='return myFunc()'>
			<fieldset id="p2" style="display: none"> -->
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
				
				Bank : <select name="country" required>
					<option value="Select">Select</option>
					<option value="India">HDFC</option>
					<option value="Cuba">ICICI</option>
					<option value="China">SBI</option>
					<option value="Nepal">BOB</option>
					<option value="Russia">Axis</option>
				</select>
				<br>
				Bank Account Number: <input type="number" id="an" placeholder="Account number" name="accountNumber" onkeypress='return event.charCode == 08 || (event.charCode >= 48 && event.charCode <= 57)||event.charCode == 32)' data-validate-pattern="numeric" /> 
				<br>
				Username:<input type="text" id="us" placeholder="Username" name="userName"/><br>
				Password:<input type="password" placeholder="Password" id="password" name="password" data-validate-length="8" /> 
				<!-- <span id="ep1" style="color: Red; display: none">*Enter Correct Password</span> -->
				<br>
				Confirm Password:<input id="cp" type="password" placeholder="Confirm Password" name="confirmPassword" data-validate-linked="password" /> 
				<!-- <span id="ep2" style="color: Red; display: none">*Password does not match</span> -->
				<br> 
				Secret Question :
				<p class="contact">
					<label for="que1">First School name?</label>
				</p>
				<input type="text" required placeholder="Your Answer" name="secretAnswer" /><br>

				<p style="color: #ff1a1a">
					<input type="checkbox" name="confirmage" value="" required>&nbsp;I
					confirm that I am over 18 years of age.
				<p>
					<br>
				<p style="margin-left: 30%">
<!-- 					<input type="button" id="loginb" value="Prev" onclick="prev()"> -->
					<input type="submit" id="loginb" value="Register"><br>
					<br>
				</p>

			</fieldset>
	</form>

	</div>

</body>
</html>
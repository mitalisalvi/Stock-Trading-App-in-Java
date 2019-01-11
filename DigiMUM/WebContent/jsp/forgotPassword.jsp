<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/Style.css">
</head>
<body>
	<div class="logo" style="margin-top: 2%; margin-left:"10px;"">
		<img src="<%=request.getContextPath() %>/images/final.jpg" alt="Smart Trader" height="100px"
			width="25%" align="top">
	</div>

	<div class="loginbox" style="margin-top: 5%">

		<fieldset style="display: inline;" id="login">
			<form action="<%=request.getContextPath()%>/ForgotPasswordController" method="post">
				<p class="contact">
					<label for="user">Username:</label>
				</p>
				<input type="text" id="user" name="userName" required
					placeholder="Username" />
				<p>Secret Question: First School Name?</p>
				<input type="text" name="secretAnswer" required
					placeholder="Your Answer" onpaste="return false"
					ondrop="return false" /><br>
				<p class="contact">
					<label for="pass">New Password:</label>
				</p>
				<br> <input type="password" name="password" required
					onpaste="return false" ondrop="return false"
					placeholder="New Password" /><br>
				<p class="contact">
					<label for="cpass">Confirm Password:</label>
				</p>
				<br> <input type="password" name="confirmPassword" required
					onpaste="return false" ondrop="return false"
					placeholder="Confirm Password" /><br>
				<center>
					<input type="Submit" value="Change Password" id="loginb">
				</center>
			</form>
			<br> <br>
		</fieldset>
	</div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>


<LINK REL=StyleSheet HREF="<%=request.getContextPath()%>/css/Style.css" TYPE="text/css">
</head>
<body>




<div class="logo" style="margin-top:2%; margin-left:"10px;"">
	<img src ="<%=request.getContextPath()%>/images/final.jpg" alt="Smart Trader" height="100px" width="25%" align="top">
</div>

<div class="loginbox" style="margin-top:5%">

<%if(request.getParameter("msg")!=null&&request.getParameter("msg")!="")
	{%>
		<span style="color:red" >Invalid UserName or Password. Please Try Again</span>
	<%
		request.setAttribute("msg","");
	}%>
 
<fieldset style=" display:inline;" id="login">


	<form action="<%=request.getContextPath() %>/LoginController" method="post" >	
	<p class="contact"><label for="user">Username</label></p> 
	<input type="text" id="user" name="userName" autofocus required placeholder="Username"/>
	<p class="contact"><label for="pass">Password</label></p> 
	<input type="password" id="password" name="password"  required placeholder="Password"/><br>
	<a href="<%=request.getContextPath()%>/jsp/forgotPassword.jsp" style="color:Red;">Forgot Password?</a><br><br>
	<input type="Submit" value="Login" id="loginb">	
	<p style="color:white"> Not a member?&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/jsp/register.jsp"  id="register" style="color:Green;">Sign up!</a></p>
</form>
<br><br>	
</fieldset>


</div>      
</div>


</body>
</html>
<%String pth=request.getContextPath();%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Set Alerts</title>
<link rel="stylesheet" type="text/css" href="<%=pth%>/css/alert.css">
</head>
<body>
<div id="wrapper">
		<div id="header">
			<div class="logo">&nbsp;</div>
			</div>
<div id="mainbody">
	
	<br>
	
		<p id="head">SET ALERTS :<p>
		<br>
		<form action="<%=pth%>/SetAlertController" method="post">
		<table>
			<tr>
			<td id="title"> Select Condition : </td>
			<td><select name="condition">
					<option value="more" selected>More than</option>
					<option value="less">Less than</option>
					
				</select> </td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			
			<tr>
			<td id="title"> Price : </td>
			<td><input type="text" name="price" /></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			
		</table>
		<input id="loginb" type="submit" value="Submit" onclick="window.close()"/>
		</form>
	   
	</div>
	</div>
	</body>
	</html>
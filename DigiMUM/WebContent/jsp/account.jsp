<%String pth = request.getContextPath(); %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Statement</title>
<link rel="stylesheet" type="text/css" href="<%=pth%>/css/profile.css">
<%
        try
	    {
             response.setHeader("Cache-Control","no-cache");
             response.setHeader("Cache-Control","no-store");
             response.setHeader("Pragma","no-cache");
             response.setDateHeader ("Expires",0);
             
             if(session.getAttribute("customer")==null)
             {
                response.sendRedirect("login.jsp");
             }
        }
         
		catch(Exception ex)
        { 
			out.println(ex);
		}
%>


</head>
<body>

	<div id="wrapper">
		<div id="header">
			<div class="logo">&nbsp;</div>
			<div id="pop">
				<a href="<%=pth%>/ViewUpdateController?selection=view" style="color: black; font-weight: bold;">My Profile</a>&nbsp; | &nbsp; <a
					href="<%=pth %>/jsp/contactUs.jsp"
					style="color: black; font-weight: bold;">Contact Us</a>&nbsp; | &nbsp;
			</div>
			<div class="logout">
				<a href="<%=pth%>/LogoutController"></a>
			</div>


		</div>
		<div id="topnavi">
			<ul>
				<li class="select"><a href="<%=pth%>/jsp/home.jsp">HOME</a></li>
					<li class="norm"><a href="<%=pth%>/ViewMarketController">MARKET</a></li>
				<li class="norm"><a href="#">PRODUCTS</a></li>
				<li class="norm"><a href="<%=pth%>/ViewWatchListController?markettype=NSE">WATCHLIST</a></li>
				<li class="norm"><a href="<%=pth%>/ViewAlertController">VIEW ALERTS</a></li>
				<li class="norm"><a href="<%=pth%>/jsp/whyUs.jsp">WHY US ?</a></li>

			</ul>
		</div>

		<div id="aside">

			<div id="profnavi">
				<img src="<%=pth%>/images/pic.jpg" alt="Profile Pic" style="width: 138px;">

			</div>
			<div id="subnavi">
				<ul>
					<li class="norm"><a href="<%=pth%>/jsp/update.jsp">Update Profile</a></li>
					<li class="norm"><a href="<%=pth%>/jsp/changePass.jsp">Change Password</a></li>
					<li class="norm"><a href="<%=pth%>/jsp/fundTransfer.jsp">Fund Transfer</a></li>
					<li class="norm"><a href="<%=pth%>/jsp/account.jsp">Account Statement</a></li>
					<li class="norm"><a href="<%=pth%>/jsp/openPosition.jsp">Open Position</a></li>
				</ul>
			</div>
		</div>   
	   
	   
	   	<div id="mainbody">
	
	<br>
	
		<p id="head">Account Statement :<p>
		<br>
		<form action="<%=pth%>/AccountStatementController" method="post">
		<table>
			<tr>
			<td id="title"> From Date : </td>
			<td><input type="date" placeholder="MM/DD/YYYY" name="fDate" onfocus="(this.type='date')"/></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			
			<tr>
			<td id="title"> To Date : </td>
			<td><input type="date" placeholder="MM/DD/YYYY" name="tDate" onfocus="(this.type='date')"/></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			
			<tr>
			<td></td>
			<td></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			
		</table>
		<input id="loginb" type="submit" value="Submit" />
		</form>
	   
	   
	   
	</div>
   </div>
<div id="footer">
<img src="<%=pth %>/images/dunya.jpg" alt="MumbaMinions"  width="100%" height="200">
				<p>Copyright @2016<br>
				Site designed by MumbaMinions</p>
			</div>
</body>
</html>
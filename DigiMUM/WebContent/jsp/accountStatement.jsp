
<%
	String pth = request.getContextPath();
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.Bean.AccountStatement"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Statement</title>
<link rel="stylesheet" type="text/css" href="<%=pth%>/css/profile.css">
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<div class="logo">&nbsp;</div>
			<div id="pop">
				<a href="<%=pth %>/jsp/profile.jsp"
					style="color: black; font-weight: bold;">My Profile</a>&nbsp; | &nbsp; <a
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
				<li class="norm"><a href="<%=pth%>/jsp/market.jsp">MARKET</a></li>
				<li class="norm"><a href="#">PRODUCTS</a></li>
				<li class="norm"><a href="#">WATCHLIST</a></li>
				<li class="norm"><a href="#">VIEW ALERTS</a></li>
				<li class="norm"><a href="#">CONTACT US</a></li>

			</ul>
		</div>

		<div id="aside">

			<div id="profnavi">
				<img src="<%=request.getContextPath()%>/images/pic.jpg"
					alt="Profile Pic" style="width: 144px;">

			</div>
			<div id="subnavi">
				<ul>
					<li class="norm"><a href="<%=pth%>/jsp/update.jsp">Update
							Profile</a></li>
					<li class="norm"><a href="<%=pth%>/jsp/changePass.jsp">Change
							Password</a></li>
					<li class="norm"><a href="<%=pth%>/jsp/fundTransfer.jsp">Fund Transfer</a></li>
					<li class="norm"><a href="<%=pth%>/jsp/account.jsp">Account Statement</a></li>
					<li class="norm"><a href="<%=pth%>/jsp/openPosition.jsp">Open Position</a></li>
				</ul>
			</div>
		</div>
		<div id="mainbody">
	`	
			<br>
			<%
				HttpSession hs = request.getSession(false);
				AccountStatement acst = (AccountStatement)hs.getAttribute("accountStatement");
			%>
			 <p id="head">ACCOUNT STATEMENT :<p> 
				<table id="open">

					<tr>
						<th colspan="4">Current Balance :<%=acst.getCurrentBalance() %></th>
					</tr>
					
							<%if(acst.getTransactions().size()>0) 
				{
				%>
					<tr>
						<th>Transaction Id</th>
						<th>Stock Id</th>
						<th>Date</th>
						<th>Quantity</th>
						<th>Buy/Sell</th>
					</tr>
			<%
			for(int i=0;i<acst.getTransactions().size();i++)
			{
			%>
					<tr>
						<td><%=acst.getTransactions().get(i).getTransactionId() %></td>
						<td><%=acst.getTransactions().get(i).getStockId() %></td>
						<td><%=acst.getTransactions().get(i).getTimestampdate() %></td>
						<td><%=acst.getTransactions().get(i).getQuantity() %></td>
						<td><%=acst.getTransactions().get(i).getBuySell() %></td>
					</tr>
					<%}}else{ %>
					<tr><td>No Transactions available</td></tr>
					<%} %>
				</table>

		</div></div>
		<div id="footer">
<img src="<%=pth %>/images/dunya.jpg" alt="MumbaMinions"  width="100%" height="200">
				<p>Copyright @2016<br>
				Site designed by MumbaMinions</p>
			</div>
</body>
</html>
<%String pth = request.getContextPath();%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%=pth%>/css/watchlist.css">
<script type="text/javascript" src="<%=pth %>/js/alert.js"></script>
<title>Forex Watchlist</title>
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
<%@page import="java.util.*" %>
<%@page import="com.Bean.*" %>

<%
HttpSession hs=request.getSession(false);  
ArrayList<Watchlist> ars = (ArrayList<Watchlist>)hs.getAttribute("viewWatchList");  



%>


	
<div id="wrapper" >
<div id="header">
			<div class="logo">&nbsp;</div>
			<div id="pop">
				<a href="<%=pth%>/ViewUpdateController?selection=view"
					style="color: black; font-weight: bold;">My Profile</a>&nbsp; | &nbsp; <a
					href="<%=pth %>/jsp/contactUs.jsp"
					style="color: black; font-weight: bold;">Contact Us</a>&nbsp; | &nbsp;
			</div>
			<div class="logout">
				<a href="<%=pth%>/LogoutController"></a>
			</div>
			</div>
			
<div id="topnavi">
			<ul class="sub">
				<li class="select"><a href="<%=pth%>/jsp/home.jsp">HOME</a></li>
				<li class="norm" id="mdm"><a href="<%=pth%>/ViewMarketController" >MARKET</a></li>
				<li class="norm" id="mpp"><a href="#">PRODUCTS</a></li>
				<li class="norm"><a href="<%=pth%>/ViewWatchListController?markettype=NSE"">WATCHLIST</a></li>
				<li class="norm"><a href="<%=pth%>/ViewAlertController">VIEW ALERTS</a></li>
				<li class="norm"><a href="#">WHY US?</a></li>
				
			</ul>
		</div>
		

		
		<div id="mainbody">
		Select a Watchlist : <select name="watchlist" onChange= "window.location.href=this.value">
					<option value="<%=pth%>/ViewWatchListController?markettype=NSE">NSE Stocks Watchlist</option>
					<option value="<%=pth%>/ViewWatchListController?markettype=NASDAQ">Nasdaq Watchlist</option>
					<option value="<%=pth%>/ViewWatchListController?markettype=FOREX" selected>Forex Watchlist</option>
				</select>
				<br>
				<br>
			<div id="table">
			<br>
		<br>
		<%if(ars.size()!=0){ %>
			<p id="head">Forex Watchlist:</p>
			<table style="width: 100%" >
				<tr>
					<th>Name</th>
					<th>Forex Symbol</th>
					<th>Current Rate</th>
					<th>Buy Price</th>
					<th>Sell Price</th>
					
					<th></th>
					<th></th>
				</tr>

				<%

for( Watchlist cb :ars)
{%>
				<tr>
					<td><%=cb.getStockName() %></td>
					<td><b><%=cb.getStockSymbol() %></b></td>
					<td><b><%= cb.getCurrentPrice() %></b></td>
					<td><%= cb.getBuyingPrice()%></td>
					<td><%= cb.getSellingPrice() %></td>
					
					
						
					<td><a href="<%=pth%>/jsp/trade.jsp"><button id="loginb" type="button" name="stockSymbol" value="">Trade</button></a></td>
					<td><a href="<%=pth%>/SetAlert?stockSymbol=<%=cb.getStockSymbol().trim()%>"><button id="loginb" type="button" name="stockSymbol" value="">Set Alert</button></a></td>
				<td><a href="<%=pth%>/ViewWatchListController?markettype=<%=cb.getStockSymbol().trim()%>"><img style="height:15px; width:15px" src="<%=pth%>/images/delete.png"> </a></td>
				</tr>
					<%} %>
			</table>
				<%}else{
				%>
				<h3 style="color:white;text-align: center">No Data in watchList</h3>
				<%} %>
			}
		</div>
		</div>


	</div>
	<div id="footer" >
	<img src="<%=pth%>/images/dunya.jpg" alt="MumbaMinions"  width="100%" height="200">
				<p>Copyright @2016<br>
				Site designed by MumbaMinions</p>
	</div>

</body>
</html>
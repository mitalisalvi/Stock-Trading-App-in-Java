<% String pth = request.getContextPath(); %>
<%@page import="java.util.*" %>
<%@page import="com.Bean.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%=pth%>/css/marketTable.css">

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

<title>Home</title>
</head>
<body>
<img class="bg" src="<%=pth %>/images/globalmarket.jpg"/>
<%
HttpSession hs=request.getSession(false);  
ArrayList<Stock> ars = (ArrayList<Stock>)hs.getAttribute("viewList");  
%>
	
<div id="wrapper">
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
				
				
				<li class="select"><a href="<%=pth %>/jsp/home.jsp">HOME</a></li>
				<li class="norm"><a href="<%=pth %>/ViewMarketController">MARKET</a></li>
				<li class="norm"><a href="<%=pth %>/jsp/product.jsp">PRODUCTS</a></li>
				<li class="norm"><a href="<%=pth%>/ViewWatchListController?markettype=NSE">WATCHLIST</a></li>
				<li class="norm"><a href="<%=pth%>/ViewAlertController">VIEW ALERTS</a></li>
				<li class="norm"><a href="<%=pth%>/jsp/whyUs.jsp">WHY US ?</a></li>



			</ul>
		</div>
</div>

		
		<div id="mainbody">
		<br><br>
		&nbsp;&nbsp;&nbsp;Select Market : <select name="market" onChange= "window.location.href=this.value">
					<option value="<%=pth%>/ViewMarketController?markettype=NSE" selected>NSE</option>
					<option value="<%=pth%>/ViewMarketController?markettype=NASDAQ">NASDAQ</option>
					<%-- <option value="<%=pth%>/ViewMarketController?markettype=FOREX">FOREX</option> --%>
				</select>
		<br>
		<br>
		<div id="table">
			<table style="width: 100%" >
				<tr>
					<th>Name</th>
					<th>Current Price</th>
					<th>Last Closed</th>
					<th>Change</th>
					<th>Buying Price</th>
					<th>Selling Price</th>
					<th>52 weeks High</th>
					<th>52 weeks Low</th>
			<!-- 		<th>Market Type</th> -->
					<th></th>
				</tr>
				
				<%

for( Stock cb :ars)
{%>
				<tr>
					<td><%=cb.getStockName() %></td>
					<td><%= cb.getCurrentPrice()%></td>
					<td><%= cb.getLastChanged() %></td>
					<td><%= cb.getChange() %></td>
					
					<td><%= cb.getBuyingPrice() %></td>
					<td><%= cb.getSellingPrice() %></td>
					<td><%= cb.getHigh52()%></td>
					<td><%= cb.getLow52()%></td>
				<%-- 	<td><%=cb.getMarketType() %></td> --%>
					
					
					<td><a href="<%=pth %>/AddToWatchlistController?stockId=<%=cb.getStockId()%>"><button type="button" name="addToWl"   style="background-color:#ADEAEA;">Add To Watchlist</button></a></td>
					<%} %>
				</tr>
				
			
				
			</table>
		</div>
		

		</div>
		<div id="footer">
		<img src="<%=pth%>/images/dunya.jpg" alt="MumbaMinions"  width="100%" height="200">
				<p>Copyright @2016<br>
				Site designed by MumbaMinions</p></div>
</body>
</html>
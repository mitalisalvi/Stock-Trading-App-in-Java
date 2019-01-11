<% String pth = request.getContextPath(); %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.Bean.ViewAlert,java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Alerts</title>
<link rel="stylesheet" type="text/css" href="<%=pth%>/css/home.css">
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
<%
HttpSession hs=request.getSession(false);
ArrayList<ViewAlert> viewAlerts=(ArrayList<ViewAlert>)hs.getAttribute("viewAlerts");
%>			
<div id="topnavi">
			<ul class="sub">
				<li class="select"><a href="<%=pth%>/jsp/home.jsp">HOME</a></li>
				<li class="norm" id="mdm"><a href="<%=pth%>/ViewMarketController">MARKET</a></li>
				<li class="norm" id="mpp"><a href="#">PRODUCTS</a></li>
				<li class="norm"><a href="<%=pth%>/ViewWatchListController?markettype=NSE"">WATCHLIST</a></li>
				<li class="norm"><a href="<%=pth%>/ViewAlertController">VIEW ALERTS</a></li>
				<li class="norm"><a href="#">WHY US?</a></li>
				
			</ul>
		</div>
		<div id="mainbody">
		<%if(viewAlerts.size()!=0){ %>
			<div id="table">
			<p id="head">Alerts:</p>
			<table style="width: 100%" >
				<tr>
					<th>Stock Name</th>
					<th>Current Value</th>
					<th>Condition</th>
				</tr>
				<%for(int i=0;i<viewAlerts.size();i++){ %>
				<tr>
					<td><%=viewAlerts.get(i).getStockName()%></td>
					<td><b><%=viewAlerts.get(i).getCurrentPrice()%></b></td>
					<td><b><%if(viewAlerts.get(i).getSign()==1){ %>
					More than <%=viewAlerts.get(i).getPrice() %>
					<%} else{%>
					less than <%=viewAlerts.get(i).getPrice()%>
					<%} %>
					
					</b></td>
				</tr>
				<%} %>
			</table>
			<%}
		else{
		%>
		<h4>No alerts available</h4>
		<%} %>	
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
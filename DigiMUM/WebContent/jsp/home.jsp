<% String pth = request.getContextPath(); %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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

<title>Home</title>
</head>
<body>

	
<div id="wrapper">
		<div id="header">
			<div class="logo">&nbsp;</div>
			<div id="pop">
				<a href="<%=pth%>/ViewUpdateController?selection=view"
					style="color: black; font-weight: bold;">My Profile</a>&nbsp; | &nbsp; <a
					href="<%=pth%>/jsp/contactUs.jsp"
					style="color: black; font-weight: bold;">Contact Us</a>&nbsp; | &nbsp;
			</div>
			<div class="logout">
				<a href="<%=pth%>/LogoutController"></a>
			</div>
		</div>

		<div id="topnavi">
			<ul class="sub">
				<li class="select"><a href="<%=pth%>/jsp/home.jsp">HOME</a></li>
				<li class="norm"><a href="<%=pth%>/ViewMarketController">MARKET</a></li>
				<li class="norm"><a href="<%=pth %>/jsp/productbse.jsp">PRODUCTS</a></li>
				<li class="norm"><a href="<%=pth%>/ViewWatchListController?markettype=NSE">WATCHLIST</a></li>
				<li class="norm"><a href="<%=pth%>/ViewAlertController">VIEW ALERTS</a></li>
				<li class="norm"><a href="<%=pth%>/jsp/whyUs.jsp">WHY US ?</a></li>


			</ul>
		</div>


		
		<div id="mainbody">
		<div id="wel2" align="center">
				<img id="ol" src="<%=pth%>/images/final.jpg" style="width:300px; height:120px; align:center;;">

				<div id="x" style="text-align: center;">
					<b>Your Guide to a Financial Hub.</b>
				</div>
				<br>
				<div id="z">
					<img id="ol1" src="<%=pth%>/images/graph.jpg" style="width:500px; height:180px; background-color:black; align:center;"></div>
					<br>
					<div style="text-align: justify; font-family: Cambria; font-size: 20px">
					<div id="y" style="text-align: center;">The purpose of a stock market is to facilitate
						the exchange of securities between buyers and sellers, reducing
						the risks of investing. Just imagine how difficult it would be to
						sell shares if you had to call around the neighborhood trying to
						find a buyer. Really, a stock market is nothing more than a
						super-sophisticated farmers' market linking buyers and sellers.</div></div>
						</div>
						</div>
</div>
		<div id="footer" >
	<img src="<%=pth %>/images/dunya.jpg" alt="MumbaMinions"  width="100%" height="200">
				<p>Copyright @2016<br>
				Site designed by MumbaMinions</p>
	</div>

</body>
</html>
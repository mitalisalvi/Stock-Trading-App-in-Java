<% String pth = request.getContextPath(); %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/market.css">
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<div class="logo">&nbsp;</div>
			<div id="pop"><a href="../jsp/profile.jsp" style="color:black; font-weight:bold;">My Profile</a>&nbsp; | <a
					href="<%=pth%>/jsp/contactUs.jsp"
					style="color: black; font-weight: bold;">Contact Us</a>&nbsp; |</div>
			<div class="logout">
				<a href="https://www.google.co.in"></a>
			</div>
		
		<div id='cssmenu'>
			<ul>
				<li><a href="<%=pth%>/jsp/home.jsp">HOME</a></li>
				<li><a href="<%=pth%>/jsp/markettable.jsp">MARKETS</a></li>
				<li class='active has-sub'><a href='#'>PRODUCTS</a>
					<ul>
						<li class='has-sub'><a href="<%=pth%>/jsp/productbse.jsp">NSE-BSE INDICES</a>
							<!-- <ul>
								<li><a href='#'><span>NSE-BSE Indices</span></a></li>
								<li class='last'><a href='#'><span>US Indices</span></a></li>
								<li class='last'><a href='#'><span>UK Indices</span></a></li>
							</ul --></li>
						<li class='has-sub'><a href="<%=pth%>/jsp/productusi.jsp">NASDAQ INDICES </a>
							<!-- <ul>
								<li><a href='#'><span>Sub Product</span></a></li>
								<li class='last'><a href='#'><span>Sub Product</span></a></li>
							</ul> -->
							<li class='has-sub'><a href="<%=pth%>/jsp/productuki.jsp">FOREX INDICES </a>
							</li>
					</ul></li>
				<li><a href="<%=pth%>/jsp/stockWatchlist.jsp">WATCHLIST</a></li>
				<li class='last'><a href="<%=pth%>/jsp/viewAlerts.jsp">VIEW ALERTS</a></li>
				<li class='last'><a href="<%=pth%>/jsp/whyus.jsp">WHY US ?</a></li>
			</ul>
		</div>
</div>
		</div>
		<div id="mainbody">
		<fieldset>
		<div class="n1">
		<h1 style="text-decoration: underline; font-family: Cambria; ">BSE-NSE INDEX's : </h1>
		<p>
		<img src="../imgs/bullet.jpg" width="20px" height="15px" > An index is a mathematical construct, so it may not be invested in directly. But many mutual funds and exchange-traded funds attempt to "track" an index (see index fund), and those funds that do not may be judged against those that do.<br>
		<br>
		<img src="../imgs/bullet.jpg" width="20px" height="15px" > Stock market indices may be classed in many ways. A 'world' or 'global' stock market index includes (typically large) companies without regard for where they are domiciled or traded. Two examples are MSCI World and S/P Global 100.<br>
		<br>
		<img src="../imgs/bullet.jpg" width="20px" height="15px" > A 'national' index represents the performance of the stock market of a given nation—and by proxy, reflects investor sentiment on the state of its economy. The most regularly quoted market indices are national indices composed of the stocks of large companies listed on a nation's largest stock exchanges, such as the American S-P 500, the Japanese Nikkei 225, and the British FTSE 100.<br>
		<br>
		<img src="../imgs/bullet.jpg" width="20px" height="15px" > Other indices may be regional, such as the FTSE Developed Europe Index or the FTSE Developed Asia Pacific Index. Indexes may be based on exchange, such as the NASDAQ-100 or NYSE US 100, or groups of exchanges, such as the Euronext 100 or OMX Nordic 40.<br>
		<br>
		<img src="../imgs/bullet.jpg" width="20px" height="15px" >The concept may be extended well beyond an exchange. The Wilshire 5000 Index, the original total market index, represents the stocks of nearly every publicly traded company in the United States, including all U.S. stocks traded on the New York Stock Exchange (but not ADRs or limited partnerships), NASDAQ and American Stock Exchange.<br>
		<br>
		<img src="../imgs/bullet.jpg" width="20px" height="15px" >More specialized indices exist tracking the performance of specific sectors of the market. Some examples include the Wilshire US REIT which tracks more than 80 American real estate investment trusts and the Morgan Stanley Biotech Index which consists of 36 American firms in the biotechnology industry.
		</p>
		</div>
		</fieldset>
		</div>


	
	<div id="footer" >
	<img src="../imgs/dunya.jpg" alt="MumbaMinions"  width="100%" height="200">
				<p>Copyright @2016<br>
				Site designed by MumbaMinions</p>
	</div>

</body>
</html>
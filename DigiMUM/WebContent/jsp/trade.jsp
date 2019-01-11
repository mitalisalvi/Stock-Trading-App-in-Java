<% String pth = request.getContextPath(); %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trade</title>
<link rel="stylesheet" type="text/css" href="<%=pth%>/css/trade.css">
<script type="text/javascript" src="<%=pth %>/js/trade.js"></script>
</head>
<body>
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
				<a href="https://www.google.co.in"></a>
			</div>
			</div>
			
			<div id="rcorners">
			<!-- <ul>
				<li class="select">TRADE</li>
				<li class="norm"></li>
				</ul> -->
				TRADE
			</div>
			<div id="mainbody">
			<br>
			<div id="table1">
				<table width="63%" align="right">
					<tr>
						<td width=10px>
							<form>
								<input id="text1" type="text" value="18019.5">
								<br> <button type="button" id="button1" onclick="myfunc()">SELL</button>
							</form>
						</td>

						<td>
							<form>
								<input id="text1" type="text" value="18021.5">
								<br> <button id="button1" type="button"
									style="background-color: rgb(0, 65, 145);" onclick="myfunc()">BUY</button>
							</form>
						</td>
					</tr>
					<tr><td><br></td></tr>
					<tr><td><br></td></tr>
					<tr></tr>
					<tr></tr>
					<tr></tr>
				</table>
			</div>
			<div id="table2">
			<table width="70%" align="center"  cell-spacing="10">

				<tr height="44px">
					<th id="title">Stake:</th>
					<td><input id="stake_spin" type="number" min="1" max="200"
						step="1" value="1" /> <select>
							<option value="gbp">GBP</option>
							<option value="usd">US Dollars</option>
							<option value="euro">Euro</option>
							<option value="rupee">Indian Rupee</option>
							<option value="yen">Japanese Yen</option>
					</select></td>
				</tr>
				<tr><td><br></td></tr>
				<tr>
					<th id="title">Stop:</th>
					<td><form name="myForm1">
							<input id="stop_spin" type="number" min="1" max="200" step="1"
								placeholder="Pts Away"> <font color="white" size="4px">(</font><font color="red" size="4px">-</font><font color="white" size="4px">/</font><font color="#4169E1" size="4px">-</font><font color="white" size="4px">)</font>
						</form></td>
				</tr>
				<tr><td><br></td></tr>
				<tr>
					<td></td>
					<td id="stop"><input type="checkbox" name="gstop"
						value="guaranteed_stop">Guaranteed Stop<br> <input
						type="checkbox" name="ststop" value="trailing_stop">Set
						Trailing Stop</td>
				</tr>
				<tr><td><br></td></tr>
				<tr>
					<th id="title">Limit:</th>
					<td><form name="myForm2">
							<input id="limit_spin" type="number" min="1" max="200" step="1"
								placeholder="Pts Away"> <font color="white" size="4px">(</font><font color="red" size="4px">-</font><font color="white" size="4px">/</font><font color="#4169E1" size="4px">-</font><font color="white" size="4px">)</font>
						</form></td>
				</tr>
				<tr><td><br></td></tr>
			</table>
			</div>
				<p id="margin">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img src="<%=pth%>/images/important.jpg" width="22px" height="19px"> &nbsp; Margin required for
				trade: 200.00 GBP</p>
				<br>
				<br>
				<br>
				<center>
			<a href="<%=request.getContextPath()%>/jsp/home.jsp"><button type="button" id="loginb">BACK</button></a>
			</center>
			<br>
			<br>
			<br>
			</div>
	</div>
			<div id="footer">
			<img src="<%=pth %>/images/dunya.jpg" alt="MumbaMinions"  width="100%" height="200">
				<p>Copyright @2016<br>
				Site designed by MumbaMinions</p>
			</div>
		
</body> 
</html>
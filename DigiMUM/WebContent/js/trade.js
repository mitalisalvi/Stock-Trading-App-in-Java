function myfunc() {
		var x = document.forms["myForm1"]["stop_spin"].value;
		var y = document.forms["myForm2"]["limit_spin"].value;
		if (x != "" && y != "") {
			myWin = window
					.open(
							"tradeConfirmation.jsp",
							"_blank",
							"toolbar=yes, scrollbars=yes, resizable=yes, top=80, left=200, width=500, height=550");
		} else
			alert("Please select proper data in Stop bar");
	}
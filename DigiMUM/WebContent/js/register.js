	function validateForm() {
		var firstName = document.forms["register"]["firstName"].value;
		var lastName = document.forms["register"]["lastName"].value;
		var phoneNumber = document.forms["register"]["phoneNumber"].value;
		var email = document.forms["register"]["email"].value;
		var confirmEmail = document.forms["register"]["confirmEmail"].value;
		var accountNo = document.forms["register"]["accountNumber"].value;
		var userName = document.forms["register"]["userName"].value;
		var password = document.forms["register"]["password"].value;
		var confirmPassword = document.forms["register"]["confirmPassword"].value;
		
		
		var atpos = email.indexOf("@");
	    var dotpos = email.lastIndexOf(".");
	    var pass = "^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$";
	    var phoneno = /^\d{10}$/;
	    var acc = /^(?:[0-9]{11}|[0-9]{2}-[0-9]{3}-[0-9]{6})$/;
	    var mail = /\S+@\S+\.\S+/;
		
		var a=0;
		
		if(firstName=="" || firstName==null || firstName.length<3) {
			alert("Please Provide Applicant's First Name");
			document.getElementById("fn").innerHTML = "";
			return false;
		}
		if(lastName=="" || lastName==null || lastName.length<3) {
			alert("Please Provide Applicant's Last Name");
			document.getElementById("ln").innerHTML = "";
			return false;
		}
		if (phoneNumber == "" || phoneNumber==null || !phoneNumber.match(phoneno)) {
			alert("Please Provide Applicant's valid Mobile Number");
			document.getElementById("mn").innerHTML = "";
			return false;
		}
		if (email == "" || email==null || !email.match(mail)) {
			alert("Please Provide Applicant's valid Email ID");
			document.getElementById("em").innerHTML = "";
			return false;
		}
		if (!email.equals(confirmEmail)) {
			alert("Please Provide Applicant's valid Email ID");
			document.getElementById("ce").innerHTML = "";
			return false;
		}
		if(accountNo=="" || accountNo==null || !accountNo.match(acc)) {
			alert("Please Provide Applicant's valid Account Number");
			document.getElementById("an").innerHTML = "";
			return false;
		}
		if(userName=="" || userName==null) {
			alert("Please Provide Applicant's username");
			document.getElementById("us").innerHTML = "";
			return false;
		}
		if(password=="" || password==null || !password.match(pass)) {
			alert("Please Provide Applicant's password");
			document.getElementById("password").innerHTML = "";
			return false;
		}
		if(!password.equals(confirmPassword)) {
			alert("Fields do not match");
			document.getElementById("cp").innerHTML = "";
			return false;
		}
		return true;
	}
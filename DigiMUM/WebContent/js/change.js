function change() {
	var oldPassword = document.forms["register"]["oldPassword"].value;
	var newPassword = document.forms["register"]["newPassword"].value;
	var confirmPassword = document.forms["register"]["confirmPassword"].value;
	
	var pass = "^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$";
	
	if(oldPassword=="" || oldPassword==null)
	if(newPassword=="" || newPassword==null || !newPassword.match(pass)) {
		alert("Please Provide Applicant's password");
		//document.getElementById("password").innerHTML = "";
		return false;
	}
	if(!newPassword.equals(confirmPassword)) {
		alert("Fields do not match");
		//document.getElementById("cp").innerHTML = "";
		return false;
	}
	return true;
}
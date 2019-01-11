function change() {
	var oldPassword = document.forms["register"]["oldPassword"].value;
	var newPassword = document.forms["register"]["newPassword"].value;
	var confirmPassword = document.forms["register"]["confirmPassword"].value;
	var userName = document.forms["register"]["userName"].value;
	
	var pass = "^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$";
	if(userName=="" || userName==null) {
		alert("Please Provide Applicant's username");
		//document.getElementById("password").innerHTML = "";
		return false;
	}
	if(oldPassword=="" || oldPassword==null) {
		alert("Please Provide Applicant's old password");
		//document.getElementById("password").innerHTML = "";
		return false;
	}
	if(newPassword=="" || newPassword==null || !newPassword.match(pass)) {
		alert("Please Provide Applicant's new password");
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
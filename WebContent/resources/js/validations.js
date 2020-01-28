$(document).ready(function() {
	window.location.hash = "#";
	window.location.hash = "No-Back";
	window.onhashchange = function() {
		window.location.hash = "#";
	};
});

$(document).ready(function() {
	$("#myBtn").click(function() {
		$("#myModal").modal();
	});

	$("#myLogin").click(function() {
		$("#regModel").modal();
	});
});

function saveValidation() {
	var name = document.getElementById("usrname").value.trim();
	var psw = document.getElementById("psw").value.trim();

	if (name == "") {
		$("#errorMsg").show();
		document.getElementById("errorMsg").innerHTML = "Please enter User Name";
		document.getElementById("usrname").focus();
		return false;
	}
	if (psw == "") {
		$("#errorMsg").show();
		document.getElementById("errorMsg").innerHTML = "Please enter Password";
		document.getElementById("psw").focus();
		return false;
	}
	$("#errorMsg").hide();
	return true;

}

function regValidation() {

	var name = document.getElementById("rusrname").value.trim();
	var email = document.getElementById("remail").value.trim();
	var contact = document.getElementById("rcontact").value.trim();
	var psw1 = document.getElementById("rpsw1").value.trim();
	var psw2 = document.getElementById("rpsw2").value.trim();

	if (name == "") {
		$("#errorMsg1").show();
		document.getElementById("errorMsg1").innerHTML = "Please enter User Name";
		document.getElementById("rusrname").focus();
		return false;
	}

	if (email == "") {
		$("#errorMsg1").show();
		document.getElementById("errorMsg1").innerHTML = "Please enter Email";
		document.getElementById("remail").focus();
		return false;
	}
	if (email != "") {
		$("#errorMsg1").show();
		var atpos = email.indexOf("@");
		var dotpos = email.lastIndexOf(".");
		if (atpos < 1 || dotpos < atpos + 2 || dotpos + 3 > email.length) {
			document.getElementById("errorMsg1").innerHTML = "Please enter Valid Email";
			document.getElementById("remail").focus();
			return false;
		}

	}
	if (contact == "") {
		$("#errorMsg1").show();
		document.getElementById("errorMsg1").innerHTML = "Please enter Contact No";
		document.getElementById("rcontact").focus();
		return false;
	}

	if (contact != "") {
		$("#errorMsg1").show();
		var mob = /^[7-9]{1}[0-9]{9}$/;
		if (mob.test(contact) == false) {
			document.getElementById("errorMsg1").innerHTML = "Please enter Valid Contact No";
			document.getElementById("rcontact").focus();
			return false;

		}
	}
	if (psw1 == "" || psw2 == "" || psw1 != psw2) {
		$("#errorMsg1").show();
		document.getElementById("errorMsg1").innerHTML = "Both Password should be same or not empty";
		document.getElementById("rpsw1").focus();
		return false;
	}
	$("#errorMsg1").hide();
	return true;

}

function error() {
	$('#errorModal').modal('show');
}

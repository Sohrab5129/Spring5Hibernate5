function validateOS() {
	
	//var categoryId = document.getElementById("categoryId").value.trim();
	var osName = document.getElementById("osName").value.trim();
	$('#osAdded').hide();
	
	
	
/*	if (categoryId==-1) {
		document.getElementById("osValidationMsg").innerHTML = "Category should not empty!";
		$('#osValidationMsg').show();	
	
		return false;
	}*/
	if (osName=="") {
		document.getElementById("osValidationMsg").innerHTML = "At leat one OS type require!";
		$('#osValidationMsg').show();	

		return false;
	}
	
	$('#osValidationMsg').hide();
	
	return true;
}
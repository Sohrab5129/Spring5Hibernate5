function validateCategory() {
	
	var categoryName = document.getElementById("categoryName").value.trim();
	var osId = document.getElementById("osId").value.trim();
	
	$('#categoryAdded').hide();
	
	
	
	if (categoryName=="") {
		document.getElementById("categoryValidationMsg").innerHTML = "Category name should not empty!";
		$('#categoryValidationMsg').show();		
		return false;
	}
	if (osId==-1 || osId==null) {
		document.getElementById("categoryValidationMsg").innerHTML = "Please select at leat one OS type!";
		$('#categoryValidationMsg').show();	

		return false;
	}
	
	$('#categoryValidationMsg').hide();
	
	return true;
}
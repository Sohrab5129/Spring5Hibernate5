function validateBrand() {
	
	var brandName = document.getElementById("brandName").value.trim();
	var catId = document.getElementById("catId").value.trim();
	
	$('#brandAdded').hide();
	
	if (brandName=="") {
		document.getElementById("brandValidationMsg").innerHTML = "Brand name should not empty!";
		$('#brandValidationMsg').show();		
		return false;
	}
	if (catId==-1 || catId==null) {
		document.getElementById("brandValidationMsg").innerHTML = "Please select at leat one category type!";
		$('#brandValidationMsg').show();	

		return false;
	}
	
	$('#brandValidationMsg').hide();
	
	return true;
}
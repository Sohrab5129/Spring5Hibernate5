
function getListBrand() {
	
	document.getElementById('addProductButton').disabled = true;
	$('#messagesDiv').hide();	
	$('#addProductDiv').hide();
	$('#OSDiv').hide();
	$('#categoryDiv').hide();
	
	/*$('#productDiv').find('input:text').val('');*/
		
	/*document.getElementById('productDiv').reset();*/
	
	/*$('#productDiv').load(window.location.href + "#productDiv");*/
	
	/*$('#productDiv')[0].reset();*/
	
	var CONTEXT_PATH = window.location.pathname.substring(0,
			window.location.pathname.indexOf("/", 2));
	$.ajax({
		type : 'POST',
		header : { Accept : "application/json; charset=utf-8", "Content-Type" : "application/json; charset=utf-8"
		},
		url : CONTEXT_PATH + '/shop/listBrand',
		data : {
		},
		success : function(result) {
			obj = JSON.parse(result);
			var list = '<option value="-1" class="disabled" >SELECT BRAND</option>';
			for ( var key in obj) {
				if (key == "Brand") {
							for ( var k in obj[key]) {
								list += '<option value="' + k + '">'+ obj[key][k] + '</option>';
							}
					$('#brand').html(list);
				}
			}
			
			$('#addProductDiv').show();
			$('#brand').show();
			$('#OSDiv').hide();
			$('#categoryDiv').hide();
			$('#os').hide();
			$('#category').hide();
			$('#productDiv').hide();
			
		}
	});
	return true;
}

function getCategory(){
	var id = document.getElementById("brand").value.trim();
		
		if (id==-1) {
			$('#errorBrandMsg').show();
			$('#categoryDiv').hide();
			$('#OSDiv').hide();
			$('#productDiv').hide();
			return false;
		}			
		$('#errorBrandMsg').hide();
		
		
		var CONTEXT_PATH = window.location.pathname.substring(0,
				window.location.pathname.indexOf("/", 2));
		$.ajax({
			type : 'POST',
			header : { Accept : "application/json; charset=utf-8", "Content-Type" : "application/json; charset=utf-8"
			},
			url : CONTEXT_PATH + '/shop/listCategoryByBrandId',
			data : {
				id : id
			},
			success : function(result) {
				obj = JSON.parse(result);
				
				var list = '<option value="-1" class="disabled" >SELECT CATEGORY</option>';
				for ( var key in obj) {

								for ( var k in obj[key]) {
									list += '<option value="' + k + '">'+ obj[key][k] + '</option>';
								}
						$('#category').html(list);

				}
				$('#category').show();
				$('#categoryDiv').show();
				$('#errorCategoryMsg').hide();				
				$('#OSDiv').hide();				
				$('#os').hide();
				$('#productDiv').hide();
			}
		});
		return true;
}

function getCategoryOS() {
	
	var id = document.getElementById("category").value.trim();
	var brand = document.getElementById("brand").value.trim();
	
	if (id==-1) {
		$('#errorCategoryMsg').show();
		$('#OSDiv').hide();
		$('#productDiv').hide();
		return false;
	}
	$('#errorCategoryMsg').hide();
	var CONTEXT_PATH = window.location.pathname.substring(0,
			window.location.pathname.indexOf("/", 2));
	$.ajax({
		type : 'POST',
		header : { Accept : "application/json; charset=utf-8", "Content-Type" : "application/json; charset=utf-8"
		},
		url : CONTEXT_PATH + '/shop/listOSyByCategoryId',
		data : {
			brandId : brand,
			category_id : id
		},
		success : function(result) {
			obj = JSON.parse(result);
			
			var list = '<option value="-1" class="disabled" >SELECT OS TYPE</option>';
			for ( var key in obj) {

							for ( var k in obj[key]) {
								list += '<option value="' + k + '">'+ obj[key][k] + '</option>';
							}
					$('#os').html(list);

			}
			
			$('#OSDiv').show();
			$('#errorOSMsg').hide();
			$('#os').show();
			$('#productDiv').hide();
		}
	});
	return true;
}

function getProductList() {
	
	var id = document.getElementById("os").value.trim();
	if (id==-1) {
		$('#errorOSMsg').show();
		$('#productDiv').hide();
		return false;
	}
	$('#errorOSMsg').hide();
	$('#productDiv').show();
	/*$("#productDiv").load("ajax/shoppingCart.jsp");*/
	
}

function addProduct() {
	
	var brand = document.getElementById("brand").value.trim();
	var category = document.getElementById("category").value.trim();	
	var os = document.getElementById("os").value.trim();
	var productName = document.getElementById("productName").value.trim();
	var quantity = document.getElementById("quantity").value.trim();
	var productDescription = document.getElementById("productDescription").value.trim();
	
	var value=/^[0-9]/;
	
	if (productName=="") {
		document.getElementById("productError").innerHTML = "Product name should not empty!";
		$('#commomErrorMsg').show();	
		return false;
	}
	
	if (value.test(quantity)==false || quantity%1!=0) {
		document.getElementById("productError").innerHTML = "Insert valid number!";
		$('#commomErrorMsg').show();	
		return false;
	}
	
	if (productDescription=="") {
		document.getElementById("productError").innerHTML = "Description should not empty!";
		$('#commomErrorMsg').show();	
		return false;
	}
	$('#commomErrorMsg').hide();	
	
	var CONTEXT_PATH = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
	
	$.ajax({
		type : 'POST',
		header : { Accept : "application/json; charset=utf-8", "Content-Type" : "application/json; charset=utf-8"
		},
		url : CONTEXT_PATH + '/shop/addProduct',
		data : {
			brandId : brand,
			categoryId : category,
			osId : os,
			product_name : productName,
			total_quantity : quantity,
			product_description : productDescription
		},
		success : function(result) {
			obj = JSON.parse(result);
			
			$('#addProductDiv').hide();	
			$('#messagesDiv').show();	
			$('#addProductButton').hide();	
			
			document.getElementById('addProductButton').disabled = false;
					
			if (obj=="success") {
				
				$('#successMessage').show();
				
				return true;
			}else{
				$('#failMessage').show();	
				return false;
			}
		}
	});
	return true;
}
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SOHRAB</title>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> 

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">-->

<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">

<link href="<c:url value="/resources/css/boostrap3.4.0.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jQuery3.4.1.js"/>"></script>
<script src="<c:url value="/resources/js/boostrap3.4.0.js"/>"></script>

<!-- <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" /> -->

<link href="<c:url value="/resources/images/logo.png" />" rel="icon" type="image/png">


<!-- responsive datatable -->
<!-- <link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/fixedheader/3.1.3/css/fixedHeader.bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.2.1/css/responsive.bootstrap.min.css">

<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/fixedheader/3.1.3/js/dataTables.fixedHeader.min.js"></script>
<script src="https://cdn.datatables.net/responsive/2.2.1/js/dataTables.responsive.min.js"></script>
<script src="https://cdn.datatables.net/responsive/2.2.1/js/responsive.bootstrap.min.js"></script> -->

</head>
<body>
	<jsp:include page="menuHeader.jsp"></jsp:include>
	<%
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
	%>
	<%
		String name = null;
		HttpSession session1 = request.getSession(false);
		if (session1.getAttribute("userName") == name) {
	%>
	<jsp:forward page="index.jsp"></jsp:forward>
	<%
		}
	%>
	
 <div class="container">

   <div class="col-md-offset-0 col-md-12" id="messagesDiv" style="display: none;">
	   <div class="alert alert-success"  id="successMessage" style="display: none;">
	  		<strong>Successfully!</strong> added product.  		
		</div>
		
		<div class="alert alert-success"  id="failMessage" style="display: none;">
	  		<strong>Failed!</strong> please try again.
	  		<a href="${pageContext.request.contextPath}/shop/myShop" id="addNewProduct" name="addNewProduct" class="btn btn-info">Add new Product</a>
	  		
		</div>
		<a href="${pageContext.request.contextPath}/shop/myShop" class="btn btn-info">Go Back</a>
		
	</div>
 
  <div class="col-md-offset-0 col-md-4">
  <div class="panel-body">
	  
   	<div class="row">
			<div class="btn-group btn-group-justified">
				<div class="btn-group">					
					<a href="${pageContext.request.contextPath}/shop/addOS" id="addOS" name="addOS" class="btn btn-info">Add OS</a>			
				</div>
		</div>			
	</div>
	<br>
	<div class="row">
			<div class="btn-group btn-group-justified">
				<div class="btn-group">					
					<a href="${pageContext.request.contextPath}/shop/getOS" id="addCategory" name="addCategory" class="btn btn-info">Add Category</a>			
				</div>
		</div>			
	</div>
	<br>
	<div class="row">
			<div class="btn-group btn-group-justified">
				<div class="btn-group">					
					<a href="${pageContext.request.contextPath}/shop/getCategory" id="addBrand" name="addBrand" class="btn btn-info">Add Brand</a>			
				</div>
		</div>			
	</div>
	<br>
	<div class="row">
			<div class="btn-group btn-group-justified">
				<div class="btn-group">					
					<a href="${pageContext.request.contextPath}/shop/showSpringValidatedForm" class="btn btn-info">Spring Validated Form</a>			
				</div>
		</div>			
	</div>
	
	<br>
	<div class="row">
			<div class="btn-group btn-group-justified">
				<div class="btn-group">					
					<a href="${pageContext.request.contextPath}/register_user_account/getForm" class="btn btn-info">Spring Validator</a>			
				</div>
		</div>			
	</div>
	<br>
	<div class="row">
			<div class="btn-group btn-group-justified">
				<div class="btn-group">					
					<button type="button" class="btn btn-info" onclick="return getListBrand();" id="addProductButton">Add Product</button>				
				</div>
		</div>			
	</div>
	</div>
	<div class="panel-body">
	<div class="row">
	<!-- 		<div class="btn-group btn-group-justified">
				<div class="btn-group">					
					<button type="button" class="btn btn-primary" onclick="return getListBrand();" >Add Product</button>				
				</div>
		</div>	 -->		
	</div>
	</div>
  </div>
  

  
 <div class="col-md-offset-1 col-md-7" style="display: none;" id="addProductDiv">
   <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title">Add Product</div>
    </div>
    
    <div class="panel-body">
     <div class="alert alert-warning" style="display: none;" id="errorBrandMsg">
  		<strong>Please!</strong> select Brand name.
	</div>
     <select class="form-control" name="brand" id="brand" onchange="return getCategory();" style="display: none;">			
	</select>
	</div>
	 <div class="panel-body" id="categoryDiv">
	 <div class="alert alert-warning" style="display: none;" id="errorCategoryMsg">
  		<strong>Please!</strong> select Category name.
	</div>
	 <select class="form-control" name="category" id="category"  onchange="return getCategoryOS();" style="display: none;">
	 
	 </select>

    </div>
    
    <div class="panel-body" id="OSDiv">
	 <div class="alert alert-warning" style="display: none;" id="errorOSMsg">
  		<strong>Please!</strong> select OS type.
	</div>
	 <select class="form-control" name="os" id="os"  onchange="return getProductList();" style="display: none;">
	 
	 </select>

    </div>
    
     <div class="panel-body" id="productDiv" style="display: none;">
    
	 <center><h3>Enter Product Details</h3> </center>
	 <div class="alert alert-warning" id="commomErrorMsg" style="display: none;">
	 <span id="productError"></span>
	</div>

    <div class="form-group">
      <label for="email">Product Name:</label>
      <input type="text" class="form-control" id="productName" name="productName">
    </div>
    <div class="form-group">
       <label for="comment">Quantity:</label>
       <input class="form-control" type="number" id="quantity">
    </div>
    <div class="form-group">
       <label for="comment">Description:</label>
      <textarea class="form-control" rows="5" id="productDescription"></textarea>
    </div>
    <div class="form-group">
   	 	<div class="col-md-12">
    			<a href="${pageContext.request.contextPath}/shop/myShop" id="cancel" name="cancel" class="btn btn-danger">Cancel</a>
  			  <button id="submit" name="submit" class="btn btn-info" value="1" onclick="return addProduct();">Add Product</button>
 		 </div>
	</div>
	
    </div>

   </div>
  </div>
</div>	
 
 <script type="text/javascript">
 
 </script>
 
<script src="<c:url value="/resources/js/validations.js"/>"></script>
<script src="<c:url value="/resources/js/addProductValidation.js"/>"></script>
 
</body>
</html>
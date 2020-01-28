<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SOHRAB</title>

<link href="<c:url value="/resources/css/styles.css" />"
	rel="stylesheet">

<link href="<c:url value="/resources/css/boostrap3.4.0.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jQuery3.4.1.js"/>"></script>
<script src="<c:url value="/resources/js/boostrap3.4.0.js"/>"></script>
<link href="<c:url value="/resources/images/logo.png" />" rel="icon"
	type="image/png">
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
 			<div class="page-header">			
					<h3>Add New Brand</h3>			
			</div>
		<c:if test="${not empty flag}">
			<div class="alert alert-success alert-dismissible" id="brandAdded">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
				<p>${brandAdded}</p>
			</div>
		</c:if>
		
		<div class="alert alert-warning alert-dismissible" style="display: none;" id="brandValidationMsg">
		</div>
<div class="row">	
	<div class="col-sm-4">
		<form action="${pageContext.request.contextPath}/shop/addBrand" method="post">	
			<c:if test="${not empty listcategory}">		
				<div class="form-group">
					<div class="col-sm-12">
					<label class="control-label">Input Brand name</label>
						
						<input type="text" name="brandName" id="brandName" class="form-control">
					</div>
					
					<div class="col-sm-12">
					<br>
					<label class="control-label">Select Category type</label>
						
						<select name="catId[]" id="catId" class="form-control" multiple="multiple">
							<option value="-1" class="form-control" selected="selected">Select Category types</option>
							<c:forEach var="os" items="${listcategory}">
								<option value="${os.id}" class="form-control">${os.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				
				<div class="form-group">
					
						<div class="col-sm-12" style="text-align: right;">
						<a href="${pageContext.request.contextPath}/shop/myShop" id="cancel" name="cancel" class="btn btn-danger">Cancel</a>
							<button id="submit" name="submit" class="btn btn-info" onclick=" return validateBrand();">Add Brand</button>
							
						</div>				
				</div>		
		</c:if>
	</form>
</div>
<div class="col-sm-8">
 <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title">Brand</div>
    </div>
    <div class="panel-body">


	<table class="table table-bordered">
      <tr>
       <th class="col-sm-3">Brand Name</th>
       <th class="col-sm-6">Linked Category</th>
       <th class="col-sm-3">Action</th>
      </tr>

      <!-- loop over and print our customers -->
      <c:forEach var="brand" items="${listBrand}">

       <!-- construct an "update" link with customer id -->
       <c:url var="updateLink" value="/modify/updateLinkedBrandCategory">
        <c:param name="brandId" value="${brand.id}" />
       </c:url>

       <!-- construct an "delete" link with customer id -->
       <c:url var="deleteLink" value="/modify/disabledBrand">
        <c:param name="brandId" value="${brand.id}" />
       </c:url>

       <tr>
        <td>${brand.name}</td>
       <td>
        <table class="table table-bordered">
        <c:forEach var="brandCategory" items="${brand.category}">   
        	<tr>
 				<td>${brandCategory.name}</td>
 			</tr>
        </c:forEach>
        </table>
 		</td>
        <td>
         <a href="${updateLink}">Update Linked Category</a>
         | <a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Disable Brand</a>
        </td>

       </tr>

      </c:forEach>

     </table>

    </div>
   </div>
</div>
</div>


</div>
<script type="text/javascript">
$(document).ready(function() {
	window.location.hash = "#";
	window.location.hash = "No-Back";
	window.onhashchange = function() {
		window.location.hash = "#";
	};
});
</script>
<script src="<c:url value="/resources/js/brand.js"/>"></script> 
<script src="<c:url value="/resources/js/category.js"/>"></script> 
<script src="<c:url value="/resources/js/os.js"/>"></script> 
<script src="<c:url value="/resources/js/validations.js"/>"></script>
<script src="<c:url value="/resources/js/addProductValidation.js"/>"></script>	
</body>
</html>
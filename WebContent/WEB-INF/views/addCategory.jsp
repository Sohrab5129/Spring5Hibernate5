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
					<h3>Add New Category</h3>			
			</div>
			
<div class="row">	

		<c:if test="${not empty flag}">
			<div class="alert alert-success alert-dismissible" id="categoryAdded">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
				<p>${categoryAdded}</p>
			</div>
		</c:if>
		
		<div class="alert alert-warning alert-dismissible" style="display: none;" id="categoryValidationMsg">
		</div>
		
	<form action="${pageContext.request.contextPath}/shop/addCategory" method="post">	
		<c:if test="${not empty listOS}">
			<div class="col-sm-4">
				<div class="form-group">
					<div class="col-sm-12">
						<span>Input Category name</span> 
						<input type="text" name="categoryName" id="categoryName" class="form-control">
					</div>
					<div class="col-sm-12">
						<span>Select OS type</span> 
						<select name="osId[]" id="osId" class="form-control" multiple="multiple">
							<option value="-1" class="form-control" selected="selected">SELECT OS types</option>
							<c:forEach var="os" items="${listOS}">
								<option value="${os.id}" class="form-control">${os.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				
				<div class="form-group">
					
						<div class="col-sm-12" style="text-align: right;">
						<a href="${pageContext.request.contextPath}/shop/myShop" id="cancel" name="cancel" class="btn btn-danger">Cancel</a>
							<button id="submit" name="submit" class="btn btn-info" onclick=" return validateCategory();">Add Category</button>
							
						</div>				
				</div>
			</div>
			
		</c:if>
	</form>
</div>
</div>

<script src="<c:url value="/resources/js/category.js"/>"></script> 
<script src="<c:url value="/resources/js/os.js"/>"></script> 
<script src="<c:url value="/resources/js/validations.js"/>"></script>
<script src="<c:url value="/resources/js/addProductValidation.js"/>"></script>	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
 <div class="row">	
 			<div class="page-header">			
					<h3>Update Brand</h3>			
			</div>
	<div class="col-sm-4">
		<form action="${pageContext.request.contextPath}/modify/updateBrand" method="post">	
			<%-- <c:if test="${not empty availableCategory}">		 --%>
				<div class="form-group">
					<div class="col-sm-12">
					<label class="control-label">Brand name</label>
						<input type="hidden" value="${brand.id}" name="brandId">
						<input type="text" name="brandName" id="brandName" class="form-control" value="${brand.name}">
					</div>
					
					<div class="col-sm-12">
					<br>
					<label class="control-label">Linked Category type</label>
						
						<select name="catId[]" id="catId" class="form-control" multiple="multiple">
							<option value="-1" class="form-control" selected="selected">Select Category types</option>
							<c:forEach var="os" items="${linkedCategory}">
								<option value="${os.id}" class="form-control">${os.name}</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-sm-12">
					<br>
					<label class="control-label">Available Category type</label>
						
						<select name="catId[]" id="catId" class="form-control" multiple="multiple">
							<option value="-1" class="form-control" selected="selected">Select Category types</option>
							<c:forEach var="os" items="${availableCategory}">
								<option value="${os.id}" class="form-control">${os.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				
				<div class="form-group">
					
						<div class="col-sm-12" style="text-align: right;">
						<br>
						<a href="${pageContext.request.contextPath}/shop/myShop" id="cancel" name="cancel" class="btn btn-danger">Cancel</a>
							<button id="submit" name="submit" class="btn btn-info" onclick=" return validateBrand();">Update Brand</button>
							<br>
						</div>				
				</div>		
		<%-- </c:if> --%>
	</form>
</div>

</div>
 </div>

</body>
</html>
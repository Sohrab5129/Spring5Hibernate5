<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SOHRAB</title>

<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">

<link href="<c:url value="/resources/css/boostrap3.4.0.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jQuery3.4.1.js"/>"></script>
<script src="<c:url value="/resources/js/boostrap3.4.0.js"/>"></script>
<link href="<c:url value="/resources/images/logo.png" />" rel="icon" type="image/png" >

</head>

<body>

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
					<h3>Add New OS</h3>			
			</div>
			
	<div class="row">
	
		<c:if test="${not empty flag}">
			<div class="alert alert-success alert-dismissible" id="osAdded">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
				<p>${osAdded}</p>
			</div>
		</c:if>
		
		<div class="alert alert-warning alert-dismissible" style="display: none;" id="osValidationMsg">
		</div>
			
		<form action="${pageContext.request.contextPath}/shop/addOSType" method="post">
			<c:if test="${not empty addOS}">
				<div class="col-sm-4">
				<%-- 	<div class="form-group">
						<div class="col-sm-12">
							<span>Select OS type</span> 
							<select name="categoryId" id="categoryId" class="form-control">
								<option value="-1" class="form-control">SELECT CATEGORY</option>
								<c:forEach var="cat" items="${category}">
									<option value="${cat.id}" class="form-control">${cat.name}</option>
								</c:forEach>
							</select>
						</div>
					</div> --%>
					<div class="form-group">
						<div class="col-sm-12" id="catId">
							<span>Input OS type</span> 
							<div><input type="text" name="osName[]" id="osName" class="form-control"></div>					
						</div>
						
						<div class="col-sm-2">
						<br>
							<button class="addNewField btn btn-info" name="submit">+</button>
						</div>
						
					</div>
					<!-- <div class="form-group">
						<div class="col-sm-12">
							<button class="addNewField btn btn-info" name="submit">+</button>
						</div>
					</div> -->
					<div class="form-group">
					
						<div class="col-sm-12" style="text-align: right;">
						<a href="${pageContext.request.contextPath}/shop/myShop" id="cancel" name="cancel" class="btn btn-danger">Cancel</a>
							<button id="submit" name="submit" class="btn btn-info" onclick=" return validateOS();">Add OS</button>
							
						</div>				
					</div>
				</div>
				<div class="col-sm-4">
					
				</div>
			</c:if>
		</form>
	</div>
 </div>
 	
<script type="text/javascript">
$(document).ready(function(){
	var max=3;
	var wrapper=$("#catId");
	var addButton=$(".addNewField");
	
	var x=1;
	$(addButton).click(function(e){
		e.preventDefault();
		if(x < max){
			x++;
			$(wrapper).append('<div><input type="text" name="osName[]" class="form-control"><a href="#" class="delete">Delete</a></div>')
		}else{
			alert("Max count")
		}
	});
	$(wrapper).on("click",".delete", function(e){
		e.preventDefault();
		$(this).parent('div').remove();
		x--;
	});
});
</script>	
<script src="<c:url value="/resources/js/os.js"/>"></script> 
<script src="<c:url value="/resources/js/validations.js"/>"></script>
<script src="<c:url value="/resources/js/addProductValidation.js"/>"></script>	
</body>
</html>
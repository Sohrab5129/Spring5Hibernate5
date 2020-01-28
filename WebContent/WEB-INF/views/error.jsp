<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Invalid User</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>



<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">

</head>
<body onload="error()">
	<%
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
	%>
	<%
		if (session.getAttribute("userName") == null) {
	%>
	<jsp:include page="index.jsp"></jsp:include>
	<%
		}
	%>
	<div id="errorModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- dialog body -->
				<div class="modal-body">
					<button type="button" class="close" data-dismiss="modal"
						style="color: red !important;">x</button>
					<center>
						<b>Invalid User Credential.<br>Please Try Again.
						</b>
					</center>
				</div>
				<!-- dialog buttons -->
				<div class="modal-footer">
					<button type="submit" class="btn btn-info btn-default pull-left"
						data-dismiss="modal" id="myBtn1">
						<span class="glyphicon glyphicon-log-in"></span> OK
					</button>
				</div>
			</div>
		</div>
	</div>
	
	<script src="<c:url value="/resources/js/validations.js" />"></script>
</body>
</html>
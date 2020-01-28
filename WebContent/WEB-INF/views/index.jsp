<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html><!--  PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SOHRAB</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">

<link href="<c:url value="/resources/images/logo.png" />" rel="icon" type="image/png">

<link href="<c:url value="/resources/css/boostrap3.4.0.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jQuery3.4.1.js"/>"></script>
<script src="<c:url value="/resources/js/boostrap3.4.0.js"/>"></script>

<script type="text/javascript">

</script>

</head>
<body style="width: 100%;" >

	<%
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
	%>
	<%
		String name = null;
		String search = null;
		HttpSession session1 = request.getSession(false);

		if (session1.getAttribute("userName") != name) {
	%>
	<jsp:forward page="dashboard.jsp"></jsp:forward>
	<%
		} else {
			session1.removeAttribute("userName");

		}
	%>

	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"><b>SOHRAB</b></a>
		</div>

		<div class="collapse navbar-collapse" id="myNavbar">
			<!-- <ul class="nav navbar-nav">
				<li class="active"><a href="">Home</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Page 1-1</a></li>
						<li><a href="#">Page 1-2</a></li>
						<li><a href="#">Page 1-3</a></li>
					</ul></li>
			</ul> -->
			<ul class="nav navbar-nav navbar-right">
				<!-- <li><a href="#"><span class="glyphicon glyphicon-user"
						id="myLogin"></span> Sign Up</a></li> -->
				<li><a href="#"><span class="glyphicon glyphicon-log-in"
						id="myBtn"></span> Login</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<jsp:include page="login.jsp"></jsp:include>
	
	<%-- <jsp:include page="registration.jsp"></jsp:include> --%>
	<%-- <jsp:include page="searchError.jsp"></jsp:include> --%>
	<%-- 	<div id="home">
		<h3>HOME</h3>
		<%
			out.print("Search Values: ");
			if (session1.getAttribute("search") != search) {
				String value = (String) session1.getAttribute("search");
				out.print(value + "----------");

			} else {
				session1.invalidate();
			}
		%>

	</div> --%>
	
Max : 	 ${maxIdealTime}
	<script src="<c:url value="/resources/js/validations.js" />"></script>
</body>
</html>

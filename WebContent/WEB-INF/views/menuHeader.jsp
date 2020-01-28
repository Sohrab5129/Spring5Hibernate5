<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

	<%
		String name=null;
		HttpSession session1 = request.getSession(false);
		if(session1.getAttribute("userName")!=null){
			 name= session1.getAttribute("userName").toString().toUpperCase();
		}
		if (name == null) {
	%>
	<jsp:forward page="index.jsp"></jsp:forward>
	<%
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
			<a class="navbar-brand active" href="#"
				style="background-color: #555; font-size: x-large; font-family: initial; color: azure;"><b>SOHRAB</b></a>
		</div>

		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href="${pageContext.request.contextPath}">Home</a></li>
				<!-- <li><a href="index.mi">Page 2</a></li>
				<li><a href="index.mi">Page 3</a></li> -->

			</ul>
			<ul class="nav navbar-nav navbar-right">
				<!-- <li>
					<form class="navbar-form navbar-left"
						action="/myInsurance/loginSearch.mi" method="post"
						onsubmit="return loginSearchValidation()">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Search"
								name="search" id="loginSearch"> <input type="hidden"
								id="searchId" name="searchId">
						</div>
						<button type="submit" class="btn btn-default">Submit</button>
					</form>
				</li> -->
				<li class="active"><a href="#"><span
						class="glyphicon glyphicon-user"></span> Welcome <%=name%></a></li>
				<li><a href="${pageContext.request.contextPath}/logout"><span
						class="glyphicon glyphicon-log-out"></span> LogOut</a></li>
			</ul>
		</div>
	</div>
	</nav>
</body>
</html>
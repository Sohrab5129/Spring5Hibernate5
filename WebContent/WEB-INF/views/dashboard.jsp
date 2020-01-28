<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SOHRAB</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />

<link href="<c:url value="/resources/images/logo.png" />" rel="icon" type="image/png" >

<link href="<c:url value="/resources/css/boostrap3.4.0.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jQuery3.4.1.js"/>"></script>
<script src="<c:url value="/resources/js/boostrap3.4.0.js"/>"></script>

<!-- responsive datatable -->
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/fixedheader/3.1.3/css/fixedHeader.bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.2.1/css/responsive.bootstrap.min.css">

<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/fixedheader/3.1.3/js/dataTables.fixedHeader.min.js"></script>
<script src="https://cdn.datatables.net/responsive/2.2.1/js/dataTables.responsive.min.js"></script>
<script src="https://cdn.datatables.net/responsive/2.2.1/js/responsive.bootstrap.min.js"></script>

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
			<div class="col-md-3">
				<div class="thumbnail">
					<a href="${pageContext.request.contextPath}/shop/myShop"> <img border="0"
						src="<c:url value="/resources/images/myShop.jpg" />" style="width: 100%;">
					</a>
				</div>
			</div>
			<%-- <div class="col-md-3">
				<div class="thumbnail">
					<a href="showCreatedPolicyList"> <img border="0"
						src="<c:url value="/resources/images/createdPolicy.png"/>" style="width: 100%;">
					</a>
				</div>
			</div>
			<div class="col-md-3">
				<div class="thumbnail">
					<a href="basicInformation"> <img border="0"
						src="<c:url value="/resources/images/create policy.png"/>" style="width: 100%;">
					</a>
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-container">
					<h1>Welcome to FileDownloader Example</h1>
					<form action="download" method="get">
						Contains:<input type="number" name="policyNo" required="required">
						<input type="text" value="infoPolicyCreted"
							name="infoPolicyCreted" style="display: none;"> <br>
						<input type="submit" value="Download">
					</form>
				</div>
			</div>

		</div> --%>

		<!-- testing responsive datatable -->

		<!-- <div style="width: 50%;">
			<table id="example" class="table table-striped table-bordered nowrap"
				style="width: 100%">
				<thead>
					<tr>
						<th>Name</th>
						<th>Position</th>
						<th>Office</th>
						<th>Age</th>
						<th>Start date</th>
						<th>Salary</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Tiger Nixon</td>
						<td>System Architect</td>
						<td>Edinburgh</td>
						<td>61</td>
						<td>2011/04/25</td>
						<td>$320,800</td>
					</tr>
					<tr>
						<td>Garrett Winters</td>
						<td>Accountant</td>
						<td>Tokyo</td>
						<td>63</td>
						<td>2011/07/25</td>
						<td>$170,750</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<th>Name</th>
						<th>Position</th>
						<th>Office</th>
						<th>Age</th>
						<th>Start date</th>
						<th>Salary</th>
					</tr>
				</tfoot>
			</table>
		</div>

		<div style="width: 50%;">
			<div id="chartContainer" style="height: 300px; width: 100%;"></div>
			
		</div> -->
	</div>
	</div>

	<!-- <script type="text/javascript">
	$(document).ready(function() {
	    var table = $('#example').DataTable( {
	        responsive: true
	    } );
	 
	    new $.fn.dataTable.FixedHeader( table );
	} );
	</script>
 -->

<!-- <input id="dataPoints"> -->

	<script src="<c:url value="/resources/js/canvasjs.min.js"/>"></script>
	
	<script src="<c:url value="/resources/js/jquery.canvasjs.min.js"/>"></script>
	<script src="<c:url value="/resources/js/validations.js"/>"></script>
</body>
</html>
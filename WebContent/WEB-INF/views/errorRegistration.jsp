<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Server Error</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- <script src="js/jquery.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script> -->
<script src="js/validations.js"></script>
<link rel="stylesheet" href="css/styles.css">
<script type="text/javascript">
	function error() {
		$('#errorModal').modal('show');
	};
</script>
</head>
<body onload="error()">
	<div id="errorModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- dialog body -->
				<div class="modal-body">
					<button type="button" class="close" data-dismiss="modal"
						style="color: red !important;">x</button>
					<center>
						<b>Due to some server error your are not get register.</b>
					</center>
				</div>
				<!-- dialog buttons -->
				<div class="modal-footer">
					<button type="submit" class="btn btn-info btn-default pull-left"
						data-dismiss="modal">OK</button>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="index.jsp"></jsp:include>
</body>
</html>
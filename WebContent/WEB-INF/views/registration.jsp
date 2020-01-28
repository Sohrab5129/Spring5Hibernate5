<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MY INSURANCE</title>
</head>
<body>
	<div class="container">
		<div class="modal fade" id="regModel" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header" style="padding: 10px 20px;">
						<button type="button" class="close" data-dismiss="modal">
							<b style="color: black;">&times;</b>
						</button>
						<h4>
							<span class="glyphicon glyphicon-list-alt"></span> Registration
							Form
						</h4>
					</div>
					<div class="modal-body" style="padding: 40px 50px;">
						<form role="form" action="/myInsurance/reg.mi" method="post"
							onsubmit="return regValidation()">
							<div class="alert alert-warning alert-dismissable"
								style="display: none;" id="errorMsg1"></div>
							<div class="form-group">
								<label for="usrname"><span
									class="glyphicon glyphicon-user"></span> Username</label> <input
									type="text" class="form-control" id="rusrname"
									placeholder="User Name" name="rusrname">
							</div>
							<div class="form-group">
								<label for="usrname"><span
									class="glyphicon glyphicon-envelope"></span> Email</label> <input
									type="text" class="form-control" id="remail"
									placeholder="Enter email" name="remail">
							</div>
							<div class="form-group">
								<label for="usrname"><span
									class="glyphicon glyphicon-phone"></span> Contact</label> <input
									type="text" class="form-control" id="rcontact"
									placeholder="Enter Contact" name="rcontact">
							</div>
							<div class="form-group">
								<label for="psw"><span
									class="glyphicon glyphicon-eye-open"></span> Password</label> <input
									type="password" name="rpsw1" class="form-control" id="rpsw1"
									placeholder="Enter password"><br> <input
									type="password" name="rpsw2" class="form-control" id="rpsw2"
									placeholder="Re-Enter password">
							</div>

							<button type="submit" class="btn btn-success btn-block">
								<span class="glyphicon glyphicon-registration-mark"></span>
								Register
							</button>
						</form>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-danger btn-default pull-left"
							data-dismiss="modal">
							<span class="glyphicon glyphicon-remove"></span> Cancel
						</button>

					</div>
				</div>

			</div>
		</div>
	</div>

</body>
</html>
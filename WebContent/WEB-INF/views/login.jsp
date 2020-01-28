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
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header" style="padding: 15px 30px;">
						<button type="button" class="close" data-dismiss="modal">
							<b style="color: black;">&times;</b>
						</button>
						<h4>
							<span class="glyphicon glyphicon-lock"></span> Login
						</h4>
					</div>
					<div class="modal-body" style="padding: 40px 50px;">
						<form role="form" action="${pageContext.request.contextPath}/login" method="post"
							onsubmit="return saveValidation()">
							<div class="alert alert-warning alert-dismissable"
								style="display: none;" id="errorMsg"></div>
							<div class="form-group">
								<label for="usrname"><span
									class="glyphicon glyphicon-user"></span> User Id</label> <input
									type="text" class="form-control" id="usrname"
									placeholder="Enter your user id" name="email">
							</div>
							<div class="form-group">
								<label for="psw"><span
									class="glyphicon glyphicon-eye-open"></span> Password</label> <input
									type="password" name="password" class="form-control" id="psw"
									placeholder="Enter password">
							</div>
			<!-- 				<div class="checkbox">
								<label><input type="checkbox" value="" checked>Remember
									me</label>
							</div> -->
							<button type="submit" class="btn btn-success btn-block">
								<span class="glyphicon glyphicon-off"></span> Login
							</button>
						</form>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-danger btn-default pull-left"
							data-dismiss="modal">
							<span class="glyphicon glyphicon-remove"></span> Cancel
						</button>
						<!-- <p>
							Not a member? <a href="#" id="myLogin1"> Sign Up</a></p> -->
						<!-- <p>
							Forgot <a href="forgetPassword.mi">Password?</a>
						</p> -->
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>
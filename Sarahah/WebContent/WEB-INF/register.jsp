<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HonestFeedBack - Register</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="static/css/styles.css">
</head>
<body>
	<header><%@include file="nav.jsp"%></header>
	<div class="container">
		<form class="form-horizontal" action="account" method="post">
		<div class="col-md-5 col-md-offset-3">
			<div class="panel panel-info">
			<div class="panel-heading">Register</div>
				<div class="panel-body">
					<div class="form-group">
						<!--   <label class="control-label col-sm-2"  for="email">Email:</label> -->
						<div class="col-sm-10">
							<input type="email" class="form-control" id="email" name="email"
								placeholder="Email">
						</div>
					</div>
					<div class="form-group">
						<!--<label class="control-label col-sm-2" for="pwd">Password:</label> -->
						<div class="col-sm-10">
							<input type="password" class="form-control" id="pwd"
								name="password" placeholder="Password">
						</div>
					</div>
					<div class="form-group">
						<!--<label class="control-label col-sm-2" for="pwd">Confirm Password:</label> -->
						<div class="col-sm-10">
							<input type="password" class="form-control" id="pwdCnfrm"
								name="passwordCnfrm" placeholder="Confirm password">
						</div>
					</div>
					<div class="form-group">
						<!-- <label class="control-label col-sm-2">Username:</label> -->
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userName"
								name="userName" placeholder="Username">
						</div>
					</div>
					<div class="form-group">
						<!--<label class="control-label col-sm-2">Name:</label> -->
						<div class="col-sm-10">
							<input type="text" class="form-control" id="name" name="name"
								placeholder="Name">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">Register</button>
						</div>
					</div>
				</div>
			</div>
			</div>
		</form>
	</div>
</body>
</html>
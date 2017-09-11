<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>HonestFeedBack - Message</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="static/css/styles.css">
</head>
<body>
	<div class="container" style="margin-top:10%">
		<form action="thankyou" method="post">
			<div class="row">
			<div class="well">
				<p>Share Your Feedback</p>
				<p>For</p>
				<p>
					<name="userName">${name}
				</p>
				<div class="form-group">
				<textarea class="form-control" rows="5" id="message" name="message"></textarea></div>
				<div class="form-group"><button type="submit" class="btn btn-info">Send</button></div>
				<input type="hidden" name="userName" value="${userName}"
					readonly="readonly" />
			</div>
			</div>
		</form>
	</div>
</body>
</html>
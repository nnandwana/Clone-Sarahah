<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HonestFeedBack - Messages</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="static/css/styles.css">
</head>
<body>
	<header><%@include file="HomeNav.jsp"%></header>
	<div class="container-fluid">
		<div class="row">
			<div class="well">
				<p>${name }</p>
				<p>
					<a href="${userName}" style="color: #0CC8C9">${userName}.sarahah.com</a>
				</p>
			</div>
		</div>
		<div class="row">
			<div class="well">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>My Messages</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="message" items="${message}">
							<tr>
							
								<td><p class="message">${message.getMessage()}</p>
									<p style="color:#9da9b0;font-size:10px">${message.getDateTime()}</p>
								</td>
								
							</tr>
						</c:forEach>
					</tbody>
					</table>
					</div>
					</div>
					</div>
</body>
</html>
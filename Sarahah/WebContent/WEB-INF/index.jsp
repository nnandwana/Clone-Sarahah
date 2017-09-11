<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>HonestFeedBack</title>
</head>
<body>
<c:if test="${isLogin eq true}">
<header><%@include file="HomeNav.jsp" %></header>
</c:if>
<c:if test="${isLogin eq false}">
<header><%@include file="nav.jsp" %></header>
</c:if>
</body>
</html>
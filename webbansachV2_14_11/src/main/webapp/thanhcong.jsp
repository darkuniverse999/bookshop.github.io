<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Thanh cong page</title>
</head>
<body>

	<c:if test="${not empty khachHang }">
		<h1>name: ${khachHang.hoTen}</h1>
	</c:if>
	
	
</body>
</html>
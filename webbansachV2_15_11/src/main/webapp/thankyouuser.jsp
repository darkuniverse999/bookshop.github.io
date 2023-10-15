
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thank You User</title>


<!-- css cdn -->
<link rel="stylesheet" href="bootstrap-5.3.1-dist/css/bootstrap.css">

<!-- js cdn -->
<script src="bootstrap-5.3.1-dist/js/bootstrap.bundle.js"></script>

<!-- jquery cdn -->
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>

<!-- fontawesome cdn -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
	integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<!-- google font 2 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Bitter:wght@100&family=Dela+Gothic+One&family=Open+Sans:wght@300&family=Young+Serif&display=swap"
	rel="stylesheet">

<!-- mycss -->
<link rel="stylesheet" href="all_component/mycss.css">

</head>

<body>


	<c:if test="${ empty khachHang }">
		<c:redirect url="login.jsp"/>
	</c:if>
	
	<%@include file="all_component/navbar.jsp"%>

	  
	  <div class="text-center cachTren">
	  	<h2 class="text-info text-uppercase">Đặt hàng thành công, cảm ơn bạn đã ủng hộ shop</h2>
	  
	    <img src="img/thankyou2.gif" alt="">
	    <img src="img/thankyou.gif" alt="">
	    <hr>
	    <a href="index.jsp"><div class="btn btn-outline-info mx-4 ">Tiếp tục mua hàng</div></a>
	    <a href="user_cart.jsp"><div class="btn btn-outline-info ">Giỏ hàng của tôi</div></a>
  	</div>

	<%@include file="all_component/footer.jsp"%>
</body>
</html>
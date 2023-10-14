<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<!-- css cdn -->
<link rel="stylesheet" href="bootstrap-5.3.1-dist/css/bootstrap.css">

<!-- js cdn -->
<script src="bootstrap-5.3.1-dist/js/bootstrap.bundle.js"></script>
<script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>
  
<!-- fontawesome cdn -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
	integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
	
</head>


<style>
/* css toast */
#toast {
	min-width: 300px;
	position: fixed;
	bottom: 30px;
	left: 50%;
	margin-left: -150px;
	background: #333;
	padding: 10px;
	color: white;
	text-align: center;
	z-index: 1;
	font-size: 18px;
	visibility: hidden;
	box-shadow: 0px 0px 100px #000;
}

#toast.display {
	visibility: visible;
	animation: fadeIn 0.5s, fadeOut 0.5s 2.5s;
}

@keyframes fadeIn {
	from { 
		bottom: 0;
		opacity: 0;
	}

	to {
		bottom: 30px;
		opacity: 1;
	}
}

@keyframes fadeOut {
	from { 
		bottom: 30px;
		opacity: 1;
	}

	to {
		bottom: 0;
		opacity: 0;
	}
}
</style>

<body>
	<h1>sua sach thanh cong roi</h1>
	
	<c:if test="${not empty addCart }">
		<div id="toast">${addCart }</div>
		<script type="text/javascript">
		    showToast();
		    function showToast(content)
		    {
		        $('#toast').addClass("display");
		        $('#toast').html(content);
		        setTimeout(()=>{
		            $("#toast").removeClass("display");
		        },2000)
		    }	
		 </script>
	</c:if>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 	<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users</title>
<!-- link css -->
<link rel="stylesheet" href="../bootstrap-5.3.1-dist/css/bootstrap.css">

<!-- src script js -->
<script src="../bootstrap-5.3.1-dist/js/bootstrap.bundle.js"></script>

<!-- fontawesome cdn -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
	integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<!-- google font -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Young+Serif&display=swap"
	rel="stylesheet">

<!-- link mycss -->
<link rel="stylesheet" href="../all_component/mycss.css">

</head>

<body>

	<c:if test="${ empty adminSession }">
		<c:redirect url="../login.jsp"/>
	</c:if>
	
	<%@include file="admin_navbar.jsp"%>


	<div class="my-bg-img">

		<div class="container">
			<div class="row">
				<table class="table table-striped">
					<thead class="table-dark">
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Tên Đăng Nhập</th>
							<th scope="col">Họ Và Tên</th>
							<th scope="col">Giới Tính</th>
							<th scope="col">Địa Chỉ</th>
							<th scope="col">Ngày Sinh</th>
							<th scope="col">Số Điện Thoại</th>
							<th scope="col">Email</th>
							<th scope="col">Số Đơn Đã Đặt</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">1</th>
							<td>Mark</td>
							<td>Lorem ipsum</td>
							<td>@mdo</td>
							<th scope="row">1</th>
							<td>Mark</td>
							<td>Otto</td>
							<td>@mdo</td>

						</tr>

					</tbody>
				</table>
			</div>
			<!-- end row -->
		</div>
		<!-- end container table -->
	</div>
	<!-- end div chua container  -->



	<%@include file="admin_footer.jsp"%>
</body>
</html>
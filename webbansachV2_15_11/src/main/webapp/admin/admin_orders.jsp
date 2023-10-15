<%@page import="model.ChiTietDonHang"%>
<%@page import="java.util.ArrayList"%>
<%@page import="database.ChiTietDonHangDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Orders</title>
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

<body class="">

	<c:if test="${ empty adminSession }">
		<c:redirect url="../login.jsp"/>
	</c:if>

	<%@include file="admin_navbar.jsp"%>

	<div class=" ">
		<div class="container-fluid ">
			<div class="row ">
				<table class="table table-striped table-primary">
					<thead class="table-dark text-center">
						<tr>
							<th scope="col">Mã Chi Tiết Đơn</th>
							<th scope="col">Tên Khách Hàng</th>
							<th scope="col">Email</th>
							<th scope="col">Địa Chỉ Nhận Hàng</th>
							<th scope="col">Số Điện Thoại</th>
							<th scope="col">Tên Sách</th>
							<th scope="col">Tác Giả</th>
							<th scope="col">Số Lượng</th>
							<th scope="col">Trạng Thái Giao Hàng</th>
							<th scope="col">Hình Thức Thanh Toán</th>
							<th scope="col">Trạng Thái Thanh Toán</th>
							<th scope="col">Tổng Tiền</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody class="text-center">
					
						<%
						
						ChiTietDonHangDAO ctdhDAO = new ChiTietDonHangDAO();
						ArrayList<ChiTietDonHang> arrCTDH = ctdhDAO.selectAllDonHangAndCTDH(); //return a arr list don hang & ctdh
						
						for(ChiTietDonHang ctdhItem : arrCTDH) {
						%>
						
						<tr>
							<th><%=ctdhItem.getMaChiTietDonHang() %> </th>
							<td><%=ctdhItem.getTenNguoiNhan() %></td>
							<td><%=ctdhItem.getEmail() %></td>
							<td><%=ctdhItem.getDiaChiNhanHang() %></td>
							<td><%=ctdhItem.getSdt() %></td>
							<td><%=ctdhItem.getTenSach() %></td>
							<td><%=ctdhItem.getTacGia() %></td>
							<td><%=ctdhItem.getSoLuong() %></td>
							<td><%=ctdhItem.getDonHang().getTrangThaiGiaoHang() %></td>
							<td><%=ctdhItem.getHinhThucThanhToan() %></td>
							<td><%=ctdhItem.getDonHang().getTrangThaiThanhToan()%></td>
							<td><%=ctdhItem.getTongThanhTien() %></td>
							<td class="text-nowrap">
							  <div class="btn btn-primary">Sửa</div>
							  <div class="btn btn-danger">Xóa</div>
							</td>
				
						</tr>
						
						<%	
						}
						%>


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
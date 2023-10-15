<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<meta charset="UTF-8">

<%
Object obj = (KhachHang) session.getAttribute("khachHang");
KhachHang kh = new KhachHang();
if (obj != null) {
	kh = (KhachHang) obj;
}
%>

<style>
.purple {
	color: #Ce44ce;
}
</style>


<div class="container-fluid fixed-top bg-body-tertiary ">
	<div class="row  align-items-center ">

		<!-- start div navbar -->
		<div class="col-md-6">
			<nav class="navbar navbar-expand-lg ">

				<a class="navbar-brand" href="#">my logo</a>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a href="index.jsp" class="nav-link active"
							aria-current="page" href="#"><i class="fa-solid fa-house"></i>Trang
								chủ</a></li>
						<li class="nav-item"><a href="newbook.jsp" class="nav-link" href="#">Sách mới</a></li>
						<li class="nav-item"><a href="oldbook.jsp" class="nav-link" href="#">Sách cũ</a></li>
						<li class="nav-item"><a href="newbook.jsp" class="nav-link" href="#">Sách second-hand</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> Thể loại </a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="#">Học Tập</a></li>
								<li>
									<hr class="dropdown-divider">
								</li>
								<li><a class="dropdown-item" href="#">Truyện Tranh</a></li>
								<li>
									<hr class="dropdown-divider">
								</li>
								<li><a class="dropdown-item" href="#">Xã Hội</a></li>
							</ul></li>
					</ul>
				</div>

				<!-- button toggle -->
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

			</nav>
		</div>
		<!-- end div navbar  -->

		<!-- start search -->
		<div class="col-md-3">
			<form action="SearchBookServlet" method="post" class="d-flex " role="search">
				<input class="form-control me-2" type="search"
					placeholder="Nhập tên sách, tác giả...." name="searchbook" required>
				<button class="btn btn-outline-success text-nowrap" type="submit">Tìm
					kiếm</button>
			</form>
		</div>
		<!-- end search -->

		<!-- start div login, logout -->
		<div class="col-md-3 d-flex justify-content-end align-items-center">
			<c:if test="${empty khachHang and empty adminSession}">
				<a href="login.jsp"><button type="button"
						class="btn btn-primary mx-2">Đăng nhập</button></a>
				<a href="register.jsp"><button type="button"
						class="btn btn-success">Đăng ký</button></a>
			</c:if>

			<c:if test="${not empty khachHang}">
				<a title="Giỏ hàng của tôi" class="imgCachTrai" href="user_cart.jsp"><img src="img/trolley_resize.png" alt=""></a>
				<a class="nav-link " href="#" role="button"
					data-bs-toggle="dropdown">
					<h6 class="dropdown-toggle">
						Xin chào: <i class="fa-regular fa-circle-user"></i>
						${khachHang.hoTen}
					</h6>
				</a>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="#">Thông tin cá nhân</a></li>
					<li><a class="dropdown-item" href="#">Thay đổi mật khẩu</a></li>
					<li><hr class="dropdown-divider"></li>
					<li><a class="dropdown-item" href="#">Bán sách</a></li>
					<li><hr class="dropdown-divider"></li>
					<li><a class="dropdown-item" href="#">Đơn hàng của tôi</a></li>
					<li><a class="dropdown-item" href="#">Sách đã đăng bán</a></li>
					<li><hr class="dropdown-divider"></li>
					<li><a data-bs-toggle="modal" data-bs-target="#modalDangXuatUser" class="dropdown-item" href="#">Đăng xuất</a></li>
				</ul>
			</c:if>
			
			<c:if test="${not empty adminSession }">
				<a class="nav-link " href="#2" role="button"
					data-bs-toggle="dropdown">
					<h6 class="dropdown-toggle">
						Xin chào Admin: <i class="fa-regular fa-circle-user"></i>
					</h6>
				</a>
				<ul class="dropdown-menu">
					<li><a href="admin/admin_home.jsp" class="dropdown-item" href="#">Trang Admin</a></li>
					<li><hr class="dropdown-divider"></li>
					<li><a data-bs-toggle="modal" data-bs-target="#modalDangXuatUser" class="dropdown-item" href="#">Đăng xuất</a></li>
				</ul>
			
			</c:if>

		</div>
		<!-- end div login, logout -->

	</div>
	<!-- end row -->
</div>
<!-- end container navbar -->

<!-- MODAL BOOTSTRAP -->
<div class="modal fade" id="modalDangXuatUser" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
		<div class="modal-content">
			<div class="modal-header">
				<h1 class="modal-title fs-5 text-danger" id="exampleModalLabel">
					<i class="fa-solid fa-triangle-exclamation iconCachPhai"></i>Thông
					báo!
				</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<h4 class="text-center text-danger">Bạn muốn đăng xuất?</h4>
			</div>
			<div class="modal-footer">
				<a href="Logout"><button type="button" class="btn btn-primary">Đồng
						ý</button></a>

				<button type="button" class="btn btn-secondary"
					data-bs-dismiss="modal">Đóng</button>
			</div>
		</div>
	</div>
</div>
<!-- end modal -->



<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%
	String adminSession = (String) session.getAttribute("adminSesssion");
	
	%>


<div class="">
<div class="khungChuaMarquee">
	<!-- div nay de lam background-img boc toan body -->
	<div class="khung">
		<marquee behavior="alternate" direction="left" class="blinking-text">Hello
			ADMIN</marquee>
	</div>
</div>


<nav class="navbar navbar-expand-lg bg-body-tertiary ">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">my logo</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="admin_home.jsp"><i
						class="fa-solid fa-house"></i>Trang chủ</a></li>
				<li class="nav-item"><a class="nav-link active" aria-current="page" href="../index.jsp">Trang bán hàng</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Sách mới</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Sách cũ</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Sách second-hand</a></li>	
				
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-bs-toggle="dropdown" aria-expanded="false">
						Chức năng </a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a href="admin_addbook.jsp" class="dropdown-item"
							href="#">Thêm sách</a></li>
						<li>
							<hr class="dropdown-divider">
						</li>
						<li><a href="admin_allbook.jsp" class="dropdown-item">Toàn
								bộ sách</a></li>
						<li>
							<hr class="dropdown-divider">
						</li>
						<li><a href="admin_orders.jsp" class="dropdown-item" href="#">Các
								đơn đặt hàng</a></li>
						<li>
							<hr class="dropdown-divider">
						</li>
						<li><a href="admin_user.jsp" class="dropdown-item" href="#">Khách
								hàng</a></li>
						<li>
							<hr class="dropdown-divider">
						</li>
						<li><a href="#" class="dropdown-item" href="#">Thống kê
								doanh thu</a></li>
						<li>
							<hr class="dropdown-divider">
						</li>
						<li><a href="#" class="dropdown-item" href="#">Thay đổi
								thông tin</a></li>
					</ul></li>

				<a class="mx-3"><button
						class="btn btn-warning text-nowrap" type="" data-bs-toggle="modal" data-bs-target="#exampleModal">Đăng xuất</button></a>
			</ul>
			<form class="d-flex " role="search">
				<input class="form-control me-2" type="search"
					placeholder="Nhập tên sách" aria-label="Search">
				<button class="btn btn-outline-success text-nowrap" type="submit">Tìm
					kiếm</button>
			</form>

			<!-- MODAL BOOTSTRAP -->
			<div class="modal fade" id="exampleModal" tabindex="-1"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div
					class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
					<div class="modal-content">
						<div class="modal-header">
							<h1 class="modal-title fs-5 text-danger" id="exampleModalLabel"><i class="fa-solid fa-triangle-exclamation iconCachPhai"></i>Thông
								báo!</h1>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">
							<h4 class="text-center text-danger">Bạn muốn đăng xuất?</h4>
						</div>
						<div class="modal-footer">
							<a href="../Logout"><button
									type="button" class="btn btn-primary">Đồng ý</button></a>

							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Đóng</button>
						</div>
					</div>
				</div>
			</div>
			<!-- end modal -->

		</div>
	</div>
</nav>
</div>

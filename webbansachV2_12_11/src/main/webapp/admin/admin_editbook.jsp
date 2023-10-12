<%@page import="model.Sach"%>
<%@page import="database.SachDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Book</title>

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

	<%
	int id = Integer.parseInt(request.getParameter("id"));
	SachDAO sachDAO = new SachDAO();
	Sach sach = sachDAO.selectById(id); //return a Book
	%>

	<%@include file="admin_navbar.jsp"%>

	<div class="container">
		<div class="row">

			<div class="col-md-5 mt-5">

				<div class="card">

					<div class="card-body">
						<h3 class="text-center mb-3">Sửa thông tin sách</h3>
						

						<form action="../EditBookServlet" method="post" enctype="multipart/form-data">

							<input type="hidden" name="maSach" value="<%=sach.getMaSach()%>">
							<!-- Book's name -->
							<div class="form-outline mb-4">
								<label class="form-label" for="idtenSach">Tên sách<span
									class="red">*</span></label> <input type="text" id="idtenSach"
									name="tenSach" class="form-control"
									value="<%=sach.getTenSach()%>" required />
							</div>

							<!-- Author's name -->
							<div class="form-outline mb-4">
								<label class="form-label" for="idtacGia">Tên tác giả<span
									class="red">*</span></label> <input type="text" id="idtacGia"
									name="tacGia" class="form-control"
									value="<%=sach.getTacGia()%>" required />
							</div>

							<!-- Original price -->
							<div class="form-outline mb-4">
								<label class="form-label" for="idgiaGoc">Giá nhập</label> <input
									type="number" id="idgiaGoc" name="giaGoc" class="form-control"
									value="<%=sach.getGiaGoc()%>" />
							</div>

							<!-- Price -->
							<div class="form-outline mb-4">
								<label class="form-label" for="idgiaBan">Giá bán<span
									class="red">*</span>
								</label> <input type="number" id="idgiaBan" name="giaBan"
									class="form-control" value="<%=sach.getGiaBan()%>" required />
							</div>

							<!-- Category -->
							<select class="form-select mb-4" name="loaiSach" id="">
								<%
								if (sach.getLoaiSach().equals("old")) {
								%>
								<option value="old">Sách cũ</option>
								<option value="new">Sách mới</option>
								<%
								} else {
								%>
								<option value="new">Sách mới</option>
								<option value="old">Sách cũ</option>
								<%
								}
								%>

							</select>

							<!-- Price -->
							<div class="form-outline mb-4">
								<label class="form-label" for="idnxb">Năm xuất bản<span
									class="red">*</span>
								</label> <input type="number" id="idnxb" name="nxb" class="form-control"
									value="<%=sach.getNXB()%>" required />
							</div>

							<!-- Status -->
							<select class="form-select mb-4" name="tinhTrang" id="">

								<%
								if (sach.getTrangThai().equals("active")) {
								%>
								<option value="active">Có sẵn</option>
								<option value="inactive">Không có sẵn</option>
								<%
								} else {
								%>
								<option value="inactive">Không có sẵn</option>
								<option value="active">Có sẵn</option>
								<%
								}
								%>

							</select>

							<!-- Kind of book -->
							<select class="form-select mb-4" name="theLoai" id="">
								<option selected value="theLoai">Thể loại</option>
								<option value="phieuLuu">Phiêu lưu</option>
								<option value="hocTap">Học tập</option>
								<option value="truyenTranh">Truyện tranh</option>
								<option value="khac">Khác</option>
							</select>

							<!-- Upload file -->
							<label class="form-label" for="customFile">Hình ảnh</label> <em
								class="text-muted small text-italic ">(*bắt buộc)</em> <input
								type="file" class="form-control" id="customFile" name="hinhAnh" required/>

							<!-- Quantity -->
							<div class="form-outline mt-4">
								<label class="form-label" for="idsoLuong">Số lượng<span
									class="red">*</span>
								</label> <input type="number" id="idsoLuong" name="soLuong"
									class="form-control" value="<%=sach.getSoLuong()%>" required />
							</div>

							<!-- Submit button -->
							<div class="text-center mt-5">

								<button type="button" class="btn btn-primary btn-block mb-4"
									data-bs-toggle="modal" data-bs-target="#exampleModal4">Sửa
									thông tin sách</button>
							</div>

							<div class="text-center mt-5">
								<button type="button" class="btn btn-primary"
									data-bs-toggle="modal" data-bs-target="#exampleModal4">test</button>
							</div>

							<!-- MODAL BOOTSTRAP -->
							<div class="modal fade" id="exampleModal4" tabindex="-1"
								aria-labelledby="exampleModalLabel" aria-hidden="true">
								<div
									class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
									<div class="modal-content">
										<div class="modal-header">
											<h1 class="modal-title fs-5 text-danger"
												id="exampleModalLabel">
												<i class="fa-solid fa-triangle-exclamation iconCachPhai"></i>Thông
												báo!
											</h1>
											<button type="button" class="btn-close"
												data-bs-dismiss="modal" aria-label="Close"></button>
										</div>
										<div class="modal-body">
											<h4 class="text-center text-danger">Bạn muốn sửa thông
												tin quyển sách này?</h4>
										</div>
										<div class="modal-footer">
											<button type="submit" class="btn btn-primary">Đồng ý</button>

											<button type="button" class="btn btn-secondary"
												data-bs-dismiss="modal">Đóng</button>
										</div>
									</div>
								</div>
							</div>
							<!-- end modal -->

						</form>
					</div>

				</div>

			</div>
			<!-- end div col -->



			<div class="col-md-7 mt-5">
				<img class="w-100"
					src="https://hd.wallpaperswide.com/thumbs/open_book-t2.jpg" alt="">

				<!-- <img class="img-fluid mt-2" src="https://www.torontopubliclibrary.ca/content/reading-challenge/images/reading-challenge-hero.jpg" alt=""> -->

				<img class="img-fluid mt-4"
					src="https://wallpaperaccess.com/full/934063.jpg" alt="">
			</div>
			<!-- end div col -->
		</div>
		<!-- end row -->
	</div>
	<!-- end container -->

	<%@include file="admin_footer.jsp"%>
</body>
</html>
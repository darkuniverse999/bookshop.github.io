<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Book</title>
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
	<%@include file="admin_navbar.jsp"%>


	<div class="container">
		<div class="row">

			<div class="col-md-5 mt-5">

				<div class="card">

					<div class="card-body">
						<h3 class="text-center mb-3">Thêm sách</h3>
						
						<c:if test="${not empty successMsg }">
							<h6 class="text-center text-success">${successMsg }</h6>
							<c:remove var="successMsg" scope="session" />
						</c:if>
						
						<c:if test="${not empty failMsg }">
							<h6 class="text-center red">${failMsg }</h6>
							<c:remove var="failMsg" scope="session" />
						</c:if>

						<form action="../AddBookServlet" method="post" enctype="multipart/form-data">
							<!-- Book's name -->
							<div class="form-outline mb-4">
								<label class="form-label" for="idtenSach">Tên sách<span
									class="red">*</span></label> <input type="text" id="idtenSach"
									name="tenSach" class="form-control" required />
							</div>

							<!-- Author's name -->
							<div class="form-outline mb-4">
								<label class="form-label" for="idtacGia">Tên tác giả<span
									class="red">*</span></label> <input type="text" id="idtacGia"
									name="tacGia" class="form-control" required />
							</div>

							<!-- Original price -->
							<div class="form-outline mb-4">
								<label class="form-label" for="idgiaGoc">Giá nhập</label> <input type="number" id="idgiaGoc"
									name="giaGoc" class="form-control" />
							</div>

							<!-- Price -->
							<div class="form-outline mb-4">
								<label class="form-label" for="idgiaBan">Giá bán<span
									class="red">*</span>
								</label> <input type="number" id="idgiaBan" name="giaBan"
									class="form-control" required />
							</div>
							
							<!-- Publishing year -->
							<div class="form-outline mb-4">
								<label class="form-label" for="idnxb">Năm xuất bản
								</label> <input type="number" id="idnxb" name="nxb"
									class="form-control" />
							</div>

							<!-- Category -->
							<select class="form-select mb-4" name="loaiSach" id="">
								<option selected>Loại sách</option>
								<option value="old">Sách cũ</option>
								<option value="new">Sách mới</option>
							</select>

							<!-- Status -->
							<select class="form-select mb-4" name="tinhTrang" id="">
								<option selected>Tình trạng</option>
								<option value="active">Có sẵn</option>
								<option value="nonactive">Không có sẵn</option>
							</select>

							<!-- Kind of book -->
							<select class="form-select mb-4" name="theLoai" id="">
								<option selected>Thể loại</option>
								<option value="phieuLuu">Phiêu lưu</option>
								<option value="hocTap">Học tập</option>
								<option value="truyenTranh">Truyện tranh</option>
								<option value="khac">Khác</option>
							</select>

							<!-- Upload file -->
							<label class="form-label" for="">Hình ảnh</label> <input
								type="file" class="form-control-file" id="" name="hinhAnh" />

							<!-- Quantity -->
							<div class="form-outline mt-4">
								<label class="form-label" for="idsoLuong">Số lượng<span
									class="red">*</span>
								</label> <input type="number" id="idsoLuong" name="soLuong" value="1"
									class="form-control" required />
							</div>

							<!-- Submit button -->
							<div class="text-center mt-5">
								<button type="submit" class="btn btn-primary btn-block mb-4">Thêm
									sách</button>
							</div>
						</form>
					</div>

				</div>

			</div>
			<!-- end div col -->

			<div class="col-md-7 mt-5">
				<img class="w-100"
					src="https://brenebrown.com/wp-content/uploads/2023/05/BB_FeaturedCover_Books_All.jpg"
					alt="">

				<!-- <img class="img-fluid mt-2" src="https://www.torontopubliclibrary.ca/content/reading-challenge/images/reading-challenge-hero.jpg" alt=""> -->

				<img class="img-fluid mt-4"
					src="https://www.hpb.com/on/demandware.static/-/Library-Sites-RefArchSharedLibrary/default/dw9a0ae43a/images/homepage/homepage-1/BookTok.png"
					alt="">
			</div>
			<!-- end div col -->
		</div>
		<!-- end row -->
	</div>
	<!-- end container -->

	<%@include file="admin_footer.jsp"%>
</body>
</html>
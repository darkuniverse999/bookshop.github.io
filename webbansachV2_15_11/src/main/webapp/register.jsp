<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>

<!-- css cdn -->
<link rel="stylesheet" href="bootstrap-5.3.1-dist/css/bootstrap.css">

<!-- js cdn -->
<script src="bootstrap-5.3.1-dist/js/bootstrap.bundle.js"></script>

<!-- fontawesome cdn -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
	integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<!-- mycss -->
<link rel="stylesheet" href="all_component/mycss.css">
</head>

<body style="background-color: #f0f1f2;">

	<%@include file="all_component/navbar.jsp"%>

	<div class="container mt-5">
		<div class="row">

			<div class="col-md-4 offset-md-4 mt-5">

				<div class="card">

					<div class="card-body">
						<h3 class="text-center mb-3">Đăng ký</h3>

						<c:if test="${not empty failMsg }">
							<h6 class="text-center red">${failMsg }</h6>
							<c:remove var="failMsg" scope="session" />
						</c:if>
						
						<c:if test="${not empty successMsg }">
							<h6 class="text-center text-success">${successMsg }</h6>
							<c:remove var="successMsg" scope="session" />
						</c:if>

						<form action="RegisterServlet" method="post">
							<!-- Full name -->
							<div class="form-outline mb-4">
								<label class="form-label" for="idHoTen">Họ và tên <span
									class="red">*</span></label> <input type="text" id="idHoTen"
									name="hoTen" class="form-control" required />
							</div>

							<!-- Email input -->
							<div class="form-outline mb-4">
								<label class="form-label" for="iduserDangKy">Tài khoản <span
									class="red">*</span></label> <input type="text" id="iduserDangKy"
									name="userDangKy" class="form-control" required />
							</div>

							<!-- Password input -->
							<div class="form-outline mb-4">
								<label class="form-label" for="idpassword">Mật khẩu <span
									class="red">*</span></label> <input type="password" id="idpassword"
									name="password" class="form-control" required />
							</div>

							<!-- Password re-input -->
							<div class="form-outline mb-4">
								<label class="form-label" for="idpasswordNhapLai">Nhập
									lại mật khẩu <span class="red">*</span>
								</label> <input type="password" id="idpasswordNhapLai"
									name="passwordNhapLai" class="form-control" required />
							</div>

							<!-- Phone -->
							<div class="form-outline mb-4">
								<label class="form-label" for="idphone">Số điện thoại<span
									class="red">*</span></label> <input type="phone" id="idphone"
									name="phone" class="form-control" required />
							</div>
							
							<!-- Email -->
							<div class="form-outline mb-4">
								<label class="form-label" for="idemail">Email<span
									class="red">*</span></label> <input type="email" id="idemail"
									name="email" class="form-control" required />
							</div>

							<div class="form-check">
								<input class="form-check-input" type="checkbox" value=""
									id="iddongYDK" name="dongYDK"> <label
									class="form-check-label" for="iddongYDK"> <a href="">Đồng
										ý điều khoản</a>
								</label>
							</div>

							<!-- Submit button -->
							<div class="text-center mt-5">
								<button type="submit" class="btn btn-primary btn-block mb-4">Đăng
									ký</button>
							</div>

							<!-- or Login -->
							<div class="text-center">
								<p>
									Đăng nhập: <a href="login.jsp">Đăng nhập</a>
								</p>
								<p>hoặc đăng nhập với:</p>
								<button type="button" class="btn btn-link btn-floating mx-1">
									<i class="fab fa-facebook-f"></i>
								</button>

								<button type="button" class="btn btn-link btn-floating mx-1">
									<i class="fab fa-google"></i>
								</button>

								<button type="button" class="btn btn-link btn-floating mx-1">
									<i class="fab fa-twitter"></i>
								</button>

								<button type="button" class="btn btn-link btn-floating mx-1">
									<i class="fab fa-github"></i>
								</button>
							</div>

						</form>
					</div>

				</div>

			</div>
			<!-- end div col -->
		</div>
		<!-- end row -->
	</div>
	<!-- end container -->

	<%@include file="all_component/footer.jsp"%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>

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
						<h3 class="text-center mb-3">Đăng nhập</h3>

						<c:if test="${not empty failMsg }">
							<h6 class="text-center red">${failMsg }</h6>
							<c:remove var="failMsg" scope="session" />
						</c:if>
						
						<!-- Start form -->
						<form action="LoginServlet" method="post">
							<!-- Email input -->
							<div class="form-outline mb-4">
								<label class="form-label" for="iduser">Tài
									khoản</label> <input type="text" id="iduser" name="user" class="form-control" />
							</div>

							<!-- Password input -->
							<div class="form-outline mb-4">
								<label class="form-label" for="idpassword">Mật
									khẩu</label> <input type="password" id="idpassword" name="password"
									class="form-control" />
							</div>

							<!-- 2 column grid layout for inline styling -->
							<div class="row mb-4">
								<div class="col d-flex justify-content-center">
									<!-- Checkbox -->
									<div class="form-check">
										<input class="form-check-input" type="checkbox" value=""
											id="idRemember" checked /> <label class="form-check-label"
											for="idRemember"> Nhớ tài khoản </label>
									</div>
								</div>

								<div class="col">
									<!-- Simple link -->
									<a href="#!">Quên mật khẩu?</a>
								</div>
							</div>

							<!-- Submit button -->
							<!-- Submit button -->
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary btn-block mb-4">Đăng nhập</button>
                            </div>

							<!-- Register buttons -->
							<div class="text-center">
								<p>
									Chưa có tài khoản? <a href="register.jsp">Đăng ký</a>
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
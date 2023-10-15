<%@page import="model.Sach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="database.SachDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Homepage</title>
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
	
<!-- google font 2 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Bitter:wght@100&family=Dela+Gothic+One&family=Open+Sans:wght@300&family=Young+Serif&display=swap"
	rel="stylesheet">
	
<!-- jquery cdn -->
<script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>
	
<!-- link mycss -->
<link rel="stylesheet" href="../all_component/mycss.css">

</head>

<body>
	
	<c:if test="${ empty adminSession }">
		<c:redirect url="../login.jsp"/>
	</c:if>

	<%@include file="admin_navbar.jsp"%>
	
	<h1>${adminSession }</h1>
	
	<%
	SachDAO sachDAO = new SachDAO();
	ArrayList<Sach> arrSachMoi = sachDAO.selectAllByNewBook(); //return a arraylist
	%>

	<!-- start content -->

	<div class="container cachTren">
		<div class="row ">
			<h3 class="mb-3 myfontfamily">SÁCH MỚI</h3>
		</div>
		<div class="row">

			<div class="card-group">

				<%
				int i = 0;
				for (Sach sach : arrSachMoi) {
				%>
				<!-- hien thi thong tin -->
				<div class="col-md-3 mb-5 d-flex justify-content-center">
					<div class="card h-100" style="width: 12em;">
						<a href="../bookdetails.jsp?bookid=<%=sach.getMaSach()%>"
							title="<%=sach.getTenSach()%>"><img
							src="../book/<%=sach.getPhoto()%>" width="204" height="319"
							class="card-img-top" alt="The archer"></a>
						<div class="card-body text-center">
							<a href="../bookdetails.jsp?bookid=<%=sach.getMaSach()%>"
								class="no-underline" title="<%=sach.getTenSach()%>" href="">
								<h5 class="card-title"><%=sach.getTenSach()%></h5>
								<h6 class="card-title">
									Tác giả:<%=sach.getTacGia()%></h6>
								<h6 class="card-title"><%=sach.getGiaBan()%>₫
								</h6>
							</a>

						</div>
						<div class="card-footer mycardfooter text-center">
							<a href="#id" title="Đặt hàng ngay" href="#"
								class="btn btn-danger">Mua</a>

							<a 
								title="Thêm vào giỏ hàng" href="#id" class="btn btn-danger"><i
								class="fa-solid fa-cart-plus"></i></a> <a
								title="Thêm vào danh sách ưa thích" href=""
								class="btn btn-danger"><i class="fa-regular fa-heart"></i></a>
						</div> 
						
						
						 
					</div>
				</div>

				<%
				i++;

				if (i == 7) {
					break; //break foreach
				} // end if
				} // end for
				%>
			</div>
			<!-- end card group -->
			

		</div>
		<!-- end row -->
		
			
			  
			

	</div>
	<!-- end container show new book -->
	

	<!-- button xem them -->
	<div class="row text-center mt-3">
		<div class="col-md-4 offset-4 ">
			<a href="../newbook.jsp"><div class="btn btn-primary">Xem thêm</div></a>
		</div>

	</div>
	<!-- end button xem them -->



	<!-- start container old book -->
	<div class="container mt-5">
		<div class="row">
			<h3 class="mb-3 myfontfamily">SÁCH CŨ</h3>
		</div>
		<div class="row">
			<div class="card-group">

				<%
				ArrayList<Sach> arrSachCu = sachDAO.selectAllByOldBook(); //return a arraylist
				int i2 = 0;
				for (Sach sach : arrSachCu) {
				%>
				<!-- hien thi thong tin -->
				<div class="col-md-3 mb-5 d-flex justify-content-center">
					<div class="card h-100" style="width: 12em;">
						<a href="../bookdetails.jsp?bookid=<%=sach.getMaSach()%>"
							title="<%=sach.getTenSach()%>" href=""><img
							src="../book/<%=sach.getPhoto()%>" width="204" height="319"
							class="card-img-top" alt="The archer"></a>
						<div class="card-body text-center">
							<a href="../bookdetails.jsp?bookid=<%=sach.getMaSach()%>"
								title="<%=sach.getTenSach()%>" href="">
								<h5 class="card-title"><%=sach.getTenSach()%></h5>
								<h6 class="card-title">
									Tác giả:<%=sach.getTacGia()%></h6>
								<h6 class="card-title"><%=sach.getGiaBan()%>₫
								</h6>
							</a>

						</div>
						<div class="card-footer mycardfooter text-center">
							<a href="#id" title="Đặt hàng ngay" href="#"
								class="btn btn-danger">Mua</a> <a
								href="#id"
								title="Thêm vào giỏ hàng" href="#" class="btn btn-danger"><i
								class="fa-solid fa-cart-plus"></i></a> <a
								title="Thêm vào danh sách ưa thích" href=""
								class="btn btn-danger"><i class="fa-regular fa-heart"></i></a>
						</div>
					</div>
				</div>

				<%
				i2++;

				if (i2 == 7) {
					break; //break foreach
				} // end if
				} // end foreach
				%>
			</div>
			<!-- end card group -->

		</div>
		<!-- end row show old book -->

		<!-- button xem them -->
		<div class="row text-center mt-3">
			<div class="col-md-4 offset-4 ">
				<a href="../oldbook.jsp"><div class="btn btn-primary">Xem
						thêm</div></a>
			</div>

		</div>
		<!-- end button xem them -->

	</div>
	<!-- end container old book -->

	<!-- end content -->
	
	<%@include file="admin_footer.jsp"%>
	

</body>
</html>
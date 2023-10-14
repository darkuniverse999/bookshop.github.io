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
<title>Search Books</title>


<!-- css cdn -->
<link rel="stylesheet" href="bootstrap-5.3.1-dist/css/bootstrap.css">

<!-- js cdn -->
<script src="bootstrap-5.3.1-dist/js/bootstrap.bundle.js"></script>

<!-- fontawesome cdn -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
	integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
	
<!-- google font 2 -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
        href="https://fonts.googleapis.com/css2?family=Bitter:wght@100&family=Dela+Gothic+One&family=Open+Sans:wght@300&family=Young+Serif&display=swap"
        rel="stylesheet">

<!-- mycss -->
<link rel="stylesheet" href="all_component/mycss.css">


</head>
<body>
	<%@include file="all_component/navbar.jsp"%>


	<%
	
	String noiDungTimKiem = request.getParameter("noiDungTimKiem");
	String searchContent = (String) session.getAttribute("msgUserContent");
	%>

	
	<!-- start content -->
	
	<div class="container cachTren">
	<h5>Từ khóa tìm kiếm: <%=noiDungTimKiem %></h5>
	<c:if test="${not empty msgUserContent}">
		<h5>Từ khóa tìm kiếm:  <%=searchContent %></h5>
		<h5>test tu khoa:  <%=searchContent %></h5> 
		<h5>hoac: ${msgUserContent } </h5> 
		
	</c:if>
	
	
		<div class="row text-center">
			<h3 class="mb-3 myfontfamily">KHO SÁCH</h3>
		</div>
		<div class="row">

			<div class="card-group">
			
			<%
				ArrayList<Sach> arrSach = (ArrayList<Sach>) session.getAttribute("searchedBooks"); //return arrlist searched book
						
				for(Sach sach : arrSach) {
			%>
				
				<!-- hien thi thong tin -->
				<div class="col-md-3 mb-5">
					<div class="card h-100" style="width: 12em;">
						<a title="<%=sach.getTenSach()%>" href=""><img
							src="book/<%=sach.getPhoto()%>" width="204" height="319"
							class="card-img-top" alt="The archer"></a>
						<div class="card-body text-center">
							<a class="no-underline" title="<%=sach.getTenSach()%>" href="">
								<h5 class="card-title"><%=sach.getTenSach()%></h5>
								<h6 class="card-title">Tác giả:<%=sach.getTacGia()%></h6>
								<h6 class="card-title"><%=sach.getGiaBan()%>₫</h6>
							</a>
							
						</div>
						<div class="card-footer mycardfooter text-center">
							<a title="Đặt hàng ngay" href="orderdetails.jsp?bookid=<%=sach.getMaSach() %>" class="btn btn-danger">Mua</a>
							<a href="AddCartServlet?bookid=<%=sach.getMaSach()%>" title="Thêm vào giỏ hàng" href="#" class="btn btn-danger"><i
								class="fa-solid fa-cart-plus"></i></a> <a
								title="Thêm vào danh sách ưa thích" href=""
								class="btn btn-danger"><i class="fa-regular fa-heart"></i></a>
						</div>
					</div>
				</div>  <!-- end col 3 -->

				<%	
					}
				%>
				</div>  <!-- end card group -->
			</div> <!-- end row -->
		</div> <!-- end container show book -->
	<!-- end content -->

	<%@include file="all_component/footer.jsp"%>

</body>
</html>
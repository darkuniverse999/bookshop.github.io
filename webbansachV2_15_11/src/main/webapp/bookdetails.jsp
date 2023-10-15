<%@page import="model.Sach"%>
<%@page import="database.SachDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book Details</title>

    <!-- link css -->
    <link rel="stylesheet" href="bootstrap-5.3.1-dist/css/bootstrap.css">

    <!-- src script js -->
    <script src="bootstrap-5.3.1-dist/js/bootstrap.bundle.js"></script>

    <!-- fontawesome cdn -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
        integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />

    <!-- link to mycss.css -->
    <link rel="stylesheet" href="all_component/mycss.css">


    <!-- google font -->
    <!-- <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Young+Serif&display=swap" rel="stylesheet"> -->

    <!-- google font 2 -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
        href="https://fonts.googleapis.com/css2?family=Bitter:wght@100&family=Dela+Gothic+One&family=Open+Sans:wght@300&family=Young+Serif&display=swap"
        rel="stylesheet">

    <!-- google font 3 -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
        href="https://fonts.googleapis.com/css2?family=Bitter:wght@100&family=Dela+Gothic+One&family=Open+Sans:wght@300&family=Young+Serif&display=swap"
        rel="stylesheet">
        
</head>

<body>

	<%@include file="all_component/navbar.jsp"%>
	
	<%
		int id = Integer.parseInt(request.getParameter("bookid"));
		SachDAO sachDAO = new SachDAO();
		Sach sach = sachDAO.selectById(id); //return a book
	
	%>
	
    <div class="container cachTren">
        <div class="row">
            <div class="col-md-4">
                <img class="img-fluid h-100 w-100" src="book/<%=sach.getPhoto()%>"
                    alt="">
            </div>

            <div class="col-md-5">
                <h1 class="mytitle"><%=sach.getTenSach()%></h1>
                <div class="author text-uppercase">Tác giả: <%=sach.getTacGia()%></div>
                <div class="price"><%=sach.getGiaBan()%>₫</div>
                <div class="available text-uppercase"><i class="fa-regular fa-circle-check iconCachPhai"></i><%=sach.getTrangThai()%></div>
                <!-- <div class="unavailable"><i class="fa-regular fa-circle-xmark iconCachPhai"></i>KHÔNG CÓ SẴN</div> -->
                <div title="Click vào đây để xem thông tin chi tiết" role="button" class="details" data-bs-toggle="collapse" href="#collapseExample">THÔNG TIN CHI
                    TIẾT<i class="fa-solid fa-eye iconCachTrai"></i></div>
                <!-- <div class="collapse" id="collapseExample">
                    <div class="card card-body">
                        Some placeholder content for the collapse component. This panel is hidden by default but
                        revealed when the user activates the relevant trigger.
                    </div>
                </div> -->
                <a href="orderdetails.jsp?bookid=<%=sach.getMaSach()%>"><div title="Mua ngay" class="btn btn-danger mybtn">MUA NGAY</div></a>
                <a href="AddCartServlet?bookid=<%=sach.getMaSach()%>" ><div title="Thêm vào giỏ hàng" class="btn btn-outline-danger mybtn"><i
                        class="fa-solid fa-cart-plus"></i>THÊM VÀO GIỎ HÀNG</div></a>
                <div title="Thêm vào danh sách ưa thích " class="btn btn-outline-danger mybtn"><i
                        class="fa-regular fa-heart"></i></div>
                <br> <br>
                <a href="index.jsp" title="Tiếp tục mua hàng" href="">Tiếp tục mua hàng <i class="fa-solid fa-arrow-right-long iconCachTrai"></i></a>
            </div> <!-- end col 5 -->


            <div class="collapse col-md-3 bookinfoborder" id="collapseExample">
                <div class="available bookinfo"><i class="fa-regular fa-circle-check iconCachPhai"></i>THÔNG TIN
                    SÁCH</div>
                <ul class="details-li text-uppercase" style="line-height: 35px;">
                    <li>LOẠI SÁCH: <%=sach.getLoaiSach()%></li>
                    <li>NĂM XUẤT BẢN: <%=sach.getNXB()%></li>
                    <li>NGƯỜI BÁN: <%=sach.getEmail()%></li>
                    <li>SỐ TRANG: </li>
                    <li>MÔ TẢ: </li>
                    <li>VỀ TÁC GIẢ: </li>
                    <li>ĐỌC THỬ:</li>
                </ul>

            </div>
        </div> <!-- end row -->
    </div> <!-- end container -->

	<%@include file="all_component/footer.jsp"%>

</body>

</html>




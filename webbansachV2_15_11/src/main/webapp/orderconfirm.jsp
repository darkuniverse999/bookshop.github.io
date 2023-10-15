<%@page import="model.ChiTietDonHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Confirm Order</title>

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

<style>
    .mycarousel img {
        height: 350px;
    }
</style>

<body style="background-color: #f0f1f2; ">
	
	<c:if test="${ empty khachHang }">
		<c:redirect url="login.jsp"/>
	</c:if>

    <%
	
	ChiTietDonHang ctdh = (ChiTietDonHang) session.getAttribute("ctdhChoXacNhan"); //return a chi tiet don hang obj
	
	double tongTien = ctdh.getSoLuong() * ctdh.getSach().getGiaBan();	
	%>

	<%@include file="all_component/navbar.jsp"%>
    
    <!-- aliceblue, moccasin -->
    <!-- style="border-left: ridge" -->

     <div class="container cachTren " style="border-radius: 6px;">
        <div class="row justify-content-center  ">
            

            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <h2 class="text-center">XÁC NHẬN ĐƠN HÀNG</h2>

                        <div class="row">
                            <form action="ConfirmOrderServlet" method="post">
                                <div class="d-flex flex-wrap justify-content-between ">
                                    <div class="col-md-5 mb-3">
                                        <label for="idhoTen" class="form-label">Họ và tên</label>
                                        <input type="text" class="form-control" id="idhoTen" name="hoTen"
                                            value="<%=ctdh.getTenNguoiNhan() %>"  disabled>
                                    </div> <!-- end div col trong form -->
        
                                    <div class="col-md-5 mb-3">
                                        <label for="iddiaChiNhanHang" class="form-label">Địa chỉ nhận hàng</label>
                                        <textarea class="form-control" id="iddiaChiNhanHang" name="diaChiNhanHang" rows="3" disabled><%=ctdh.getDiaChiNhanHang()%></textarea>
                                    </div> <!-- end div col trong form -->
        
                                    <div class="col-md-5 mb-3">
                                        <label for="idsdt" class="form-label">Số điện thoại</label>
                                        <input type="tel" class="form-control" id="idsdt" name="sdt"
                                            value="<%=ctdh.getSdt() %>" disabled>
                                    </div> <!-- end div col trong form -->
        
                                    <div class="col-md-5 mb-3">
                                        <label for="idhinhThucThanhToan" class="form-label">Hình thức thanh toán</label>
                                        <select class="form-select" name="hinhThucThanhToan" id="idhinhThucThanhToan" disabled>
                                        
                                        	<%
                                        	if(ctdh.getHinhThucThanhToan().equals("Thanh toán khi nhận hàng")) {
                                        	%>
                                        		<option value="Thanh toán khi nhận hàng" selected>Thanh toán khi nhận hàng</option>
                                        	<%	
                                        	} else {
                                        	%>	
                                        		<option value="Chuyển khoản">Chuyển khoản</option>
                                        	<%	
                                        	}
                                        	%>
 
                                        </select>
                                    </div> <!-- end div col trong form -->
        
                                    <div class="col-md-5 mb-3">
                                        <label for="idemail" class="form-label">Email</label>
                                        <input type="email" class="form-control" id="idemail" name="email"
                                            value="<%=ctdh.getEmail() %>" disabled>
                                    </div> <!-- end div col trong form -->
        
                                    <div class="col-md-5 mb-3">
                                        <label for="idmaGiamGia" class="form-label">Mã giảm giá</label>
                                        <input type="email" class="form-control" id="idmaGiamGia" name="maGiamGia"
                                            placeholder="Nhập mã giảm giá" value="<%=ctdh.getMaGiamGia() %>" disabled>
                                    </div> <!-- end div col trong form -->

                                    <div class="col-md-4 mb-3 mt-2 d-flex text-nowrap align-items-center">
                                        <label for="idsoLuong" class="form-label align-items-center">Số lượng:</label>

                                        <input type="number" class="form-control khungSoLuong" id="idsoLuong" name="soLuong"
                                            value="<%=ctdh.getSoLuong() %>" disabled>
                                    </div> <!-- end div col trong form -->

                                    <div class="col-md-5 mb-3 mt-2 d-flex text-nowrap align-items-center">
                                        <label for="idtongTien" class="form-label align-items-center">Tổng tiền:</label>
                                        <input type="number" class="form-control khungSoLuong" id="idtongTien" name="tongTien"
                                            value="<%=tongTien %>" readonly>
                                    </div> <!-- end div col trong form -->
        
                                </div> <!-- end div chia cot trong form-->
								
								<!-- button -->
                        <div class="mydiv text-center mt-4 mb-5 ">
                            <button type="submit" title="Xác nhận" class="btn btn-danger mx-3">Xác nhận</button>
                            <a href="orderdetails.jsp?bookid=<%=ctdh.getSach().getMaSach() %>"><div title="Tiếp tục mua hàng" class="btn btn-outline-danger">Trở về</div></a>
                        </div> <!-- end button -->
                        
                            </form>
                        </div> <!-- end row form -->
        
                        
                    </div><!-- end col 6 -->
                    </div>
                </div>
        </div> <!-- end row -->
    </div><!-- end container -->
    
    

	
	<!-- TEST -->
	<h3>ten nguoi nhan: <%=ctdh.getTenNguoiNhan() %></h3>   
	
	<h4>test thử utf-8: bông hoa hồng</h4> 
	
	<h4>test thử utf-8: ${ctdhChoXacNhan.tenNguoiNhan }</h4>                    

	<%@include file="all_component/footer.jsp"%>

</body>

</html>
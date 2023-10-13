<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Details</title>

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

	<%@include file="all_component/navbar.jsp"%>
    
    <!-- aliceblue, moccasin -->
    <!-- style="border-left: ridge" -->

    <div class="container cachTren " style="border-radius: 6px;">
        <div class="row justify-content-center  ">
            

            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <h2 class="text-center">THÔNG TIN ĐẶT HÀNG</h2>

                        <div class="row">
                            <form action="">
                                <div class="d-flex flex-wrap justify-content-between ">
                                    <div class="col-md-5 mb-3">
                                        <label for="idhoTen" class="form-label">Họ và tên</label>
                                        <input type="text" class="form-control" id="idhoTen" name="hoTen"
                                            value="<%=kh.getHoTen() %>" required>
                                    </div> <!-- end div col trong form -->
        
                                    <div class="col-md-5 mb-3">
                                        <label for="iddiaChiNhanHang" class="form-label">Địa chỉ nhận hàng</label>
                                        <textarea class="form-control" id="iddiaChiNhanHang" name="diaChiNhanHang" rows="3" value="<%=kh.getDiaChiNhanHang() %>" required></textarea>
                                    </div> <!-- end div col trong form -->
        
                                    <div class="col-md-5 mb-3">
                                        <label for="idsdt" class="form-label">Số điện thoại</label>
                                        <input type="tel" class="form-control" id="idsdt" name="sdt"
                                            value="<%=kh.getSdt()%>" required>
                                    </div> <!-- end div col trong form -->
        
                                    <div class="col-md-5 mb-3">
                                        <label for="idhinhThucThanhToan" class="form-label">Hình thức thanh toán</label>
                                        <select class="form-select" name="hinhThucThanhToan" id="idhinhThucThanhToan" required>
                                            <option value="">Chuyển khoản</option>
                                            <option value="" selected>Thanh toán khi nhận hàng</option>
                                        </select>
                                    </div> <!-- end div col trong form -->
        
                                    <div class="col-md-5 mb-3">
                                        <label for="idemail" class="form-label">Email</label>
                                        <input type="email" class="form-control" id="idemail" name="email"
                                            value="<%=kh.getEmail()%>">
                                    </div> <!-- end div col trong form -->
        
                                    <div class="col-md-5 mb-3">
                                        <label for="idmaGiamGia" class="form-label">Mã giảm giá</label>
                                        <input type="email" class="form-control" id="idmaGiamGia" name="maGiamGia"
                                            placeholder="Nhập mã giảm giá">
                                    </div> <!-- end div col trong form -->

                                    <div class="col-md-4 mb-3 mt-2 d-flex text-nowrap align-items-center">
                                        <label for="idsoLuong" class="form-label align-items-center">Số lượng:</label>

                                        <input type="number" class="form-control khungSoLuong" id="idsoLuong" name="soLuong"
                                            value="1">
                                    </div> <!-- end div col trong form -->
        
                                </div> <!-- end div chia cot trong form-->
                            </form>
                        </div> <!-- end row form -->
        
                        <!-- button -->
                        <div class="mydiv text-center mt-3 mb-5 ">
                            <div title="Đặt hàng ngay" class="btn btn-danger mx-3">Đặt hàng ngay</div>
                            <div title="Tiếp tục mua hàng" class="btn btn-outline-danger">Tiếp tục mua hàng</div>
                        </div> <!-- end button -->
                    </div><!-- end col 6 -->
                    </div>
                </div>
        </div> <!-- end row -->
    </div><!-- end container -->

	<%@include file="all_component/footer.jsp"%>

</body>

</html>
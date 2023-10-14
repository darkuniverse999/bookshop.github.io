<%@page import="database.CartDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Sach"%>
<%@page import="database.SachDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page isELIgnored="false" %>
 
 <%@ page import="javax.servlet.http.HttpServletRequest" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
<!-- link css -->
<link rel="stylesheet" href="bootstrap-5.3.1-dist/css/bootstrap.css">

<!-- src script js -->
<script src="bootstrap-5.3.1-dist/js/bootstrap.bundle.js"></script>

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
<link rel="stylesheet" href="all_component/mycss.css">

<!-- link svg icon alert 
<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
  <symbol id="check-circle-fill" fill="currentColor" viewBox="0 0 16 16">
    <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
  </symbol>
  <symbol id="info-fill" fill="currentColor" viewBox="0 0 16 16">
    <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
  </symbol>
  <symbol id="exclamation-triangle-fill" fill="currentColor" viewBox="0 0 16 16">
    <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
  </symbol>
</svg>

-->


</head>


<body style="background-color: #f0f1f2; ">
	<%@include file="all_component/navbar.jsp"%>


    <div class="container cachTren" style="border-radius: 6px;">
        <div class="row">

            <div class="col-md-6 ">
            
                <div class="card">
                    <div class="card-body">
                        <h2 class="text-center">GIỎ HÀNG CỦA BẠN</h2>

                        <table class="table table-striped text-center" >
                            <thead>
                                <tr>
                                    <th scope="col"></th>
                                    <th scope="col">Hình Ảnh</th>
                                    <th scope="col">Tên Sách</th>
                                    <th scope="col">Tác Giả</th>
                                    <th scope="col">Giá</th>
                                    <th scope="col"></th>
                                </tr>
                            </thead>
                            
                            <tbody>
                            
                            <%
                            
                            //List<Cart> listCart = (ArrayList<Cart>) session.getAttribute("userCart"); //return a list cart of user 
                            
                   			CartDAO cartDAO = new CartDAO();
                   			List<Cart> listCart = cartDAO.selectCartByUserId(kh.getMaKhachHang()); 

                            %>
                            
                            	<%
                            double tongTien=0.0;
                            for(Cart cart : listCart) { 
                        	%>
                            	<tr>
                                    <td class="td"><a title="XÓA KHỎI GIỎ HÀNG"  href="DeleteCartServlet?cartid=<%=cart.getMaGioHang() %>" ><i class="fa-solid fa-xmark"></i></a></td>
                                    <td class="td"><a href="bookdetails.jsp?id=<%=cart.getSach().getMaSach()%>"><img alt="" src="book/<%=cart.getSach().getPhoto()%>" style="width:70px; height:100px;"> </a></td>
                                    <td class="td"><a href="bookdetails.jsp?id=<%=cart.getSach().getMaSach()%>"> <%=cart.getSach().getTenSach() %></a></td>
                                    <td class="td"><%=cart.getSach().getTacGia() %></td>
                                    <td class="td"><%=cart.getSach().getGiaBan() %></td>
                                    <td class="td"><a href="orderdetails.jsp?bookid=<%=cart.getSach().getMaSach()%>"><div class="btn btn-warning">Mua</div></a></td>
                                    
                                </tr>
    
                            <%
                            tongTien+=cart.getSach().getGiaBan();
                           
                            }
                            %>


                            </tbody>
                        </table>
                        
                        <div class="bg-warning justify-content-between d-flex">
                            <h6>Tổng tiền:</h6>
                            <h4 class="red"><%=tongTien%>₫</h4>
                        </div>
                    </div> <!-- end card body -->
                </div> <!-- end div card -->
     
            </div> <!-- end col 6 -->
           
      
			

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
                                        <textarea class="form-control" id="iddiaChiNhanHang" name="diaChiNhanHang" rows="3"  required><%=kh.getDiaChiNhanHang() %></textarea>
                                    </div> <!-- end div col trong form -->
        
                                    <div class="col-md-5 mb-3">
                                        <label for="idsdt" class="form-label">Số điện thoại</label>
                                        <input type="tel" class="form-control" id="idsdt" name="sdt"
                                            value="<%=kh.getSdt()%>" required>
                                    </div> <!-- end div col trong form -->
        
                                    <div class="col-md-5 mb-3">
                                        <label for="idhinhThucThanhToan" class="form-label">Hình thức thanh toán</label>
                                        <select class="form-select" name="hinhThucThanhToan" id="idhinhThucThanhToan">
                                            <option value="">Chuyển khoản</option>
                                            <option value="" selected>Thanh toán khi nhận hàng</option>
                                        </select>
                                    </div> <!-- end div col trong form -->
        
                                    <div class="col-md-5 mb-3">
                                        <label for="idemail" class="form-label">Email</label>
                                        <input type="email" class="form-control" id="idemail" name="email"
                                            value="<%=kh.getEmail()%>">
                                    </div> <!-- end div col trong form -->
        
                                    
        
                                </div> <!-- end div chia cot trong form-->
                            </form>
                        </div> <!-- end row form -->
        
                        <!-- button -->
                        <div class="mydiv text-center mt-5  ">
                            <div title="Cập nhật thông tin" class="btn btn-warning mx-3 text-white">Cập nhật thông tin</div>
                            <div title="Tiếp tục mua hàng" class="btn btn-success">Tiếp tục mua hàng</div>
                        </div> <!-- end button -->
                    </div><!-- end col 6 -->
                    </div>
                </div>

        </div> <!-- end row -->
    </div><!-- end container -->

	<%@include file="all_component/footer.jsp"%>
</body>

</html>
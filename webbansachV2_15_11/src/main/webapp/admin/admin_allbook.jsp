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
<title>All Book</title>
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

<body class="">

	<c:if test="${ empty adminSession }">
		<c:redirect url="../login.jsp"/>
	</c:if>
	
	<%@include file="admin_navbar.jsp"%>
	
	<div>
		<c:if test="${not empty successMsg }">
			<h4 class="text-center text-success"><i class="fa-solid fa-arrow-right text-success"></i>${successMsg }<i class="fa-solid fa-arrow-left text-success"></i></h4>
			<c:remove var="successMsg" scope="session" />
		</c:if>
	</div>

	<div class="my-bg-img">
	<div class="container">
		<div class="row">

			
			<table class="table table-striped text-center">
				<thead class="table-dark">
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Hình Ảnh</th>
						<th scope="col">Tên Sách</th>
						<th scope="col">Tác Giả</th>
						<th scope="col">Giá Bán</th>
						<th scope="col">Loại Sách</th>
						<th scope="col">NXB</th>
						<th scope="col">Trạng Thái</th>
						<th scope="col">Thể Loại</th>
						<th scope="col">Số Lượng</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				
				<%
				SachDAO sachDAO = new SachDAO();
				ArrayList<Sach> sachs = sachDAO.selectAll(); //return a arraylist
				for(Sach sach : sachs) {
				%>
					
					<tbody>
					<tr>
						<th class=""><%=sach.getMaSach()%></th>
						<td class=""><a href="../bookdetails.jsp?id=<%=sach.getMaSach()%>"><img alt="" src="../book/<%=sach.getPhoto()%>" style="width: 49px; height: 70px"></a></td>
						<td class=""><a href="../bookdetails.jsp?id=<%=sach.getMaSach()%>"><%=sach.getTenSach()%></a> </td>
						<td class=""><%=sach.getTacGia()%></td>
						<td class=""><%=sach.getGiaBan()%></td>
						<td class=""><%=sach.getLoaiSach()%></td>
						<td class=""><%=sach.getNXB()%></td>
						<td class=""><%=sach.getTrangThai()%></td>
						<td class=""><%=sach.getTheLoai()%></td>
						<td class=""><%=sach.getSoLuong()%></td>
						<td class="">
							<a href="admin_editbook.jsp?id=<%=sach.getMaSach()%>"><div class="btn btn-primary"><i class="fa-regular fa-pen-to-square iconCachPhai"></i>Sửa</div>
							</a> 
							<a href="admin_allbook.jsp?id=<%=sach.getMaSach()%>" data-bs-toggle="modal" data-bs-target="#<%=sach.getMaSach()%>"><div class="btn btn-danger"><i class="fa-regular fa-square-minus iconCachPhai"></i>Xóa</div></a>
						
							<!-- MODAL BOOTSTRAP -->
							 <div class="modal fade" id="<%=sach.getMaSach()%>" tabindex="-1" aria-labelledby="exampleModalLabeltest" aria-hidden="true">
						        <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
						            <div class="modal-content">
						                <div class="modal-header">
						                    <h1 class="modal-title fs-5 text-danger" id="exampleModalLabeltest"><i class="fa-solid fa-triangle-exclamation iconCachPhai"></i>Thông báo!</h1>
						                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
						                </div>
						                <div class="modal-body">
						                    <h4 class="text-center text-danger">Bạn muốn xóa quyển sách?</h4>
						                </div>
						                <div class="modal-footer">
						                	<a href="../DeleteBookServlet?id=<%=sach.getMaSach()%>" ><div class="btn btn-primary">Đồng ý</div></a>
						                    
						                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
						                </div>
						            </div>
						        </div>
						    </div> <!-- end modal -->
						    
						</td> <!-- end table data button -->
						
					</tr> 	
					
				</tbody>
				
				
				
				<%
				}
				%>
			</table>
		</div> <!-- end row -->
	</div> <!-- end container table -->
	</div> <!-- end div chua container  -->
	
	
	<% String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath(); %>
	<h1><%=path %>/admin/admin_allbook.jsp</h1>


	<%
    HttpServletRequest request2 = (HttpServletRequest) request;
    String currentURL = request2.getRequestURL().toString();
    // hoặc sử dụng request.getRequestURI() nếu bạn chỉ cần URI (đường dẫn tương đối)

    out.println("Đường dẫn hiện tại: " + currentURL);
	%>

	<%@include file="admin_footer.jsp"%>
</body>
</html>
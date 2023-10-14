package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.SachDAO;
import model.ChiTietDonHang;
import model.KhachHang;
import model.Sach;

/**
 * Servlet implementation class OrderDetailsServlet
 */
@WebServlet("/OrderDetailsServlet")
public class OrderDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
//		String hoTen = request.getParameter("hoTen");
//		String diaChiNhanHang = request.getParameter("diaChiNhanHang");
//		String sdt = request.getParameter("sdt");
//		String hinhThucThanhToan = request.getParameter("hinhThucThanhToan");
//		String email = request.getParameter("email");
//		String maGiamGia = request.getParameter("maGiamGia");
//		int soLuong = Integer.parseInt(request.getParameter("soLuong"));
//		
//		HttpSession session = request.getSession();
//		
////		DonHang donHangChoXacNhan = new DonHang();
////		donHangChoXacNhan.setHinhThucThanhToan(hinhThucThanhToan);
//		
//		ChiTietDonHang ctdhChoXacNhan = new ChiTietDonHang();
////		ctdhChoXacNhan.setDonHang(donHangChoXacNhan); //set don hang
//		ctdhChoXacNhan.setTenNguoiNhan(hoTen);
//		ctdhChoXacNhan.setDiaChiNhanHang(diaChiNhanHang);
//		ctdhChoXacNhan.setSdt(sdt);
//		ctdhChoXacNhan.setHinhThucThanhToan(hinhThucThanhToan);
//		ctdhChoXacNhan.setEmail(email);
//		ctdhChoXacNhan.setMaGiamGia(maGiamGia);
//		ctdhChoXacNhan.setSoLuong(soLuong);
//		
//		session.setAttribute("ctdhChoXacNhan", ctdhChoXacNhan); 
//		
//		System.out.println("chuyen tu servlet order details den trang orderconfirm");
//		response.sendRedirect("orderconfirm.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//sua loi font tieng viet doPost o day:
		//set character tieng viet cho doPost
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		
		String hoTen = request.getParameter("hoTen");
		String diaChiNhanHang = request.getParameter("diaChiNhanHang");
		String sdt = request.getParameter("sdt");
		String hinhThucThanhToan = request.getParameter("hinhThucThanhToan");
		String email = request.getParameter("email");
		String maGiamGia = request.getParameter("maGiamGia");
		int soLuong = Integer.parseInt(request.getParameter("soLuong"));
		
		HttpSession session = request.getSession();
		
//		DonHang donHangChoXacNhan = new DonHang();
//		donHangChoXacNhan.setHinhThucThanhToan(hinhThucThanhToan);
		
		int maSach = Integer.parseInt(request.getParameter("maSach"));
		
		SachDAO sachDAO = new SachDAO();
		Sach sach = sachDAO.selectById(maSach); //return a book
		double giaBan = (double) sach.getGiaBan(); //da co gia ban
		
		ChiTietDonHang ctdhChoXacNhan = new ChiTietDonHang();
//		ctdhChoXacNhan.setDonHang(donHangChoXacNhan); //set don hang
		ctdhChoXacNhan.setTenNguoiNhan(hoTen);
		ctdhChoXacNhan.setDiaChiNhanHang(diaChiNhanHang);
		ctdhChoXacNhan.setSdt(sdt);
		ctdhChoXacNhan.setHinhThucThanhToan(hinhThucThanhToan);
		ctdhChoXacNhan.setEmail(email);
		ctdhChoXacNhan.setMaGiamGia(maGiamGia);
		ctdhChoXacNhan.setSoLuong(soLuong);
		ctdhChoXacNhan.setGiaBan(giaBan);
		ctdhChoXacNhan.setSach(sach); //set a book obj
		
		
		session.setAttribute("ctdhChoXacNhan", ctdhChoXacNhan); 
		
		System.out.println("chuyen tu servlet order details den trang orderconfirm");
		response.sendRedirect("orderconfirm.jsp");
//		response.sendRedirect("thanhcong2test.jsp");
		
	}

}

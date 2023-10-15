package controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.ChiTietDonHangDAO;
import database.DonHangDAO;
import model.ChiTietDonHang;
import model.DonHang;
import model.KhachHang;

/**
 * Servlet implementation class ConfirmOrderServlet
 */
@WebServlet("/ConfirmOrderServlet")
public class OrderConfirmationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderConfirmationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		//set character tieng viet cho doPost
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		KhachHang kh = (KhachHang) session.getAttribute("khachHang"); //return a khach hang obj
		
		double tongTien = Double.parseDouble(request.getParameter("tongTien"));
		
		System.out.println(request.getParameter("tongTien"));
		
		ChiTietDonHang chiTietDonHang = (ChiTietDonHang) session.getAttribute("ctdhChoXacNhan"); //session return a ctdh obj
		chiTietDonHang.setTongThanhTien(tongTien); // set tong tien dc lay tu trang order confirmation
		
		Random rd = new Random();
		int maDonRandom = (int) (System.currentTimeMillis() + rd.nextInt(1000));
		DonHang donHang = new DonHang(maDonRandom, kh, chiTietDonHang.getDiaChiNhanHang(), "Mới tạo", chiTietDonHang.getHinhThucThanhToan(), "chưa thanh toán - chờ cập nhật", null, null);
		
//		donHang.setMaDon(maDonRandom); //set ma don hang random
		
		DonHangDAO donHangDAO = new DonHangDAO();
		int kq1 = donHangDAO.insert(donHang); //them don hang vao csdl truoc tien moi them chi tiet don hang
		
		chiTietDonHang.setDonHang(donHang); //set don hang
		
		int maCTDHRandom = (int) (System.currentTimeMillis() + rd.nextInt(1000));
		System.out.println("ma chi tiet don hang random: "+maCTDHRandom);
		chiTietDonHang.setMaChiTietDonHang(maCTDHRandom); //set ma chi tiet don hang random
		
		ChiTietDonHangDAO ctdhDAO = new ChiTietDonHangDAO();
		int kq2 = ctdhDAO.insert(chiTietDonHang); // them chi tiet don hang vao csdl
		
		if(kq1==1 && kq2==1) {
			response.sendRedirect("thankyouuser.jsp");
			session.removeAttribute("ctdhChoXacNhan"); //xoa cai session ctdhChoXacNhan cua trang order details servlet di
		}
		else {
			response.sendRedirect("thatbai.jsp");
		}
		
		
	}
}

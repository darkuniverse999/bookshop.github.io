package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.ChiTietDonHangDAO;
import database.DonHangDAO;

/**
 * Servlet implementation class Admin_DisplayUserOrder
 */
@WebServlet("/Admin_DisplayUserOrder")
public class Admin_DisplayUserOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_DisplayUserOrder() {
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
		
		// KHONG CAN DUNG SERVLET NAY
		// KHONG CAN DUNG SERVLET NAY
		// KHONG CAN DUNG SERVLET NAY
		// KHONG CAN DUNG SERVLET NAY
		// KHONG CAN DUNG SERVLET NAY
		
//		DonHangDAO donHangDAO = new DonHangDAO();
//		donHangDAO.selectAll(); //return arr list don hang 
//		
//		ChiTietDonHangDAO ctdhDAO = new ChiTietDonHangDAO();
		
		
	}

}

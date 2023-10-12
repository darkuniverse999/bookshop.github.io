package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.CartDAO;
import database.SachDAO;
import model.Cart;
import model.KhachHang;
import model.Sach;

/**
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int bookId = Integer.parseInt(request.getParameter("bookid")); //lay bookid tren url ?bookid=
		//c1: lấy theo session
		HttpSession session = request.getSession();

		Object obj = (KhachHang) session.getAttribute("khachHang");
		KhachHang kh = new KhachHang();
		if (obj != null) {
			kh = (KhachHang) obj;
			System.out.println("hey hey");
			
			SachDAO sachDAO = new SachDAO();
			Sach sach = sachDAO.selectById(bookId); //return a book
					
			
			Cart cart = new Cart();
			cart.setKhachHang(kh);
			cart.setSach(sach);
			cart.setTongTien((double)sach.getGiaBan());
			
			// them vao session gio hang cua user
			ArrayList<Cart> listCart = (ArrayList<Cart>) session.getAttribute("userCart"); //return a list cart
			listCart.add(cart);
			
			CartDAO cartDAO = new CartDAO();
			cartDAO.insert(cart);
			
			//tao 1 session msg thong bao thanh cong
			
			session.setAttribute("addCart", "Thêm vào giỏ hàng thành công");
			
			response.sendRedirect("index.jsp");
//			response.sendRedirect("thanhcong2test.jsp");
			
		} else {
			response.sendRedirect("login.jsp");
		}
		
		
		
//		SachDAO sachDAO = new SachDAO();
//		Sach sach = sachDAO.selectById(bookId); //return a book
//				
//		
//		Cart cart = new Cart();
//		cart.setKhachHang(kh);
//		cart.setSach(sach);
//		cart.setTongTien((double)sach.getGiaBan());
//		
//		ArrayList<Cart> listCart = (ArrayList<Cart>) session.getAttribute("userCart"); //return a list cart
//		listCart.add(cart);
		
		
		//linh tinh
//		kh.getListCart().add(cart); //return arraylist
		
		
//		session.setAttribute("userCart", cart); //session cart
		
		
		
//		CartDAO cartDAO = new 
		//end linh tinh
		
//		CartDAO cartDAO = new CartDAO();
//		cartDAO.insert(cart);
		
		
		
//		request.getParameter("uid"); //c1: lấy uid trên thanh url => nếu k có user => uid auto = 0 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

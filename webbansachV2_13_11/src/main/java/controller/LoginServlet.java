package controller;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.CartDAO;
import database.KhachHangDAO;
import model.Cart;
import model.KhachHang;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		String url="";
		
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
//		HttpSession session2 = request.getSession();
		
		KhachHangDAO khDAO = new KhachHangDAO();
		KhachHang kh = khDAO.kiemTraTaiKhoan(user, password);
		
		if(user.equalsIgnoreCase("admin") && password.equals("123")) {
			session.setAttribute("adminSesssion", "admin sesssion");
			response.sendRedirect("admin/admin_home.jsp");
			
		}
		
		else {
			if(kh!=null) { //return 1 KhachHang
//				url="/thanhcong.jsp";
				
				session.setAttribute("khachHang", kh);
				
				//linh tinh
//				Cart cart = new Cart();
//				cart.setKhachHang(kh);
//				cart.setTongTien(0.0);
				
//				ArrayList<Cart> listCart = new ArrayList<Cart>();
//				listCart.add(cart);
				
//				session.setAttribute("userCart", listCart); 
				//end linh tinh
				
//				CartDAO cartDAO = new CartDAO();
//				List<Cart> listCart = cartDAO.selectCartByUserId(kh.getMaKhachHang()); //return a list cart
//				
//				session.setAttribute("userCart", listCart); //user has a lot of carts
				
				
//				session.setAttribute("successMsg", "success...");
				response.sendRedirect("index.jsp");
//				response.sendRedirect("thanhcong.jsp");
			}
			else {
//				url="/thatbai.jsp";
				
				session.setAttribute("failMsg", "Vui lòng kiểm tra lại thông tin đăng nhập");
				response.sendRedirect("login.jsp");
			}
		}
		
		
//		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
//		rd.forward(request, response);
		
	}
}

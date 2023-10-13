package controller;

import java.io.IOException;
import java.util.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.CartDAO;
import model.Cart;

/**
 * Servlet implementation class DeleteCartServlet
 */
@WebServlet("/DeleteCartServlet")
public class DeleteCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
//		HttpSession session = request.getSession();
		
		int cartid = Integer.parseInt(request.getParameter("cartid"));
		
//		KhachHang kh = (KhachHang) session.getAttribute("khachHang"); //session store a KhachHang obj
//		Object obj = (Object) session.getAttribute("userCart"); //session store list cart of user
		
//		List<Cart> listCart = new ArrayList<Cart>();
		
//		if(obj!=null) {
//			
//			listCart =  (List<Cart>) obj;
//		}
		
//		for(Cart cartItem : listCart) {
//			if(cartid==cartItem.getMaGioHang()) {
//				listCart.remove(cartItem);
//			}
//		}
		
//		Iterator<Cart> iterator = listCart.iterator();
//		while (iterator.hasNext()) {
//		    Cart element = iterator.next();
//		    if (element.getMaGioHang()==cartid) {
//		    	iterator.remove(); // Xóa phần tử hiện tại
//		    }
//		    break;
//		}
		
//		List<Cart> newListCart = new ArrayList<Cart>();
//		Collections.addAll(newListCart, iterator);
		
		
//		List<Cart> newList = new ArrayList<>();
//		while (iterator.hasNext()) {
//		    Cart element = iterator.next();
//		    newList.add(element);
//		}
		
		
//		SachDAO sachDAO = new SachDAO();
//		Sach sach = sachDAO.selectById(idbook); //return a book obj
		
//		Cart cart = new Cart();
//		cart.setSach(sach);
//		cart.setKhachHang(kh);
		
		CartDAO cartDAO = new CartDAO();
		cartDAO.deleteCartById(cartid);
		
		
		
//		session.removeAttribute("userCart");
		
//		session.setAttribute("userCart", newList);
		
		response.sendRedirect("user_cart.jsp");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

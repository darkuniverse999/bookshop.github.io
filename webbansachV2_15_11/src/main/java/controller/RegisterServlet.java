package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.KhachHangDAO;
import model.KhachHang;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
//		System.out.println("a");
		
		HttpSession session = request.getSession();
		String dongYDieuKhoan = request.getParameter("dongYDK");
		String hoTen = request.getParameter("hoTen");
		String userDangKy = request.getParameter("userDangKy");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		KhachHang kh = new KhachHang();
		kh.setHoTen(hoTen);
		kh.setUser(userDangKy);
		kh.setPassword(password);
		kh.setSdt(phone);
		kh.setEmail(email);
			
		KhachHangDAO khDAO = new KhachHangDAO();
		
		if(dongYDieuKhoan!=null) {
//			response.sendRedirect("register.jsp");
//			System.out.println(dongYDieuKhoan);
			
			if(khDAO.kiemTraTenDangKy(userDangKy)) {
				session.setAttribute("failMsg", "Tên đăng nhập đã tồn tại");
				response.sendRedirect("register.jsp");
			}
			else {
				khDAO.insert(kh); //return int
				session.setAttribute("successMsg", "Đăng ký thành công");
				response.sendRedirect("register.jsp");
			}
			
		} 
		else {
			session.setAttribute("failMsg", "Bạn chưa đồng ý điều khoản");
			response.sendRedirect("register.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

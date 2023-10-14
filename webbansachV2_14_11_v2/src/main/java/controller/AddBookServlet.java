package controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;



import database.SachDAO;
import model.Sach;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/AddBookServlet")
@MultipartConfig
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
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
//		doGet(request, response);
		
		//set character tieng viet cho doPost
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		
		String tenSach=request.getParameter("tenSach");
		String tacGia=request.getParameter("tacGia");
		float giaGoc= Float.parseFloat(request.getParameter("giaGoc"));
		float giaBan= Float.parseFloat(request.getParameter("giaBan"));
		int nxb=Integer.parseInt(request.getParameter("nxb"));
		String loaiSach=request.getParameter("loaiSach");
		String tinhTrang=request.getParameter("tinhTrang");
		String theLoai=request.getParameter("theLoai");
		String hinhAnh=request.getParameter("hinhAnh");
		int soLuong= Integer.parseInt(request.getParameter("soLuong"));
		
		Part part=request.getPart("hinhAnh");
		String fileName=part.getSubmittedFileName();
		
//		String path=getServletContext().getRealPath("")+"book";
		String path="C:\\Users\\anhtu\\eclipse-workspace\\webbansachV2\\src\\main\\webapp\\book";
		System.out.println(path);
		
		File f = new File(path);
		part.write(path + File.separator + fileName);
		
		
//		System.out.println(fileName);
		
		Sach sach=new Sach(tenSach, tacGia, giaGoc, giaBan, loaiSach, nxb, tinhTrang, theLoai, fileName, "admin@gmail.com", soLuong);
		
		SachDAO sachDAO = new SachDAO();
		int ketQua = sachDAO.insert(sach); //return int
		
		HttpSession session = request.getSession();
		
		if(ketQua==1) {
			session.setAttribute("successMsg", "Thêm sách thành công");
			response.sendRedirect("admin/admin_addbook.jsp");
		}
		else {
			session.setAttribute("failMsg", "Thêm sách thất bại, vui lòng kiểm tra lại thông tin");
			response.sendRedirect("admin/admin_addbook.jsp");
		}
	}

}

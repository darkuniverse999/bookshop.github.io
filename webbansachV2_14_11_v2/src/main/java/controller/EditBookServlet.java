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
 * Servlet implementation class EditBookServlet
 */
@WebServlet("/EditBookServlet")
@MultipartConfig
public class EditBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditBookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		int maSach = Integer.parseInt(request.getParameter("maSach"));
		System.out.println("ma sach:" + maSach); // test
		String tenSach = request.getParameter("tenSach");
		System.out.println("ten sach" + tenSach); // test
		String tacGia = request.getParameter("tacGia");
		float giaGoc = Float.parseFloat(request.getParameter("giaGoc"));
		float giaBan = Float.parseFloat(request.getParameter("giaBan"));
		String loaiSach = request.getParameter("loaiSach");
		int nxb = Integer.parseInt(request.getParameter("nxb"));
		String tinhTrang = request.getParameter("tinhTrang");
		String theLoai = request.getParameter("theLoai");
//		String hinhAnh=request.getParameter("hinhAnh");
//		System.out.println("string hinh anh:"+hinhAnh); //test 
		int soLuong = Integer.parseInt(request.getParameter("soLuong"));

//		System.out.println(hinhAnh.equals(" ")); // neu k co hinh thi chuoi nay cung k bang khoang trang, the no la cai j?

		//
		Part part = request.getPart("hinhAnh");
		String fileName = part.getSubmittedFileName();
		System.out.println(fileName); // test

		String path = "C:\\Users\\anhtu\\eclipse-workspace\\webbansachV2\\src\\main\\webapp\\book";
		System.out.println(path);

		File f = new File(path);
		part.write(path + File.separator + fileName);

		
		Sach sachMoi = new Sach(maSach, tenSach, tacGia, giaGoc, giaBan, loaiSach, nxb, tinhTrang, theLoai, fileName,
				"admin@gmail.com", soLuong);

		SachDAO sachDAO = new SachDAO();
		int ketQua = sachDAO.update(sachMoi); // return int

		System.out.println(ketQua);
		
		HttpSession session = request.getSession();

		if (ketQua == 1) {
			session.setAttribute("successMsg", "Sửa thông tin sách thành công");
			response.sendRedirect("admin/admin_allbook.jsp");
		} else {
			response.sendRedirect("thatbai.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

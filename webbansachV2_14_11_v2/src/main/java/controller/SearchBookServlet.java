package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.SachDAO;
import database.SearchBookDAO;
import model.Sach;

/**
 * Servlet implementation class SearchBookServlet
 */
@WebServlet("/SearchBookServlet")
public class SearchBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
				//set character tieng viet cho doPost
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8");
				
//				String userContent = request.getParameter("searchbook");
//				System.out.println("noi dung user tim: "+userContent);
//				
//				SearchBookDAO searchBookDAO = new SearchBookDAO();
//				ArrayList<Sach> arrSach = searchBookDAO.searchBookByNameOrAuthor(userContent); //return a array list of book
//				
//				System.out.println("sach tim duoc:");
//				for(Sach sach : arrSach) {
//					System.out.println(sach.toString());
//				}
//				
//				//c1: tao 1 session luu arrSach chuyen qua searchedbook.jsp hien thi
//				HttpSession session = request.getSession();
//				session.setAttribute("searchedBooks", arrSach);
//				
//				session.setAttribute("msgusercontent", userContent);
//				
//				//c2: qua searchedbook.jsp goi SearchDAO truyen vao userContent
//				if(arrSach.size()>0) {
//					response.sendRedirect("searchedbook.jsp?noiDungTimKiem="+userContent);
//				} else {
//					response.sendRedirect("thatbai.jsp");
//				}
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
		
		String userContent = request.getParameter("searchbook");
		System.out.println("noi dung user tim: "+userContent);
		
		
		SearchBookDAO searchBookDAO = new SearchBookDAO();
		ArrayList<Sach> arrSach = searchBookDAO.searchBookByNameOrAuthor(userContent); //return a array list of book
		
		System.out.println("sach tim duoc:");
		for(Sach sach : arrSach) {
			System.out.println(sach.toString());
		}
		
		//c1: tao 1 session luu arrSach chuyen qua searchedbook.jsp hien thi
		HttpSession session = request.getSession();
		session.setAttribute("searchedBooks", arrSach);
		
		session.setAttribute("msgUserContent", userContent);
		
		//c2: qua searchedbook.jsp goi SearchDAO truyen vao userContent
		if(arrSach.size()>0) {
//			response.sendRedirect("searchedbook.jsp?noiDungTimKiem="+userContent); //viet kieu nay se bi loi font 
			response.sendRedirect("searchedbook.jsp");
		} else {
			response.sendRedirect("thatbai.jsp");
		}
		
	}

}

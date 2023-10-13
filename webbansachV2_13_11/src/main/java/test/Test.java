package test;

import java.util.ArrayList;

import database.KhachHangDAO;
import model.KhachHang;

public class Test {
	public static void main(String[] args) {
		KhachHangDAO khDAO = new KhachHangDAO();
		ArrayList<KhachHang> arr = khDAO.selectAll(); //return a arraylist
		
//		for (KhachHang khachHang : arr) {
//			System.out.println(khachHang);
//		}
		
		khDAO.kiemTraTaiKhoan("user1", "password1"); // return a KhachHang
		System.out.println(khDAO.kiemTraTaiKhoan("user1", "password1"));
	}
}

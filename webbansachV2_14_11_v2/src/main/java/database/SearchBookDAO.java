package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Sach;

public class SearchBookDAO implements SearchBookDAOInterface<Sach> {
	
	public ArrayList<Sach> searchBookByNameOrAuthor(String userContent) {
		// TODO Auto-generated method stub
		
//		Sach ketQua = null;
		
		ArrayList<Sach> ketQua = new ArrayList<Sach>();

		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
//			String sql = "SELECT * FROM sach WHERE (LOWER(tensach) LIKE LOWER(?) "
//					+ "or TRANSLATE(tensach, 'áàảãạâấầẩẫậăắằẳẵặéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴĐ', 'aaaaaaaaaaaaaaaaeeeeeeeeiiiiiooooooooooooooooouuuuuuuuuuuyyyyydAAAAAAAAAAAAAAAAEEEEEEEEIIIIIOOOOOOOOOOOOOOOOOUUUUUUUUUUYYYYYD') "
//					+ "= TRANSLATE(?, 'áàảãạâấầẩẫậăắằẳẵặéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴĐ', 'aaaaaaaaaaaaaaaaeeeeeeeeiiiiiooooooooooooooooouuuuuuuuuuuyyyyydAAAAAAAAAAAAAAAAEEEEEEEEIIIIIOOOOOOOOOOOOOOOOOUUUUUUUUUUYYYYYD') )";
//			String sql = "SELECT * FROM sach WHERE (LOWER(tensach) LIKE LOWER(?) or LOWER(tacgia) LIKE LOWER(?) )";
//			String sql = "SELECT * FROM sach WHERE (UPPER(tensach) = UPPER(?) )";
//			String sql = "SELECT * FROM sach WHERE COLLATION(tensach) like COLLATION(?)";
//			String sql = "SELECT * FROM sach WHERE UNACCENT(LOWER(tensach)) = UNACCENT(LOWER(?))";
			
//			PreparedStatement st = con.prepareStatement(sql);
			
			//xu ly thong tin user truyen vao:
			
//			String temp="";
//			temp=userContent;
//			
//			temp="%temp%";
			
//			userContent = "%" + userContent.toLowerCase() + "%";
//			String userContentASCII = removeDiacritics(userContent);
			
//			userContent = userContent.toLowerCase();
			
//			userContent = "%" + userContent + "%";
			
//			st.setString(1, userContent);
//			st.setString(2, userContent);
//			st.setString(2, userContentASCII);
//			st.setString(3, temp);
			
			String sql = "SELECT * FROM sach "
					+ "WHERE "
					+ "TRANSLATE(LOWER(tensach), 'áàảãạâấầẩẫậăắằẳẵặéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴĐ', 'aaaaaaaaaaaaaaaaeeeeeeeeiiiiiooooooooooooooooouuuuuuuuuuuyyyyydAAAAAAAAAAAAAAAAEEEEEEEEIIIIIOOOOOOOOOOOOOOOOOUUUUUUUUUUYYYYYD') "
					+ "like "
					+ "TRANSLATE(?, 'áàảãạâấầẩẫậăắằẳẵặéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴĐ', 'aaaaaaaaaaaaaaaaeeeeeeeeiiiiiooooooooooooooooouuuuuuuuuuuyyyyydAAAAAAAAAAAAAAAAEEEEEEEEIIIIIOOOOOOOOOOOOOOOOOUUUUUUUUUUYYYYYD') "
					+ "or "
					+ "TRANSLATE(LOWER(tacgia), 'áàảãạâấầẩẫậăắằẳẵặéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴĐ', 'aaaaaaaaaaaaaaaaeeeeeeeeiiiiiooooooooooooooooouuuuuuuuuuuyyyyydAAAAAAAAAAAAAAAAEEEEEEEEIIIIIOOOOOOOOOOOOOOOOOUUUUUUUUUUYYYYYD') "
					+ "like "
					+ "TRANSLATE(?, 'áàảãạâấầẩẫậăắằẳẵặéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴĐ', 'aaaaaaaaaaaaaaaaeeeeeeeeiiiiiooooooooooooooooouuuuuuuuuuuyyyyydAAAAAAAAAAAAAAAAEEEEEEEEIIIIIOOOOOOOOOOOOOOOOOUUUUUUUUUUYYYYYD') ";
			
			PreparedStatement st = con.prepareStatement(sql);

			// Xử lý thông tin người dùng truyền vào:
			String userContentLower = "%" + userContent.toLowerCase() + "%";
//			String userContentTranslate = "%"+ removeDiacritics(userContent).toLowerCase() +"%";
			st.setString(1, userContentLower);
			st.setString(2, userContentLower);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {

				int maSach = rs.getInt("masach"); // truyen vao ten cot hoac so cot
				String TenSach = rs.getString("TenSach");
				String TacGia = rs.getString("TacGia");
				float GiaBan = rs.getFloat("GiaBan");
				String LoaiSach = rs.getString("LoaiSach");
				int namxuatban = rs.getInt("namxuatban");
				String TrangThai = rs.getString("TrangThai");
				String TheLoai = rs.getString("TheLoai");
				String Photo = rs.getString("Photo");
				int SoLuong = rs.getInt("SoLuong");

				Sach sach = new Sach();
				sach.setMaSach(maSach);
				sach.setTenSach(TenSach);
				sach.setTacGia(TacGia);
				sach.setGiaBan(GiaBan);
				sach.setLoaiSach(LoaiSach);
				sach.setNXB(namxuatban);
				sach.setTrangThai(TrangThai);
				sach.setTheLoai(TheLoai);
				sach.setPhoto(Photo);
				sach.setSoLuong(SoLuong);

				ketQua.add(sach);

			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	

//	public static String removeDiacritics(String input) {
//	    input = "TRANSLATE(" + input + ", 'áàảãạâấầẩẫậăắằẳẵặéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴĐ', 'aaaaaaaaaaaaaaaaeeeeeeeeiiiiiooooooooooooooooouuuuuuuuuuuyyyyydAAAAAAAAAAAAAAAAEEEEEEEEIIIIIOOOOOOOOOOOOOOOOOUUUUUUUUUUYYYYYD')";
//	    return input;
//	}
	
//	public static String removeDiacritics(String input) {
//    input = "TRANSLATE(" + input + ", 'áàảãạâấầẩẫậăắằẳẵặéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴĐ', 'aaaaaaaaaaaaaaaaeeeeeeeeiiiiiooooooooooooooooouuuuuuuuuuuyyyyydAAAAAAAAAAAAAAAAEEEEEEEEIIIIIOOOOOOOOOOOOOOOOOUUUUUUUUUUYYYYYD')";
//    return input;
//	}
	
	@Override
	public ArrayList<Sach> searchBookByCategory(String selectedValue) {
		// TODO Auto-generated method stub
		return null;
	}
}

package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Sach;

public class SachDAO implements DAOInterface<Sach> {

	@Override
	public ArrayList<Sach> selectAll() {
		// TODO Auto-generated method stub

		ArrayList<Sach> ketQua = new ArrayList<>();

		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "select * from sach";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
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

				Sach sachMoi = new Sach();
				sachMoi.setMaSach(maSach);
				sachMoi.setTenSach(TenSach);
				sachMoi.setTacGia(TacGia);
				sachMoi.setGiaBan(GiaBan);
				sachMoi.setLoaiSach(LoaiSach);
				sachMoi.setNXB(namxuatban);
				sachMoi.setTrangThai(TrangThai);
				sachMoi.setTheLoai(TheLoai);
				sachMoi.setPhoto(Photo);
				sachMoi.setSoLuong(SoLuong);

				ketQua.add(sachMoi);

			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
	
	public ArrayList<Sach> selectAllByNewBook() {
		// TODO Auto-generated method stub

				ArrayList<Sach> ketQua = new ArrayList<>();

				try {
					// Bước 1: tạo kết nối đến CSDL
					Connection con = JDBCUtil.getConnection();

					// Bước 2: tạo ra đối tượng statement
					String sql = "select * from sach where loaisach=? order by masach desc"; //lay nhung quyen sach moi nhat
					PreparedStatement st = con.prepareStatement(sql);
					st.setString(1, "new");

					// Bước 3: thực thi câu lệnh SQL
					System.out.println(sql);
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

						Sach sachMoi = new Sach();
						sachMoi.setMaSach(maSach);
						sachMoi.setTenSach(TenSach);
						sachMoi.setTacGia(TacGia);
						sachMoi.setGiaBan(GiaBan);
						sachMoi.setLoaiSach(LoaiSach);
						sachMoi.setNXB(namxuatban);
						sachMoi.setTrangThai(TrangThai);
						sachMoi.setTheLoai(TheLoai);
						sachMoi.setPhoto(Photo);
						sachMoi.setSoLuong(SoLuong);

						ketQua.add(sachMoi);

					}

					// Bước 5:
					JDBCUtil.closeConnection(con);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return ketQua;
	}
	
	public ArrayList<Sach> selectAllByOldBook() {
		// TODO Auto-generated method stub

		ArrayList<Sach> ketQua = new ArrayList<>();

		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "select * from sach where loaisach=? order by masach desc"; //lay nhung quyen sach cu nhat
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "old");

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
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

				Sach sachMoi = new Sach();
				sachMoi.setMaSach(maSach);
				sachMoi.setTenSach(TenSach);
				sachMoi.setTacGia(TacGia);
				sachMoi.setGiaBan(GiaBan);
				sachMoi.setLoaiSach(LoaiSach);
				sachMoi.setNXB(namxuatban);
				sachMoi.setTrangThai(TrangThai);
				sachMoi.setTheLoai(TheLoai);
				sachMoi.setPhoto(Photo);
				sachMoi.setSoLuong(SoLuong);

				ketQua.add(sachMoi);

			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
	
	@Override
	public Sach selectById(Sach t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Sach selectById(int id) {
		// TODO Auto-generated method stub
		
//		Sach ketQua = null;

		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "select * from sach where masach=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
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

				Sach sachMoi = new Sach();
				sachMoi.setMaSach(maSach);
				sachMoi.setTenSach(TenSach);
				sachMoi.setTacGia(TacGia);
				sachMoi.setGiaBan(GiaBan);
				sachMoi.setLoaiSach(LoaiSach);
				sachMoi.setNXB(namxuatban);
				sachMoi.setTrangThai(TrangThai);
				sachMoi.setTheLoai(TheLoai);
				sachMoi.setPhoto(Photo);
				sachMoi.setSoLuong(SoLuong);

				return sachMoi;

			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public int insert(Sach t) {
		// TODO Auto-generated method stub

		int ketQua = 0;

		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO Sach(TenSach, TacGia, GiaGoc, GiaBan, LoaiSach, NamXuatBan, TrangThai, TheLoai, Photo, Email, SoLuong)"
					+ "values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getTenSach());
			st.setString(2, t.getTacGia());
			st.setFloat(3, t.getGiaGoc());
			st.setFloat(4, t.getGiaBan());
			st.setString(5, t.getLoaiSach());
			st.setInt(6, t.getNXB());
			st.setString(7, t.getTrangThai());
			st.setString(8, t.getTheLoai());
			st.setString(9, t.getPhoto());
			st.setString(10, t.getEmail());
			st.setInt(11, t.getSoLuong());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("cau lenh sql: " + sql);

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<Sach> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Sach t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteById(int id) {
		// TODO Auto-generated method stub

		int ketQua = 0;

		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "delete from sach where masach=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("cau lenh sql: " + sql);

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int deleteAll(ArrayList<Sach> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Sach t) {
		// TODO Auto-generated method stub
		int ketQua = 0;

		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "update sach set TenSach=?, TacGia=?, GiaGoc=?, GiaBan=?, LoaiSach=?, namxuatban=?, TrangThai=?, TheLoai=?, Photo=?, Email=?, SoLuong=? where masach=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getTenSach());
			st.setString(2, t.getTacGia());
			st.setFloat(3, t.getGiaGoc());
			st.setFloat(4, t.getGiaBan());
			st.setString(5, t.getLoaiSach());
			st.setInt(6, t.getNXB());
			st.setString(7, t.getTrangThai());
			st.setString(8, t.getTheLoai());
			st.setString(9, t.getPhoto());
			st.setString(10, t.getEmail());
			st.setInt(11, t.getSoLuong());
			st.setInt(12, t.getMaSach());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("cau lenh sql: " + sql);

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

}

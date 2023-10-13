package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.KhachHang;

public class KhachHangDAO implements DAOInterface<KhachHang> {

	@Override
	public ArrayList<KhachHang> selectAll() {
		// TODO Auto-generated method stub

//		String test="";
		ArrayList<KhachHang> ketQua = new ArrayList();

		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM khachhang";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int MaKhachHang = rs.getInt("MaKhachHang");
				String user = rs.getString("TenDangNhap");
				String password = rs.getString("MatKhau");
				String HoTen = rs.getString("HoTen");
				boolean GioiTinh = rs.getBoolean("GioiTinh");
				String DiaChiNhanHang = rs.getString("DiaChiNhanHang");
				Date NgaySinh = rs.getDate("NgaySinh");
				String Sdt = rs.getString("Sdt");
				String Email = rs.getString("Email");
				boolean DangKyNhanBanTin = rs.getBoolean("DangKyNhanBanTin");

				KhachHang khachHang = new KhachHang(MaKhachHang, user, password, HoTen, GioiTinh, DiaChiNhanHang,
						NgaySinh, Sdt, Email, DangKyNhanBanTin);
				ketQua.add(khachHang);
//				test+=rs.getString("Sdt");
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
	public KhachHang selectById(KhachHang t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean kiemTraTenDangKy(String user) {
		
		boolean ketQua = false;

		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM khachhang where TenDangNhap=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, user);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				ketQua=true;
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
	
	public KhachHang selectById(String t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public KhachHang selectById(int id) {
		
		

		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM khachhang where makhachhang=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int MaKhachHang = rs.getInt("MaKhachHang");
				String user = rs.getString("TenDangNhap");
				String password = rs.getString("MatKhau");
				String HoTen = rs.getString("HoTen");
				boolean GioiTinh = rs.getBoolean("GioiTinh");
				String DiaChiNhanHang = rs.getString("DiaChiNhanHang");
				Date NgaySinh = rs.getDate("NgaySinh");
				String Sdt = rs.getString("Sdt");
				String Email = rs.getString("Email");
				boolean DangKyNhanBanTin = rs.getBoolean("DangKyNhanBanTin");

				KhachHang khachHang = new KhachHang(MaKhachHang, user, password, HoTen, GioiTinh, DiaChiNhanHang,
						NgaySinh, Sdt, Email, DangKyNhanBanTin);
				
				return khachHang;
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
	public int insert(KhachHang t) {
		// TODO Auto-generated method stub

		int ketQua=0;

		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "insert into khachhang(TenDangNhap, MatKhau, HoTen, GioiTinh, DiaChiNhanHang, NgaySinh, Sdt, Email, DangKyNhanBanTin)"
					+"values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getUser());
			st.setString(2, t.getPassword());
			st.setString(3, t.getHoTen());
			st.setBoolean(4, t.isGioiTinh());
			st.setString(5, t.getDiaChiNhanHang());
			st.setDate(6, t.getNgaySinh());
			st.setString(7, t.getSdt());
			st.setString(8, t.getEmail());
			st.setBoolean(9, t.isDangKyNhanEmail());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("cau lenh sql: "+sql);
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<KhachHang> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(KhachHang t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<KhachHang> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(KhachHang t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public KhachHang kiemTraTaiKhoan(String user, String password) {
		// TODO Auto-generated method stub

//		String test="";
//		ArrayList<KhachHang> ketQua = new ArrayList();

		KhachHang ketQua = null;

		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM khachhang where TenDangNhap=? and MatKhau=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, user);
			st.setString(2, password);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int MaKhachHang = rs.getInt("MaKhachHang");
				String TenDangNhap = rs.getString("TenDangNhap");
				String MatKhau = rs.getString("MatKhau");
				String HoTen = rs.getString("HoTen");
				boolean GioiTinh = rs.getBoolean("GioiTinh");
				String DiaChiNhanHang = rs.getString("DiaChiNhanHang");
				Date NgaySinh = rs.getDate("NgaySinh");
				String Sdt = rs.getString("Sdt");
				String Email = rs.getString("Email");
				boolean DangKyNhanBanTin = rs.getBoolean("DangKyNhanBanTin");

				ketQua = new KhachHang(MaKhachHang, TenDangNhap, MatKhau, HoTen, GioiTinh, DiaChiNhanHang, NgaySinh,
						Sdt, Email, DangKyNhanBanTin);

//				test+=rs.getString("Sdt");

			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;

	}

}

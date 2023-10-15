package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DonHang;
import model.KhachHang;
import model.Sach;

public class DonHangDAO implements DAOInterface<DonHang> {

	@Override
	public ArrayList<DonHang> selectAll() {
		
		ArrayList<DonHang> ketQua = new ArrayList<>();

		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "select * from donhang"; //lay nhung quyen sach cu nhat
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {

				int madonhang = rs.getInt("madonhang");
				int MaKhachHang = rs.getInt("MaKhachHang");
				String DiaChiNhanHang = rs.getString("DiaChiNhanHang");
				String TrangThaiGiaoHang = rs.getString("TrangThaiGiaoHang");
				String HinhThucThanhToan = rs.getString("HinhThucThanhToan");
				String TrangThaiThanhToan = rs.getString("TrangThaiThanhToan");
				Date NgayDatHang = rs.getDate("NgayDatHang");
				Date NgayGiaoHang = rs.getDate("NgayGiaoHang");
				
				KhachHangDAO khDAO = new KhachHangDAO();
				KhachHang kh = khDAO.selectById(MaKhachHang); // return a khach hang obj

				DonHang donHang = new DonHang(madonhang, kh, DiaChiNhanHang, TrangThaiGiaoHang, HinhThucThanhToan, TrangThaiThanhToan, NgayDatHang, NgayGiaoHang);

				ketQua.add(donHang);

			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
	
	public ArrayList<DonHang> selectAllDonHangAndCTDH() {
		
		ArrayList<DonHang> ketQua = new ArrayList<>();

		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "select * from donhang dh join chitietdonhang ctdh on "
					+ "dh.madonhang = ctdh.madonhang"; // k the tao view nen dung cai nay
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {

				int madonhang = rs.getInt("madonhang");
				int MaKhachHang = rs.getInt("MaKhachHang");
				String DiaChiNhanHang = rs.getString("DiaChiNhanHang");
				String TrangThaiGiaoHang = rs.getString("TrangThaiGiaoHang");
				String HinhThucThanhToan = rs.getString("HinhThucThanhToan");
				String TrangThaiThanhToan = rs.getString("TrangThaiThanhToan");
				Date NgayDatHang = rs.getDate("NgayDatHang");
				Date NgayGiaoHang = rs.getDate("NgayGiaoHang");
				
				KhachHangDAO khDAO = new KhachHangDAO();
				KhachHang kh = khDAO.selectById(MaKhachHang); // return a khach hang obj

				DonHang donHang = new DonHang(madonhang, kh, DiaChiNhanHang, TrangThaiGiaoHang, HinhThucThanhToan, TrangThaiThanhToan, NgayDatHang, NgayGiaoHang);

				ketQua.add(donHang);

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
	public DonHang selectById(DonHang t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public DonHang selectById(int id) {
		// TODO Auto-generated method stub
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "select * from donhang where madonhang=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {

				int madonhang = rs.getInt("madonhang");
				int MaKhachHang = rs.getInt("MaKhachHang");
				String DiaChiNhanHang = rs.getString("DiaChiNhanHang");
				String TrangThaiGiaoHang = rs.getString("TrangThaiGiaoHang");
				String HinhThucThanhToan = rs.getString("HinhThucThanhToan");
				String TrangThaiThanhToan = rs.getString("TrangThaiThanhToan");
				Date NgayDatHang = rs.getDate("NgayDatHang");
				Date NgayGiaoHang = rs.getDate("NgayGiaoHang");
				
				KhachHangDAO khDAO = new KhachHangDAO();
				KhachHang kh = khDAO.selectById(MaKhachHang); // return a khach hang obj

				DonHang donHang = new DonHang(madonhang, kh, DiaChiNhanHang, TrangThaiGiaoHang, HinhThucThanhToan, TrangThaiThanhToan, NgayDatHang, NgayGiaoHang);

				return donHang;
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
	public int insert(DonHang t) {
		
		int ketQua = 0;

		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO DonHang (madonhang, MaKhachHang, DiaChiNhanHang, TrangThaiGiaoHang, HinhThucThanhToan, TrangThaiThanhToan, NgayDatHang, NgayGiaoHang)"
					+ "values(?,?,?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getMaDon());
			st.setInt(2, t.getKhachHang().getMaKhachHang());
			st.setString(3, t.getDiaChiNhanHang());
			st.setString(4, t.getTrangThaiGiaoHang());
			st.setString(5, t.getHinhThucThanhToan());
			st.setString(6, t.getTrangThaiGiaoHang());
			st.setDate(7, t.getNgayDat());
			st.setDate(8, t.getNgayGiao());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("cau lenh sql: " + sql);
			System.out.println("them don hang vao csdl thanh cong");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<DonHang> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(DonHang t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<DonHang> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(DonHang t) {
		// TODO Auto-generated method stub
		return 0;
	}

}

package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DonHang;

public class DonHangDAO implements DAOInterface<DonHang> {

	@Override
	public ArrayList<DonHang> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DonHang selectById(DonHang t) {
		// TODO Auto-generated method stub
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

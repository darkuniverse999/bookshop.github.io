package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ChiTietDonHang;

public class ChiTietDonHangDAO implements DAOInterface<ChiTietDonHang> {

	@Override
	public ArrayList<ChiTietDonHang> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChiTietDonHang selectById(ChiTietDonHang t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(ChiTietDonHang t) {
		int ketQua = 0;

		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO ChiTietDonHang(machitietdonhang, MaDonHang, MaSach, TenNguoiNhan, SoDienThoai, DiaChiNhanHang, TenSach, TacGia, SoLuong, GiamGia, GiaBan, TongThanhTien)"
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getMaChiTietDonHang());
			st.setInt(2, t.getDonHang().getMaDon()); //ok
			st.setInt(3, t.getSach().getMaSach()); //ok
			st.setString(4, t.getTenNguoiNhan());
			st.setString(5, t.getSdt());
			st.setString(6, t.getDiaChiNhanHang());
			st.setString(7, t.getSach().getTenSach());
			st.setString(8, t.getSach().getTacGia());
			st.setInt(9, t.getSoLuong());
			st.setDouble(10, t.getGiamGia());
			st.setDouble(11, t.getSach().getGiaBan());
			st.setDouble(12, t.getTongThanhTien());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("cau lenh sql: " + sql);
			System.out.println("them ctdh vao csdl thanh cong: ");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<ChiTietDonHang> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(ChiTietDonHang t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<ChiTietDonHang> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ChiTietDonHang t) {
		// TODO Auto-generated method stub
		return 0;
	}

}

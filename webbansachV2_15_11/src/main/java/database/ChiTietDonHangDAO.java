package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ChiTietDonHang;
import model.DonHang;
import model.KhachHang;
import model.Sach;

public class ChiTietDonHangDAO implements DAOInterface<ChiTietDonHang> {

	@Override
	public ArrayList<ChiTietDonHang> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
public ArrayList<ChiTietDonHang> selectAllDonHangAndCTDH() {
		
		ArrayList<ChiTietDonHang> ketQua = new ArrayList<>();

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

				int machitietdonhang = rs.getInt("machitietdonhang");
				int MaDonHang = rs.getInt("MaDonHang");
				int MaSach = rs.getInt("MaSach");
				String TenNguoiNhan = rs.getString("TenNguoiNhan");
				String SoDienThoai = rs.getString("SoDienThoai");
				String DiaChiNhanHang = rs.getString("DiaChiNhanHang");
				String TenSach = rs.getString("TenSach");
				String TacGia = rs.getString("TacGia");
				int SoLuong = rs.getInt("SoLuong");
				double GiamGia = rs.getDouble("GiamGia");
				double giaban = rs.getDouble("giaban");
				double TongThanhTien = rs.getDouble("TongThanhTien");
				
				DonHangDAO dhDAO = new DonHangDAO();
				DonHang donHang = dhDAO.selectById(MaDonHang); //return a don hang obj
				
				SachDAO sachDAO = new SachDAO();
				Sach sach = sachDAO.selectById(MaSach); //return a book obj
				
				ChiTietDonHang ctdh = new ChiTietDonHang();
				ctdh.setMaChiTietDonHang(machitietdonhang);
				ctdh.setDonHang(donHang);
				ctdh.setSach(sach);
				ctdh.setTenNguoiNhan(TenNguoiNhan);
				ctdh.setSdt(SoDienThoai);
				ctdh.setDiaChiNhanHang(DiaChiNhanHang);
				ctdh.setTenSach(TenSach);
				ctdh.setTacGia(TacGia);
				ctdh.setSoLuong(SoLuong);
				ctdh.setGiamGia(GiamGia);
				ctdh.setGiaBan(giaban);
				ctdh.setTongThanhTien(TongThanhTien);
				
				ketQua.add(ctdh);

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

package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Cart;
import model.Sach;

public class CartDAO implements DAOInterface<Cart> {

	@Override
	public ArrayList<Cart> selectAll() {
		return null;
	}

	@Override
	public Cart selectById(Cart t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Cart> selectCartByUserId(int maKhachHang) {
		// TODO Auto-generated method stub

				ArrayList<Cart> ketQua = new ArrayList<>();

				try {
					// Bước 1: tạo kết nối đến CSDL
					Connection con = JDBCUtil.getConnection();

					// Bước 2: tạo ra đối tượng statement
					String sql = "select * from giohang where makhachhang=?";
					PreparedStatement st = con.prepareStatement(sql);
					st.setInt(1, maKhachHang);

					// Bước 3: thực thi câu lệnh SQL
					System.out.println(sql);
					ResultSet rs = st.executeQuery();

					// Bước 4:
					while (rs.next()) {

						System.out.println("lay thong tin gio hang tu csdl len");

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
	public int insert(Cart t) {

		int ketQua = 0;
		

		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO GioHang(MaSach, MaKhachHang, TenSach, TacGia, Gia, TongTien)"
					+ "values(?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getSach().getMaSach());
			st.setInt(2, t.getKhachHang().getMaKhachHang());
			st.setString(3, t.getSach().getTenSach());
			st.setString(4, t.getSach().getTacGia());
			st.setDouble(5, t.getSach().getGiaBan());
			st.setDouble(6, t.getTongTien());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("cau lenh sql: " + sql);
			System.out.println("insert cart thanh cong");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<Cart> arr) {
		
//		int ketQua=0;
//		
//		for(Cart cart : arr) {
//			ketQua+=this.insert(cart);
//		}
//		
//		return ketQua;
		return 0;
	}

	@Override
	public int delete(Cart t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<Cart> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Cart t) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}

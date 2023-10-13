package model;

import java.sql.Date;

public class KhachHang {
//	- Khách hàng:
//		 + Mã khách hàng (String)
//		 + Tên đăng nhập 
//		 + Mật khẩu
//		 + Họ tên
//		 + Giới tính (String hoặc boolean hoặc tinyint hoặc bit)
//		 + Địa chỉ nhận hàng
//		 + Ngày sinh
//		 + Sdt
//		 + Email
//		 + Đăng ký nhận bản tin email (true/false, boolean)
	
	private int maKhachHang;
	private String user;
	private String password;
	private String hoTen;
	private boolean gioiTinh;
	private String diaChiNhanHang;
	private Date ngaySinh;
	private String sdt;
	private String email;
	private boolean dangKyNhanEmail;
	public KhachHang(int maKhachHang, String user, String password, String hoTen, boolean gioiTinh,
			String diaChiNhanHang, Date ngaySinh, String sdt, String email, boolean dangKyNhanEmail) {
		super();
		this.maKhachHang = maKhachHang;
		this.user = user;
		this.password = password;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.diaChiNhanHang = diaChiNhanHang;
		this.ngaySinh = ngaySinh;
		this.sdt = sdt;
		this.email = email;
		this.dangKyNhanEmail = dangKyNhanEmail;
	}
	
	public KhachHang() {
		super();
	}
	
	public int getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getDiaChiNhanHang() {
		return diaChiNhanHang;
	}
	public void setDiaChiNhanHang(String diaChiNhanHang) {
		this.diaChiNhanHang = diaChiNhanHang;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isDangKyNhanEmail() {
		return dangKyNhanEmail;
	}
	public void setDangKyNhanEmail(boolean dangKyNhanEmail) {
		this.dangKyNhanEmail = dangKyNhanEmail;
	}
	
	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", user=" + user + ", password=" + password + ", hoTen="
				+ hoTen + ", gioiTinh=" + gioiTinh + ", diaChiNhanHang=" + diaChiNhanHang + ", ngaySinh=" + ngaySinh
				+ ", sdt=" + sdt + ", email=" + email + ", dangKyNhanEmail=" + dangKyNhanEmail + "]";
	}
	
	
}

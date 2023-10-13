package model;

public class ChiTietDonHang {
//	- Chi tiết đơn hàng:
//		 + Mã chi tiết đơn hàng kiểu int, tự tăng
//		 + mã Đơn hàng kiểu int (thuộc đơn hàng nào)
//		 + mã sách kiểu int (chứa thông tin quyển sách nào)
	
//		 + tên người nhận kiểu nvarchar
//		 + số điện thoại kiểu nvarchar
//		 + Địa chỉ nhận hàng kiểu nvarchar
//
//		 + tên sách kiểu nvarchar
//		 + tác giả kiểu nvarchar
//		 + số lượng kiểu int
//		 + giảm giá kiểu double
//		 + Giá bán kiểu double
//		 + Tổng thành tiền kiểu double
	
	//them tu don hang
//	 + Hình thức thanh toán kiểu nvarchar
	
	//them 
//	+ email
//	+ ma Giam Gia
	
	private int maChiTietDonHang;
	private DonHang donHang;
	private Sach sach;
	private String tenNguoiNhan;
	private String sdt;
	private String diaChiNhanHang;
	private String tenSach;
	private String tacGia;
	private int soLuong;
	private double giamGia;
	private double giaBan;
	private double tongThanhTien;
	private String hinhThucThanhToan;
	private String email;
	private String maGiamGia;
	
	public ChiTietDonHang() {
		super();
	}
	
	
	public int getMaChiTietDonHang() {
		return maChiTietDonHang;
	}
	public void setMaChiTietDonHang(int maChiTietDonHang) {
		this.maChiTietDonHang = maChiTietDonHang;
	}
	public DonHang getDonHang() {
		return donHang;
	}
	public void setDonHang(DonHang donHang) {
		this.donHang = donHang;
	}
	public Sach getSach() {
		return sach;
	}
	public void setSach(Sach sach) {
		this.sach = sach;
	}
	public String getTenNguoiNhan() {
		return tenNguoiNhan;
	}
	public void setTenNguoiNhan(String tenNguoiNhan) {
		this.tenNguoiNhan = tenNguoiNhan;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiaChiNhanHang() {
		return diaChiNhanHang;
	}
	public void setDiaChiNhanHang(String diaChiNhanHang) {
		this.diaChiNhanHang = diaChiNhanHang;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public String getTacGia() {
		return tacGia;
	}
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getGiamGia() {
		return giamGia;
	}
	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}
	public double getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}
	public double getTongThanhTien() {
		return tongThanhTien;
	}
	public void setTongThanhTien(double tongThanhTien) {
		this.tongThanhTien = tongThanhTien;
	}
	
	public String getHinhThucThanhToan() {
		return hinhThucThanhToan;
	}
	public void setHinhThucThanhToan(String hinhThucThanhToan) {
		this.hinhThucThanhToan = hinhThucThanhToan;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public String getMaGiamGia() {
		return maGiamGia;
	}
	public void setMaGiamGia(String maGiamGia) {
		this.maGiamGia = maGiamGia;
	}
	
	
}

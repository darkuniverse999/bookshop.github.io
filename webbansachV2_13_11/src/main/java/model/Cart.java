package model;

public class Cart {
	private int maGioHang;
	private Sach sach; //chua thong tin quyen sach nao
	private KhachHang khachHang; //chua thong tin quyen sach nao
	private String tenSach;
	private String tacGia;
	private double gia;
	private double tongTien;
	
	public Cart() {
		super();
	}
	
	public Cart(int maGioHang, Sach sach, KhachHang khachHang, String tenSach, String tacGia, double gia,
			double tongTien) {
		super();
		this.maGioHang = maGioHang;
		this.sach = sach;
		this.khachHang = khachHang;
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.gia = gia;
		this.tongTien = tongTien;
	}



	public int getMaGioHang() {
		return maGioHang;
	}
	public void setMaGioHang(int maGioHang) {
		this.maGioHang = maGioHang;
	}
	public Sach getSach() {
		return sach;
	}
	public void setSach(Sach sach) {
		this.sach = sach;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
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
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	
	
}

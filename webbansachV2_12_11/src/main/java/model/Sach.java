package model;

public class Sach {
	/*
	- Sách:
		 + Mã sách kiểu int, tự động tăng
		 + tên sách kiểu nvachar(50)
		 + tác giả nvachar(50)
		 + giá gốc kiểu float (là giá ban đầu)
		 + giá bán kiểu float (là giá bán)
		 + loại sách kiểu nvachar(50) (loại sách cũ hoặc mới)
		 + trạng thái kiểu nvachar(50) (trạng thái có sẵn hoặc k có sẵn)
		 + thể loại kiểu nvachar(50)
		 + photo kiểu nvachar(50)
		 + Email kiểu nvachar(50)
		 + số lượng kiểu int
	*/
	
	private int maSach;
	private String tenSach;
	private String tacGia;
	private float giaGoc;
	private float giaBan;
	private String loaiSach;
	private int namXuatBan;
	private String trangThai;
	private String theLoai;
	private String photo;
	private String email;
	private int soLuong;
	
	public Sach() {
		super();
	}
	public Sach(int maSach, String tenSach, String tacGia, float giaGoc, float giaBan, String loaiSach, int namXuatBan,
			String trangThai, String theLoai, String photo, String email, int soLuong) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.giaGoc = giaGoc;
		this.giaBan = giaBan;
		this.loaiSach = loaiSach;
		this.namXuatBan = namXuatBan;
		this.trangThai = trangThai;
		this.theLoai = theLoai;
		this.photo = photo;
		this.email = email;
		this.soLuong = soLuong;
	}
	public Sach(String tenSach, String tacGia, float giaGoc, float giaBan, String loaiSach, int namXuatBan, String trangThai,
			String theLoai, String photo, String email, int soLuong) {
		super();
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.giaGoc = giaGoc;
		this.giaBan = giaBan;
		this.loaiSach = loaiSach;
		this.namXuatBan = namXuatBan;
		this.trangThai = trangThai;
		this.theLoai = theLoai;
		this.photo = photo;
		this.email = email;
		this.soLuong = soLuong;
	}
	public int getMaSach() {
		return maSach;
	}
	public void setMaSach(int maSach) {
		this.maSach = maSach;
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
	public float getGiaGoc() {
		return giaGoc;
	}
	public void setGiaGoc(float giaGoc) {
		this.giaGoc = giaGoc;
	}
	public float getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(float giaBan) {
		this.giaBan = giaBan;
	}
	public String getLoaiSach() {
		return loaiSach;
	}
	public void setLoaiSach(String loaiSach) {
		this.loaiSach = loaiSach;
	}
	public int getNXB() {
		return namXuatBan;
	}
	public void setNXB(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public String getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
}

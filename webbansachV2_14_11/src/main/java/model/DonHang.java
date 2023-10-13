package model;

import java.sql.Date;

public class DonHang {
	
//	- Đơn hàng:
//		 + Mã đơn kiểu int, tự tăg
//		 + mã Khách hàng kiểu int (thuộc khách hàng nào)
//		 + Địa chỉ nhận hàng kiểu nvarchar
//		 + Trạng thái giao hàng: mới tạo, đang xử lý, đang giao, đã giao, trả hàng
//		 + Hình thức thanh toán kiểu nvarchar
//		 + Trạng thái thanh toán kiểu nvarchar
//		 + Ngày đặt hàng kiểu date
//		 + Ngày giao hàng kiểu date

	private int maDon;
	private KhachHang khachHang;
	private String diaChiNhanHang;
	private String trangThaiGiaoHang;
	private String hinhThucThanhToan;
	private String trangThaiThanhToan;
	private Date ngayDat;
	private Date ngayGiao;
	
	public DonHang() {
		super();
	}
	
	

	public DonHang(KhachHang khachHang, String diaChiNhanHang, String trangThaiGiaoHang, String hinhThucThanhToan,
			String trangThaiThanhToan, Date ngayDat, Date ngayGiao) {
		super();
		this.khachHang = khachHang;
		this.diaChiNhanHang = diaChiNhanHang;
		this.trangThaiGiaoHang = trangThaiGiaoHang;
		this.hinhThucThanhToan = hinhThucThanhToan;
		this.trangThaiThanhToan = trangThaiThanhToan;
		this.ngayDat = ngayDat;
		this.ngayGiao = ngayGiao;
	}



	public int getMaDon() {
		return maDon;
	}
	public void setMaDon(int maDon) {
		this.maDon = maDon;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public String getDiaChiNhanHang() {
		return diaChiNhanHang;
	}
	public void setDiaChiNhanHang(String diaChiNhanHang) {
		this.diaChiNhanHang = diaChiNhanHang;
	}
	public String getTrangThaiGiaoHang() {
		return trangThaiGiaoHang;
	}
	public void setTrangThaiGiaoHang(String trangThaiGiaoHang) {
		this.trangThaiGiaoHang = trangThaiGiaoHang;
	}
	public String getHinhThucThanhToan() {
		return hinhThucThanhToan;
	}
	public void setHinhThucThanhToan(String hinhThucThanhToan) {
		this.hinhThucThanhToan = hinhThucThanhToan;
	}
	public String getTrangThaiThanhToan() {
		return trangThaiThanhToan;
	}
	public void setTrangThaiThanhToan(String trangThaiThanhToan) {
		this.trangThaiThanhToan = trangThaiThanhToan;
	}
	public Date getNgayDat() {
		return ngayDat;
	}
	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}
	public Date getNgayGiao() {
		return ngayGiao;
	}
	public void setNgayGiao(Date ngayGiao) {
		this.ngayGiao = ngayGiao;
	}
	
	
}

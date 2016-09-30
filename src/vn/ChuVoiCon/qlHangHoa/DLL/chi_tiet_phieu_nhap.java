package vn.ChuVoiCon.qlHangHoa.DLL;

public class chi_tiet_phieu_nhap {
	private int ma_phieu_nhap;
	private String ma_san_pham;
	private int so_luong;
	private double don_gia;
	private phieu_nhap phieu;
	private chi_tiet_san_pham ctsp;
	

	public chi_tiet_san_pham getCtsp() {
		return ctsp;
	}

	public void setCtsp(chi_tiet_san_pham ctsp) {
		this.ctsp = ctsp;
	}

	public phieu_nhap getPhieu_nhap() {
		return phieu;
	}

	public void setPhieu_nhap(phieu_nhap phieu) {
		this.phieu = phieu;
	}

	public int getMa_phieu_nhap() {
		return ma_phieu_nhap;
	}

	public void setMa_phieu_nhap(int ma_phieu_nhap) {
		this.ma_phieu_nhap = ma_phieu_nhap;
	}

	public String getMa_san_pham() {
		return ma_san_pham;
	}

	public void setMa_san_pham(String ma_san_pham) {
		this.ma_san_pham = ma_san_pham;
	}

	public int getSo_luong() {
		return so_luong;
	}

	public void setSo_luong(int so_luong) {
		this.so_luong = so_luong;
	}

	public double getDon_gia() {
		return don_gia;
	}

	public void setDon_gia(double don_gia) {
		this.don_gia = don_gia;
	}
	
	
	
}

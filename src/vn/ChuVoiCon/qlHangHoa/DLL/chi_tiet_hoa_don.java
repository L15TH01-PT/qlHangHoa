package vn.ChuVoiCon.qlHangHoa.DLL;


public class chi_tiet_hoa_don {
	private int ma_hoa_don;
	private String id_sp;
	private chi_tiet_san_pham sp;
	private double don_gia;
	private int so_luong;
	private hoa_don hoa_don;
	
	public int getMa_hoa_don() {
		return ma_hoa_don;
	}
	public void setMa_hoa_don(int ma_hoa_don) {
		this.ma_hoa_don = ma_hoa_don;
	}
	public String getId_sp() {
		return id_sp;
	}
	public void setId_sp(String id_sp) {
		this.id_sp = id_sp;
	}
	public chi_tiet_san_pham getSp() {
		return sp;
	}
	public void setSp(chi_tiet_san_pham sp) {
		this.sp = sp;
	}
	public double getDon_gia() {
		return don_gia;
	}
	public void setDon_gia(double don_gia) {
		this.don_gia = don_gia;
	}
	public int getSo_luong() {
		return so_luong;
	}
	public void setSo_luong(int so_luong) {
		this.so_luong = so_luong;
	}
	public hoa_don getHoa_don() {
		return hoa_don;
	}
	public void setHoa_don(hoa_don hoa_don) {
		this.hoa_don = hoa_don;
	}
}

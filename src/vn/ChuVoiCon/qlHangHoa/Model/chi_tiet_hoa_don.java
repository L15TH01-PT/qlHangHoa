package vn.ChuVoiCon.qlHangHoa.Model;

public class chi_tiet_hoa_don {
	private long ma_hoa_don;
	private String IDHangHoa;
	private double don_gia;
	private int so_luong;
	private hoa_don hoa_don;
	
	public long getMa_hoa_don() {
		return ma_hoa_don;
	}
	public void setMa_hoa_don(long ma_hoa_don) {
		this.ma_hoa_don = ma_hoa_don;
	}
	public String getIDHangHoa() {
		return IDHangHoa;
	}
	public void setIDHangHoa(String iDHangHoa) {
		IDHangHoa = iDHangHoa;
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

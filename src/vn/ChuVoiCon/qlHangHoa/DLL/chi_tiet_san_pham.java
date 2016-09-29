package vn.ChuVoiCon.qlHangHoa.DLL;

import vn.ChuVoiCon.qlHangHoa.DAO.Connect;

public class chi_tiet_san_pham extends Connect{
	private String id_sp;
	private String id_loai;
	private String id_ncc;
	private String ten_sp;
	private String noi_dung;
	private int bao_hanh;
	private String don_vi_tinh;
	private String ten_loai;
		
	public chi_tiet_san_pham(String ten_loai) {
		super();		
		this.ten_loai = ten_loai;
	}
	public String getTen_loai() {
		return ten_loai;
	}
	public void setTen_loai(String ten_loai) {
		this.ten_loai = ten_loai;
	}
	public String getId_sp() {
		return id_sp;
	}
	public void setId_sp(String id_sp) {
		this.id_sp = id_sp;
	}
	public String getId_loai() {
		return id_loai;
	}
	public void setId_loai(String id_loai) {
		this.id_loai = id_loai;
	}
	public String getId_ncc() {
		return id_ncc;
	}
	public void setId_ncc(String id_ncc) {
		this.id_ncc = id_ncc;
	}
	public String getTen_sp() {
		return ten_sp;
	}
	public void setTen_sp(String ten_sp) {
		this.ten_sp = ten_sp;
	}
	public String getNoi_dung() {
		return noi_dung;
	}
	public void setNoi_dung(String noi_dung) {
		this.noi_dung = noi_dung;
	}
	public int getBao_hanh() {
		return bao_hanh;
	}
	public void setBao_hanh(int bao_hanh) {
		this.bao_hanh = bao_hanh;
	}
	public String getDon_vi_tinh() {
		return don_vi_tinh;
	}
	public void setDon_vi_tinh(String don_vi_tinh) {
		this.don_vi_tinh = don_vi_tinh;
	}
	public chi_tiet_san_pham(String id_sp, String id_loai, String id_ncc,
			String ten_sp, String noi_dung, int bao_hanh, String don_vi_tinh) {
		super();
		this.id_sp = id_sp;
		this.id_loai = id_loai;
		this.id_ncc = id_ncc;
		this.ten_sp = ten_sp;
		this.noi_dung = noi_dung;
		this.bao_hanh = bao_hanh;
		this.don_vi_tinh = don_vi_tinh;
	}
	public chi_tiet_san_pham() {
		super();
	}	
}

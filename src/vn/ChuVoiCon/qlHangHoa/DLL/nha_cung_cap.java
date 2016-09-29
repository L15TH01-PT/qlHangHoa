package vn.ChuVoiCon.qlHangHoa.DLL;

import vn.ChuVoiCon.qlHangHoa.DAO.Connect;

public class nha_cung_cap extends Connect{
	private String id_ncc;
	private String ten_ncc;
	private String nguoi_lien_he;
	private String dien_thoai;
	private String dia_chi;
	public String getId_ncc() {
		return id_ncc;
	}
	public void setId_ncc(String id_ncc) {
		this.id_ncc = id_ncc;
	}
	public String getTen_ncc() {
		return ten_ncc;
	}
	public void setTen_ncc(String ten_ncc) {
		this.ten_ncc = ten_ncc;
	}
	public String getNguoi_lien_he() {
		return nguoi_lien_he;
	}
	public void setNguoi_lien_he(String nguoi_lien_he) {
		this.nguoi_lien_he = nguoi_lien_he;
	}
	public String getDien_thoai() {
		return dien_thoai;
	}
	public void setDien_thoai(String dien_thoai) {
		this.dien_thoai = dien_thoai;
	}
	public String getDia_chi() {
		return dia_chi;
	}
	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}
	public nha_cung_cap(String id_ncc, String ten_ncc, String nguoi_lien_he,
			String dien_thoai, String dia_chi) {
		super();
		this.id_ncc = id_ncc;
		this.ten_ncc = ten_ncc;
		this.nguoi_lien_he = nguoi_lien_he;
		this.dien_thoai = dien_thoai;
		this.dia_chi = dia_chi;
	}
	public nha_cung_cap() {
		super();
	}	
}

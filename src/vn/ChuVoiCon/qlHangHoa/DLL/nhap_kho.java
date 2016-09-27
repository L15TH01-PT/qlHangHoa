package vn.ChuVoiCon.qlHangHoa.DLL;

import java.sql.Date;
import java.util.ArrayList;;

public class nhap_kho {
	private String ma_phieu_nhap;
	private Date ngay_lap;
	private Date ngay_huy;
	private int id_nv;
	private ArrayList<chi_tiet_nhap_kho> chi_tiet_nhap_kho;
	
	public String getMa_phieu_nhap() {
		return ma_phieu_nhap;
	}
	public void setMa_phieu_nhap(String ma_phieu_nhap) {
		this.ma_phieu_nhap = ma_phieu_nhap;
	}
	public Date getNgay_lap() {
		return ngay_lap;
	}
	public void setNgay_lap(Date ngay_lap) {
		this.ngay_lap = ngay_lap;
	}
	public Date getNgay_huy() {
		return ngay_huy;
	}
	public void setNgay_huy(Date ngay_huy) {
		this.ngay_huy = ngay_huy;
	}
	public int getId_nv() {
		return id_nv;
	}
	public void setId_nv(int id_nv) {
		this.id_nv = id_nv;
	}
	public ArrayList<chi_tiet_nhap_kho> getChi_tiet_nhap_kho() {
		return chi_tiet_nhap_kho;
	}
	public void setChi_tiet_nhap_kho(ArrayList<chi_tiet_nhap_kho> chi_tiet_nhap_kho) {
		this.chi_tiet_nhap_kho = chi_tiet_nhap_kho;
	}
	
	
}

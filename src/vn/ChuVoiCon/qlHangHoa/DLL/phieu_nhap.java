package vn.ChuVoiCon.qlHangHoa.DLL;

import java.sql.Date;
import java.util.ArrayList;

public class phieu_nhap {
	private int ma_phieu_nhap;
	private Date ngay_lap;
	private int id_nv;
	private Date ngay_huy;
	private ArrayList<chi_tiet_phieu_nhap> ct_nhap_kho;
	
	public ArrayList<chi_tiet_phieu_nhap> getCt_nhap_kho() {
		return ct_nhap_kho;
	}
	public void setCt_nhap_kho(ArrayList<chi_tiet_phieu_nhap> ct_nhap_kho) {
		this.ct_nhap_kho = ct_nhap_kho;
	}
	public int getMa_phieu_nhap() {
		return ma_phieu_nhap;
	}
	public void setMa_phieu_nhap(int ma_phieu_nhap) {
		this.ma_phieu_nhap = ma_phieu_nhap;
	}
	public Date getNgay_lap() {
		return ngay_lap;
	}
	public void setNgay_lap(Date ngay_lap) {
		this.ngay_lap = ngay_lap;
	}
	public int getId_nv() {
		return id_nv;
	}
	public void setId_nv(int id_nv) {
		this.id_nv = id_nv;
	}
	public Date getNgay_huy() {
		return ngay_huy;
	}
	public void setNgay_huy(Date ngay_huy) {
		this.ngay_huy = ngay_huy;
	}
	
	
	
}

package vn.ChuVoiCon.qlHangHoa.Model;

import java.sql.Date;
import java.util.ArrayList;

public class hoa_don {
	private long ma_hoa_don;
	private Date ngay_lap;
	private String ten_khach_hang;
	private int id_nv;
	private int ghi_chu;
	private Date ngay_huy;
	private ArrayList<chi_tiet_hoa_don> chi_tiet_hoa_dons;
	
	public long getMa_hoa_don() {
		return ma_hoa_don;
	}
	public void setMa_hoa_don(long ma_hoa_don) {
		this.ma_hoa_don = ma_hoa_don;
	}
	public Date getNgay_lap() {
		return ngay_lap;
	}
	public void setNgay_lap(Date ngay_lap) {
		this.ngay_lap = ngay_lap;
	}
	public String getTen_khach_hang() {
		return ten_khach_hang;
	}
	public void setTen_khach_hang(String ten_khach_hang) {
		this.ten_khach_hang = ten_khach_hang;
	}
	public int getId_nv() {
		return id_nv;
	}
	public void setId_nv(int id_nv) {
		this.id_nv = id_nv;
	}
	public int getGhi_chu() {
		return ghi_chu;
	}
	public void setGhi_chu(int ghi_chu) {
		this.ghi_chu = ghi_chu;
	}
	public Date getNgay_huy() {
		return ngay_huy;
	}
	public void setNgay_huy(Date ngay_huy) {
		this.ngay_huy = ngay_huy;
	}
	public ArrayList<chi_tiet_hoa_don> getChi_tiet_hoa_dons() {
		return chi_tiet_hoa_dons;
	}
	public void setChi_tiet_hoa_dons(ArrayList<chi_tiet_hoa_don> chi_tiet_hoa_dons) {
		this.chi_tiet_hoa_dons = chi_tiet_hoa_dons;
	}
}

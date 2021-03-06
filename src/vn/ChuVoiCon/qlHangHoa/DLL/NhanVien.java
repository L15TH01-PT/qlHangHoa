package vn.ChuVoiCon.qlHangHoa.DLL;
import java.sql.Date;

import vn.ChuVoiCon.qlHangHoa.DAO.Connect;

public class NhanVien extends Connect {
	
	private int id;
	private String ma_nhan_vien;
	private String ho_nhan_vien;
	private String ten_nhan_vien;
	private boolean phai;
	private Date ngay_sinh;
	private int luong;
	private String dia_chi;
	private int ma_phong_ban;
	private int ma_chuc_vu;
	private int trang_thai;
	private String dien_thoai;
	private String mat_khau;
	
	
	public String getDia_chi() {
		return dia_chi;
	}
	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}
	public String getHo_nhan_vien() {
		return ho_nhan_vien;
	}
	public void setHo_nhan_vien(String ho_nhan_vien) {
		this.ho_nhan_vien = ho_nhan_vien;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMa_nhan_vien() {
		return ma_nhan_vien;
	}
	public void setMa_nhan_vien(String ma_nhan_vien) {
		this.ma_nhan_vien = ma_nhan_vien;
	}
	public String getTen_nhan_vien() {
		return ten_nhan_vien;
	}
	public void setTen_nhan_vien(String ten_nhan_vien) {
		this.ten_nhan_vien = ten_nhan_vien;
	}
	public boolean isPhai() {
		return phai;
	}
	public void setPhai(boolean phai) {
		this.phai = phai;
	}
	public Date getNgay_sinh() {
		return ngay_sinh;
	}
	public void setNgay_sinh(Date ngay_sinh) {
		this.ngay_sinh = ngay_sinh;
	}
	public int getLuong() {
		return luong;
	}
	public void setLuong(int luong) {
		this.luong = luong;
	}
	public int getMa_phong_ban() {
		return ma_phong_ban;
	}
	public void setMa_phong_ban(int ma_phong_ban) {
		this.ma_phong_ban = ma_phong_ban;
	}
	public int getMa_chuc_vu() {
		return ma_chuc_vu;
	}
	public void setMa_chuc_vu(int ma_chuc_vu) {
		this.ma_chuc_vu = ma_chuc_vu;
	}
	public int getTrang_thai() {
		return trang_thai;
	}
	public void setTrang_thai(int trang_thai) {
		this.trang_thai = trang_thai;
	}
	public String getDien_thoai() {
		return dien_thoai;
	}
	public void setDien_thoai(String dien_thoai) {
		this.dien_thoai = dien_thoai;
	}
	public String getMat_khau() {
		return mat_khau;
	}
	public void setMat_khau(String mat_khau) {
		this.mat_khau = mat_khau;
	}
	public NhanVien(int id, String ma_nhan_vien,String ho_nhan_vien, String ten_nhan_vien,
			boolean phai, Date ngay_sinh, int luong,String dia_chi, int ma_phong_ban,
			int ma_chuc_vu, int trang_thai, String dien_thoai, String mat_khau) {
		super();
		this.id = id;
		this.ma_nhan_vien = ma_nhan_vien;
		this.ho_nhan_vien = ho_nhan_vien;
		this.ten_nhan_vien = ten_nhan_vien;
		this.phai = phai;
		this.ngay_sinh = ngay_sinh;
		this.luong = luong;
		this.dia_chi = dia_chi;
		this.ma_phong_ban = ma_phong_ban;
		this.ma_chuc_vu = ma_chuc_vu;
		this.trang_thai = trang_thai;
		this.dien_thoai = dien_thoai;
		this.mat_khau = mat_khau;
	}
	public NhanVien() {
		super();
	}
	@Override
	public String toString() {
		return "NhanVien [id=" + id + ", ma_nhan_vien=" + ma_nhan_vien
				+ ", ho_nhan_vien=" + ho_nhan_vien + ", ten_nhan_vien="
				+ ten_nhan_vien + ", phai=" + phai + ", ngay_sinh=" + ngay_sinh
				+ ", luong=" + luong + ", dia_chi=" + dia_chi
				+ ", ma_phong_ban=" + ma_phong_ban + ", ma_chuc_vu="
				+ ma_chuc_vu + ", trang_thai=" + trang_thai + ", dien_thoai="
				+ dien_thoai + ", mat_khau=" + mat_khau + "]";
	}
	
	
	
}

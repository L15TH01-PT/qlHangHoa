package vn.ChuVoiCon.qlHangHoa.DLL;
import vn.ChuVoiCon.qlHangHoa.DAO.Connect;

public class LoaiSanPham extends Connect {
	private String id_loai;
	private String ten_loai;
	public String getId_loai() {
		return id_loai;
	}
	public void setId_loai(String id_loai) {
		this.id_loai = id_loai;
	}
	public String getTen_loai() {
		return ten_loai;
	}
	public void setTen_loai(String ten_loai) {
		this.ten_loai = ten_loai;
	}
	public LoaiSanPham(String id_loai, String ten_loai) {
		super();
		this.id_loai = id_loai;
		this.ten_loai = ten_loai;
	}
	public LoaiSanPham() {
		super();
	}
	
}

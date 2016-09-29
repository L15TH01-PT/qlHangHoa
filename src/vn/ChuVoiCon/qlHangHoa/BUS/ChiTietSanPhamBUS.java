package vn.ChuVoiCon.qlHangHoa.BUS;

import java.util.ArrayList;

import vn.ChuVoiCon.qlHangHoa.DAO.ChiTietSanPhamDAO;
import vn.ChuVoiCon.qlHangHoa.DAO.Connect;
import vn.ChuVoiCon.qlHangHoa.DLL.chi_tiet_san_pham;
import vn.ChuVoiCon.qlHangHoa.DLL.loai_san_pham;

public class ChiTietSanPhamBUS extends Connect {
	ChiTietSanPhamDAO ctspd = new ChiTietSanPhamDAO();

	public ArrayList<chi_tiet_san_pham> getDSCTSP() {
		ArrayList<chi_tiet_san_pham> arrCTSP = new ArrayList<chi_tiet_san_pham>();
		arrCTSP = ctspd.getDSCTSP();
		return arrCTSP;
	}

	public int addSP(String masp, String maloai, String mancc, String tensp,
			String noidung, int baohanh, String dvt, double dongia) {
		return ctspd.add(masp, maloai, mancc, tensp, noidung, baohanh, dvt,
				dongia);
	}

	public int deleteSP(String masp) {
		return ctspd.delete(masp);
	}

	public int editSP(String masp, String maloai, String mancc, String tensp,
			String noidung, int baohanh, String dvt, double dongia) {
		return ctspd.edit(masp, maloai, mancc, tensp, noidung, baohanh, dvt,
				dongia);
	}
}
